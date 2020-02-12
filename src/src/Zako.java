package src;
import edu.uc3m.game.GameBoardGUI;

/**
 * Class for the sprite of the enemy "Zako".
 * 
 * @author Raúl P. and Diego G.
 * @version 6.2
 * 
 */

public class Zako extends Enemy {
	
	/**
	 * This variable is used to have a reference in order to calculate the delay in
	 * the entry animation
	 */
	protected static int generatedZakos;

	public Zako(GameBoardGUI board, EnemyTorpedo[] enemyTorpedoes, Game game, int level) {

		super(board, enemyTorpedoes, game, 1, level);
		generatedZakos++;

	}

	protected void entryAnimation() {
		super.entryAnimation();
		
		//The pathIndex will have negative values to set a delay when doing the entry animation.
		pathIndex = -generatedZakos * Constants.SEPARATOR;
	}

}
