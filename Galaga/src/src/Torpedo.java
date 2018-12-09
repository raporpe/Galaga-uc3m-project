package src;

import edu.uc3m.game.GameBoardGUI;

public class Torpedo extends Sprite{

	
	
	public Torpedo(GameBoardGUI board) {
		super(IdManager.getId("torpedo"), board, 0, 0);

	//	this.imgPath = "torpedo100.png"; // Por qué this.imgPath y no arriba poner String imgPath = "torpedo100.png"; ????????????????
	//	setImgPath("torpedo100.png");  //POR QUÉ NO SE PUEDE PONER UN FIELD String imgPath = "torpedo100.png";  y hay que user setImagPath???
		


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
	
	public void checkEnd() {
		if(getY() <= 10) {
			setVisibility(false);
		}
	}
	
	
	
	
	
	

}
 