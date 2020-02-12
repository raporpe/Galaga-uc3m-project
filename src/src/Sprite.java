package src;

import edu.uc3m.game.GameBoardGUI;

/**
 * Mother of Enemy and Player. Class for all the common characteristics between
 * sprites
 * 
 * @author Raúl P. and Diego G.
 * @version 52.03
 * 
 */

abstract public class Sprite {

	protected GameBoardGUI board;
	protected int id;
	protected int x;
	protected int y;

	/**
	 * Used to evaluate if the sprite has to be updated
	 */
	protected boolean visible;
	protected String currentSkin = "noSkin.png";
	/**
	 * In some cases, lie in the entry animation, this variable is set to false to
	 * prevent th previous torpedoes from colliding
	 */
	protected boolean activeCollisions;

	protected int maxLives;
	protected int lives;

	protected int level = 1;

	/**
	 * Increased every time the update() is executed
	 */
	protected int frameCounter;

	public Sprite(GameBoardGUI board, int maxLives, boolean activeCollisions, int level) {

		this.level = level;
		this.board = board;
		this.maxLives = maxLives;
		this.lives = maxLives;

		// Generating sprite
		this.id = IdManager.assignId(this);
		this.currentSkin = Constants.getSkin(this, lives, 0);
		this.board.gb_addSprite(this.id, this.currentSkin, true);

		// Setting the sprite in the position
		initialCoordinates();
		this.board.gb_moveSpriteCoord(this.id, this.x, this.y);
		setVisibility(true);
		this.activeCollisions = false;

	}

	/**
	 * Gets the corresponding initial coordinates for the sprite from constants.
	 * 
	 * Warning: this function is used in the constructor. In the child classes this
	 * function can be differently implemented.
	 */
	public void initialCoordinates() {
		int[] tempInitialCoordinates = Constants.getInitialCoordinatesVector(this, level);
		setX(tempInitialCoordinates[0]);
		setY(tempInitialCoordinates[1]);
	}

	/**
	 * This method is called in every frame unless the sprite visibility is set to
	 * false.
	 */
	protected void update() {
		frameCounter++;
	}

	// Getters and setters

	/**
	 * Sets the x position. The sprite position in the board is not updated.
	 * Moreover, it checks if the x position is correct.
	 * 
	 * @param x position
	 */
	protected void setX(int x) {
		if (x >= 0 && x <= Constants.BOARD_WIDTH) {
			this.x = x;
		}
	}

	/**
	 * Sets the y position. The sprite position in the board is not updated.
	 * Moreover, it checks if the y position is correct.
	 * 
	 * @param y position
	 */
	protected void setY(int y) {
		if (y >= -10 && y <= Constants.BOARD_HEIGHT + 10) {
			this.y = y;
		}
	}

	/**
	 * @return Array of coordinates of the sprite: {x,y}
	 */
	public int[] getCoordinates() {
		int[] coord = { this.x, this.y };
		return coord;
	}

	/**
	 * Changed the visibility variable of the sprite and hides or shows the sprite
	 * in the board. Use to
	 * 
	 * @param visibility false for hidden or true for visible
	 */
	protected void setVisibility(boolean visibility) {
		this.visible = visibility;
		board.gb_setSpriteVisible(this.id, visibility);
	}

	/**
	 * Used to check if the sprite has to be updated.
	 * 
	 * @return visibility status of the sprite
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Changes the Sprite Skin in the board and updates the variable currentSkin.
	 * Warning: the skin image has to be included in the correct folder.
	 * 
	 * @param image   Skin image path.
	 * @param bigSkin If the new skin has to be bigger than usual.
	 */
	protected void setSpriteSkin(String image, boolean bigSkin) {
		this.currentSkin = image;
		if (bigSkin) {
			board.gb_setSpriteImage(this.id, this.currentSkin, 50, 50);
		} else {
			board.gb_setSpriteImage(this.id, this.currentSkin);
		}
	}

	// --------------Movement functions---------------//
	// There are three functions.

	/**
	 * Moves the Sprite instantly to the desired position using the board
	 * coordinates without changing the skin.
	 * 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	protected void moveSpriteTo(int x, int y) {
		setX(x);
		setY(y);
		board.gb_moveSpriteCoord(this.id, this.x, this.y);
	}

	/**
	 * Changes the sprite position and sets the according skin looking to the
	 * direction. This method uses the direction system described in Constants. For
	 * further information, see
	 * 
	 * @param direction The direction (an int from 0 to 15). Use the direction
	 *                  system defined in Constants.
	 * @param modulus   The factor by which the position variation will be
	 *                  multiplied. Recommended value is one.
	 */
	protected void changeSpritePos(int direction, int modulus) {

		// Negative values are not considered in the modulus
		modulus = Math.abs(modulus);
		int dx = Constants.MOVES[direction][0] * modulus;
		int dy = Constants.MOVES[direction][1] * modulus;
		setX(x + dx);
		setY(y + dy);
		setSpriteSkin(Constants.getSkin(this, lives, direction), false);

		board.gb_moveSpriteCoord(this.id, this.x, this.y);
	}

	/**
	 * Changes the sprite position but the skin is not changed. Warning: the sprite
	 * will variate its position by the inserted values but not go to the
	 * coordinates of the inserted values.
	 * 
	 * @param dx x coordinate variation.
	 * @param dy y coordinate variation.
	 */
	protected void changeSpritePosDxDy(int dx, int dy) {
		setX(this.x + dx);
		setY(this.y + dy);
		board.gb_moveSpriteCoord(this.id, this.x, this.y);
	}

	// ------------Collision System--------------///

	/**
	 * Decreases by one the sprite lives
	 */
	protected void loseLive() {
		// Imagine two torpedoes collide with a Sprite in the same frame. That's why
		// this.lifes is checked to be greater than 0.
		if (this.lives > 0) {
			this.lives--;
		}
	}

	/**
	 * Executed by CollisionChecker in both sprites if their distance is under a
	 * threshold.
	 */
	protected void collision() {
		if (activeCollisions) {
			loseLive();
			if (this.lives == 0) {
				this.death();
			}
		}
	}

	/**
	 * Executed when the sprite has zero lives.
	 */
	protected void death() {
		setVisibility(false);
		activeCollisions = false;
		moveSpriteTo(Constants.DEFAULT_SPRITE_POS_X, Constants.DEFAULT_SPRITE_POS_Y);
	}

	/**
	 * Returns if the Sprite has active collitions.
	 * 
	 * @return True if the sprite collitions are active
	 */
	public boolean isActiveCollisions() {
		return activeCollisions;
	}


	// Empty constructor
	public Sprite() {

	}

}
