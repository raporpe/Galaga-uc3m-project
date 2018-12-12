package src;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy{
	
	
	private int id;
	
	
	
	public Commander(int id, GameBoardGUI board){
		
		super(id, board);
		setLifes(2);
		
	}
	
	
	
	
	@Override
	public void moveToNextPosition() {
	
	}


}
