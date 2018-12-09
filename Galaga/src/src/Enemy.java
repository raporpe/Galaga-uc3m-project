package src;
//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

abstract public class Enemy extends Sprite{
	

	protected int pathPos;
	protected int[] temporalPathToFollow; //Esto va en coordenadas de una sola dimension

	protected boolean exploding;
	protected int explodingSkin;
	protected boolean attacking;
	protected int lastSwarmSkin;
	
	public Enemy(int id, GameBoardGUI board) {
		super(id, board , Constants.enemyCoordinatesLevel1[id][0], Constants.enemyCoordinatesLevel1[id][1]);
		setVisibility(true);

	}
	

	public Enemy() {
		
	}

	
	
	public void moveToNextPosition() {
		


	}
	
	
	//Override this in every other Sprite
	public void animate() {
		if(exploding) {
			
		} else if (attacking){
			setSpriteSkin(Constants.getSkin(this, temporalPathToFollow[pathPos]));

		} else {
			if ()
			setSpriteSkin(Constants.getSkin(this, lastSwarm));

		}
		
	}



}
