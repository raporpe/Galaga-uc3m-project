package src;

import edu.uc3m.game.GameBoardGUI;

public class Zako extends Enemy{
		
	public Zako(int id, GameBoardGUI board){
		
		super(id, board, "enemy300.png");
	}
	public static void moveZako(Enemy zako) throws InterruptedException {
		
		zako.x = zako.getX()+(int) (Math.random()*10);
		zako.y = zako.getY()+(int) (Math.random()*10);
		Thread.sleep(20);	
	}
}
