package exampli;

public class Enemy {
	private int x;
	private int y;
	private int id;
	private byte dir;
	private String image;
	
	public Enemy (int x, int y, int id, String image) {
		setX(x);
		setY(y);
		setId(id);
		setImage(image);
	}
	
	public void setX(int x) {
		if(x>=0) {
			this.x=x;
		}
	}
	
	public void setY(int y) {
		if(y>=0) {
			this.y=y;
		}
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setImage(String im) {
		this.image=im;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getId() {
		return id;
	}
	
	public void move(byte direction, byte steps) {
		if(direction>=0 && direction<16) {
			dir = direction;
			this.x=this.x+Constants.MOVES[dir][0]*steps;
			this.y=this.y+Constants.MOVES[dir][1]*steps;

		}
	}
	public String getImage() {
		return image;
	}
	
	
	
}
