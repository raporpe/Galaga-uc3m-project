package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

/**
 * Child of Sprite. Mother of Zako, Commander, Goei
 * 
 * @author Raúl P. and Diego G.
 * @version 33.5
 * 
 * 
 */

abstract public class Enemy extends Sprite {

	Game game;

	protected int pathIndex;
	protected int[][] temporalPathToFollow;

	protected boolean defaultSwarmSkin;
	protected int explodingSkin = 20;
	protected int xSwarm;
	protected int ySwarm;

	// State of the sprite
	protected char movementState = 0;
	protected int pathNumber = 0;
	protected int fixedAttackPattern;

	protected static EnemyTorpedo[] torpedo;
	private static int torpedoIndex;

	public static int activeEnemies = 0;
	private static int initializatedEnemies;
	public static boolean allEnemiesReady;

	public Enemy(GameBoardGUI board, EnemyTorpedo[] enemyTorpedoes, Game game, int maxlives, int level) {
		super(board, maxlives, false, level);

		this.game = game;
		Enemy.activeEnemies++;
		torpedo = enemyTorpedoes;
		entryAnimation();

	}

	public void initialCoordinates() {
		int[] tempInitialCoordinates = Constants.getInitialCoordinatesVector(this, this.level);
		this.xSwarm = tempInitialCoordinates[0];
		this.ySwarm = tempInitialCoordinates[1];
		this.x = Constants.BOARD_WIDTH;
		this.y = Constants.BOARD_HEIGHT;

	}

	/**
	 * Resets the variables each level. This is done this way because new enemies objects are created in each level.
	 */
	protected static void resetVariables() {
		activeEnemies = 0;
		allEnemiesReady = false;
		initializatedEnemies = 0;
		torpedo = null;
		torpedoIndex = 0;

		// Resetting child values
		Zako.generatedZakos = 0;
		Goei.generatedGoei = 0;
		Commander.generatedCommander = 0;
	}

	/* (non-Javadoc)
	 * @see src.Sprite#update()
	 */
	protected void update() {
		super.update();
		nextPosition();

		if (frameCounter % 50 == 0) {
			defaultSwarmSkin = !defaultSwarmSkin;
		}

		animate();

		if (initializatedEnemies == Constants.getNumberOfAvailablePositions(level)) {
			allEnemiesReady = true;
		}

	}

	/**
	 * The sprite changes its position according to the state it is in. Called by
	 * update()
	 */
	private void nextPosition() {
		// Swarm movements

		/*
		 * movementState possible values
		 * 's' --> Swarm (when in swarm formation)
		 * 'e' --> Entry animation (when starting a level)
		 * 'a' --> Attacking
		 * 'x' --> eXploding
		 * 'r' --> Route (when following the generated Route back to its swarm position)
		 */

		if (movementState == 's') {
			// Update with the swarm positions.
			moveSpriteTo(xSwarm, ySwarm);
			// If the enemy is not in the swarm.
		} else {

			//When exploding
			if (movementState == 'e' && frameCounter % 3 == 0) {
				if (pathIndex <= 0) {
					moveSpriteTo(temporalPathToFollow[0][0], temporalPathToFollow[0][1]);
				}
				if (pathIndex > 0) {
					changeSpritePos(temporalPathToFollow[pathIndex][0], temporalPathToFollow[pathIndex][1]);
				}
				pathIndex++;

				// When the entry animation is finished
				if (pathIndex >= temporalPathToFollow.length) {
					goToSwarm();
					initializatedEnemies++;
					activeCollisions = true;
					pathIndex = 0;
				}

				// When attacking
			} else if (movementState == 'a' && frameCounter % 5 == 0) {
				// If modulus is -1, it shoots a torpedo
				if (temporalPathToFollow[pathIndex][1] == -1) {
					shootTorpedo();
				}
				changeSpritePos(temporalPathToFollow[pathIndex][0], temporalPathToFollow[pathIndex][1]);
				pathIndex++;

				// When the enemy reaches the end of the board.
				if (this.y >= Constants.BOARD_HEIGHT) {
					moveSpriteTo(this.x, 0);
					movementState = 's';
					goToSwarm();

				// When the enemy has finished an attack but it is not yet at the end of the board.
				} else if (pathIndex >= temporalPathToFollow.length) {
					pathIndex = 0;
					int randomPath;
					if (fixedAttackPattern == 0) {
						randomPath = (int) (Math.random() * Constants.availableNumberOfPath + 1);

					} else {
						randomPath = fixedAttackPattern;
					}
					temporalPathToFollow = Constants.getPath(this, randomPath);
				}

			// When moving back to the swarm
			} else if (movementState == 'r' && frameCounter % 3 == 0) {

				changeSpritePosDxDy(temporalPathToFollow[pathIndex][0], temporalPathToFollow[pathIndex][1]);
				pathIndex++;

				if (pathIndex >= temporalPathToFollow.length) {
					pathIndex = 0;
					movementState = 's';
				}

			}

		}
	}

