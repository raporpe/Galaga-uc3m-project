package src;

import edu.uc3m.game.GameBoardGUI;

abstract public class Sprite {
	
	protected int id;
	protected int x;
	protected int y;
	protected GameBoardGUI board;
	protected boolean visible;
	protected String defaultSkin = Constants.getSkin(this, 0);
	protected int lifes = 1;
	
	
	//Animation and image change
	


	public Sprite(int id, GameBoardGUI board, int x, int y) {

		setId(id);
		setBoard(board);	
		
		setX(x);
		setY(y);
		
		
		
		//Creating sprite
		this.board.gb_addSprite(this.id, this.defaultSkin, true);
		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
		
	}
	
	public Sprite() {
		
	}
	
	
	
	public boolean checkCollision(Sprite sprite) {
		if(Math.abs(sprite.getX() - this.getX()) < Game.SPRITE_WIDTH && Math.abs(sprite.getY() - this.getY()) < Game.SPRITE_WIDTH) {
			this.setVisibility(false);
			this.moveDefaultLocation();
			sprite.destroy(sprite);
			
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
		
		public String getDefaultSkin() {
			return defaultSkin;
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
		
		
		public int getLifes() {
			return lifes;
		}

		protected void setLifes(int lifes) {
			this.lifes = lifes;
		}
		


		
		//Functions

		public void setVisibility(boolean visibility) {
			this.visible = visibility;
			board.gb_setSpriteVisible(getId(), visibility);
		}
		
		
		
		public void moveSpriteTo(int x, int y) {
			this.setX(x);												//
			this.setY(y);												// Why?
			board.gb_moveSpriteCoord(this.getId(), this.x, this.y);		//
		}
		
		public void changeSpritePos(int dx, int dy) {
			this.setX(x + dx);												//
			this.setY(y + dy);												// Why?
			board.gb_moveSpriteCoord(this.getId(), this.x, this.y);	     	//
		}
		
		
		public void moveDefaultLocation() {
			board.gb_moveSpriteCoord(getId(), 0, 0);
		}
		
		public void destroy(Sprite sprite) {
			sprite.animateExplosion();
			sprite.setVisibility(false);
			sprite.moveSpriteTo(Game.DEFAULT_SPRITE_POS_X, Game.DEFAULT_SPRITE_POS_Y);
		}
		
		
		public void setSpriteSkin(String image){
			board.gb_setSpriteImage(this.getId(), image);
		}
		
		//Temporal
		public void animateExplosion() {
		} //They dont have explosion by default

		public void setLevel(int newLevel) {
			
		}


		
	

}
