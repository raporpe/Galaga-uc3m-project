package src;
//Importing the Locale object to change the default
//configuration of the computer to English
import java.util.Locale;
//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;
public class Game {

	//We declare a GameBoardGUI object
	public static GameBoardGUI board;
	public int i=0;
	
	public static void main(String[] args) {
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		//Create a 17x22 board
		board = new GameBoardGUI(17,22);
		//We create an enemy
//		Enemy enemy1 = new Enemy(85,110,0,"player.png");
		//Adding the enemy to the board
//board.gb_addSprite(enemy1.getId(), enemy1.getImgPath(), true);
		//Placing the enemy at the requested coordinates
//board.gb_moveSpriteCoord(enemy1.getId(), enemy1.getX(), enemy1.getX());
		//set Sprite visible
//board.gb_setSpriteVisible(enemy1.getId(), true);
		//Make board visible
		board.setVisible(true);
				
		board.gb_setGridColor(10, 10, 10);
		
		//We create three layers of stars
		
		Runnable layer1 = new Stars(11, 100);
		new Thread(layer1).start();
		Runnable layer2 = new Stars(11, 500);
		new Thread(layer2).start();
		Runnable layer3 = new Stars(11, 1000);
		new Thread(layer3).start();



		board.gb_showMessageDialog("Test");;

		
//		do {
//			String lastAction;
//			lastAction = board.gb_getLastAction();
//			if(lastAction.equals("right")) {
//				enemy1.setX(enemy1.getX() + 1);
//			}
//			if(lastAction.equals("left")) {
//				enemy1.setX(enemy1.getX() - 1);
//			}
//			if(lastAction.equals("up")) {
//				enemy1.setY(enemy1.getY() - 1);
//			}
//			if(lastAction.equals("down")) {
//				enemy1.setY(enemy1.getY() + 1);
//			}
//			if(lastAction.equals("space")) {
//				enemy1.move((byte)1, (byte)1);
//			}
//			board.gb_moveSpriteCoord(enemy1.getId(), enemy1.getX(), enemy1.getY());
//		}while(false);

	}

}
