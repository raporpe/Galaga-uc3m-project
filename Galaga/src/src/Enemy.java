package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


public class Enemy {
	
	private int id;
	private int x;
	private int y;
	protected String imgPath;
	private GameBoardGUI board;
	

	
	public Enemy(int id, GameBoardGUI b, String imgPath) {
	
		this.id=id;
		this.imgPath=imgPath;
		this.x = Constants.enemyCoordinatesLevel1[id][0];
		this.y = Constants.enemyCoordinatesLevel1[id][1];

		this.board = b;
		this.board.gb_addSprite(this.id, this.getImgPath(), true);
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

		if(Math.abs(pos1X-pos1X) < Game.COLLISION_RADIUS  && Math.abs(pos2X-pos2Y) < Game.COLLISION_RADIUS) {
			return true;
		}else {
			return false;
		}
	}
	public void move(int a, int b) {
		
	}
	
	
	
	
	
	
	
}
