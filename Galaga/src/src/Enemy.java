package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


abstract public class Enemy {
	
	private int id;
	private int x;
	private int y;
	private GameBoardGUI board;
	
	protected String imgPath;
	
	public Enemy(int id, GameBoardGUI board) {
		
		//Transferring board pointer
		this.board = board;
		
		this.id = id;
		
		//Setting coordinates
		this.x = Constants.enemyCoordinatesLevel1[id][0];
		this.y = Constants.enemyCoordinatesLevel1[id][1];
		
		//Creating sprites and setting coordinates and visibility
		this.board.gb_addSprite(this.id, this.imgPath, true);
		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
		this.board.gb_setSpriteVisible(this.id, true);


	}
	
	//Empty constructor
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
		if(Math.abs(pos1X-pos1X) < Game.COLLISION_RADIUS  && Math.abs(pos2X-pos2Y) < Game.COLLISION_RADIUS) {
			return true;
		}else {
			return false;
		}
		
	}
	public void move(int a, int b) {
		
	}
	
	
	
	
	
	
	
}
