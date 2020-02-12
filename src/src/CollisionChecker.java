package src;

import edu.uc3m.game.GameBoardGUI;

/**
 * Class used to detect the collisions between sprites.
 * 
 * @author Raúl P. and Diego G.
 * @version 3.2
 * 
 */

public class CollisionChecker {

	double distanceThresold;

	public CollisionChecker(GameBoardGUI board, double distanceThresold) {
		this.distanceThresold = distanceThresold;
	}

	/**
	 * Checks if two sprites have collided and tells them if they have collided
	 * using the collide() method of both of them.
	 * 
	 * @param spriteA one sprite to check
	 * @param spriteB other sprite to check
	 */
	public void check(Sprite spriteA, Sprite spriteB) {

		if (calculateDistance(spriteA, spriteB) < distanceThresold && spriteA.isActiveCollisions()
				&& spriteB.isActiveCollisions()) {

			spriteA.collision();
			spriteB.collision();

		}
	}
	
	/**
	 * Checks if the collisions between a sprite and an array of sprites and tells them if they have collided
	 * using the collide() method.
	 * 
	 * @param spriteA one sprite to check.
	 * @param spriteB an array of sprites to check.
	 */

	public void check(Sprite spriteA, Sprite[] spriteB) {

		if (spriteA.isActiveCollisions()) {
			for (Sprite iSpriteB : spriteB) {
				if (iSpriteB.isActiveCollisions()) {
					if (calculateDistance(spriteA, iSpriteB) < distanceThresold) {

						spriteA.collision();
						iSpriteB.collision();

					}
				}
			}
		}
	}
	
	
	/**
	 * Checks if the collisions between a two arrays of sprites and tells them if they have collided
	 * using the collide() method.
	 * 
	 * @param spriteA an array of sprites to check.
	 * @param spriteB other array of sprites to check.
	 */

	public void check(Sprite[] spriteA, Sprite[] spriteB) {

		for (int ii = 0; ii < spriteA.length; ii++) {
			if (spriteA[ii].isActiveCollisions()) {
				for (int jj = 0; jj < spriteB.length; jj++) {
					if (spriteB[jj].isActiveCollisions()) {
						if (calculateDistance(spriteB[jj], spriteA[ii]) < distanceThresold) {

							spriteA[ii].collision();
							spriteB[jj].collision();

						}
					}
				}
			}
		}
	}
	
	/**
	 * Checks if the collitions between a array of arrays of sprites and an array of sprites and tells them if they have collided
	 * using the collide() method.
	 * 
	 * @param spriteA a array of arrays of sprites to check.
	 * @param spriteB an array of sprites to check.
	 */

	public void check(Sprite[][] spriteA, Sprite[] spriteB) {

		for (Sprite[] spriteTypeA : spriteA) {
			for (Sprite spriteToCheckA : spriteTypeA) {
				if (spriteToCheckA.isActiveCollisions()) {
					for (Sprite spriteBToCheck : spriteB) {
						if (spriteBToCheck.isActiveCollisions()) {
							if (calculateDistance(spriteToCheckA, spriteBToCheck) < distanceThresold) {

								spriteToCheckA.collision();
								spriteBToCheck.collision();

							}
						}
					}
				}
			}
		}
	}

	public void check(Sprite[][] spriteA, Sprite spriteB) {

		if (spriteB.isActiveCollisions()) {
			for (Sprite[] spriteTypeA : spriteA) {
				for (Sprite spriteToCheckA : spriteTypeA) {
					if (spriteToCheckA.isActiveCollisions()) {
						if (calculateDistance(spriteToCheckA, spriteB) < distanceThresold) {

							spriteToCheckA.collision();
							spriteB.collision();

						}
					}
				}
			}
		}
	}

	// Distance calculator
	private double calculateDistance(Sprite spriteA, Sprite spriteB) {
		int[] spriteACoord = spriteA.getCoordinates();
		int[] spriteBCoord = spriteB.getCoordinates();

		double distanceX = Math.abs(spriteACoord[0] - spriteBCoord[0]);
		double distanceY = Math.abs(spriteACoord[1] - spriteBCoord[1]);

		return (Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));

	}

}