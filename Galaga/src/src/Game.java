package src;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Importing the Locale object to change the default
//configuration of the computer to English
import java.util.Locale;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;
public class Game implements KeyListener {

	//We declare a GameBoardGUI object
	private static GameBoardGUI board;
	public int i=0;
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

	
	final static int FPS = 60;
	final static int EXPECTED_TIME = 1000000000 / FPS;
	final static int TORPEDOES_SPEED = 1;
	final static int SPRITE_WIDTH = 10;
	final static int SPRITE_HEIGTH = 10;
	final static int DEFAULT_SPRITE_POS_X = 0;
	final static int DEFAULT_SPRITE_POS_Y = 0;

	
	
	//Testing

	@Override
	public void keyTyped(KeyEvent e) {		
		int test = e.getKeyCode();
		if(test == KeyEvent.VK_0) {
			goUp();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void goUp() {
		Player pepe = new Player("pepe", 3, board);
		pepe.moveLeft(1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static Player player;
	private static Torpedo[] torpedo;
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String playerName;
		
		
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		//Create a 17x22 board
		board = new GameBoardGUI(Game.BOARD_WIDTH_BIG_COORDINATES,Game.BOARD_HEIGHT_BIG_COORDINATES);
		
		Enemy[] enemies = new Enemy[Constants.enemyCoordinatesLevel1.length];

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
		
		for(int ii = 0; ii<(BOARD_WIDTH_BIG_COORDINATES); ii++) {
			for(int jj = 0; jj < (BOARD_HEIGHT_BIG_COORDINATES); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		playerName = "Galaga";
	
	//	Game.board.gb_showMessageDialog("Select your name");
				

		
		
		
		
		//Create planets
		
		//We create the player
		player = new Player(playerName, 3, board);
		
		//Generate torpedoes array
		torpedo = new Torpedo[Game.BOARD_HEIGHT_BIG_COORDINATES];
		for(int ii = 0; ii < torpedo.length; ii++) {
			torpedo[ii] = new Torpedo((ii+50), board);
		}
		
		



//----------------------THE MAIN WHILE-------------------------//
		
		
	/* 			  ("`-''-/").___..--''"`-._
				   `6_ 6  )   `-.  (     ).`-.__.`)
				   (_Y_.)'  ._   )  `._ `. ``-..-'			//This cat will keep our code efficient, clean and organised.				   												
				 _..`--'_..-_/  /--'_.' ,'					//She  likes to eat bugs.
				(il),-''  (li),'  ((!.-'				
		
	*/
		
		do {
			
			//we take at the beggining the time
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
				shootTorpedo(player);
			}

			board.gb_moveSpriteCoord(player.getId(), player.getX(), player.getY());
			
			updateTorpedoes();

			/*for(int ii = 11; ii < 20; ii++) {
				Zako.moveZako(enemies[ii]);
			}	*/		
			
			//Implement fps control
			double computingTime = System.nanoTime() - initialTime;
			long sleepFor = (long)(EXPECTED_TIME - computingTime) / 1000000;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while(Game.isRunning());

	}
	
	private static void updateTorpedoes() {
		for(int ii = 0; ii < torpedo.length; ii++) {
			if(torpedo[ii].isVisible()) {
				torpedo[ii].moveStep();
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
	
	private void checkPossibleCollisions() {
		
	}
	
}


	


