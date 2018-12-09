package src;

import edu.uc3m.game.GameBoardGUI;

abstract public class Sprite {
	
	protected int id;
	protected int x;
	protected int y;
	protected GameBoardGUI board;
	protected boolean visible;
	
	//Animation and image change
	protected String defaultSpriteImage;
	protected String alternativeSpriteImage;
	protected int animationState;

	public Sprite(int id, GameBoardGUI board, int x, int y) {

		setId(id);
		setBoard(board);	
		
		setX(x);
		setY(y);
		
		
		
		//Creating sprite
		this.board.gb_addSprite(this.getId(), this.getImgPath(), true);
		this.board.gb_moveSpriteCoord(this.getId(), getX(), getY());
		
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
		
		public String getImgPath() {
			return defaultSpriteImage;
		}

		public void setSpriteImage(String spriteImageFrame1, String spriteImageFrame2) {
			this.defaultSpriteImage = spriteImageFrame1;
			this.alternativeSpriteImage = spriteImageFrame2;
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
		
		public String getSpriteImageFrame1() {
			return this.defaultSpriteImage;
		}

		public String getSpriteImageFrame2() {
			return this.alternativeSpriteImage;
		}

		
		public int getAnimationState() {
			return animationState;
		}

		public void setAnimationState(int animationState) {
			if(animationState >= 0 && 4 >= animationState) {
				this.animationState = animationState;
			}
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
		
		public void moveDefaultLocation() {
			board.gb_moveSpriteCoord(getId(), 0, 0);
		}
		
		public void destroy(Sprite sprite) {
			sprite.animateExplosion();
			sprite.setVisibility(false);
			sprite.moveSpriteTo(Game.DEFAULT_SPRITE_POS_X, Game.DEFAULT_SPRITE_POS_Y);
		}
		
		public void animateExplosion() { //Must go before animate().
			this.setAnimationState(2); //Change it for a direct variable change instead of setter. For learning purpose.
		}
		
		public void setSpriteDisplayingImage(String image){
			board.gb_setSpriteImage(this.getId(), image);
		}
		
		
		public void animate() {

			switch(animationState){
			case 0:
				setSpriteDisplayingImage(this.getSpriteImageFrame1());
				setAnimationState(1);
				break;
				
			case 1:
				setSpriteDisplayingImage(this.getSpriteImageFrame2());
				setAnimationState(0);
				break;

			case 2:
				setAnimationState(3);
				break;

			case 3:
				setAnimationState(4);
				break;

			case 4:
				setAnimationState(5);
				break;
				
			case 5:
				
				setAnimationState(0);
				break;
				
			}
		}
	

}
