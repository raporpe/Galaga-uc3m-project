package src;

//Importing the Locale object to change the default
//configuration of the computer to English
import java.util.Locale;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

/**
 * Class to control the board, the main thread...
 * 
 * @author Raúl P. and Diego G.
 * @version 43.5
 * 
 */

public class Game {


	//Player variables
	private int playerKills;
	private int score;
	private int maxPlayerLives = 5;
	private static String playerName = "noName";
	int level = 1;
	double initialTime;

	private int frameCounter;

	private boolean running = true;
	private boolean fastPlayerControls;

	
	//Game control
	
	public void stopGame() {
		running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	

	public static void main(String[] args) {
		
		//-------------BASIC BOARD INITIALIZATION--------------

		// To change the GUI to English
		Locale.setDefault(new Locale("en"));

		// Create a 17x22 board
		GameBoardGUI board = new GameBoardGUI(Constants.BOARD_WIDTH_BIG_COORDINATES,
				Constants.BOARD_HEIGHT_BIG_COORDINATES);

		//Setting board visible.
		board.setVisible(true);

		//Grid color setter to black.
		board.gb_setGridColor(0, 0, 0);
		
		//Setting all board squares to black
		for (int ii = 0; ii < (Constants.BOARD_WIDTH_BIG_COORDINATES); ii++) {
			for (int jj = 0; jj < (Constants.BOARD_HEIGHT_BIG_COORDINATES); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		// Initial names
		board.gb_setTextPlayerName("SuperGalaga");
		board.gb_setPortraitPlayer("portrait.png");
		board.gb_setTextPointsUp("Score");
		board.gb_setTextPointsDown("Mega Torpedoes");
		board.gb_setTextLevel("Level");
		board.gb_setTextAbility1("Shoots");
		board.gb_setTextAbility2("Kills");


		//----------------------THE MAIN WHILE-------------------------//

		//Warning: this will be repeated forever.
		//Thanks to this the new game buttons work when the game is stopped.
		while (true) {

			Game game = new Game();
			
			//Resetting the board
			game.resetStats(board);
			board.gb_clearCommandBar();
			board.gb_clearConsole();
			board.gb_clearSprites();
			board.repaint();
			
			//Resetting the enemy variables
			Enemy.resetVariables();
		
			board.gb_println("Welcome to Galaga! \n --------------------------- \n Press 'New' and insert your name"
					+ "\n\nPress space to shoot torpedoes,"
					+ "\n left and right arrows to move the player, \n and up to shoot MegaTorpedoes"
					+ "\nType the command 'fastControls' to enable\nimproved player controls");

			// Waiting to click start game.
			boolean waitingForUserAction = true;
			do {

				String lastAction = board.gb_getLastAction();
				lastAction = lastAction.trim();
				System.out.print(lastAction);

				//This means that new game was pressed previously
				if(!playerName.equals("noName")) {
					waitingForUserAction = false;
				}
				
				
				if (lastAction.startsWith("new game")) {
					lastAction = lastAction.replace("new game", "");
					playerName = lastAction;
					waitingForUserAction = false;
					
				} else if (lastAction.equals("exit game")) {
					board.gb_showMessageDialog("First, you have to start a game");
					
				} else if(lastAction.startsWith("command")) {
					String command = lastAction.replace("command", "");
					command = command.replace(" ", "");
					command = command.toLowerCase();
					
					if(command.equals("fastcontrols")) {
						game.fastPlayerControls = !game.fastPlayerControls;
						
						String print = "Fastplayer movememt is: ";
						
						if(game.fastPlayerControls) {
							print += "enabled";
						} else {
							print += "desabled";
						}
						
						board.gb_println(print);
					} else if(command.equals("god")) {
						game.maxPlayerLives = 100;
						board.gb_println("God enabled for the next game");
					} else {
						board.gb_println("The command does not exist");

					}
					
					board.gb_println("");
					board.gb_clearCommandBar();

				}

			} while (waitingForUserAction);
			
			//Once the user has pressed New Game, the rest is initialised
			
			//-------------------Game Initialization-------------------//

			PlayerTorpedo[] playerTorpedo = new PlayerTorpedo[Constants.BOARD_HEIGHT_BIG_COORDINATES];
			EnemyTorpedo[] enemyTorpedo = new EnemyTorpedo[Constants.BOARD_HEIGHT_BIG_COORDINATES];
			Player player = new Player(board, playerTorpedo, game, game.maxPlayerLives, game.level);
			CollisionChecker collisionChecker = new CollisionChecker(board, Constants.COLLISION_RADIUS);
			
			//All the enemies are unified in a array of enemies arrays.
			Enemy[][] enemies = game.generateEnemies(board, enemyTorpedo, game);

			// Initialize torpedoes array for the player and the enemies.
			for (int ii = 0; ii < playerTorpedo.length; ii++) {
				playerTorpedo[ii] = new PlayerTorpedo(board);
			}
			for (int ii = 0; ii < enemyTorpedo.length; ii++) {
				enemyTorpedo[ii] = new EnemyTorpedo(board);
			}

			// Star declaration. There are two "layers" of stars. The fast ones and the slow ones.
			Star[] fastStar = new Star[Constants.getNumberOfAvailablePositions("Star", 1)];
			Star[] slowStar = new Star[Constants.getNumberOfAvailablePositions("Star", 1)];

			// Stars initialization (fast and slow).
			for (int ii = 0; ii < fastStar.length; ii++) {
				fastStar[ii] = new Star(board, 0.02, 60);
			}
			for (int ii = 0; ii < slowStar.length; ii++) {
				slowStar[ii] = new Star(board, 0.05, 0);
			}

			//For the new movements system
			boolean right = false;
			boolean left = false;
			boolean space = false;

			int lastFrameWitoutRight = 0;
			int lastFrameWitoutLeft = 0;
			int lastFrameWitoutSpace = 0;

		//----------------------THE GAME WHILE-------------------------//

			do {

				// Take the initial time when a frame is being processed.
				// At the end of the Game while another time is taken to control the time spent
				// in processing each frame.
				game.initialTime = System.nanoTime();

				String lastAction;

				// Player movements system.
				if (game.fastPlayerControls) {

					if (right) {
						player.moveRight(Constants.PLAYER_MOVEMENT_SPACE);
					}
					if (left) {
						player.moveLeft(Constants.PLAYER_MOVEMENT_SPACE);
					}
					if (space) {
						player.shootTorpedo(false);
					}

					lastAction = board.gb_getLastAction();
					lastAction = lastAction.trim();
					System.out.print(lastAction + ".");

					if (lastAction.equals("right")) {
						right = true;
					}
					if (lastAction.equals("left")) {
						left = true;
					}
					if (lastAction.equals("space")) {
						space = true;
					}
					if (lastAction.equals("up")) {
						player.shootTorpedo(true);
					}

					if (lastAction.equals("") || lastAction.equals("left") || lastAction.equals("space")) {
						lastFrameWitoutRight++;
						if (lastFrameWitoutRight >= 40) {
							right = false;
							lastFrameWitoutRight = 0;
						}
					}
					if (lastAction.equals("") || lastAction.equals("right") || lastAction.equals("space")) {
						lastFrameWitoutLeft++;
						if (lastFrameWitoutLeft >= 40) {
							left = false;
							lastFrameWitoutLeft = 0;
						}
					}

					if (lastAction.equals("") || lastAction.equals("right") || lastAction.equals("left")) {
						lastFrameWitoutSpace++;
						if (lastFrameWitoutSpace >= 40) {
							space = false;
							lastFrameWitoutSpace = 0;
						}
					}
				} else {
					lastAction = board.gb_getLastAction();
					if (lastAction.equals("right")) {
						player.moveRight(Constants.PLAYER_MOVEMENT_SPACE);

					}
					if (lastAction.equals("left")) {
						player.moveLeft(Constants.PLAYER_MOVEMENT_SPACE);
					}

					if (lastAction.equals("space")) {
						player.shootTorpedo(false);
					}
					if (lastAction.equals("up")) {
						player.shootTorpedo(true);
					}

				}
				

				//Picking random attackers
				game.pickRandomEnemiesToAttack(enemies);
				
				//-----UPDATES----//
					//This executes the update() function in the Sprites.
					//Enemies Swarm
					game.swarmUpdate(enemies);
					
					//Torpedoes
					game.update(playerTorpedo);
					game.update(enemyTorpedo);
	
					//Enemies
					game.update(enemies);
	
					//Stars
					game.update(slowStar);
					game.update(fastStar);
					
					//Player
					player.update();
					
					//The board
					game.updateStats(board, player);


				// Checking all possible collisions
				collisionChecker.check(enemies, playerTorpedo);
				collisionChecker.check(enemies, player);
				collisionChecker.check(player, enemyTorpedo);
				
				
				// Checking if any button has been pressed
				if (lastAction.contains("exit game")) {
					board.gb_showMessageDialog("Thanks for playing!");
					playerName = "noName";
					game.stopGame();
				} else if (lastAction.startsWith("new game")) {
					lastAction = lastAction.trim();
					playerName = lastAction.replace("new game", "");
					game.stopGame();
				} else if (lastAction.startsWith("command")) {
					board.gb_println("\nYou cannot enter commands now.\nStop the game and enter them");
					board.gb_clearCommandBar();
				}
				
				//Checks if all the enemies are dead and the game has to pass to the next level.
				if (Enemy.activeEnemies <= 0) {
					game.level++;

					if (game.level <= Constants.MAX_LEVEL) {
						Enemy.resetVariables();
						player.passToLevel(game.level);
						// Generate new enemies
						enemies = game.generateEnemies(board, enemyTorpedo, game);
					} else {
						board.gb_showMessageDialog("Congratulations!");
						game.stopGame();
					}
				}
				
				
				game.frameCounter++;

			
			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\   FPS CONTROLLER  \::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */

					double computingTime = System.nanoTime() - game.initialTime;
					long sleepFor = (long) (Constants.EXPECTED_TIME - computingTime) / 1000000;
	
					if (sleepFor < 0) {
						sleepFor = 0;
						System.out.println("Warning: FPS drop!");
					}
	
					try {
						Thread.sleep(sleepFor);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */

			} while (game.isRunning());
			
			//----------------------END OF THE GAME WHILE-------------------------//

		}
//----------------------END OF THE MAIN WHILE-------------------------//

	}
	
	
	
	
	
//----------------------FUNCTIONS-------------------------//

	private void update(Sprite[][] sprite) {
		for (Sprite[] spriteType : sprite) {
			for (Sprite spriteToUpdate : spriteType) {

				if (spriteToUpdate.isVisible()) {
					spriteToUpdate.update();
				}

			}
		}
	}

	private void update(Sprite[] sprite) {

		for (Sprite spriteToUpdate : sprite) {
			if (spriteToUpdate.isVisible() && spriteToUpdate != null) {
				spriteToUpdate.update();
			}
		}

	}

	private int dx = 1;

	private void swarmUpdate(Enemy[][] enemy) {
		boolean result = false;
		boolean reachedBound = false;
		if (frameCounter % 5 == 0 && Enemy.allEnemiesReady) {

			for (Enemy[] enemyType : enemy) {
				for (Enemy enemyToUpdate : enemyType) {

					result = enemyToUpdate.moveXSwarm(dx);

					if (result) {
						reachedBound = true;
					}
				}
			}

			if (reachedBound) {
				dx = -dx;
				for (Enemy[] enemyType : enemy) {
					for (Enemy enemyToUpdate : enemyType) {

						enemyToUpdate.moveDownSwarm(1);
						reachedBound = false;
					}
				}
			}
		}
	}

	public Enemy[][] generateEnemies(GameBoardGUI board, EnemyTorpedo[] enemyTorpedoes, Game game) {

		// We generate another enemies
		Zako[] zako = new Zako[Constants.getNumberOfAvailablePositions("Zako", level)];
		Goei[] goei = new Goei[Constants.getNumberOfAvailablePositions("Goei", level)];
		Commander[] commander = new Commander[Constants.getNumberOfAvailablePositions("Commander", level)];

		// All the enemies are unifies in one array
		Enemy[][] enemies = { zako, goei, commander };

		// Enemies initialization
		for (int ii = 0; ii < zako.length; ii++) {
			zako[ii] = new Zako(board, enemyTorpedoes, game, level);
		}

		for (int ii = 0; ii < goei.length; ii++) {
			goei[ii] = new Goei(board, enemyTorpedoes, game, level);
		}

		for (int ii = 0; ii < commander.length; ii++) {
			commander[ii] = new Commander(board, enemyTorpedoes, game, level);
		}

		return enemies;
	}

	private void pickRandomEnemiesToAttack(Enemy[][] enemies) {

		if (Enemy.allEnemiesReady) {
			int attackType = (int) (Math.random() * 2);

			switch (attackType) {

			case 0:

				for (Enemy[] enemyType : enemies) {

					for (Enemy oneEnemy : enemyType) {
						int doesAttack = (int) (Math.random() * Constants.ATTACK_POSSIBILITY);
						if (doesAttack == 0) {
							oneEnemy.attack(0);
						}
					}

				}

				break;

			case 1: // A team of enemies
				for (Enemy[] enemyType : enemies) {
					int doesAttack = (int) (Math.random() * Constants.ATTACK_POSSIBILITY);
					int attackPattern = (int) (Math.random() * (Constants.availableNumberOfPath) + 1);
					
					//Number of the array from which to begin
					int initialii = (int) (Math.random() * enemyType.length);
					
					//How many attacks to trigger
					int amount = (int) (Math.random() * 4 + 1);

					//telling the sprites to attack
					if (doesAttack == 0) {
						for (int ii = initialii, started = 0; ii < enemyType.length; ii++, started++) {
							if(started <= amount) {
								enemyType[ii].attack(attackPattern);
							}
						}
					}

				}

				break;

			}
		}
	}

	private void updateStats(GameBoardGUI board, Player player) {
		board.gb_setValueAbility2(playerKills);
		board.gb_setValueLevel(level);
		board.gb_setValuePointsUp(score);
		board.gb_setValueAbility2(playerKills);
		board.gb_setTextPlayerName(playerName);
	}

	public void killedEnemy(Enemy enemy) {
		int multiplicator;
		if (enemy instanceof Zako) {
			multiplicator = 1;
		} else if (enemy instanceof Goei) {
			multiplicator = 2;
		} else if (enemy instanceof Commander) {
			multiplicator = 5;
		} else {
			multiplicator = 1;
		}

		// Formula for increasing the score
		score += (int) (multiplicator * level);
		playerKills++;
	}

	private void resetStats(GameBoardGUI board) {
		// This sets all the board indicators to zero.
		board.gb_setValueAbility1(0);
		board.gb_setValueAbility2(0);
		board.gb_setValueHealthCurrent(0);
		board.gb_setValueHealthMax(0);
		board.gb_setValuePointsDown(0);
		board.gb_setValueLevel(0);
		board.gb_setTextPlayerName("Galaga");
	}

}