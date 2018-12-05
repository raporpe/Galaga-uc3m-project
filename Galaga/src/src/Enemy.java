package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;



abstract public class Enemy extends Sprite{
	
	protected String[] explosion = new String[] {"explosion20", "explosion21", "explosion22", "explosion23", "explosion24"};

	
	public Enemy(int id, GameBoardGUI board, String spriteImageFrame1, String spriteImageFrame2) {
		super(id, board, spriteImageFrame1, spriteImageFrame2 , Constants.enemyCoordinatesLevel1[id][0], Constants.enemyCoordinatesLevel1[id][1]);
		setVisibility(true);

	}
	

	public Enemy() {
		
	}
	boolean right =true;
	public void moveToNextPosition() {
		if(right==true) {
			setX(getX()+1);
		}
		if(getX()==Game.BOARD_WIDTH-25) {
			setY(getY()+5);
			right=false;
		}
		if(right==false) {
			setX(getX()-1);
		}
		if(getX()==25) {
			setY(getY()+5);
			right=true;
		}
	}



}
