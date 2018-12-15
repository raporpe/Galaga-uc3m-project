package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

abstract public class Enemy extends Sprite {

	protected int pathPos;
	protected int[] temporalPathToFollow; // Esto va en coordenadas de una sola dimension

	protected boolean exploding;
	protected boolean attacking;
	protected boolean defaultSwarmSkin = true;
	protected int explodingSkin;
	protected double lastSystemTime;
	protected boolean swarm=true;
	protected int xSwarm;
	protected int ySwarm;
	protected boolean boundRight;
	protected boolean boundLeft;

	// en el update
	/*
	 * si esta en el swarm, seguir xSwarm y tambien ySwarm
	 * si no esta en el swarm, seguir x y tambien y
	 */
	public Enemy(GameBoardGUI board) {
		super(board);
		xSwarm=x;
		ySwarm=y;

	}

	public Enemy() {

	}
	
	protected void update() {
		animate();
		if(swarm) {
			moveSpriteTo(xSwarm, ySwarm);
		}else {
			moveSpriteTo(x,y);
		}
	}
	



	public void animate() {
		if (exploding) {
			setSpriteSkin(Constants.getSkin(this, explodingSkin++));

			// Reset the explosion state
			if (explodingSkin >= 8) {
				explodingSkin = 0;
				exploding = false;
			}

		} else {
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
		setVisibility(false);
		//Visibility is disabled after exploding animation
	}

}
