package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


abstract public class Enemy extends Sprite{
	
	
	public Enemy(int id, GameBoardGUI board, String imgPath) {
		super(id, board, imgPath, Constants.enemyCoordinatesLevel1[id][0], Constants.enemyCoordinatesLevel1[id][1]);
		setVisibility(true);



	}
	
//	protected void moveToDefaultCoordinates(){
//		this.x = Constants.enemyCoordinatesLevel1[this.id][0];
//		this.y = Constants.enemyCoordinatesLevel1[this.id][1];
//		moveSpriteTo(this.x, this.y);
//	}

	public Enemy() {
		
	}



}
