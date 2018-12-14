package src;

public class Constants {
	public static final int DIR_N = 0;
	public static final int DIR_NNE = 1;
	public static final int DIR_NE = 2;
	public static final int DIR_ENE = 3;
	public static final int DIR_E = 4;
	public static final int DIR_ESE = 5;
	public static final int DIR_SE = 6;
	public static final int DIR_SSE = 7;
	public static final int DIR_S = 8;
	public static final int DIR_SSW = 9;
	public static final int DIR_SW = 10;
	public static final int DIR_WSW = 11;
	public static final int DIR_W = 12;
	public static final int DIR_WNW = 13;
	public static final int DIR_NW = 14;
	public static final int DIR_NNW = 15;

	// The move deltas for the directions: dX,dY
	public static final int[][] MOVES = { { 0, -4 }, // DIR_N
			{ 1, -4 }, // DIR_NNE
			{ 3, -3 }, // DIR_NE
			{ 4, -1 }, // DIR_ENE
			{ 4, 0 }, // DIR_E
			{ 4, 1 }, // DIR_ESE
			{ 3, 3 }, // DIR_SE
			{ 1, 4 }, // DIR_SSE
			{ 0, 4 }, // DIR_S
			{ -1, 4 }, // DIR_SSW
			{ -3, 3 }, // DIR_SW
			{ -4, 1 }, // DIR_WSW
			{ -4, 0 }, // DIR_W
			{ -4, -1 }, // DIR_WNW
			{ -3, -3 }, // DIR_NW
			{ -1, -4 }, // DIR_NNW
	};
	
	
	//Responsiveness
	public static final int BOARD_WIDTH = 170;
	public static final int BOARD_HEIGHT = 220;
	
	public static final int BOARD_WIDTH_BIG_COORDINATES = BOARD_WIDTH/10;
	public static final int BOARD_HEIGHT_BIG_COORDINATES = BOARD_HEIGHT/10;

	
	final static int FPS = 120;
	final static int EXPECTED_TIME = 1000000000 / FPS;
	final static int TORPEDOES_SPEED = 1;
	final static int SPRITE_WIDTH = 5;
	final static int SPRITE_HEIGTH = 5;
	final static int DEFAULT_SPRITE_POS_X = 0;
	final static int DEFAULT_SPRITE_POS_Y = 0;
	
	final static int MAX_TORPEDOES_PER_SQAURE = 1;
	
	final static int PLAYER_TORPEDOES_OFFSET = 5;
	
	final static int PLAYER_MOVEMENT_SPACE = 2;
	
	//Collisions
	public static final int COLLISION_RADIUS = 10;
	
	
	//COORDINATES FOR LEVEL 1
	
	
	public static final int [][] commanderCoordinatesLevel1 = {	
			{ BOARD_WIDTH / 2 - 10, 15 }, { BOARD_WIDTH / 2, 15 },{ BOARD_WIDTH / 2 + 10, 15 } };
	
	public static final int [][] goeiCoordinatesLevel1 = {
			{ BOARD_WIDTH / 2 - 50, 25 }, { BOARD_WIDTH / 2 - 40, 25 }, { BOARD_WIDTH / 2 - 30, 25 },
			{ BOARD_WIDTH / 2 - 20, 25 }, { BOARD_WIDTH / 2 - 10, 25 }, { BOARD_WIDTH / 2, 25 },
			{ BOARD_WIDTH / 2 + 10, 25 }, { BOARD_WIDTH / 2 + 20, 25 }, { BOARD_WIDTH / 2 + 30, 25 },
			{ BOARD_WIDTH / 2 + 40, 25 }, { BOARD_WIDTH / 2 + 50, 25 }};
	
	public static final int [][] zakoCoordinatesLevel1 = {
			{ BOARD_WIDTH / 2 - 50, 35 },
			{ BOARD_WIDTH / 2 - 40, 35 }, { BOARD_WIDTH / 2 - 30, 35 }, { BOARD_WIDTH / 2 - 20, 35 },
			{ BOARD_WIDTH / 2 - 10, 35 }, { BOARD_WIDTH / 2, 35 }, { BOARD_WIDTH / 2 + 10, 35 },
			{ BOARD_WIDTH / 2 + 20, 35 }, { BOARD_WIDTH / 2 + 30, 35 }, { BOARD_WIDTH / 2 + 40, 35 },
			{ BOARD_WIDTH / 2 + 50, 35 }};
	
	
	//COORDINATES FOR LEVEL2
	public static final int [][] commanderCoordinatesLevel2 = {	
			{ BOARD_WIDTH / 2 - 30, 15 },{ BOARD_WIDTH / 2 - 10, 15 }, { BOARD_WIDTH / 2, 15 },
			{ BOARD_WIDTH / 2 + 10, 15 },{ BOARD_WIDTH / 2 + 30, 15 } };
	
