package src;

/**
 * Class to store stats and predetermined variables
 * 
 * @author Raúl P. and Diego G.
 * @version 43.01
 * 
 */

public class Constants {
	
	//DIRECTIONS
	
	/**
	 * These are the possible directions enemies can look to
	 */
	
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

	// ADAPTIVE VARIABLES
	
	/**
	 * These stats can be changed whenever wanted without having to
	 * 	implement more code
	 */
	
	public static final int BOARD_WIDTH = 170;
	public static final int BOARD_HEIGHT = 220;

	public static final int BOARD_WIDTH_BIG_COORDINATES = BOARD_WIDTH / 10;
	public static final int BOARD_HEIGHT_BIG_COORDINATES = BOARD_HEIGHT / 10;

	final static int FPS = 120;
	final static int EXPECTED_TIME = 1000000000 / FPS;
	final static int TORPEDOES_SPEED = 1;
	final static int SPRITE_WIDTH = 5;
	final static int SPRITE_HEIGTH = 5;
	final static int DEFAULT_SPRITE_POS_X = 0;
	final static int DEFAULT_SPRITE_POS_Y = 0;

	final static int MAX_TORPEDOES_PER_SQAURE = 1;

	final static int PLAYER_TORPEDOES_OFFSET = 5;

	final static int PLAYER_MOVEMENT_SPACE = 1;

	final static int SWARM_BORDER = 5;
	final static int SEPARATOR = 4;
	
	final static int MAX_LEVEL = 3;

	// Only positive numbers. 1 is always.
	final static int ATTACK_POSSIBILITY = FPS*10;

	// Collisions
	public static final int COLLISION_RADIUS = 8;

//COORDINATES
	
	/**
	 * These coordinates depend on the width and height of the game board, so
	 * they adapt to the dimensions of the board if we decide it to change.
	 * 
	 *  For the Stars, these are their initial coordinates.
	 *  
	 *  For the Enemies, these are the initial coordinates inside the swarm.
	 */
	
	// STAR COORDINATES
		public static final int[][] StarPositions = { { BOARD_WIDTH / 2 + 70, 50 }, { BOARD_WIDTH / 2 + 28, 10 },
				{ BOARD_WIDTH / 2 + 53, 140 }, { BOARD_WIDTH / 2 - 34, BOARD_HEIGHT / 2 - 80 },
				{ BOARD_WIDTH / 2 - 43, BOARD_HEIGHT / 2 - 74 }, { BOARD_WIDTH / 2 - 15, BOARD_HEIGHT / 2 - 42 },
				{ BOARD_WIDTH / 2, BOARD_HEIGHT / 2 + 50 }, { BOARD_WIDTH / 2 - 85, BOARD_HEIGHT / 2 - 74 },
				{ BOARD_WIDTH / 2 - 20, BOARD_HEIGHT / 2 - 60 }, { BOARD_WIDTH / 2 + 60, BOARD_HEIGHT / 2 + 96 },
				{ BOARD_WIDTH / 2 - 48, BOARD_HEIGHT / 2 + 7 }, { BOARD_WIDTH / 2 - 30, BOARD_HEIGHT / 2 },
				{ BOARD_WIDTH / 2 - 82, BOARD_HEIGHT / 2 + 44 }, { BOARD_WIDTH / 2 - 14, BOARD_HEIGHT / 2 - 30 },
				{ BOARD_WIDTH / 2 - 70, BOARD_HEIGHT / 2 + 73 }, { BOARD_WIDTH / 2 - 63, BOARD_HEIGHT / 2 - 95 },
				{ BOARD_WIDTH / 2 - 25, BOARD_HEIGHT / 2 + 54 }, { BOARD_WIDTH / 2 + 50, BOARD_HEIGHT / 2 + 4 },
				{ BOARD_WIDTH / 2 + 67, BOARD_HEIGHT / 2 + 34 },{ BOARD_WIDTH / 2 - 13, BOARD_HEIGHT / 2 - 25 },
				{ BOARD_WIDTH / 2 + 2, BOARD_HEIGHT / 2 + 4 },{ BOARD_WIDTH / 2 + 23, BOARD_HEIGHT / 2 +14 },
				{ BOARD_WIDTH / 2 - 67, BOARD_HEIGHT / 2 - 14 },{ BOARD_WIDTH / 2 - 13, BOARD_HEIGHT / 2 - 64 },
				{ BOARD_WIDTH / 2 + 18, BOARD_HEIGHT / 2 + 84 },{ BOARD_WIDTH / 2 - 52, BOARD_HEIGHT / 2 + 74 }};
	
