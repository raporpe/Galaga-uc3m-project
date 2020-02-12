package src;
import edu.uc3m.game.GameBoardGUI;

/**
 * Class for the player system of lives, torpedoes, movements...
 * 
 * @author Raúl P. and Diego G.
 * @version 38.1
 * 
 */

public class Player extends Sprite {

	// Stats variables
	private int shoots;

	private PlayerTorpedo[] playerTorpedoes;
	private int torpedoIndex;
	private int availableMegaTorpedoes;

	/**
	 * Array of id's for the sprites representing the player lives
	 */
	private int[] lifesSpriteId;
	
	/**
	 * The current position in the array of sprites id's.
	 * THis value is decreased each time the player loses a life.
	 */
	private int lifesSpriteIdIndex;

	/**
	 * Used for counting the elapsed time from one shoot to another and limit the
	 * torpedoes rate.
	 */
	private double lastShotTime = System.currentTimeMillis();

	Game game;

	public Player(GameBoardGUI board, PlayerTorpedo[] playerTorpedoes, Game game, int maxLives, int level) {
		super(board, maxLives, true, level);

		this.game = game;
		this.playerTorpedoes = playerTorpedoes;
		this.availableMegaTorpedoes = level;

		initializeStats();

		this.activeCollisions = true;
	}

	// --------Movement functions----------//
	
	/** The player can only move in one dimmension.
	 * @param quantity the variation to the right in the x coordinate (only positive values).
	 */
	public void moveRight(int quantity) {
		quantity = Math.abs(quantity);
		if (this.x < Constants.BOARD_WIDTH - 5) {
			moveSpriteTo(this.x + quantity, this.y);
		}
	}

	/** The player can only move in one dimmension.
	 * @param quantity the variation to the left in the x coordinate (only positive values).
	 */
	
	public void moveLeft(int quantity) {
		quantity = Math.abs(quantity);
		if (this.x > 6) {
			moveSpriteTo(this.x - quantity, this.y);
		}
	}



	/**
	 * Since the player object is only created once for a game, we need to tell the
	 * player that the game is now in the next level
	 * 
	 * @param level the new level to be set
	 */
	public void passToLevel(int level) {
		this.level = level;
		this.availableMegaTorpedoes += level;
	}

	/**
	 * Called in Game each time the player hits the shoot button. This method
	 * includes a delayer to prevent the player from shooting too many torpedoes.
	 * 
	 * @param megaTorpedo true if you want to shoot a Mega Torpedo
	 */
	public void shootTorpedo(boolean megaTorpedo) {

		// Cool down system. A formula is used to calculate the gap time between two shoots.
		if (System.currentTimeMillis()
				- lastShotTime > (Constants.MAX_TORPEDOES_PER_SQAURE * 10 * 1000 / Constants.FPS)) {

			if (isVisible() && Enemy.allEnemiesReady) {

				if (torpedoIndex >= playerTorpedoes.length) {
					torpedoIndex = 0;
				}

				if (megaTorpedo && availableMegaTorpedoes > 0) {
					this.playerTorpedoes[torpedoIndex].initTorpedo(this.x, this.y - Constants.PLAYER_TORPEDOES_OFFSET,
							true);
					availableMegaTorpedoes--;
				}

				if (!megaTorpedo) {
					this.playerTorpedoes[torpedoIndex].initTorpedo(this.x, this.y - Constants.PLAYER_TORPEDOES_OFFSET,
							false);
				}

				torpedoIndex++;
				shoots++;
			}

			lastShotTime = System.currentTimeMillis();
		}
	}


	/*
	 * The player dead is different from the rest because it will send the signal to
	 * game to stop. Moreover, the entire game will freeze and only play the player
	 * destruction animation.
	 */
	@Override
	protected void death() {
		activeCollisions = false;

		// The entire game will be stopped just to animate this.
		animateDeath();
		// Then it will continues the sequence
		board.gb_showMessageDialog("You have died!");
		game.stopGame();
	}


	/**
	 *  Called in death(). This function is exclusive of Player.
	 *  The entire game will freeze during the animation.
	 */
	private void animateDeath() {
		int explodingSkin = 1;
		while (explodingSkin < 5) {

			setSpriteSkin(Constants.getSkin(this, lives, explodingSkin++), true);

			// The entire game will be frozen just to animate this
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// The board is called to play the player damage effect.
	public void collision() {
		super.collision();
		board.gb_animateDamage();
	}

	// Called in every frame.
	protected void update() {
		super.update();

		// We have set a delayer to prevent the board from being refreshed too many
		// times.
		if (frameCounter % 5 == 0) {
			updateStats();
		}
	}

	protected void loseLive() {
		//This deletes one sprite representing the player lifes.
		if (lives >= 0) {
			board.gb_setSpriteVisible(lifesSpriteId[lifesSpriteIdIndex--], false);
		}
		
		super.loseLive();
	}

	//---------Board stats controller--------//

	/**
	 * The player is in charge of updating and starting part of the board stats. The
	 * rest of the board stats are updated by Game.
	 */
	private void initializeStats() {

		// Generating text
		board.gb_setValueHealthCurrent(this.lives);
		board.gb_setValueHealthMax(this.maxLives);
		board.gb_setValueAbility1(this.shoots);

		// This generates the Sprites at the bottom of the screen
		lifesSpriteId = new int[this.maxLives];

		for (int ii = 0; ii < lifesSpriteId.length; ii++) {
			lifesSpriteId[ii] = IdManager.assignId(null);
			board.gb_addSprite(lifesSpriteId[ii], "player.png", true);
			board.gb_moveSpriteCoord(lifesSpriteId[ii], 10 * ii + 6, Constants.BOARD_HEIGHT - 6);
			board.gb_setSpriteVisible(lifesSpriteId[ii], true);
		}
		
		lifesSpriteIdIndex = lifesSpriteId.length - 1;
	}

	/**
	 * Update in every frame the new stats values. Called in update()
	 */
	private void updateStats() {
		board.gb_setValueHealthCurrent(this.lives);
		board.gb_setValueAbility1(this.shoots);
		board.gb_setValuePointsDown(this.availableMegaTorpedoes);
	}

}
