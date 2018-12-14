package src;

//Importing the Locale object to change the default
//configuration of the computer to English

import java.util.Locale;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


public class Game {



	
	private static boolean running = true;
	
	public static void stopGame() {
		Game.running = false;
	}
	
	public static Boolean isRunning() {
		if(Game.running) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//Great variables declaration
	
	static double initialTime;

	
	//Responsiveness
	public static final int BOARD_WIDTH = 170;
	public static final int BOARD_HEIGHT = 220;
	
	public static final int BOARD_WIDTH_BIG_COORDINATES = BOARD_WIDTH/10;
	public static final int BOARD_HEIGHT_BIG_COORDINATES = BOARD_HEIGHT/10;

	
	final static int FPS = 120;
	final static int EXPECTED_TIME = 1000000000 / FPS;
	final static int TORPEDOES_SPEED = 1;
	final static int SPRITE_WIDTH = 5;
	final static int SPRITE_HEIGTH = 5;
	final static int DEFAULT_SPRITE_POS_X = 0;
	final static int DEFAULT_SPRITE_POS_Y = 0;
	
	final static int MAX_TORPEDOES_PER_SQAURE = 1;
	
	final static int PLAYER_TORPEDOES_OFFSET = 5;
	
	final static int PLAYER_MOVEMENT_SPACE = 2;
	
	//Collisions
	public static final int COLLISION_RADIUS = 10;

	
	//Testing
	

	
	
	
	


	
	
	
	public static void main(String[] args) {
		
		String playerName = "test";
		
		
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		
		
		//Create a 17x22 board
		GameBoardGUI board = new GameBoardGUI(Game.BOARD_WIDTH_BIG_COORDINATES, Game.BOARD_HEIGHT_BIG_COORDINATES);
		
		Torpedo[] playerTorpedo = new Torpedo[Game.BOARD_HEIGHT_BIG_COORDINATES];

		Player player = new Player(board, playerName, playerTorpedo);
		Enemy[] enemies = new Enemy[Constants.enemyCoordinatesLevel1.length];
		Game game = new Game();
		CollisionChecker collisionChecker = new CollisionChecker(board, COLLISION_RADIUS);
		
		

		//Initialize torpedoes array
		for(int ii = 0; ii < playerTorpedo.length; ii++) {
			playerTorpedo[ii] = new Torpedo(board);
		}
		
		
		
		//Star declaration
		
		Constants constants = new Constants();
		
		Star[] fastStar = new Star[constants.StarPositions.length];

		Star[] slowStar = new Star[constants.StarPositions.length];
		
		
		//Stars initialization
		for (int ii = 0; ii < fastStar.length; ii++) {
			fastStar[ii] = new Star(board, 0.01, 60);
		}
		
		for (int ii = 0; ii < slowStar.length; ii++) {
			slowStar[ii] = new Star(board, 1, 0);
		}
		
		
		
		//Enemies initialization
		for(int ii = 0; ii < 11; ii++) {
			enemies[ii] = new Goei(board);
		}
		
		for(int ii = 11; ii < 22; ii++) {
			enemies[ii] = new Zako(board);
		}
		for(int ii = 22; ii < 25; ii++) {
			enemies[ii] = new Commander(board);
		}
		
		
		
		
		
		
		//After startup, setting board visible.
		board.setVisible(true);




				
		
		
		//Grid color setter
		board.gb_setGridColor(40, 40, 40);		
		
		for(int ii = 0; ii < (BOARD_WIDTH_BIG_COORDINATES); ii++) {
			for(int jj = 0; jj < (BOARD_HEIGHT_BIG_COORDINATES); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		
		
		
				

		
		double lastShotTime = 0;


//----------------------THE MAIN WHILE-------------------------//
		
		
/* 
 				  ("`-''-/").___..--''"`-._
				   `6_ 6  )   `-.  (     ).`-.__.`)
				   (_Y_.)'  ._   )  `._ `. ``-..-'			//This cat will keep our code efficient, clean and organised.				   												
				 _..`--'_..-_/  /--'_.' ,'					//She likes eating bugs.
				(il),-''  (li),'  ((!.-'						
*/
		
		do {
			
			//we take at the beginning the time
			//THIS IS AN IMPLEMENTATION OF FPS SYSTEM
			initialTime = System.nanoTime();
			
			
						
			
			String lastAction;
			lastAction = board.gb_getLastAction();
			if(lastAction.equals("right")) {	
				player.moveRight(PLAYER_MOVEMENT_SPACE);

			}
			if(lastAction.equals("left")) {
				player.moveLeft(PLAYER_MOVEMENT_SPACE);
			}
			
			if(lastAction.equals("space")) {
				
				if(System.currentTimeMillis() - lastShotTime > (MAX_TORPEDOES_PER_SQAURE*10*1000/Game.FPS)) {
					player.shootTorpedo();
					lastShotTime = System.currentTimeMillis();
					System.out.println(lastShotTime);
				}
				
			}


			
			game.updateTorpedoes(playerTorpedo);
			game.updateEnemies(enemies);
			game.updateStars(slowStar, fastStar);
			
			//Checking all possible collisions
			
			collisionChecker.check(playerTorpedo, enemies, true, true);
			collisionChecker.check(player, enemies, true, true);
	
			
			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\   FPS CONTROLLER  \::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */
		
					double computingTime = System.nanoTime() - initialTime;
					long sleepFor = (long)(EXPECTED_TIME - computingTime) / 1000000;
					
					if(sleepFor < 0) {
						sleepFor = 0;
						System.out.println("Warning: FPS decrease!");
					}
					
					try {
						Thread.sleep(sleepFor);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//Displaying speed factor
					System.out.println(EXPECTED_TIME/computingTime);
				
			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */
			
			
		}while (Game.isRunning());
		
//----------------------END OF THE MAIN WHILE-------------------------//

	
	}
	
	private void updateTorpedoes(Torpedo[] playerTorpedo) {
		for(int ii = 0; ii < playerTorpedo.length; ii++) {
			if(playerTorpedo[ii].isVisible()) {
				playerTorpedo[ii].moveStep();
//				playerTorpedo[ii].checkEnd();
			}
		}
	}
	
	
	private void updateEnemies(Enemy[] enemies) {
		for(int ii = 0; ii < enemies.length; ii++) {
				enemies[ii].animate();
			//	enemies[ii].moveToNextPosition();
		}
	}
	
	private void updateStars(Star[] fastStar, Star[] slowStar) {
		for(int ii = 0; ii < slowStar.length; ii++) {
			slowStar[ii].moveStep();
			fastStar[ii].moveStep();
		}
	}

	

	
	
}


	


