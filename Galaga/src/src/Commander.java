package src;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy{
	
	private GameBoardGUI board;
	public Commander(int id, GameBoardGUI board){
		super(id,board,"enemy100.png");
	}
}
