package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;



abstract public class Enemy extends Sprite{
	
	
	public Enemy(int id, GameBoardGUI board, String imgPath) {
		super(id, board, imgPath, Constants.enemyCoordinatesLevel1[id][0], Constants.enemyCoordinatesLevel1[id][1]);
		setVisibility(true);

	}
	

	public Enemy() {
		
	}



}
