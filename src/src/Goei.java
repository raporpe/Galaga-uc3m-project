package src;
import edu.uc3m.game.GameBoardGUI;

/**
 * Class for the sprite of the enemy "Goei"
 * 
 * @author Raúl P. and Diego G.
 * @version 3.1
 * 
 */

public class Goei extends Enemy {
	
	/**
	 * This variable is used to have a reference in order to calculate the delay in
	 * the entry animation
	 */
	protected static int generatedGoei;

	public Goei(GameBoardGUI board, EnemyTorpedo[] enemyTorpedoes, Game game, int level) {

		super(board, enemyTorpedoes, game, 1, level);
		generatedGoei++;

	}

	protected void entryAnimation() {
		super.entryAnimation();
		
		//The pathIndex will have negative values to set a delay when doing the entry animation.
		pathIndex = -generatedGoei * Constants.SEPARATOR;
	}

}
