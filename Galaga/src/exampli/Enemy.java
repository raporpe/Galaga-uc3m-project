package exampli;

import edu.uc3m.game.GameBoardGUI;

public class Enemy {
	private int x;
	private int y;
	private int id;

	private String image;
	
	TestingGUI board = new TestingGUI();
		
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
	
	public String getImage() {
		return image;
	}
	
	
	public void moving(int module, int dir) {
		setX(getX() + Constants.MOVES[dir][0]*module);
		switch(dir) {
		}
		setY(getY() + Constants.MOVES[dir][1]*module);

	
	}

	
}


