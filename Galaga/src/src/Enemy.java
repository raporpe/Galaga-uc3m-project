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
	protected double lastSystemTime2;

	protected boolean swarm = true;
	protected int explodingSkin = 20;

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
			if (System.currentTimeMillis() - lastSystemTime2 > 30) {

				setSpriteSkin(Constants.getSkin(this, explodingSkin++));

				// Reset the explosion state
				if (explodingSkin >= 26) {
					explodingSkin = 20;
					exploding = false;
					setVisibility(false);
					this.moveSpriteTo(Constants.DEFAULT_SPRITE_POS_X, Constants.DEFAULT_SPRITE_POS_Y);
				}
				lastSystemTime2 = System.currentTimeMillis();

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
		// Visibility is disabled after exploding animation
	}

}
