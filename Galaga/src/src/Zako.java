package src;

import edu.uc3m.game.GameBoardGUI;

public class Zako extends Enemy{
		
	public Zako(int id, GameBoardGUI board){
		super(id, board, "enemy300.png");
	}
	
	public static void moveZako(Enemy zako) {
		zako.x = zako.getX()+(int) (Math.random()*10);
		zako.y = zako.getY()+(int) (Math.random()*10);
	}
}
