package src;

import edu.uc3m.game.GameBoardGUI;

public class Torpedo extends Sprite{

	
	
	public Torpedo(GameBoardGUI board) {
		super(board);
		setVisibility(false);

	}


	public void initTorpedo(int posX, int posY) {
		setX(posX);
		setY(posY);
		setVisibility(true);
		moveSpriteTo(posX, posY);
	}
	
	
	//Functions
	
	public void moveStep() {
		setY(this.y - Game.TORPEDOES_SPEED);
		board.gb_moveSpriteCoord(this.id, this.x, this.y);
	}
	
	public void checkEnd() {
		if(this.y <= 10) {
			setVisibility(false);
		}
	}
	
	
	
	
	
	

}
 