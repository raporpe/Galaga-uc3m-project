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
	public int i=0;
	public static final int COLLISION_RADIUS = 10;
	public static int dx = 0;

	
	public static boolean running = true;
	
	
	//Responsive
	public static int width = 170;
	public static int height = 220;
	
	public static void main(String[] args) {
		
		String playerName;
		
		
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		//Create a 17x22 board
		board = new GameBoardGUI(Game.width/10,Game.height/10);
		
		Enemy[] enemies = new Enemy[Constants.enemyCoordinatesLevel1.length];
		/*for(int ii = 0; ii < enemies.length; ii++) {
			enemies[ii] = new Zako(ii,board);
			if(ii-2 < enemies.length) {
				enemies[ii] = new Goei(ii,board);
			}
		}*/
		enemies[0]= new Zako(0,board);
		enemies[1]= new Commander(1,board);
		enemies[2]= new Goei(2,board);

		
		
		
		

		
		
		board.setVisible(true);
				
		
		
		//Grid color setter
		board.gb_setGridColor(80, 80, 80);		
		
		for(int ii = 0; ii<(width/10); ii++) {
			for(int jj = 0; jj < (height/10); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		playerName = "Galagoncio";
	
	//	Game.board.gb_showMessageDialog("Select your name");
				

		//Create planets
		
		//We create the player
		Player player = new Player(playerName, 3, board);
		
		
		
		



		board.addKeyListener(new KeyListener() {
						
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				Game.dx = 0;
				
			}
			
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				Game.dx = 1;
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		do {
			
			player.moveRight(Game.dx);			
			
			
//			String lastAction;
//			lastAction = board.gb_getLastAction();
//			if(lastAction.equals("right")) {	
//				player.moveRight();
//
//			}
//			if(lastAction.equals("left")) {
//				player.moveLeft();
//			}
//			
//			if(lastAction.equals("space")) {
//				player.torpedo();
//				Game.running = false;
//			}

			board.gb_moveSpriteCoord(player.getId(), player.getX(), player.getY());
			
		}while(Game.running);

	}

}