	// LEVEL 1
	public static final int[][] commanderCoordinatesLevel1 = { { BOARD_WIDTH / 2 - 50, 15 }, { BOARD_WIDTH / 2, 15 },
			{ BOARD_WIDTH / 2 + 50, 15 } };
	
	public static final int[][] goeiCoordinatesLevel1 = { { BOARD_WIDTH / 2 - 50, 25 },
			{ BOARD_WIDTH / 2 - 30, 25 }, { BOARD_WIDTH / 2 - 10, 25 }, { BOARD_WIDTH / 2 + 10, 25 },
			{ BOARD_WIDTH / 2 + 30, 25 }, { BOARD_WIDTH / 2 + 50, 25 } };

	public static final int[][] zakoCoordinatesLevel1 = { { BOARD_WIDTH / 2 - 60, 35 }, { BOARD_WIDTH / 2 - 40, 35 },
			{ BOARD_WIDTH / 2 - 20, 35 }, { BOARD_WIDTH / 2, 35 }, { BOARD_WIDTH / 2 + 20, 35 },
			{ BOARD_WIDTH / 2 + 40, 35 }, { BOARD_WIDTH / 2 + 60, 35 } };

	// LEVEL 2
	public static final int[][] commanderCoordinatesLevel2 = { { BOARD_WIDTH / 2 - 30, 15 },
			{ BOARD_WIDTH / 2 - 10, 15 }, { BOARD_WIDTH / 2, 15 }, { BOARD_WIDTH / 2 + 10, 15 },
			{ BOARD_WIDTH / 2 + 30, 15 }, { BOARD_WIDTH / 2 - 20, 5 }, { BOARD_WIDTH / 2 + 20, 5 } };

	public static final int[][] goeiCoordinatesLevel2 = { { BOARD_WIDTH / 2 - 50, 25 }, { BOARD_WIDTH / 2 - 40, 25 },
			{ BOARD_WIDTH / 2 - 30, 25 }, { BOARD_WIDTH / 2 - 20, 25 }, { BOARD_WIDTH / 2 - 10, 25 },
			{ BOARD_WIDTH / 2, 25 }, { BOARD_WIDTH / 2 + 10, 25 }, { BOARD_WIDTH / 2 + 20, 25 },
			{ BOARD_WIDTH / 2 + 30, 25 }, { BOARD_WIDTH / 2 + 40, 25 }, { BOARD_WIDTH / 2 + 50, 25 },
			{ BOARD_WIDTH / 2 - 40, 35 }, { BOARD_WIDTH / 2 - 30, 35 }, { BOARD_WIDTH / 2 - 20, 35 },
			{ BOARD_WIDTH / 2 - 10, 35 }, { BOARD_WIDTH / 2 + 10, 35 }, { BOARD_WIDTH / 2 + 20, 35 },
			{ BOARD_WIDTH / 2 + 30, 35 }, { BOARD_WIDTH / 2 + 40, 35 } };

	public static final int[][] zakoCoordinatesLevel2 = { { BOARD_WIDTH / 2 - 40, 45 }, { BOARD_WIDTH / 2 - 30, 45 },
			{ BOARD_WIDTH / 2 - 20, 45 }, { BOARD_WIDTH / 2 + 20, 45 }, { BOARD_WIDTH / 2 + 30, 45 },
			{ BOARD_WIDTH / 2 + 40, 45 }, { BOARD_WIDTH / 2 - 30, 55 }, { BOARD_WIDTH / 2 + 30, 55 } };

