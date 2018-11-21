package src;

public class Player {
	private int x;
	private final int Y;
	
	

		
	//Constructor
	public Player (int x, int Y) {
		this.x = x;
		this.Y = Y;
		
	}
	
	
	//Setters and getters
	
	public int getX() {
		return x;
	}
	
	//Movements
	public void moveRight() {
		this.x = this.x + 1;
		
	}
	public void moveLeft() {
		this.x = this.x - 1;
	}
	
}
