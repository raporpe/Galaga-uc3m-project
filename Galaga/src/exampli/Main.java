package exampli;
import java.util.Locale;
import edu.uc3m.game.GameBoardGUI;


public class Main {
	
	public static void main(String[] args) {
		
		Locale.setDefault(new Locale("en"));
		
		GameBoardGUI board;
		
		board = new GameBoardGUI(17,22);
		
		board.setVisible(true);
		
		Enemy example = new Enemy(85,110);
		

	
	}
	
	
}
