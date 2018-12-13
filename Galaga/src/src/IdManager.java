package src;

public class IdManager {

	public final static int STARS_ID_OFFSET = 4000;
	public final static int TORPEDOES_ID_OFFSET = 5000;
	public static int ZAKO_ID_OFFSET = 1000;
	public static int GOEI_ID_OFFSET = 1100;
	public static int COMMANDER_ID_OFFSET = 1200;
	public static int NOT_IDENTIFIES_OFFSET = 1200;


	private static int starsIdCount = STARS_ID_OFFSET;
	private static int torpedoesIdCount = TORPEDOES_ID_OFFSET;
	private static int zakoIdCount = ZAKO_ID_OFFSET;
	private static int goeiIdCount = GOEI_ID_OFFSET;
	private static int commanderIdCount = COMMANDER_ID_OFFSET;
	
	private static int notIndetified = NOT_IDENTIFIES_OFFSET;

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
		
		return notIndetified++;
	}


}