	// LEVEL 3
	public static final int[][] commanderCoordinatesLevel3 = { { BOARD_WIDTH / 2 - 30, 15 },
			{ BOARD_WIDTH / 2 - 10, 15 }, { BOARD_WIDTH / 2, 15 }, { BOARD_WIDTH / 2 + 10, 15 },
			{ BOARD_WIDTH / 2 + 30, 15 }, { BOARD_WIDTH / 2 - 20, 5 }, { BOARD_WIDTH / 2 + 20, 5 } };

	public static final int[][] goeiCoordinatesLevel3 = { { BOARD_WIDTH / 2 - 60, 25 }, { BOARD_WIDTH / 2 - 50, 25 },
			{ BOARD_WIDTH / 2 - 40, 25 }, { BOARD_WIDTH / 2 - 30, 25 }, { BOARD_WIDTH / 2 - 20, 25 },
			{ BOARD_WIDTH / 2 - 10, 25 }, { BOARD_WIDTH / 2, 25 }, { BOARD_WIDTH / 2 + 10, 25 },
			{ BOARD_WIDTH / 2 + 20, 25 }, { BOARD_WIDTH / 2 + 30, 25 }, { BOARD_WIDTH / 2 + 40, 25 },
			{ BOARD_WIDTH / 2 + 50, 25 }, { BOARD_WIDTH / 2 + 60, 25 } };

	public static final int[][] zakoCoordinatesLevel3 = { { BOARD_WIDTH / 2 - 60, 35 }, { BOARD_WIDTH / 2 - 50, 35 },
			{ BOARD_WIDTH / 2 - 40, 35 }, { BOARD_WIDTH / 2 - 30, 35 }, { BOARD_WIDTH / 2 - 20, 35 },
			{ BOARD_WIDTH / 2 - 10, 35 }, { BOARD_WIDTH / 2, 35 }, { BOARD_WIDTH / 2 + 10, 35 },
			{ BOARD_WIDTH / 2 + 20, 35 }, { BOARD_WIDTH / 2 + 30, 35 }, { BOARD_WIDTH / 2 + 40, 35 },
			{ BOARD_WIDTH / 2 + 50, 35 }, { BOARD_WIDTH / 2 + 60, 35 }, { BOARD_WIDTH / 2 - 60, 45 },
			{ BOARD_WIDTH / 2 - 50, 45 }, { BOARD_WIDTH / 2 - 40, 45 }, { BOARD_WIDTH / 2 - 30, 45 },
			{ BOARD_WIDTH / 2 - 20, 45 }, { BOARD_WIDTH / 2 - 10, 45 }, { BOARD_WIDTH / 2, 45 },
			{ BOARD_WIDTH / 2 + 10, 45 }, { BOARD_WIDTH / 2 + 20, 45 }, { BOARD_WIDTH / 2 + 30, 45 },
			{ BOARD_WIDTH / 2 + 40, 45 }, { BOARD_WIDTH / 2 + 50, 45 }, { BOARD_WIDTH / 2 + 60, 45 } };

// SPECIAL MOVEMENTS

	/**
	 * These paths are selected randomly with methods. There is a wide range of movements that
	 * have been created using the coordinates system.
	 */
	// ZIG ZAG
	public static final int[][] zigzagDirections = { { DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 },
			{ DIR_SSW, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SE, 1 },
			{ DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_S, -1 } };

	// LOOP
	public static final int[][] loopDirections = { { DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_E, 1 },
			{ DIR_ENE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 }, { DIR_NW, 1 }, { DIR_WNW, 1 }, { DIR_W, 1 },
			{ DIR_WSW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, -1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 }, { DIR_S, 1 } };
	
	//ATTACK IN DIAGONALS
	public static final int[][] diagonalLeft = {{DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },{ DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },{ DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }};

	public static final int[][] diagonalRight = {{DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },{ DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },{ DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }};
		
	public static final int[][] rangedShooting = {{DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 },
			{ DIR_W, 1 },{ DIR_W, 1 },{ DIR_W, 1 },{ DIR_WSW, 1 },{ DIR_SW, 1 }, { DIR_SSW, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 }, 
			{DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 },{ DIR_E, 1 },{ DIR_ESE, 1 },{ DIR_SE, 1 },{ DIR_SSE, 1 },{ DIR_S, 1 },
			{DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 },
			{ DIR_W, 1 },{ DIR_W, 1 },{ DIR_W, 1 },{ DIR_WSW, 1 },{ DIR_SW, 1 }, { DIR_SSW, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 }, 
			{DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 },{ DIR_E, 1 },{ DIR_ESE, 1 },{ DIR_SE, 1 },{ DIR_SSE, 1 },{ DIR_S, -1 }};

