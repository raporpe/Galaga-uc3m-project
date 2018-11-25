package src;

public class Player {
	
	private int X = (int)(Game.width/2);
	private final int Y = (Game.height-20);
	private int id= 1;
	
	
	

		
	//Constructor
	public Player () {
		
		
		Game.board.gb_addSprite(1, "player.png", true);
		Game.board.gb_moveSpriteCoord(1, this.X, this.Y);
		Game.board.gb_setSpriteVisible(1, true);
		
	}
	
	
	//Setters and getters
	
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	public int getId() {
		return id;
	}
	
	//Movements
	public void moveRight() {
		if(this.X < Game.width-5) {
			this.X = this.X + 1;
		}
	}
	
	public void moveLeft() {
		if(this.X > 6) {
			this.X = this.X - 1;
		}
	}
	
	public void torpedo() {
		
		
		
	}
	
}
