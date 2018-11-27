package src;
//Importing the Locale object to change the default
//configuration of the computer to English
import java.util.Locale;
//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;
public class Game {

	//We declare a GameBoardGUI object
	private static GameBoardGUI board;
	public int i=0;
	
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
		
		for(int ii = 0; ii < enemies.length; ii++) {
			enemies[ii] = new Zako(1);
			if(ii-2 < enemies.length) {
				enemies[ii] = new Goei(2);
			}
		}
		
		
		
		
		

		
		
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
		
		
		
		




		
		
		
		
		
		
		do {
			String lastAction;
			lastAction = board.gb_getLastAction();
			if(lastAction.equals("right")) {	
				player.moveRight();

			}
			if(lastAction.equals("left")) {
				player.moveLeft();
			}
			
			if(lastAction.equals("space")) {
				player.torpedo();
				Game.running = false;
			}

			board.gb_moveSpriteCoord(player.getId(), player.getX(), player.getY());
			
		}while(Game.running);

	}

}
