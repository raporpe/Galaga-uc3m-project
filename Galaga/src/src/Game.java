package src;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Importing the Locale object to change the default
//configuration of the computer to English
import java.util.Locale;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;
public class Game{

	//We declare a GameBoardGUI object
	private static GameBoardGUI board;
	public int i=0;
	public static final int COLLISION_RADIUS = 10;
	public static final int TORPEDOES_SPEED = 1;
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
	
	final static int FPS = 60;
	final static int EXPECTED_TIME = 1000000000 / FPS;
	
	
	

	
	public void goUp() {
		Player pepe = new Player("pepe", 3, board);
		pepe.moveLeft(1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		String playerName;
		
		
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		//Create a 17x22 board
		board = new GameBoardGUI(Game.BOARD_WIDTH/10,Game.BOARD_HEIGHT/10);
		
		Enemy[] enemies = new Enemy[Constants.enemyCoordinatesLevel1.length];

		for(int ii = 0; ii < 11; ii++) {
			enemies[ii] = new Goei(ii,board);
		}
		for(int ii = 11; ii < 21; ii++) {
			enemies[ii] = new Zako(ii,board);

		}
		for(int ii = 21; ii < 24; ii++) {
			enemies[ii] = new Commander(ii,board);
		}


		
		
		
		

		
		
		board.setVisible(true);
				
		
		
		//Grid color setter
		board.gb_setGridColor(80, 80, 80);		
		
		for(int ii = 0; ii<(BOARD_WIDTH/10); ii++) {
			for(int jj = 0; jj < (BOARD_HEIGHT/10); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		playerName = "Galagoncio";
	
	//	Game.board.gb_showMessageDialog("Select your name");
				

		
		
		
		
		//Create planets
		
		//We create the player
		Player player = new Player(playerName, 3, board);
		
		
		
		



//----------------------THE MAIN WHILE-------------------------

		
		
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
				player.torpedo();
			}

			board.gb_moveSpriteCoord(player.getId(), player.getX(), player.getY());
			
			
			
			
			
			
			//Implement fps control
			double computingTime = System.nanoTime() - initialTime;
			long sleepFor = (long)(EXPECTED_TIME - computingTime) / 1000000;
			
//			try {
//				Thread.sleep(sleepFor);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		}while(Game.isRunning());

	}


	

}
