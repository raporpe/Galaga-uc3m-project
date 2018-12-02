package src;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy{
	
	public Commander(int id, GameBoardGUI board){
		super(id,board,"enemy100.png");
	}
	public static void moveZako(Enemy commander) {
		commander.x = commander.getX()+(int) (Math.random()*10);
		
	}
	
	public static void damaged(Enemy commander) {
		commander.imgPath="enemy900.png";
	}
}