	//FROM ONE BOUND TO OTHER
		public static final int[][] boundToBound = {{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },
			{DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_WSW,1},{ DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, -1 },
			{ DIR_SSE, 1 },{ DIR_SE, 1 },{ DIR_ESE, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },
			{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_ESE, 1 },{ DIR_SE, 1 },{ DIR_SSE, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },
			{DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_WSW,1},{ DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_SSE, 1 },{ DIR_SE, 1 },{ DIR_ESE, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },
			{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_E, 1 },{ DIR_ESE, 1 },{ DIR_SE, 1 },{ DIR_SSE, 1 },{ DIR_S, -1 }};

	// BIG ZIGZAG
		public static final int[][] bigZigzagDirections = { { DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 },
				{ DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 },
				{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 },
				{ DIR_SSW, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 },
				{ DIR_SSW, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SE, 1 },
				{ DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_S, 1 },{ DIR_SSE, 1 }, { DIR_SE, 1 },
				{ DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_S, 1 } };

// INITIAL ANIMATIONS
		
		/**
		 * These are the initial paths enemies will take to reach their swarm position declared above.
		 * 
		 * The first position of this array is referring to their initial position, right when the
		 * game starts. 
		 */
		
	// ZAKO
	public static final int[][] zakoInitialDirections = { { BOARD_WIDTH / 2 - 70, -10 },  { DIR_SE, 1 },{ DIR_SE, 1 },{ DIR_SE, 1 },{ DIR_SE, 1 },
			{ DIR_SE, 1 },{ DIR_SE, 1 },{ DIR_SE, 1 },{ DIR_SE, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_N, 1 },{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_NNE, 1 }, { DIR_NNE, 1 }, { DIR_NE, 1 },
			{ DIR_NE, 1 }, { DIR_ENE, 1 }, { DIR_ENE, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 },
			{ DIR_ESE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 },
			{ DIR_W, 1 }, { DIR_WNW, 1 }, { DIR_NW, 1 }, { DIR_NNW, 1 }, { DIR_N, 1 }, { DIR_NW, 1 }, { DIR_NW, 1 },
			{ DIR_NW, 1 }, { DIR_NW, 1 }, { DIR_NNW, 1 }, { DIR_NNW, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 }, { DIR_NNW, 1 },
			{ DIR_NW, 1 }, { DIR_NW, 1 }, { DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_WSW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SE, 1 },
			{ DIR_ESE, 1 }, { DIR_E, 1 }, { DIR_ENE, 1 }, { DIR_NE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_NNE, 1 }, { DIR_NNE, 1 }, { DIR_NE, 1 }, { DIR_NE, 1 },
			{ DIR_ENE, 1 }, { DIR_ENE, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_SSE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },
			{ DIR_S, 1 }, { DIR_SSW, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 }, { DIR_WSW, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_WNW, 1 },
			{ DIR_WNW, 1 }, { DIR_NW, 1 }, { DIR_NW, 1 }, { DIR_NNW, 1 }, { DIR_NNW, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 } };

