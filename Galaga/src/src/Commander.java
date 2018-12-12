package src;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy{	
	
	public Commander(GameBoardGUI board){
		
		super(IdManager.assignId("commander"), board);
		setLifes(2);
		
	}
	
	
	
	
	@Override
	public void moveToNextPosition() {
	
	}


}
