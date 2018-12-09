package src;
//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

abstract public class Enemy extends Sprite{
	

	protected int pathPos;
	protected int[] temporalPathToFollow;

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
	
	
	//Override this in every other 
	public void animate() {
		if(exploding) {
			setSpriteSkin(Constants.getSkin(this, ));
		} else if (attacking){
			
		} else {
			if ()
			setSpriteSkin(Constants.getSkin(this, lastSwarm));

		}
		
	}



}
