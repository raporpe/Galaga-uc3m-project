package src;
import edu.uc3m.game.GameBoardGUI;

/**
 * Class for the sprite of the enemy "Commander"
 * 
 * @author Raúl P. and Diego G.
 * @version 2.3
 * 
 */

public class Commander extends Enemy {

	/**
	 * This variable is used to have a reference in order to calculate the delay in
	 * the entry animation
	 */
	protected static int generatedCommander;

	public Commander(GameBoardGUI board, EnemyTorpedo[] enemyTorpedoes, Game game, int level) {

		super(board, enemyTorpedoes, game, 2, level);
		generatedCommander++;

	}

	protected void entryAnimation() {
		super.entryAnimation();
		
		//The pathIndex will have negative values to set a delay when doing the entry animation.
		pathIndex = -generatedCommander * Constants.SEPARATOR;
	}

}
