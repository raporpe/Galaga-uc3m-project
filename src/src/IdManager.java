package src;

/**
 * Class used to create unique IDs
 * 
 * @author Raúl P. and Diego G.
 * @version 1.6
 * 
 */

public class IdManager {
	
	//The id from which the counter begins
	public final static int STARS_ID_OFFSET = 4000;
	public final static int TORPEDOES_ID_OFFSET = 5000;
	public final static int ZAKO_ID_OFFSET = 100;
	public final static int GOEI_ID_OFFSET = 300;
	public final static int COMMANDER_ID_OFFSET = 500;
	public final static int GENERIC_ID_OFFSET = 13000;
	
	//Counter
	private static int starsIdCount = STARS_ID_OFFSET;
	private static int torpedoesIdCount = TORPEDOES_ID_OFFSET;
	private static int zakoIdCount = ZAKO_ID_OFFSET;
	private static int goeiIdCount = GOEI_ID_OFFSET;
	private static int commanderIdCount = COMMANDER_ID_OFFSET;
	private static int genericId = GENERIC_ID_OFFSET;
	
	//This function is called in the Sprites constructor
	public static int assignId(Sprite sprite) {

		if (sprite instanceof Star) {
			return starsIdCount++;
		}

		if (sprite instanceof Torpedo) {
			return torpedoesIdCount++;
		}

		if (sprite instanceof Zako) {
			return zakoIdCount++;
		}

		if (sprite instanceof Goei) {
			return goeiIdCount++;
		}

		if (sprite instanceof Commander) {
			return commanderIdCount++;
		}

		if (sprite instanceof Player) {
			return 1;
		}

		return genericId++;
	}

}
