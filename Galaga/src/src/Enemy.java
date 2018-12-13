package src;
//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

abstract public class Enemy extends Sprite{
	

	protected int pathPos;
	protected int[] temporalPathToFollow; //Esto va en coordenadas de una sola dimension

	protected boolean exploding;
	protected int explodingSkin;
	protected boolean attacking;
	protected boolean defaultSwarmSkin;
	protected double lastSystemTime;
	

	
	public Enemy(int id, GameBoardGUI board) {
		super(id, board , Constants.enemyCoordinatesLevel1[id][0], Constants.enemyCoordinatesLevel1[id][1]); //Arreglar esto mañana
		setVisibility(true);

	}
	
	public Enemy() {
		
	}

	public void moveToNextPosition() {
		
		changeSpritePos(Constants.MOVES[temporalPathToFollow[pathPos]][0],Constants.MOVES[temporalPathToFollow[pathPos]][1]);
		setSpriteSkin(Constants.getSkin(this, temporalPathToFollow[pathPos]));
	}
	
	//Override this in every other Sprite
	public void animate() {
		if(exploding) {
			setSpriteSkin(Constants.getSkin(this, explodingSkin++));
			
			//Reset the explosion state
			if(explodingSkin >= 8) {
				explodingSkin = 0;
				exploding= false;
			}
			
		} else {
			if(System.currentTimeMillis() - lastSystemTime > 1000) {
				if(defaultSwarmSkin) {
					setSpriteSkin(Constants.getSkin(this, 0));
				} else {
					setSpriteSkin(Constants.getSkin(this, -1));
				}
				lastSystemTime = System.currentTimeMillis();
			}
		}
	}
	
	public void getStandardPath() {
			this.moveSpriteTo(this.getX(), explodingSkin);
	 }

	
	public void animateExplosion() {
		exploding = true;
	}


}
