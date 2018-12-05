package src;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy{
	
	
	private int damageCount;
	
	
	public Commander(int id, GameBoardGUI board){
		
		super(id, board, "enemy1G0.png" , "enemy1G1.png");
		
	}
	
	
	

	//Getters and setters
	public int getDamageCount() {
		return damageCount;
	}


	public void setDamageCount(int damageCount) {
		this.damageCount = damageCount;
	}
}
