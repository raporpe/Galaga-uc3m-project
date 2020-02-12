package src;

import edu.uc3m.game.GameBoardGUI;

/**
 * Child of Sprite. Controls everything related to initializations, movements of
 * torpedoes...
 * 
 * @author Raúl P. and Diego G.
 * @version 18.1
 * 
 */

abstract public class Torpedo extends Sprite {

	public Torpedo(GameBoardGUI board) {
		super(board, 1, false, 1);

		// By default, torpedoes are waiting to be fired, this is why they are not
		// visible at the beginning.
		setVisibility(false);
	}

	@Override
	public void initialCoordinates() {
		// We don't want to perform any operation because torpedoes don't need initial
		// coordinates
	}

	public void update() {
		moveStep();
		checkEnd();
	}

	/**
	 * Shoots a torpedo in the desired position.
	 * 
	 * @param posX x coordinate where the torpedo begins
	 * @param posY y coordinate where the torpedo begins
	 */
	public void initTorpedo(int posX, int posY) {
		setX(posX);
		setY(posY);
		moveSpriteTo(posX, posY);
		setVisibility(true);
		this.activeCollisions = true;
	}

	/**
	 * Moves the torpedo to the next position.
	 */
	abstract public void moveStep();

	/**
	 * Checks if the torpedo has reached the end of the board. In that case, it
	 * hides it and deactivate the collisions.
	 */
	abstract public void checkEnd();
	
	
	//Empty constructor
	public Torpedo() {
		
	}

}
