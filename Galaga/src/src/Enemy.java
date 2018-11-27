package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


public class Enemy {
	private int id;
	private int x;
	private int y;
	private String imgPath;
	private GameBoardGUI board;
	
	public Enemy(int id, GameBoardGUI b) {
		
		this.id=id;
		
		this.x = Constants.enemyCoordinatesLevel1[id][0];
		this.y = Constants.enemyCoordinatesLevel1[id][1];
		
		this.board = b;

		Game.board.
		
		this.board.gb_addSprite(this.id, this.imgPath, true);
		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
		this.board.gb_setSpriteVisible(this.id, true);


	}
	
	public Enemy() {
		
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
