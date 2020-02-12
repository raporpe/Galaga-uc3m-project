package src;
import edu.uc3m.game.GameBoardGUI;

/**
 * Child of Torpedo
 * 
 * @author Raúl P. and Diego G.
 * @version 4.6
 * 
 */

public class PlayerTorpedo extends Torpedo {

	public PlayerTorpedo(GameBoardGUI board) {
		super(board);
	}

	//Executed in the update()
	public void moveStep() {
		setY(this.y - Constants.TORPEDOES_SPEED);
		board.gb_moveSpriteCoord(this.id, this.x, this.y);
	}

	//Executed in the update()
	public void checkEnd() {
		if (this.y <= -5) {
			setVisibility(false);
			activeCollisions = false;
		}
	}

	//Executed by the player
	//The player can shoot normal torpedoes and megaTorpedoes.
	public void initTorpedo(int posX, int posY, boolean megaTorpedo) {
		super.initTorpedo(posX, posY);

		// If the player torpedo is an megaTorpedo.
		if (megaTorpedo) {

			//To be sure this torpedo doesn't die so easily.
			this.lives = 100;
			setSpriteSkin("torpedo300.png", true);

		} else {

			//If the torpedo in the array is reused, the torpedo has to be set to a normal one again.
			this.lives = 1;
			setSpriteSkin("torpedo100.png", false);

		}
	}

}
