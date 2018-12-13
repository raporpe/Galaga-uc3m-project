package src;

//Importing the Locale object to change the default
//configuration of the computer to English
import java.util.Locale;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


public class Game {

	//We declare a GameBoardGUI object
	private static GameBoardGUI board;
	public int i = 0;
	public static final int COLLISION_RADIUS = 10;
	public static int dx = 0;

	
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
	
	static double initialTime;

	//Responsiveness
	public static final int BOARD_WIDTH = 170;
	public static final int BOARD_HEIGHT = 220;
	
	public static final int BOARD_WIDTH_BIG_COORDINATES = BOARD_WIDTH/10;
	public static final int BOARD_HEIGHT_BIG_COORDINATES = BOARD_HEIGHT/10;

	
	final static int FPS = 60;
	final static int EXPECTED_TIME = 1000000000 / FPS;
	final static int TORPEDOES_SPEED = 1;
	final static int SPRITE_WIDTH = 5;
	final static int SPRITE_HEIGTH = 5;
	final static int DEFAULT_SPRITE_POS_X = 0;
	final static int DEFAULT_SPRITE_POS_Y = 0;
	
	final static int MAX_TORPEDOES_PER_SQAURE = 1;
	
	final static int PLAYER_TORPEDOES_OFFSET = 5;
	
	
	//Testing
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static Player player;
	public final static Torpedo[] playerTorpedo = new Torpedo[Game.BOARD_HEIGHT_BIG_COORDINATES];

	static Enemy[] enemies;
	static Star[] star = new Star[Constants.StarPositions.length];

	
	
	
	public static void main(String[] args) {
		
		String playerName;
		
		
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		//Create a 17x22 board
		board = new GameBoardGUI(Game.BOARD_WIDTH_BIG_COORDINATES,Game.BOARD_HEIGHT_BIG_COORDINATES);
		
		enemies = new Enemy[Constants.enemyCoordinatesLevel1.length];


		for(int ii = 0; ii < 11; ii++) {
			enemies[ii] = new Goei(board);
		}
		
		for(int ii = 11; ii < 22; ii++) {
			enemies[ii] = new Zako(board);
		}
		for(int ii = 22; ii < 25; ii++) {
			enemies[ii] = new Commander(board);
		}
		
		board.setVisible(true);

		//Stars initialization
		for (int ii = 0; ii < star.length; ii++) {
			star[ii] = new Star(1, 0, board);
		}


		
		
		
		

		
		

				
		
		
		//Grid color setter
		board.gb_setGridColor(40, 40, 40);		
		
		for(int ii = 0; ii < (BOARD_WIDTH_BIG_COORDINATES); ii++) {
			for(int jj = 0; jj < (BOARD_HEIGHT_BIG_COORDINATES); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		playerName = "Galaga";
			
		
		
		
		//We create the player
		player = new Player(playerName, board);
		
		//Generate torpedoes array
		for(int ii = 0; ii < playerTorpedo.length; ii++) {
			playerTorpedo[ii] = new Torpedo(board);
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
			

			
			player.moveRight(Game.dx);			
			
			
			String lastAction;
			lastAction = board.gb_getLastAction();
			if(lastAction.equals("right")) {	
				player.moveRight(1);

			}
			if(lastAction.equals("left")) {
				player.moveLeft(1);
			}
			
			if(lastAction.equals("space")) {
				
				if(System.currentTimeMillis() - lastShotTime > (MAX_TORPEDOES_PER_SQAURE*10*1000/Game.FPS)) {
					shootTorpedo(player);
					lastShotTime = System.currentTimeMillis();
					System.out.println(lastShotTime);
				}
				
			}

			
			updateTorpedoes();
			updateEnemies();
			updateStars();
	
			
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
			
			
		}while(Game.isRunning());
		
//----------------------END OF THE MAIN WHILE-------------------------//

	
	}
	
	private static void updateTorpedoes() {
		checkTorpedoesCollisions();
		for(int ii = 0; ii < playerTorpedo.length; ii++) {
			if(playerTorpedo[ii].isVisible()) {
				playerTorpedo[ii].moveStep();
				//torpedo[ii].checkEnd();
			}
		}
	}
	
	
	private static void updateEnemies() {
		for(int ii = 0; ii < enemies.length; ii++) {
				enemies[ii].animate();
				enemies[ii].moveToNextPosition();
		}
	}
	
	private static void updateStars() {
		for(int ii = 0; ii < star.length; ii++) {
			star[ii].moveStep();
		}
	}


	
	static int m = 0;
	
	private static void shootTorpedo(Player player) { 
		if(m >= playerTorpedo.length) {
			m=0;
		}
		
		if(true) {
			playerTorpedo[m].initTorpedo(player.getX(), player.getY()-PLAYER_TORPEDOES_OFFSET);
			m++;
		}
		
	}
	
	private static void checkTorpedoesCollisions() {
		for(int ii = 0; ii < playerTorpedo.length; ii++) {
			for(int jj = 0; jj < enemies.length; jj++) {
				playerTorpedo[ii].checkCollision(enemies[jj]);
			}
		}
	}
	
}


	


