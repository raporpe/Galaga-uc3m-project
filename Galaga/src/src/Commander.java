package src;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy{
	
	
	
	public Commander(GameBoardGUI board){
		
		super(IdManager.getId("commander"), board);
		setLifes(2);
		
	}
	
	
	
	
	@Override
	public void moveToNextPosition() {
	
	}


}