	public static final int [][] goeiCoordinatesLevel2 = {
			{ BOARD_WIDTH / 2 - 50, 25 }, { BOARD_WIDTH / 2 - 40, 25 }, { BOARD_WIDTH / 2 - 30, 25 },
			{ BOARD_WIDTH / 2 - 20, 25 }, { BOARD_WIDTH / 2 - 10, 25 }, { BOARD_WIDTH / 2, 25 },
			{ BOARD_WIDTH / 2 + 10, 25 }, { BOARD_WIDTH / 2 + 20, 25 }, { BOARD_WIDTH / 2 + 30, 25 },
			{ BOARD_WIDTH / 2 + 40, 25 }, { BOARD_WIDTH / 2 + 50, 25 }};
	
	public static final int [][] zakoCoordinatesLevel2 = {
			{ BOARD_WIDTH / 2 - 50, 35 },
			{ BOARD_WIDTH / 2 - 40, 35 }, { BOARD_WIDTH / 2 - 30, 35 }, { BOARD_WIDTH / 2 - 20, 35 },
			{ BOARD_WIDTH / 2 - 10, 35 }, { BOARD_WIDTH / 2, 35 }, { BOARD_WIDTH / 2 + 10, 35 },
			{ BOARD_WIDTH / 2 + 20, 35 }, { BOARD_WIDTH / 2 + 30, 35 }, { BOARD_WIDTH / 2 + 40, 35 },
			{ BOARD_WIDTH / 2 + 50, 35 }, { BOARD_WIDTH / 2 - 50, 45 }, { BOARD_WIDTH / 2 - 40, 45 },
			{ BOARD_WIDTH / 2 - 30, 45 }, { BOARD_WIDTH / 2 - 20, 45 }, { BOARD_WIDTH / 2 - 10, 45 },
			{ BOARD_WIDTH / 2, 45 }, { BOARD_WIDTH / 2 + 10, 45 }, { BOARD_WIDTH / 2 + 20, 45 },
			{ BOARD_WIDTH / 2 + 30, 45 }, { BOARD_WIDTH / 2 + 40, 45 }, { BOARD_WIDTH / 2 + 50, 45 }};
	
	//COORDINATES LEVEL 3
	public static final int [][] commanderCoordinatesLevel3 = {	
			{ BOARD_WIDTH / 2 - 50, 15 },{ BOARD_WIDTH / 2 - 30, 15 },{ BOARD_WIDTH / 2 - 10, 15 }, { BOARD_WIDTH / 2, 15 },
			{ BOARD_WIDTH / 2 + 10, 15 },{ BOARD_WIDTH / 2 + 30, 15 },{ BOARD_WIDTH / 2 + 50, 15 }};
	
	public static final int [][] goeiCoordinatesLevel3 = {
			{ BOARD_WIDTH / 2 - 60, 25 }, { BOARD_WIDTH / 2 - 50, 25 }, { BOARD_WIDTH / 2 - 40, 25 },
			{ BOARD_WIDTH / 2 - 30, 25 }, { BOARD_WIDTH / 2 - 20, 25 }, { BOARD_WIDTH / 2 - 10, 25 },
			{ BOARD_WIDTH / 2, 25 }, { BOARD_WIDTH / 2 + 10, 25 }, { BOARD_WIDTH / 2 + 20, 25 },
			{ BOARD_WIDTH / 2 + 30, 25 }, { BOARD_WIDTH / 2 + 40, 25 }, { BOARD_WIDTH / 2 + 50, 25 },
			{ BOARD_WIDTH / 2 + 60, 25 }};
	
	public static final int [][] zakoCoordinatesLevel3 = {
			{ BOARD_WIDTH / 2 - 60, 35 }, { BOARD_WIDTH / 2 - 50, 35 },
			{ BOARD_WIDTH / 2 - 40, 35 }, { BOARD_WIDTH / 2 - 30, 35 }, { BOARD_WIDTH / 2 - 20, 35 },
			{ BOARD_WIDTH / 2 - 10, 35 }, { BOARD_WIDTH / 2, 35 }, { BOARD_WIDTH / 2 + 10, 35 },
			{ BOARD_WIDTH / 2 + 20, 35 }, { BOARD_WIDTH / 2 + 30, 35 }, { BOARD_WIDTH / 2 + 40, 35 },
			{ BOARD_WIDTH / 2 + 50, 35 }, { BOARD_WIDTH / 2 + 60, 35 }, { BOARD_WIDTH / 2 - 60, 45 },
			{ BOARD_WIDTH / 2 - 50, 45 }, { BOARD_WIDTH / 2 - 40, 45 }, { BOARD_WIDTH / 2 - 30, 45 },
			{ BOARD_WIDTH / 2 - 20, 45 }, { BOARD_WIDTH / 2 - 10, 45 }, { BOARD_WIDTH / 2, 45 },
			{ BOARD_WIDTH / 2 + 10, 45 }, { BOARD_WIDTH / 2 + 20, 45 }, { BOARD_WIDTH / 2 + 30, 45 },
			{ BOARD_WIDTH / 2 + 40, 45 }, { BOARD_WIDTH / 2 + 50, 45 }, { BOARD_WIDTH / 2 + 60, 45 }};
	
