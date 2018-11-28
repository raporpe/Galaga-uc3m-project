package src;

import edu.uc3m.game.GameBoardGUI;

abstract public class Sprite {
	
	protected int id;
	protected int x;
	protected int y;
	protected String imgPath;
	protected GameBoardGUI board;
	protected boolean visible;

	public Sprite(int id, GameBoardGUI board) {


		setId(id);
		setBoard(board);	
		
		//Creating sprite
		this.board.gb_addSprite(this.getId(), this.getImgPath(), true);
		this.board.gb_moveSpriteCoord(this.getId(), getX(), getY());
		
	}
	
	
	
	public boolean checkCollision(Sprite sprite) {
		if(Math.abs(sprite.getX() - this.getX()) < Game.SPRITE_WIDTH || Math.abs(sprite.getX() - this.getX()) < Game.SPRITE_WIDTH) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	//Getters and setters
		public int getId() {
			return id;
		}

		public int getX() {
			return x;
		}


		public int getY() {
			return y;
		}


		public void setId(int id) {
			this.id = id;
		}


		public void setX(int x) {
			this.x = x;
		}


		public void setY(int y) {
			this.y = y;
		}
		
		public String getImgPath() {
			return imgPath;
		}


		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}
		
		public GameBoardGUI getBoard() {
			return board;
		}

		public void setBoard(GameBoardGUI board) {
			this.board = board;
		}
		
		public boolean isVisible() {
			return visible;
		}
		
		public void setVisibility(boolean visibility) {
			this.visible = visibility;
			board.gb_setSpriteVisible(getId(), visibility);
		}
		
		//Functions
		
		public void moveSpriteTo(int x, int y) {
			board.gb_moveSpriteCoord(getId(), x, y);
		}
	

}
