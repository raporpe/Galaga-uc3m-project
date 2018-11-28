package src;

import edu.uc3m.game.GameBoardGUI;

public class Zako extends Enemy{
		
	public Zako(int id, GameBoardGUI board){
		
		super(id, board, "enemy300.png");
	}
	
	public void moveZako(Enemy zako) throws InterruptedException {
		
			x = this.getX()+(int) (Math.random()*10);
			y = this.getX()+(int) (Math.random()*10);
		Thread.sleep(20);	
	}
}
