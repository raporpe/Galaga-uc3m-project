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
//	Constants constants = new Constants();


	
	


		
 	public Sprite(GameBoardGUI board) {

		setBoard(board);
		setId(IdManager.assignId(this));
		setSpriteSkin(Constants.getSkin(this, 0));
		
		if(!(this instanceof Enemy || this instanceof Torpedo)) { //Find better implementation
			int[] tempInitialCoordinates = Constants.getInitialCoordinatesVector(this);
			setX(tempInitialCoordinates[0]);
			setY(tempInitialCoordinates[1]);
		}


		//Initializing sprite
		this.board.gb_addSprite(this.id, this.defaultSkin, true);
		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
		setVisibility(true);
		
	}

	
	protected void update() {
		
	}
	

	
	
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
			board.gb_setSpriteVisible(this.id, visibility);
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
			board.gb_setSpriteImage(id, this.defaultSkin);
		}
		
		
		public void destroy() {
			this.death();
			this.moveSpriteTo(Constants.DEFAULT_SPRITE_POS_X, Constants.DEFAULT_SPRITE_POS_Y);
		}
		
		//Temporal
		//They don't have explosion by default
		
		public void death() {
			this.setVisibility(false);
		} 
		
		public boolean equals(String string) {
			if(string.equals(this.getClass().getName())) {
				return true;
			}
			return false;
		}
		
	

}
