package src;
import edu.uc3m.game.GameBoardGUI;

/**
 * An extra class created for the movement of stars
 * 
 * @author Raúl P. and Diego G.
 * @version 7.2
 * 
 */

public class Star extends Sprite {

	private double speed;
	private double lastSystemTime = System.currentTimeMillis(); // TODO: DO SOMETHING WITH THIS

	public Star(GameBoardGUI board, double speed, int shift) {

		super(board, 0, false, 1);
		setSpeed(speed);

	}

	public void update() {
		moveStep();
	}

	public void moveStep() {
		if (System.currentTimeMillis() - lastSystemTime > 1 / speed) {
			setY(this.y + 1);

			if (this.y == Constants.BOARD_HEIGHT) {
				setY(0);
			}

			board.gb_moveSpriteCoord(this.id, this.x, this.y);
			lastSystemTime = System.currentTimeMillis();
		}

	}

	// Getters and setters
	private void setSpeed(double speed) {
		if (speed > 0 && speed <= 1) {
			this.speed = speed;
		} else {
			this.speed = 1;
		}
	}

}
