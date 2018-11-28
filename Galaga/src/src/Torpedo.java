package src;

import edu.uc3m.game.GameBoardGUI;

public class Torpedo extends Sprite{


	
	public Torpedo(int id, GameBoardGUI board) {
		super(id, board);
		setImgPath("torpedo100.png");
	}


	public void initTorpedo(int posX, int posY) {
		setX(posX);
		setY(posY);
		setVisibility(true);
		moveSpriteTo(posX, posY);
	}
	
	
	//Functions
	
	public void moveStep() {
		setY(getY() - Game.TORPEDOES_SPEED);
		board.gb_moveSpriteCoord(getId(), getX(), getY());
	}
	
	
	
	
	
	

}
 