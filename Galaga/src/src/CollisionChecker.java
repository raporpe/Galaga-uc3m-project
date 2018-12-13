package src;

import edu.uc3m.game.GameBoardGUI;

public class CollisionChecker {

	double distanceThresold;

	public CollisionChecker(GameBoardGUI board, double distanceThresold) {
		this.distanceThresold = distanceThresold;
	}

	public void check(Sprite spriteA, Sprite spriteB, boolean spriteADeath, boolean spriteBDeath) {

		if (calculateDistance(spriteA, spriteB) < distanceThresold && spriteA.isVisible() && spriteB.isVisible()) {

			if (spriteADeath) {
				spriteA.destroy();
			}

			if (spriteBDeath) {
				spriteB.destroy();
			}

		}

	}

	public void check(Sprite spriteA, Sprite[] spriteB, boolean spriteADeath, boolean spriteBDeath) {

		if (spriteA.isVisible()) {
			for (Sprite iSpriteB : spriteB) { // TODO: INVENT ANOTHER NAME
				if (iSpriteB.isVisible()) {
					if (calculateDistance(spriteA, iSpriteB) < distanceThresold) {
						if (spriteADeath) {
							spriteA.destroy();
						}

						if (spriteBDeath) {
							iSpriteB.destroy();
						}
					}
				}
			}
		}

	}

	public void check(Sprite[] spriteA, Sprite[] spriteB, boolean spriteADeath, boolean spriteBDeath) {

		for (int ii = 0; ii < spriteA.length; ii++) {
			if (spriteA[ii].isVisible()) {
				for (int jj = 0; jj < spriteB.length; jj++) {
					if (spriteB[jj].isVisible()) {

						if (spriteADeath) {
							spriteA[ii].destroy();
						}

						if (spriteBDeath) {
							spriteB[jj].destroy();
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
