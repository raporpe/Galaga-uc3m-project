package src;

import edu.uc3m.game.GameBoardGUI;

abstract public class Sprite {
	
	protected GameBoardGUI board;
	protected int id;
	protected int x;
	protected int y;
	protected boolean visible;
	protected int lifes = 1;
	protected String defaultSkin = "noSkin.png";


	
	


		
	public Sprite(GameBoardGUI board) {

		setBoard(board);
		setId(IdManager.assignId(this));
		setSpriteSkin(Constants.getSkin(this, 0));
		
		int[] tempInitialCoordinates = Constants.getCoordinates(this);
		setX(tempInitialCoordinates[0]);
		setY(tempInitialCoordinates[1]);

		//Initializing sprite
		this.board.gb_addSprite(this.id, this.defaultSkin, true);
		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
		setVisibility(true);
		
	}
	
	
//	protected void initializeSprite(int id, int x, int y, boolean visibility) {
//		setId(id);
//		setX(x);
//		setY(y);
//
//		//Creating sprite
//		this.board.gb_addSprite(this.id, this.defaultSkin, true);
//		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
//		setVisibility(visibility);
//	}
		
	
//	public Sprite(int id, GameBoardGUI board, int x, int y) {
//
//		setId(id);
//		setBoard(board);	
//		setX(x);
//		setY(y);														Deprecated
//		
//		//Creating sprite
//		this.board.gb_addSprite(this.id, this.defaultSkin, true);
//		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
//		
//	}

	
	
	public Sprite() {
		
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
		
		
		public int[] getCoordinates() {
			int[] coord = {this.x, this.y};
			return coord;
		}


		public void setId(int id) {
			if(id > 0) {
				this.id = id;
			}
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

		
		public void setSpriteSkin(String image){
			this.defaultSkin = image;
			board.gb_setSpriteImage(this.id, image);
		}
		
		
		public void destroy() {
			this.death();
			this.moveSpriteTo(Game.DEFAULT_SPRITE_POS_X, Game.DEFAULT_SPRITE_POS_Y);
		}
		
		//Temporal
		//They don't have explosion by default
		
		public void death() {
			this.setVisibility(false);
		} 
		
	

}
