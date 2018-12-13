package src;

public class IdManager {

	public final static int STARS_ID_OFFSET = 4000;
	public final static int TORPEDOES_ID_OFFSET = 5000;
	public static int ZAKO_ID_OFFSET = 1000;
	public static int GOEI_ID_OFFSET = 1100;
	public static int COMMANDER_ID_OFFSET = 1200;

	private static int starsIdCount = STARS_ID_OFFSET;
	private static int torpedoesIdCount = TORPEDOES_ID_OFFSET;
	private static int zakoIdCount = ZAKO_ID_OFFSET;
	private static int goeiIdCount = GOEI_ID_OFFSET;
	private static int commanderIdCount = COMMANDER_ID_OFFSET;

	public static int assignId(String sprite) {
		
		if(sprite.equals("star")) {
			return starsIdCount++;
		} else if(sprite.equals("torpedo")) {
			return torpedoesIdCount++;
		} else if(sprite.equals("zako")) {
			return zakoIdCount++;
		} else if(sprite.equals("goei")) {
			return goeiIdCount++;
		} else if(sprite.equals("commander")) {
			return commanderIdCount++;
		} else if(sprite.equals("player")){
			return 1;
		}
		return 0;
		
		
//		public static int getId(Sprite sprite) {
//			
//			if(sprite instanceof Star) {
//				return starsIdCount++;
//			} else if(sprite instanceof Torpedo) {
//				return torpedoesIdCount++;
//			} else {
//				return 0;
//			}
//			
//		}
		
	}

}
