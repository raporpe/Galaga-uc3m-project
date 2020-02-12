package src;
import edu.uc3m.game.GameBoardGUI;

/**
 * Class for the torpedoes of enemy
 * 
 * @author Raúl P. and Diego G.
 * @version 2.1
 * 
 */

public class EnemyTorpedo extends Torpedo {

	public EnemyTorpedo(GameBoardGUI board) {
		super(board);
	}

	//Executed in update()
	public void moveStep() {

		setY(this.y + Constants.TORPEDOES_SPEED);
		board.gb_moveSpriteCoord(this.id, this.x, this.y);

	}

	//Executed in update()
	//To check if the torpedo has reached the end and prevent it from colliding with other sprites.
	public void checkEnd() {
		if (this.y >= Constants.BOARD_HEIGHT + 5) {
			setVisibility(false);
			activeCollisions = false;
		}
	}

}