	// GOEI
	public static final int[][] goeiInitialDirections = { { BOARD_WIDTH / 2 + 70, -10 }, { DIR_SW, 1 },{ DIR_SW, 1 }, { DIR_SW, 1 },{ DIR_SW, 1 },
			{ DIR_SW, 1 }, { DIR_SW, 1 },{ DIR_SW, 1 },{ DIR_SW, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_N, 1 },{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 }, { DIR_NNW, 1 }, { DIR_NW, 1 },
			{ DIR_NW, 1 }, { DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_WSW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 },
			{ DIR_E, 1 }, { DIR_ENE, 1 }, { DIR_NE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_NE, 1 }, { DIR_NE, 1 },
			{ DIR_NE, 1 }, { DIR_NE, 1 }, { DIR_NNE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_NNE, 1 }, { DIR_NNE, 1 },
			{ DIR_NE, 1 }, { DIR_NE, 1 }, { DIR_ENE, 1 }, { DIR_ENE, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_ESE, 1 }, { DIR_SE, 1 }, { DIR_SSE, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SW, 1 },
			{ DIR_WSW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_WNW, 1 }, { DIR_NW, 1 }, { DIR_NNW, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 },
			{ DIR_NNW, 1 }, { DIR_NW, 1 }, { DIR_NW, 1 }, { DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_WSW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_W, 1 }, { DIR_WSW, 1 }, { DIR_WSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 },
			{ DIR_SSW, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SSE, 1 },
			{ DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_ENE, 1 }, { DIR_ENE, 1 }, { DIR_NE, 1 }, { DIR_NE, 1 },
			{ DIR_NNE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 } };

	// COMMANDER
	public static final int[][] commanderInitialDirections =  { { BOARD_WIDTH / 2, -10 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },{ DIR_S, 1 },
			{ DIR_N, 1 },{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_NNW, 1 }, { DIR_NNW, 1 }, { DIR_NW, 1 },
			{ DIR_NW, 1 }, { DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 },
			{ DIR_W, 1 }, { DIR_WSW, 1 }, { DIR_SW, 1 }, { DIR_SSW, 1 }, { DIR_S, 1 }, { DIR_SSE, 1 }, { DIR_SE, 1 },
			{ DIR_ESE, 1 }, { DIR_E, 1 }, { DIR_E, 1 }, { DIR_ENE, 1 }, { DIR_NE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 },
			{ DIR_NE, 1 }, { DIR_NE, 1 }, { DIR_NE, 1 }, { DIR_NE, 1 }, { DIR_NNE, 1 }, { DIR_NNE, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSW, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 },
			{ DIR_WSW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_NW, 1 }, { DIR_NW, 1 },
			{ DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_NNE, 1 }, { DIR_NNE, 1 }, { DIR_NE, 1 }, { DIR_NE, 1 }, { DIR_ENE, 1 }, { DIR_ENE, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSW, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 },
			{ DIR_WSW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_NW, 1 }, { DIR_NW, 1 },
			{ DIR_WNW, 1 }, { DIR_WNW, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_NNE, 1 }, { DIR_NNE, 1 }, { DIR_NE, 1 }, { DIR_NE, 1 }, { DIR_ENE, 1 }, { DIR_ENE, 1 }, { DIR_E, 1 },
			{ DIR_E, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 }, { DIR_SE, 1 }, { DIR_SE, 1 }, { DIR_ESE, 1 }, { DIR_ESE, 1 },
			{ DIR_S, 1 }, { DIR_S, 1 }, { DIR_SSW, 1 }, { DIR_SSW, 1 }, { DIR_SW, 1 }, { DIR_SW, 1 }, { DIR_WSW, 1 },
			{ DIR_WSW, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_W, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 },
			{ DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 }, { DIR_N, 1 } };
	
	
	/**
	 * 	Used to obtain the image of the sprite
	 * @param sprite the sprite object
	 * @param lives the number of lives of the sprite
	 * @param number the number of skin
	 * @return the skin path
	 */
	public static String getSkin(Sprite sprite, int lives, int number) {
		if (sprite instanceof Player) {
			if (lives == 0) {
				String returnStr = "explosion1";
				returnStr += String.valueOf(number);
				returnStr += ".png";
				return returnStr;
			}
			return "player.png";
		}
		
		if(number >= 20 && number <= 24) {
			String returnStr = "explosion";
			returnStr += String.valueOf(number);
			returnStr += ".png";
			return returnStr;
		}
		
		if (sprite instanceof Zako) {
			if (number == -1) {
				return "enemy3G0.png";
			}
			
			if (number == 0) {
				return "enemy3G1.png";
			}
			
			String returnStr = "enemy3";
			if (number > 0 && number <= 15) {

				if (number > 0 && number < 10) {
					returnStr += "0";
				}

				returnStr += String.valueOf(number);
				returnStr += ".png";

				return returnStr;
			}
		}

		if (sprite instanceof Goei) {
			String returnStr = "enemy2";
			
			if (number == -1) {
				return "enemy2G1.png";
			}
			
			if (number == 0) {
				return "enemy200.png";
			}
			
			if (number > 0 && number <= 15) {

				if (number >= 0 && number < 10) {
					returnStr += "0";
				}
				returnStr += String.valueOf(number);

				returnStr += ".png";



				return returnStr;
			}
		}

		if (sprite instanceof Commander) {
			if (lives == 2) {
				if (number == -1) {
					return "enemy1G1.png";
				}

				if (number == 0) {
					return "enemy1G0.png";
				}

				if (number > 0 && number <= 15) {

					String returnStr = "enemy1";
					if (number > 0 && number < 10) {
						returnStr += "0";
					}
					returnStr += String.valueOf(number);
					returnStr += ".png";

					return returnStr;
				}

			}

			if (lives == 1) {
				if (number == -1) {
					return "enemy9G1.png";
				}

				if (number == 0) {
					return "enemy9G0.png";
				}

				if (number >= 0 && number <= 15) {

					String returnStr = "enemy9";
					if (number > 0 && number < 10) {
						returnStr += "0";
					}
					returnStr += String.valueOf(number);
					returnStr += ".png";

					return returnStr;
				}
			}

		}
		if (sprite instanceof PlayerTorpedo){
			return "torpedo100.png";
		}

		if (sprite instanceof EnemyTorpedo) {
			return "torpedo200.png";
		}

		if (sprite instanceof Star) {
			return "star.png";
		}
		return "SkinFailed.png";
	}

	
	//SOME VARIABLES TO CONTROL COUNTERS THAT WILL BE USED NOW
	