	/**
	 * The enemy updates its skin in the board to the corresponding one.
	 */
	public void animate() {

		/*
		 * movementState possible values
		 * 's' --> Swarm (when in swarm formation)
		 * 'e' --> Entry animation (when starting a level)
		 * 'a' --> Attacking
		 * 'x' --> eXploding
		 * 'r' --> Route (when following the generated Route back to its swarm position)
		 */

		// Exploding state
		if (movementState == 'x') {

			if (frameCounter % 3 == 0) { // Delayer
				// Reset the explosion state

				// When the explotion ends
				if (explodingSkin >= 25) {
					explodingSkin = 20;
					setVisibility(false);
					this.moveSpriteTo(Constants.DEFAULT_SPRITE_POS_X, Constants.DEFAULT_SPRITE_POS_Y);
					activeEnemies--;
				}

				setSpriteSkin(Constants.getSkin(this, lives, explodingSkin++), true);

			}

		}

		// This changes the enemy skin to make it appear to be floating.
		if (movementState == 's' && allEnemiesReady) {
			if (defaultSwarmSkin) {
				setSpriteSkin(Constants.getSkin(this, lives, 0), false);
			} else {
				setSpriteSkin(Constants.getSkin(this, lives, -1), false);
			}
		}

	}

	/* (non-Javadoc)
	 * @see src.Sprite#death()
	 */
	public void death() {
		activeCollisions = false;
		movementState = 'x';
		game.killedEnemy(this);
		// Visibility is disabled after exploding animation
	}

	// -------------Swarm control---------------//

	/**
	 * Used to move a sprite in the swarm. Warning: this method has to be executed
	 * in every sprite at the same time to make the swarm effect. If the sprite is
	 * not in the swarm, its current position will not change.
	 * 
	 * @param dx The variation in the x axis. Recommended value: 1.
	 * @return True if the sprite has touched a border of the board.
	 */
	public boolean moveXSwarm(int dx) {
		this.xSwarm += dx;

		if (this.xSwarm <= Constants.SWARM_BORDER) {
			return true;
		}

		if (this.xSwarm >= Constants.BOARD_WIDTH - Constants.SWARM_BORDER) {
			return true;
		}

		return false;
	}

	/**
	 * Controlled from game. Called when a sprite reaches the board bounds.
	 * 
	 * @param dy The variation in the y axis. Recommended value: 1. Only positive
	 *           values accepted.
	 */
	public void moveDownSwarm(int dy) {
		dy = Math.abs(dy);
		this.ySwarm += dy;
	}

	// ----------------SPRITE MOVEMENTS OPERATIONS------------//

	/**
	 * The sprite makes the animation entry.
	 */
	protected void entryAnimation() {
		movementState = 'e'; // Entry
		this.temporalPathToFollow = Constants.getPath(this, 0);
	}

	/**
	 * Makes the sprite perform an attack.
	 * 
	 * @param pattern The attack pattern stored in Constants to be used. If zero, a
	 *                random one will be chosen. if different to zero, the selected
	 *                pattern will be done repeatedly during the attack.
	 */
	protected void attack(int pattern) {
		// We check this to avoid enemies that are being destroyed from attacking
		if (movementState == 's') {
			movementState = 'a';
			pathIndex = 0;

			if (pattern == 0) {
				int ran = (int) (Math.random() * Constants.availableNumberOfPath + 1);
				this.temporalPathToFollow = Constants.getPath(this, ran);

			} else {
				// Here we can indicate a pattern to be followed at the same time by a team of
				// sprites.
				this.temporalPathToFollow = Constants.getPath(this, pattern);
				fixedAttackPattern = pattern;

			}
		}
	}

	/**
	 * Makes all the necessary operations so that the sprite will go to the swarm in
	 * the following frames
	 */
	protected void goToSwarm() {
		setSpriteSkin(Constants.getSkin(this, lives, 0), false);
		movementState = 'r';
		temporalPathToFollow = generateRouteToSwarmPos(this);
		pathIndex = 0;
	}

	/**
	 * Calculates the route for the sprite to go from its current position to its
	 * swarm poition
	 * 
	 * Warning: the generated array has to be interpreted by the
	 * changeSpritePosDxDy() function.
	 * 
	 * @param enemy Enemy object for which you want to calculate the route to its
	 *              Swarm position.
	 * @return array of variations in the position that have to be performed to go
	 *         to the swarm.
	 */
	public int[][] generateRouteToSwarmPos(Enemy enemy) {

		int precision = 5;
		int vectorX = enemy.xSwarm - enemy.x;
		int vectorY = enemy.ySwarm - enemy.y;
		// The length is one more because the last position has the remaining vector.
		int arrayLength = precision + 1;
		int[][] returnArrayVector = new int[arrayLength][];

		// Due to the int cast, some displacement is lost. It will be recovered at the
		// end inserting the remaining vector.
		int[] vector = { (int) (vectorX / precision), (int) (vectorY / precision) };
		for (int ii = 0; ii < returnArrayVector.length - 1; ii++) {
			returnArrayVector[ii] = vector;

		}

		// Inserting the remaining vector.
		int[] remainingVector = { (int) (vectorX % precision), (int) (vectorY % precision) };
		returnArrayVector[returnArrayVector.length - 1] = remainingVector;

		return returnArrayVector;
	}

	/**
	 * Shoots an enemy torpedo. The enemy torpedoes array is static and used by all
	 * of them.
	 * 
	 */
	public void shootTorpedo() {
		if (this.isVisible()) {
			if (torpedoIndex >= torpedo.length) {
				torpedoIndex = 0;
			}
			torpedo[torpedoIndex].initTorpedo(this.x, this.y + Constants.PLAYER_TORPEDOES_OFFSET);
			torpedoIndex++;
		}
	}

	// Empty constructor
	public Enemy() {

	}

}