	//Star coordinates
	public static final int[][] StarPositions = { { 11, 11 }, { 28, 22 }, { 33, 33 }, { 44, 44 }, { 23, 34 }, { 1, 80 } };

	public static String getSkin(Sprite sprite, int a) {
		if (sprite instanceof Player) {
			return "player.png";
		}

			if (a == 20) {
				return "explosion20.png";
			} else if (a == 21) {
				return "explosion21.png";
			} else if (a == 22) {
				return "explosion22.png";
			} else if (a == 23) {
				return "explosion23.png";
			} else if (a == 24) {
				return "explosion24.png";
			} else if (a == 25) {
				return "explosion25.png";
			}


		if (sprite instanceof Zako) {
			switch (a) {
			case -1:
				return "enemy3G0.png";
			case DIR_N:
				return "enemy3G1.png";
			case DIR_NNE:
				return "enemy301.png";
			case DIR_NE:
				return "enemy302.png";
			case DIR_ENE:
				return "enemy303.png";
			case DIR_E:
				return "enemy304.png";
			case DIR_ESE:
				return "enemy305.png";
			case DIR_SE:
				return "enemy306.png";
			case DIR_SSE:
				return "enemy307.png";
			case DIR_S:
				return "enemy308.png";
			case DIR_SSW:
				return "enemy309.png";
			case DIR_SW:
				return "enemy310.png";
			case DIR_WSW:
				return "enemy311.png";
			case DIR_W:
				return "enemy312.png";
			case DIR_WNW:
				return "enemy313.png";
			case DIR_NW:
				return "enemy314.png";
			case DIR_NNW:
				return "enemy315.png";
			}
		}

		if (sprite instanceof Goei) {
			switch (a) {
			case -1:
				return "enemy200.png";
			case DIR_N:
				return "enemy2G0.png";
			case DIR_NNE:
				return "enemy201.png";
			case DIR_NE:
				return "enemy202.png";
			case DIR_ENE:
				return "enemy203.png";
			case DIR_E:
				return "enemy204.png";
			case DIR_ESE:
				return "enemy205.png";
			case DIR_SE:
				return "enemy206.png";
			case DIR_SSE:
				return "enemy207.png";
			case DIR_S:
				return "enemy208.png";
			case DIR_SSW:
				return "enemy209.png";
			case DIR_SW:
				return "enemy210.png";
			case DIR_WSW:
				return "enemy211.png";
			case DIR_W:
				return "enemy212.png";
			case DIR_WNW:
				return "enemy213.png";
			case DIR_NW:
				return "enemy214.png";
			case DIR_NNW:
				return "enemy215.png";
			}
		}

		if (sprite instanceof Commander) {

			if (sprite.getLifes() == 1) {
				switch (a) {
				case -1:
					return "enemy9G1.png";
				case DIR_N:
					return "enemy900.png";
				case DIR_NNE:
					return "enemy901.png";
				case DIR_NE:
					return "enemy902.png";
				case DIR_ENE:
					return "enemy903.png";
				case DIR_E:
					return "enemy904.png";
				case DIR_ESE:
					return "enemy905.png";
				case DIR_SE:
					return "enemy906.png";
				case DIR_SSE:
					return "enemy907.png";
				case DIR_S:
					return "enemy908.png";
				case DIR_SSW:
					return "enemy909.png";
				case DIR_SW:
					return "enemy910.png";
				case DIR_WSW:
					return "enemy911.png";
				case DIR_W:
					return "enemy912.png";
				case DIR_WNW:
					return "enemy913.png";
				case DIR_NW:
					return "enemy914.png";
				case DIR_NNW:
					return "enemy915.png";
				}
			}

			switch (a) {
			case -1:
				return "enemy1G1.png";
			case DIR_N:
				return "enemy100.png";
			case DIR_NNE:
				return "enemy101.png";
			case DIR_NE:
				return "enemy102.png";
			case DIR_ENE:
				return "enemy103.png";
			case DIR_E:
				return "enemy104.png";
			case DIR_ESE:
				return "enemy105.png";
			case DIR_SE:
				return "enemy106.png";
			case DIR_SSE:
				return "enemy107.png";
			case DIR_S:
				return "enemy108.png";
			case DIR_SSW:
				return "enemy109.png";
			case DIR_SW:
				return "enemy110.png";
			case DIR_WSW:
				return "enemy111.png";
			case DIR_W:
				return "enemy112.png";
			case DIR_WNW:
				return "enemy113.png";
			case DIR_NW:
				return "enemy114.png";
			case DIR_NNW:
				return "enemy115.png";

			}
		}

		if (sprite instanceof Torpedo) {
			return "torpedo100.png";
		}

		if (sprite instanceof Torpedo) {
			return "torpedo200.png";
		}

		if (sprite instanceof Star) {
			return "star.png";
		}
 
		return "SkinFailed.png";
	}
	
