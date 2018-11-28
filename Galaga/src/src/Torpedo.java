package src;

import edu.uc3m.game.GameBoardGUI;

public class Torpedo extends Sprite{

		
	
	public Torpedo(int id, GameBoardGUI board) {
	//	this.imgPath = "torpedo100.png"; // Por qu� this.imgPath y no arriba poner String imgPath = "torpedo100.png"; ????????????????
		setImgPath("torpedo100.png");  //POR QU� NO SE PUEDE PONER UN FIELD String imgPath = "torpedo100.png";  y hay que user setImagPath???
		
		setId(id);				
		setBoard(board);	
		
		//Creating sprite
		this.board.gb_addSprite(this.getId(), this.getImgPath(), true);
		this.board.gb_moveSpriteCoord(this.getId(), getX(), getY());
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
 