package src;

import edu.uc3m.game.GameBoardGUI;

public class Star extends Sprite{
	
	private int speed;
	private int shift;
		
	
	public Star(int speed, int shift, GameBoardGUI board) {
		super(IdManager.getId("star"), board, "star.png", "", Constants.getStarPosition()[0] + shift, Constants.getStarPosition()[1]);
		setSpeed(speed);
		setShift(shift);
		setVisibility(true);
		
		
		
	}
	
	public void moveStep() {
		setY(getY() + this.speed);
		if(getY() == Game.BOARD_HEIGHT) {
			setX(0);
		}
	}
		
	
	
	//Getters and setters
	private void setSpeed(int speed) {
		this.speed = speed;
	}
	
	private int getSpeed() {
		return this.speed;
	}

	private int getShift() {
		return shift;
	}

	private void setShift(int shift) {
		this.shift = shift;
	}
	
	
	
	
	
	
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//Procedural generator of stars position
//	
//	//TODO: add in the memory: We attempted several times to design an algorithm capable of creating nice-evenly distributed stars position.
//	//However, we realised we weren't mathematicians. So we decided to implement the Poisson-Disc Sampling by Robert Bridson.
//
//	
//	public void positionGeneratorDisk(int[] X, int[] Y, int density, int precission) {
//		
//		int[] tempX = new int[X.length]; //The same length for both
//		int[] tempY = new int[Y.length];
//		
//		//Creating one initial random point
//		tempX[0] = (int)(Math.random()*(Game.BOARD_WIDTH));
//		tempY[0] = (int)(Math.random()*(Game.BOARD_HEIGHT));
//		
//		tempX[1] = (int)(Math.random()*(Game.BOARD_WIDTH));
//		tempY[1] = (int)(Math.random()*(Game.BOARD_HEIGHT));
//		tempX[2] = (int)(Math.random()*(Game.BOARD_WIDTH));
//		tempY[2] = (int)(Math.random()*(Game.BOARD_HEIGHT));
//		
//		
//		//Procedural generator for even distribution of stars
//		
//		for(int ii = 3; ii < tempX.length; ii++){
//			
//			int bestIndex = 0;
//			
//			//Generating ten candidates
//			
//				int[] candidateX = new int[precission];
//				int[] candidateY = new int[precission];
//	
//				for(int kk = 0; kk < precission; kk++) {
//					candidateX[kk] = (int)(Math.random()*(Game.BOARD_WIDTH));
//					candidateY[kk] = (int)(Math.random()*(Game.BOARD_HEIGHT));
//				}
//				
//				//Selecting the best candidate between the generated ones
//				
//				double biggestDistance = 0; //TODO: Arbitrary?
//				double totalDistance = 0;
//				
//				
//									
//					for(int kk = 0; kk < precission; kk++) {
//						
//						totalDistance = 0;
//						
//						//Calculating the total distance of k = 1 and so wrt tempX
//						for(int ll = 0; ll < ii; ll++) {
//								totalDistance = totalDistance + distanceCalculator(candidateX[kk], candidateY[kk], tempX[ll], tempY[ll]);
//						}
//						
//						if(biggestDistance > totalDistance) {
//							bestIndex = kk;
//							biggestDistance = totalDistance;
//						}
//						
//						
//					}
//
//			
//			tempX[ii] = candidateX[bestIndex];
//			tempY[ii] = candidateY[bestIndex];
//			
//			
//		}
//		
//		System.arraycopy(tempX, 0, X, 0, X.length);
//		System.arraycopy(tempY, 0, Y, 0, Y.length);
//
//	}
//	

	
	

