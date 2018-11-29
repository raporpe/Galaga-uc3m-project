package src;

import edu.uc3m.game.GameBoardGUI;

public class Goei extends Enemy{
		
	public Goei(int id,GameBoardGUI board){
		
		super(id, board, "enemy200.png");

	}
	
	public static void moveGoei(Enemy goei) {
		
		goei.x = goei.getX()+(int) (Math.random()*10);
		goei.y = goei.getY()+(int) (Math.random()*10);
		
	}
}