	private static int StarPosCounter = 0;
	private static boolean firstTime = true;
	private static int zakoPosCounter = 0;
	private static int goeiPosCounter = 0;
	private static int commanderPosCounter = 0;

	/**
	 * Thanks to this method the initial position of the sprites can be obtained efficiently

	 * @param sprite the sprite object
	 * @param level the level in which the sprite is
	 * @return a vector with the corresponding coordinates
	 */
	public static int[] getInitialCoordinatesVector(Sprite sprite, int level) {
		// Stars coordinates assigner
		if (sprite instanceof Star) {
			if (firstTime) {
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

				// System for shifting the stars for the second layer of stars.
				int shift = (int) (Math.random() * 60 + 20);

				// Analyzing shift in x.
				if (returnVector[0] + shift > BOARD_WIDTH) {
					returnVector[0] = returnVector[0] + shift - BOARD_WIDTH;
				} else {
					returnVector[0] = returnVector[0] + shift;
				}
				return returnVector;
			}
		}

		if (level == 1) {
			// Zako coordinates assigner
			if (sprite instanceof Zako) {
				if (zakoPosCounter >= zakoCoordinatesLevel1.length) {
					zakoPosCounter = 0;
				}
				return zakoCoordinatesLevel1[zakoPosCounter++];

			}
			// Goei coordinates assigner
			if (sprite instanceof Goei) {

				if (goeiPosCounter >= goeiCoordinatesLevel1.length) {
					goeiPosCounter = 0;
				}

				return goeiCoordinatesLevel1[goeiPosCounter++];
			}

			// Commander coordinates assigner
			if (sprite instanceof Commander) {
				if (commanderPosCounter >= commanderCoordinatesLevel1.length) {
					commanderPosCounter = 0;
				}
				return commanderCoordinatesLevel1[commanderPosCounter++];

			}
		}

		if (level == 2) {
			// Zako coordinates assigner

			if (sprite instanceof Zako) {

				if (zakoPosCounter >= zakoCoordinatesLevel2.length) {
					zakoPosCounter = 0;
				}

				return zakoCoordinatesLevel2[zakoPosCounter++];

			}

			// Goei coordinates assigner
			if (sprite instanceof Goei) {

				if (goeiPosCounter >= goeiCoordinatesLevel2.length) {
					goeiPosCounter = 0;
				}
				return goeiCoordinatesLevel2[goeiPosCounter++];

			}

			// Commander coordinates assigner
			if (sprite instanceof Commander) {

				if (commanderPosCounter >= commanderCoordinatesLevel2.length) {
					commanderPosCounter = 0;
				}

				return commanderCoordinatesLevel2[commanderPosCounter++];
			}
		}

		if (level == 3) {
			// Zako coordinates assigner
			if (sprite instanceof Zako) {
				if (zakoPosCounter >= zakoCoordinatesLevel3.length) {
					zakoPosCounter = 0;
				}

				return zakoCoordinatesLevel3[zakoPosCounter++];

			}

			// Goei coordinates assigner
			if (sprite instanceof Goei) {
				if (goeiPosCounter >= goeiCoordinatesLevel3.length) {
					goeiPosCounter = 0;
				}
				return goeiCoordinatesLevel3[goeiPosCounter++];

			}

			// Commander coordinates assigner
			if (sprite instanceof Commander) {
				if (commanderPosCounter >= commanderCoordinatesLevel3.length) {
					commanderPosCounter = 0;
				}
				return commanderCoordinatesLevel3[commanderPosCounter++];

			}
		}

		if (sprite instanceof Player) {
			int[] playerPosition = { (BOARD_WIDTH / 2), (BOARD_HEIGHT - 20) };
			return playerPosition;
		}

		return null;

	}

	
	/**
	 * Method to know how many positions are available in the arrays

	 * @param sprite the sprite object
	 * @param level the level of the game
	 * @return the number of available positions in the array for the sprites
	 */
	public static int getNumberOfAvailablePositions(String sprite, int level) {
		if (sprite.equals("Star")) {
			return StarPositions.length;
		}

		if (level == 1) {
			if (sprite.equals("Commander")) {
				return commanderCoordinatesLevel1.length;
			}
			if (sprite.equals("Goei")) {
				return goeiCoordinatesLevel1.length;
			}
			if (sprite.equals("Zako")) {
				return zakoCoordinatesLevel1.length;
			}
		}
		if (level == 2) {
			if (sprite.equals("Commander")) {
				return commanderCoordinatesLevel2.length;
			}
			if (sprite.equals("Goei")) {
				return goeiCoordinatesLevel2.length;
			}
			if (sprite.equals("Zako")) {
				return zakoCoordinatesLevel2.length;
			}
		}
		if (level == 3) {
			if (sprite.equals("Commander")) {
				return commanderCoordinatesLevel3.length;
			}
			if (sprite.equals("Goei")) {
				return goeiCoordinatesLevel3.length;
			}
			if (sprite.equals("Zako")) {
				return zakoCoordinatesLevel3.length;
			}
		}
		return 0;
	}

