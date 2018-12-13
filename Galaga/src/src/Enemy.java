package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;

abstract public class Enemy extends Sprite {

	protected int pathPos;
	protected int[] temporalPathToFollow; // Esto va en coordenadas de una sola dimension

	protected boolean exploding;
	protected int explodingSkin;
	protected boolean attacking;
	protected boolean defaultSwarmSkin = true;
	protected double lastSystemTime;


	public Enemy(GameBoardGUI board) {
		super(board);

	}

	public Enemy() {

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

	public void getStandardPath() {
		this.moveSpriteTo(this.getX(), explodingSkin);
	}

	public void death() {
		exploding = true;
		//Visibility is disabled after exploding animation
	}

}
