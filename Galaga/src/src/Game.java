package src;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	
	
	//Responsive
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

	
	
	//Testing
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static Player player;
	private static Torpedo[] torpedo;
	static Enemy[] enemies;

	
	private static int rightFactor = 0;
	private static int leftfactor = 0;
	
	
	
	
	
	public static void main(String[] args) {
		
		String playerName;
		
		
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		//Create a 17x22 board
		board = new GameBoardGUI(Game.BOARD_WIDTH_BIG_COORDINATES,Game.BOARD_HEIGHT_BIG_COORDINATES);
		
		enemies = new Enemy[Constants.enemyCoordinatesLevel1.length];


		for(int ii = 0; ii < 10; ii++) {
			enemies[ii] = new Goei(ii,board);
		}
		
		for(int ii = 10; ii < 20; ii++) {
			enemies[ii] = new Zako(ii,board);
		}
		for(int ii = 20; ii < 23; ii++) {
			enemies[ii] = new Commander(ii,board);
		}
		

		


		
		
		
		

		
		
		board.setVisible(true);
				
		
		
		//Grid color setter
		board.gb_setGridColor(80, 80, 80);		
		
		for(int ii = 0; ii < (BOARD_WIDTH_BIG_COORDINATES); ii++) {
			for(int jj = 0; jj < (BOARD_HEIGHT_BIG_COORDINATES); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		playerName = "Galaga";
	
	//	Game.board.gb_showMessageDialog("Select your name");
				

		
		
		
		
		//Create planets
		
		//We create the player
		player = new Player(playerName, board);
		
		//Generate torpedoes array
		torpedo = new Torpedo[Game.BOARD_HEIGHT_BIG_COORDINATES];
		for(int ii = 0; ii < torpedo.length; ii++) {
			torpedo[ii] = new Torpedo((ii+50), board);
		}
		
		double lastShotTime = 0;

		//FOr the keylistener


//----------------------THE MAIN WHILE-------------------------//
		
		
/* 				  ("`-''-/").___..--''"`-._
				   `6_ 6  )   `-.  (     ).`-.__.`)
				   (_Y_.)'  ._   )  `._ `. ``-..-'			//This cat will keep our code efficient, clean and organised.				   												
				 _..`--'_..-_/  /--'_.' ,'					//She likes eating bugs.
				(il),-''  (li),'  ((!.-'						
*/
		
		do {
			
			//we take at the beginning the time
			//THIS IS AN IMPLEMENTATION OF FPS SYSTEM
			double initialTime = System.nanoTime();
			
	
			
			
			
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
				
				if(System.currentTimeMillis() - lastShotTime > (30*1000/Game.FPS)) {
					shootTorpedo(player);
					lastShotTime = System.currentTimeMillis();
					System.out.println(lastShotTime);
				}
				
			}
			
			player.moveLeft(leftfactor);
			player.moveRight(rightFactor);

			board.gb_moveSpriteCoord(player.getId(), player.getX(), player.getY());
			
			updateTorpedoes();
	
			
			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\   FPS CONTROLLER  \::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */
		
					double computingTime = System.nanoTime() - initialTime;
					long sleepFor = (long)(EXPECTED_TIME - computingTime) / 1000000;
					
					if(sleepFor < 0) {
						sleepFor = 0;
						System.out.println("FPS decrease");
					}
					
					try {
						Thread.sleep(sleepFor);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */
			
			
		}while(Game.isRunning());
		
//----------------------END OF THE MAIN WHILE-------------------------//


		
//		board.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				int key = e.getKeyCode();
//						if(key == KeyEvent.VK_0) {
//							rightFactor = 0;
//						}	
//						if(key == KeyEvent.VK_B) {
//							leftfactor = 0;
//						}				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int key = e.getKeyCode();
//						if(key == KeyEvent.VK_0) {
//							rightFactor = 1;
//						}	
//						if(key == KeyEvent.VK_B) {
//							leftfactor = 1;
//						}	
//			}
//		});
		
		
		
		
		
		
		
	}
	
	private static void updateTorpedoes() {
		checkTorpedoesCollisions();
		for(int ii = 0; ii < torpedo.length; ii++) {
			if(torpedo[ii].isVisible()) {
				torpedo[ii].moveStep();
				//torpedo[ii].checkEnd();
			}
		}
	}
	
	private void updateSprites() {
	}
	
	private void updateStars() {
		
	}


	
	static int m = 0;
	
	private static void shootTorpedo(Player player) { 
		if(m >= torpedo.length) {
			m=0;
		}
		
		if(true) {
			torpedo[m].initTorpedo(player.getX(), player.getY()-5);
			m++;
		}
		
	}
	
	private static void checkTorpedoesCollisions() {
		for(int ii = 0; ii < torpedo.length; ii++) {
			for(int jj = 0; jj < enemies.length; jj++) {
				torpedo[ii].checkCollision(enemies[jj]);
			}
		}
	}
	
}


	


