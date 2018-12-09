package src;

public class IdManager {
	
	
	public final static int STARS_ID_OFFSET = 4000;
	public final static int TORPEDOES_ID_OFFSET = 5000;
	private static int ZAKO_ID_OFFSET = 100;
	private static int GOEI_ID_OFFSET=100;
	private static int COMMANDER_ID_OFFSET = 100;
	
	private static int starsIdCount = STARS_ID_OFFSET;
	private static int torpedoesIdCount = TORPEDOES_ID_OFFSET;
	private static int zakoIdCount = ZAKO_ID_OFFSET;
	private static int goeiIdCount = GOEI_ID_OFFSET;
	private static int commanderIdCount = COMMANDER_ID_OFFSET;

	public static int getId(String sprite) {
		
		if(sprite.equals("star")) {
			return starsIdCount++;
		} else if(sprite.equals("torpedo")) {
			return torpedoesIdCount++;
		} else if(sprite.equals("zako")) {
			return zakoIdCount++;
		}else if(sprite.equals("goei")) {
			return goeiIdCount++;
		}else if(sprite.equals("commander")) {
			return commanderIdCount++;
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
