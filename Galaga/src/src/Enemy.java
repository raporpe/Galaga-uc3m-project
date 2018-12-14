package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

abstract public class Enemy extends Sprite {

	protected int pathPos;
	protected int[] temporalPathToFollow; // Esto va en coordenadas de una sola dimension

	protected boolean exploding;
	protected boolean attacking;
	protected boolean defaultSwarmSkin = true;
	protected double lastSystemTime;
	protected boolean swarm = true;
	protected int explodingSkin;


	public Enemy(GameBoardGUI board) {
		super(board);

	}

	public Enemy() {

	}
	
	protected void update() {
		animate();
//		if(swarm) {
//			moveSpriteTo()
//		}
	}



	public void animate() {
		if (exploding) {
			setSpriteSkin(Constants.getSkin(this, explodingSkin++));

			// Reset the explosion state
			if (explodingSkin >= 8) {
				explodingSkin = 0;
				exploding = false;
				setVisibility(false);

			}

		} else if (swarm) {
			if (System.currentTimeMillis() - lastSystemTime > 1000) {
				if (defaultSwarmSkin) {
					setSpriteSkin(Constants.getSkin(this, 0));
					defaultSwarmSkin = !defaultSwarmSkin;
				} else {
					setSpriteSkin(Constants.getSkin(this, -1));
					defaultSwarmSkin = !defaultSwarmSkin;

				}
				lastSystemTime = System.currentTimeMillis();
			}
		}
	}


	public void death() {
		exploding = true;
		//Visibility is disabled after exploding animation
	}

}
