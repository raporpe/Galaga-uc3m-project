package src;

public class Player {
	private int x;
	final int Y;
	private String sprite;

	public Player (int x, int y, String sprite) {
		setX(x);
		this.Y=y;
		setSprite(sprite);
	}
	
	public void setX(int x) {
		if(x>=0) {
			this.x=x;
		}
	}
	
	
	public void setSprite(String sprite) {
		this.sprite=sprite;
	}
	
	public int getX() {
		return x;
	}
	
	public String getSprite() {
		return sprite;
	}
	
	public void move(int module, int dir) {
		setX(getX() + Constants.MOVES[dir][0]*module);
		
		setY(getY() + Constants.MOVES[dir][1]*module);
		
	}
}