	private int counterL1 = 0;

	//FOR ENEMIES
	public int[] [] getInitialCoordinatesArray(Sprite sprite, int level) {
		if(level==1) {
			if(sprite instanceof Commander) {
				return commanderCoordinatesLevel1;
			}
			if(sprite instanceof Goei) {
				return goeiCoordinatesLevel1;
			}
			if(sprite instanceof Zako) {
				return zakoCoordinatesLevel1;
			}
		}
		if(level==2) {
			if(sprite instanceof Commander) {
				return commanderCoordinatesLevel2;
			}
			if(sprite instanceof Goei) {
				return goeiCoordinatesLevel2;
			}
			if(sprite instanceof Zako) {
				return zakoCoordinatesLevel2;
			}
		}
		if(level==3) {
			if(sprite instanceof Commander) {
				return commanderCoordinatesLevel3;
			}
			if(sprite instanceof Goei) {
				return goeiCoordinatesLevel3;
			}
			if(sprite instanceof Zako) {
				return zakoCoordinatesLevel3;
			}
		}
		return null;
	}
	
	private static int StarPosCounter = 0;
	private static boolean firstTime = true;
	
	//FOR PLAYER AND STARS
	public static int[] getInitialCoordinatesVector(Sprite sprite) {
		//Stars coordinates assigner
		if (sprite instanceof Star) {

			if(firstTime) {
				if (StarPosCounter >= StarPositions.length) {
					StarPosCounter = 0;
					firstTime = false;

				}
				return StarPositions[StarPosCounter++];
			} else {
				if (StarPosCounter >= StarPositions.length) {
					StarPosCounter = 0;
				}
				
				int[] returnVector = StarPositions[StarPosCounter++];

				int shift = (int)(Math.random()*60+20);
				
				//Analysisng shift in x
				if(returnVector[0] + shift > BOARD_WIDTH) {
					returnVector[0] = returnVector[0] + shift - BOARD_WIDTH;
				} else {
					returnVector[0] = returnVector[0] + shift;
				}
								
				return returnVector;
				
			}

		}
		
		if (sprite instanceof Player) {
			int[] playerPosition = { (BOARD_WIDTH / 2), (BOARD_HEIGHT - 20) };
			return playerPosition;
		}

		
		
		return null;

	}
	
	
	//AÑADIR CONSTANTS PARA SABER CUANTAS POSICIONES DISPONIBLES HAY PARA CADA SPRITE Y PARA CADA NIVEL
	public int getNumberOfAvailablePositions(String sprite, int level) {
		if(sprite.equals("Star")) {
			return StarPositions.length;
		}
		
		if(level==1) {
			if(sprite.equals("Commander")){
				return commanderCoordinatesLevel1.length;
			}
			if(sprite.equals("Goei")) {
				return goeiCoordinatesLevel1.length;
			}
			if(sprite.equals("Zako")) {
				return zakoCoordinatesLevel1.length;
			}
		}
		if(level==2) {
			if(sprite.equals("Commander")) {
				return commanderCoordinatesLevel2.length;
			}
			if(sprite.equals("Goei")) {
				return goeiCoordinatesLevel2.length;
			}
			if(sprite.equals("Zako")) {
				return zakoCoordinatesLevel2.length;
			}
		}
		if(level==3) {
			if(sprite.equals("Commander")) {
				return commanderCoordinatesLevel3.length;
			}
			if(sprite.equals("Goei")) {
				return goeiCoordinatesLevel3.length;
			}
			if(sprite.equals("Zako")) {
				return zakoCoordinatesLevel3.length;
			}
		}
		return 0;
	}
}