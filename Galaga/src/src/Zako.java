package src;

import edu.uc3m.game.GameBoardGUI;

public class Zako extends Enemy{
	
	private GameBoardGUI board;
	
	public Zako(int id, GameBoardGUI board){
		
		super(id, board, "enemy300.png");
		
	}
}
