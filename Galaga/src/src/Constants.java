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
	 
	// The move deltas for the directions: dX,dY}
	 public static final int[][] MOVES = {
	  { 0, -4 }, // DIR_N
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
	  { -4,-1 }, // DIR_WNW
	  { -3,-3 }, // DIR_NW
	  { -1,-4 }, // DIR_NNW
	 };
	 

	 public static final int [][] enemyCoordinatesLevel1= {

			{Game.BOARD_WIDTH/2-50,25},{Game.BOARD_WIDTH/2-40,25},{Game.BOARD_WIDTH/2-30,25},{Game.BOARD_WIDTH/2-20,25},{Game.BOARD_WIDTH/2-10,25},{Game.BOARD_WIDTH/2,25},{Game.BOARD_WIDTH/2+10,25},{Game.BOARD_WIDTH/2+20,25},{Game.BOARD_WIDTH/2+30,25},{Game.BOARD_WIDTH/2+40,25},{Game.BOARD_WIDTH/2+50,25},
			{Game.BOARD_WIDTH/2-50,35},{Game.BOARD_WIDTH/2-40,35},{Game.BOARD_WIDTH/2-30,35},{Game.BOARD_WIDTH/2-20,35},{Game.BOARD_WIDTH/2-10,35},{Game.BOARD_WIDTH/2,35},{Game.BOARD_WIDTH/2+10,35},{Game.BOARD_WIDTH/2+20,35},{Game.BOARD_WIDTH/2+30,35},{Game.BOARD_WIDTH/2+40,35},{Game.BOARD_WIDTH/2+50,35},
																	{Game.BOARD_WIDTH/2-10,15},{Game.BOARD_WIDTH/2,15},{Game.BOARD_WIDTH/2+10,15}};
	 public static final int [][] enemyCoordinatesLevel2= {

				{Game.BOARD_WIDTH/2-50,25}, {Game.BOARD_WIDTH/2-40,25}, {Game.BOARD_WIDTH/2-30,25},{Game.BOARD_WIDTH/2-20,25},{Game.BOARD_WIDTH/2-10,25},{Game.BOARD_WIDTH/2,25},{Game.BOARD_WIDTH/2+10,25}, {Game.BOARD_WIDTH/2+20,25}, {Game.BOARD_WIDTH/2+30,25}, {Game.BOARD_WIDTH/2+40,25},{Game.BOARD_WIDTH/2+50,25},
				{Game.BOARD_WIDTH/2-50,35}, {Game.BOARD_WIDTH/2-40,35}, {Game.BOARD_WIDTH/2-30,35},{Game.BOARD_WIDTH/2-20,35},{Game.BOARD_WIDTH/2-10,35},{Game.BOARD_WIDTH/2,35},{Game.BOARD_WIDTH/2+10,35}, {Game.BOARD_WIDTH/2+20,35}, {Game.BOARD_WIDTH/2+30,35}, {Game.BOARD_WIDTH/2+40,35},{Game.BOARD_WIDTH/2+50,35},
				{Game.BOARD_WIDTH/2-50,45}, {Game.BOARD_WIDTH/2-40,45}, {Game.BOARD_WIDTH/2-30,45},{Game.BOARD_WIDTH/2-20,45},{Game.BOARD_WIDTH/2-10,45},{Game.BOARD_WIDTH/2,45},{Game.BOARD_WIDTH/2+10,45}, {Game.BOARD_WIDTH/2+20,45}, {Game.BOARD_WIDTH/2+30,45}, {Game.BOARD_WIDTH/2+40,45},{Game.BOARD_WIDTH/2+50,45},
																								   							  {Game.BOARD_WIDTH/2-10,15},{Game.BOARD_WIDTH/2,15},{Game.BOARD_WIDTH/2+10,15}};
	 
	 public static final int [][] enemyCoordinatesLevel3= {


				{Game.BOARD_WIDTH/2-60,25}, {Game.BOARD_WIDTH/2-50,25}, {Game.BOARD_WIDTH/2-40,25}, {Game.BOARD_WIDTH/2-30,25},{Game.BOARD_WIDTH/2-20,25},{Game.BOARD_WIDTH/2-10,25},{Game.BOARD_WIDTH/2,25},{Game.BOARD_WIDTH/2+10,25}, {Game.BOARD_WIDTH/2+20,25}, {Game.BOARD_WIDTH/2+30,25}, {Game.BOARD_WIDTH/2+40,25},{Game.BOARD_WIDTH/2+50,25},{Game.BOARD_WIDTH/2+60,25},
				{Game.BOARD_WIDTH/2-60,35}, {Game.BOARD_WIDTH/2-50,35}, {Game.BOARD_WIDTH/2-40,35}, {Game.BOARD_WIDTH/2-30,35},{Game.BOARD_WIDTH/2-20,35},{Game.BOARD_WIDTH/2-10,35},{Game.BOARD_WIDTH/2,35},{Game.BOARD_WIDTH/2+10,35}, {Game.BOARD_WIDTH/2+20,35}, {Game.BOARD_WIDTH/2+30,35}, {Game.BOARD_WIDTH/2+40,35},{Game.BOARD_WIDTH/2+50,35},{Game.BOARD_WIDTH/2+60,35},
				{Game.BOARD_WIDTH/2-60,45}, {Game.BOARD_WIDTH/2-50,45}, {Game.BOARD_WIDTH/2-40,45}, {Game.BOARD_WIDTH/2-30,45},{Game.BOARD_WIDTH/2-20,45},{Game.BOARD_WIDTH/2-10,45},{Game.BOARD_WIDTH/2,45},{Game.BOARD_WIDTH/2+10,45}, {Game.BOARD_WIDTH/2+20,45}, {Game.BOARD_WIDTH/2+30,45}, {Game.BOARD_WIDTH/2+40,45},{Game.BOARD_WIDTH/2+50,45},{Game.BOARD_WIDTH/2+60,45},
																															   {Game.BOARD_WIDTH/2-20,15},{Game.BOARD_WIDTH/2-10,15},{Game.BOARD_WIDTH/2,15},{Game.BOARD_WIDTH/2+10,15}, {Game.BOARD_WIDTH/2+20,15}};
	 
	 public static String getSkin(Sprite sprite, int a) {
		 if (sprite instanceof Zako) {
			 switch(a) {
			 case -1:
				 return "enemy3G0.png";
			 case 0:
				 return "enemy3G1.png";
			 case 1:
				 return "enemy301.png";
			 case 2:
				 return "enemy302.png";
			 case 3:
				 return "enemy303.png";
			 case 4:
				 return "enemy304.png";
			 case 5:
				 return "enemy305.png";
			 case 6:
				 return "enemy306.png";
			 case 7:
				 return "enemy307.png";
			 case 8:
				 return "enemy308.png";
			 case 9:
				 return "enemy309.png";
			 case 10:
				 return "enemy310.png";
			 case 11:
				 return "enemy311.png";
			 case 12:
				 return "enemy312.png";
			 case 13:
				 return "enemy313.png";
			 case 14:
				 return "enemy314.png";
			 case 15:
				 return "enemy315.png";
			 }
			 
		 }else if(sprite instanceof Goei) {
			 switch(a) {
			 case -1:
				 return "enemy200.png";
			 case 0:
				 return "enemy2G0.png";
			 case 1:
				 return "enemy201.png";
			 case 2:
				 return "enemy202.png";
			 case 3:
				 return "enemy203.png";
			 case 4:
				 return "enemy204.png";
			 case 5:
				 return "enemy205.png";
			 case 6:
				 return "enemy206.png";
			 case 7:
				 return "enemy207.png";
			 case 8:
				 return "enemy208.png";
			 case 9:
				 return "enemy209.png";
			 case 10:
				 return "enemy210.png";
			 case 11:
				 return "enemy211.png";
			 case 12:
				 return "enemy212.png";
			 case 13:
				 return "enemy213.png";
			 case 14:
				 return "enemy214.png";
			 case 15:
				 return "enemy215.png";
			 }
		 }else if(sprite instanceof Commander) {
			 switch(a) {
			 case -1:
				 return "enemy1G1.png";
			 case 0:
				 return "enemy100.png";
			 case 1:
				 return "enemy101.png";
			 case 2:
				 return "enemy102.png";
			 case 3:
				 return "enemy103.png";
			 case 4:
				 return "enemy104.png";
			 case 5:
				 return "enemy105.png";
			 case 6:
				 return "enemy106.png";
			 case 7:
				 return "enemy107.png";
			 case 8:
				 return "enemy108.png";
			 case 9:
				 return "enemy109.png";
			 case 10:
				 return "enemy110.png";
			 case 11:
				 return "enemy111.png";
			 case 12:
				 return "enemy112.png";
			 case 13:
				 return "enemy113.png";
			 case 14:
				 return "enemy114.png";
			 case 15:
				 return "enemy115.png";
			 }
		 }else if(sprite instanceof Torpedo) {
			 return "enemy100.png";
		 }
		 return "";
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public static final int[][] StarPositions = {{11,11},{22,22},{33,33},{44,44}};
	private static int StarPosCounter = 0;
	
	public static int[] getStarPosition() {
		if(StarPosCounter >= StarPositions.length) {
			StarPosCounter = 0;
		}
		return StarPositions[StarPosCounter++];
	}

}


