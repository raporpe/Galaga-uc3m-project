package src;

import edu.uc3m.game.GameBoardGUI;

public class Torpedo {

	private String imgPath;
	private int id;
	private GameBoardGUI board;
	private int x;
	private int y;
	private boolean visible;
	private final int DEFAULT_POSTITION_X = 0;
	private final int DEFAULT_POSTITION_Y = 0;


	public Torpedo(int id, GameBoardGUI board) {
		setId(id);
		this.board = board;
		this.imgPath="torpedo100.png";
		
		//Generate sprites
		board.gb_addSprite(getId(), getImgPath(), true);
		board.gb_moveSpriteCoord(getId(), DEFAULT_POSTITION_X, DEFAULT_POSTITION_Y);
	}
	
	public void initTorpedo(int posX, int posY) {
		setX(posX);
		setY(posY);
		setVisibility(true);
		board.gb_moveSpriteCoord(getId(), getX(), getY());
		board.gb_setSpriteVisible(getId(), true);
	}
	
	//Getters and setters
	private void setX(int x) {
		if(x > 0) {
			this.x = x;
		}
	}
	
	private void setY(int y) {
		if(y > 0) {
			this.y = y;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	private void setId(int id) {
		if(id > 0) {
			this.id = id;
		}
	}
	
	private int getId() {
		return this.id;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisibility(boolean visibility) {
		this.visible = visibility;
	}
	

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	
	
	//Functions
	
	public void moveStep() {
		setY(getY() - Game.TORPEDOES_SPEED);
		board.gb_moveSpriteCoord(getId(), getX(), getY());
	}
	
	
	
	
	
	

}
 