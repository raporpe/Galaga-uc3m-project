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
	 

	 public static final int [][] id= {
			 {(Game.width)/2-40,25},{(Game.width)/2-30,25},{55,25},{(Game.width)/2-20,25},{(Game.width)/2-10,25},{(Game.width)/2,25},{(Game.width)/2-10,25},{(Game.width)/2-20,25},{(Game.width)/2+30,25},{(Game.width)/2+40,25},
			 {(Game.width)/2-40,35},{(Game.width)/2-30,35},{55,35},{(Game.width)/2-20,35},{(Game.width)/2-10,35},{(Game.width)/2,35},{(Game.width)/2-10,35},{(Game.width)/2-20,35},{(Game.width)/2+30,35},{(Game.width)/2+40,35},
			 													   						  {(Game.width)/2-10,15},{(Game.width)/2,35},{(Game.width)/2-10,45}};
	 }
