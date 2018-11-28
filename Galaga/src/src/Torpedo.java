package src;

import edu.uc3m.game.GameBoardGUI;

public class Torpedo {

	private String imgPath;
	private int id;
	private GameBoardGUI board;
	private int x;
	private int y;
	
	
	public Torpedo(int id, GameBoardGUI board, int x, int y) {
		setX(x);
		setY(y);
		this.board = board;
		setId(id);
	}
	
	//Getters and setters
	private void setX(int x) {
		if(x > 0) {
			this.x = x;
		}
	}
	
	private void setY(int y) {
		if(y > 0) {
			this.y = y;
		}
	}
	
	private void setId(int id) {
		if(id > 0) {
			this.id = id;
		}
	}
	
	//Functions
	
	public void moveStep() {
		this.x = this.x + Game.TORPEDOES_SPEED;
	}
	
	
	
	
	

}
 