package src;

import edu.uc3m.game.GameBoardGUI;

public class Goei extends Enemy{
		
	public Goei(int id,GameBoardGUI board){
		
		super(id, board, "enemy2G0.png", "enemy2G1.png");

	}
	
	public static void moveGoei(Enemy goei) {
		
		goei.x = goei.getX()+(int) (Math.random()*10);
		goei.y = goei.getY()+(int) (Math.random()*10);
		
	}
}

