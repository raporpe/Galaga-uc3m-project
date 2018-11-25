package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


public class Enemy {
	private int id;
	private int x;
	private int y;
	private String type;
	private String imgPath;
		
	public Enemy(int id, String type) {
		this.id=id;
		this.type=type;
		
		if(type.equals("zako")) {
			this.imgPath="enemy300.png";
		}else if(type.equals("goei")) {
			this.imgPath="enemy200.png";
		}else if(type.equals("galagan")) {
			this.imgPath="enemy100.png";
		}
		this.id=

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


	
	
	//Functions
	
	public boolean CheckCollision(int pos1X, int pos1Y, int pos2X, int pos2Y) {
		//Check player position
		if(pos1X==pos2X && pos2Y == pos2Y) {
			return true;
		}else {
			return false;
		}
	}
	public void move(int a, int b) {
		
	}
	
	
	
	
	
	
	
}
