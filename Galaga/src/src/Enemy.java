package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


public class Enemy {




	private int id;
	private int x;
	private int y;
	private int EnemyType;



	private String imgPath;
		
	

	public Enemy(int x, int y, int EnemyType, String imgPath) {
		
		//TODO: ADD THE CHECKER
		this.EnemyType = EnemyType;
		
		
		
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
	
	public boolean CheckCollision() {
		//Check player pos
		return true;
	}
	
	public void move(int a, int b) {
		
	}
	
	
	
	
	
	
	
}
