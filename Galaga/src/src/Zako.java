package src;

import edu.uc3m.game.GameBoardGUI;

public class Zako extends Enemy{
		
	public Zako(int id, GameBoardGUI board){
		
		super(id, board, "enemy300.png");
	}
	
	public void moveZako(Enemy zako,int speed) throws InterruptedException {
		
		for(int i =0;i<11;i++)
			x = this.getX()+(int) (Math.random()*speed);
			y = this.getX()+(int) (Math.random()*speed);
		Thread.sleep(20);	
	}
}
