package src;

import edu.uc3m.game.GameBoardGUI;

public class Stars implements Runnable {
	
	private int density;
	private int speed;
	private int[] starPositionX;
	private int[] starPositionY;
	private int precission = 20;
	private GameBoardGUI board;
	
	public void generateSky() {
		
		starPositionX = new int[this.density];
		starPositionY = new int[this.density];
		
		//Procedural generator
		positionGenerator(starPositionX, starPositionY, this.density, this.precission);
		
		
		for(int ii = 0; ii < this.density; ii++) {
			this.board.gb_addSprite((ii+5000), "Star.png", true);
			this.board.gb_moveSpriteCoord((ii+5000), starPositionX[ii], starPositionY[ii]);
			this.board.gb_setSpriteVisible((ii+5000), true);
		}
		
		
		
		//Movement loop
		while(Game.running) {
			for(int ii = 0; ii < this.density; ii++) {
				
				if(starPositionY[ii] < Game.height) {
					starPositionY[ii]++;
				} else {
					starPositionY[ii] = 0;
				}
				
				//starPositionX[ii] = starPositionX[ii] + (int)((Math.random()*-1));
				
				this.board.gb_moveSpriteCoord((ii+5000), starPositionX[ii], starPositionY[ii]);
				
			}
			
			//Ralentizer
			try { 										//why is try necessary?
				Thread.sleep(this.speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
	
	 
	

	//Procedural generator of stars position
	
	//TODO: add in the memory: We attempted several times to design an algorithm capable of creating nice-evenly distributed stars position.
	//However, we realised we weren't mathematicians. So we decided to implement the Poisson-Disc Sampling by Robert Bridson.

	
	public void positionGenerator(int[] X, int[] Y, int density, int precission) {
		
		int[] tempX = new int[X.length]; //The same length for both
		int[] tempY = new int[Y.length];
		
		//Creating one initial random point
		tempX[0] = (int)(Math.random()*(Game.width));
		tempY[0] = (int)(Math.random()*(Game.height));
		
		tempX[1] = (int)(Math.random()*(Game.width));
		tempY[1] = (int)(Math.random()*(Game.height));
		tempX[2] = (int)(Math.random()*(Game.width));
		tempY[2] = (int)(Math.random()*(Game.height));
		
		
		//Procedural generator for even distribution of stars
		
		for(int ii = 3; ii < tempX.length; ii++){
			
			int bestIndex = 0;
			
			//Generating ten candidates
			
				int[] candidateX = new int[precission];
				int[] candidateY = new int[precission];
	
				for(int kk = 0; kk < precission; kk++) {
					candidateX[kk] = (int)(Math.random()*(Game.width));
					candidateY[kk] = (int)(Math.random()*(Game.height));
				}
				
				//Selecting the best candidate between the generated ones
				
				double biggestDistance = 0; //TODO: Arbitrary?
				double totalDistance = 0;
				
				
									
					for(int kk = 0; kk < precission; kk++) {
						
						totalDistance = 0;
						
						//Calculating the total distance of k = 1 and so wrt tempX
						for(int ll = 0; ll < ii; ll++) {
								totalDistance = totalDistance + NewdistanceCalculator(candidateX[kk], candidateY[kk], tempX[ll], tempY[ll]);
						}
						
						if(biggestDistance < totalDistance) {
							bestIndex = kk;
							biggestDistance = totalDistance;
						}
						
						
					}

			
			tempX[ii] = candidateX[bestIndex];
			tempY[ii] = candidateY[bestIndex];
			
			
		}
		
		System.arraycopy(tempX, 0, X, 0, X.length);
		System.arraycopy(tempY, 0, Y, 0, Y.length);

	}
	
	
	
	

	
	


	private double distanceCalculator(int Ax,int Ay, int Bx, int By) {
		
		int dx = Math.abs(Ax-Bx);
		int dy = Math.abs(Ay-By);
		
		double distance = Math.pow((dx*dx + dy*dy),(0.5));
		
		return distance;
		
	}
	
	private double NewdistanceCalculator(int Ax,int Ay, int Bx, int By) {
		
		int dx = Math.abs(Ax-Bx);
		int dy = Math.abs(Ay-By);
		
		if(dx > Game.width) {
			dx = dx - Game.width;
		}
		if(dy > Game.height) {
			dy = dy - Game.height;
		}
		
		double distance = Math.pow((dx*dx + dy*dy),(0.5));
		
		return distance;
		
	}
	
	
	
	
	
	public Stars(int density, int speed) {
		if (density > 0) {
			this.density = density;
		}
		this.speed = speed;
	}
	
	public void start() {
		generateSky();
	}

	@Override
	public void run() {
		generateSky();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Procedural generator of stars position
	
	//TODO: add in the memory: We attempted several times to design an algorithm capable of creating nice-evenly distributed stars position.
	//However, we realised we weren't mathematicians. So we decided to implement the Poisson-Disc Sampling by Robert Bridson.

	
	public void positionGeneratorDisk(int[] X, int[] Y, int density, int precission) {
		
		int[] tempX = new int[X.length]; //The same length for both
		int[] tempY = new int[Y.length];
		
		//Creating one initial random point
		tempX[0] = (int)(Math.random()*(Game.width));
		tempY[0] = (int)(Math.random()*(Game.height));
		
		tempX[1] = (int)(Math.random()*(Game.width));
		tempY[1] = (int)(Math.random()*(Game.height));
		tempX[2] = (int)(Math.random()*(Game.width));
		tempY[2] = (int)(Math.random()*(Game.height));
		
		
		//Procedural generator for even distribution of stars
		
		for(int ii = 3; ii < tempX.length; ii++){
			
			int bestIndex = 0;
			
			//Generating ten candidates
			
				int[] candidateX = new int[precission];
				int[] candidateY = new int[precission];
	
				for(int kk = 0; kk < precission; kk++) {
					candidateX[kk] = (int)(Math.random()*(Game.width));
					candidateY[kk] = (int)(Math.random()*(Game.height));
				}
				
				//Selecting the best candidate between the generated ones
				
				double biggestDistance = 0; //TODO: Arbitrary?
				double totalDistance = 0;
				
				
									
					for(int kk = 0; kk < precission; kk++) {
						
						totalDistance = 0;
						
						//Calculating the total distance of k = 1 and so wrt tempX
						for(int ll = 0; ll < ii; ll++) {
								totalDistance = totalDistance + distanceCalculator(candidateX[kk], candidateY[kk], tempX[ll], tempY[ll]);
						}
						
						if(biggestDistance > totalDistance) {
							bestIndex = kk;
							biggestDistance = totalDistance;
						}
						
						
					}

			
			tempX[ii] = candidateX[bestIndex];
			tempY[ii] = candidateY[bestIndex];
			
			
		}
		
		System.arraycopy(tempX, 0, X, 0, X.length);
		System.arraycopy(tempY, 0, Y, 0, Y.length);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