	public static int getNumberOfAvailablePositions(int level) {
		switch (level) {
		case 1:
			return commanderCoordinatesLevel1.length + goeiCoordinatesLevel1.length + zakoCoordinatesLevel1.length;
		case 2:
			return commanderCoordinatesLevel2.length + goeiCoordinatesLevel2.length + zakoCoordinatesLevel2.length;
		case 3:
			return commanderCoordinatesLevel3.length + goeiCoordinatesLevel3.length + zakoCoordinatesLevel3.length;
		}
		return 0;
	}
	
	/**
	 * Path system that enemies use to choose a path.
	 * This is done randomly, choosing any path of the ones created.

	 * @param sprite the sprite object
	 * @param pathNumber the number indentifier of the path
	 * @return a two dimmension array with the directions
	 */
	public static int[][] getPath(Sprite sprite, int pathNumber) {
		switch (pathNumber) {
		case 0:
			if (sprite instanceof Zako) {
				return zakoInitialDirections;
			}
			if (sprite instanceof Goei) {
				return goeiInitialDirections;
			}
			if (sprite instanceof Commander) {
				return commanderInitialDirections;
			}
		case 1:
			return zigzagDirections;
		case 2:
			return loopDirections;
		case 3:
			return bigZigzagDirections;
		case 4:
			return diagonalRight;
		case 5:
			return diagonalLeft;
		case 6:
			return rangedShooting;
		case 7:
			return boundToBound;
		}
		return null;
	}
	
	//Number of available paths
	//If we want to implement another path, we just increase it by one unit.
	public static int availableNumberOfPath = 7;
}