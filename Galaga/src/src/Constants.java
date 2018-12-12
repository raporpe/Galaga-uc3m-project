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
		 if(sprite.getLifes()==2) {
			 switch(a) {
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
 
		 }else if(sprite.getLifes()==1) {
		 if(a == 20) {
			 return "explosion20.png";
		 }else if(a==21) {
			 return "explosion21.png";
		 }else if(a==22) {
			 return "explosion22.png";
		 }else if(a==23) {
			 return "explosion23.png";
		 }else if(a==24) {
			 return "explosion24.png";
		 }else if(a==25) {
			 return "explosion25.png";
		 }else if (sprite instanceof Zako) {
			 switch(a) {
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
			 
		 }else if(sprite instanceof Goei) {
			 switch(a) {
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
		 }else if(sprite instanceof Commander) {
			 switch(a) {
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
		 }else if(sprite instanceof Torpedo) {
			 return "torpedo100.png";
		 }else if(sprite instanceof Torpedo) {
			 return "torpedo200.png";
		 }
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


