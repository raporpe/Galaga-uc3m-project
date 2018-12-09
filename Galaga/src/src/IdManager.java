package src;

public class IdManager {
	
	
	public final static int STARS_ID_OFFSET = 4000;
	public final static int TORPEDOES_ID_OFFSET = 5000;

	private static int starsIdCount = STARS_ID_OFFSET;
	private static int torpedoesIdCount = TORPEDOES_ID_OFFSET;

	
	
	
//	public static int getId(Sprite sprite) {
//		
//		if(sprite instanceof Star) {
//			return starsIdCount++;
//		} else if(sprite instanceof Torpedo) {
//			return torpedoesIdCount++;
//		} else {
//			return 0;
//		}
//		
//	}
//	
	public static int getId(String sprite) {
		
		if(sprite.equals("star")) {
			return starsIdCount++;
		} else if(sprite.equals("torpedo")) {
			return torpedoesIdCount++;
		} else {
			return 0;
		}
		
	}

}
