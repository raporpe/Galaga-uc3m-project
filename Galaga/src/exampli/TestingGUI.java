package exampli;
//Importing the Locale object to change the default
//configuration of the computer to English
import java.util.Locale;
//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;
public class TestingGUI {

	public static void main(String[] args) {
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));
		//We declare a GameBoardGUI object
		GameBoardGUI board;
		//Create a 17x22 board
		board = new GameBoardGUI(17,22);
		//We create an enemy
		Enemy enemy1= new Enemy(85,110,0,"enemy100.png");
		//Adding the enemy to the board
		board.gb_addSprite(enemy1.getId(), enemy1.getImage(), true);
		//Placing the enemy at the requested coordinates
		board.gb_moveSpriteCoord(enemy1.getId(), enemy1.getX(), enemy1.getX());
		//set Sprite visible
		board.gb_setSpriteVisible(enemy1.getId(), true);
		//Make board visible
		board.setVisible(true);
		
		
		do {
			String lastAction;
			lastAction = board.gb_getLastAction();
			if(lastAction.equals("right")) {
				enemy1.setX(enemy1.getX() + 1);
			}
			if(lastAction.equals("left")) {
				enemy1.setX(enemy1.getX() - 1);
			}
			if(lastAction.equals("up")) {
				enemy1.setY(enemy1.getY() - 1);
			}
			if(lastAction.equals("down")) {
				enemy1.setY(enemy1.getY() + 1);
			}
			board.gb_moveSpriteCoord(enemy1.getId(), enemy1.getX(), enemy1.getY());
		}while(true);

	}

}
