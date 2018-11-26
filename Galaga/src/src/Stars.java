package src;

public class Stars implements Runnable {
	
	int density;
	int speed;
	int[] starPositionX;
	int[] starPositionY;
	int precission = 10;
	
	
	
	
	
	public void generateSky() {
		
		starPositionX = new int[this.density];
		starPositionY = new int[this.density];
		
		//Procedural generator
		positionGenerator(starPositionX, starPositionY, this.density, this.precission);
		
		
		for(int ii = 0; ii < this.density; ii++) {
			Game.board.gb_addSprite((ii+5000), "Star.png", true);
			Game.board.gb_moveSpriteCoord((ii+5000), starPositionX[ii], starPositionY[ii]);
			Game.board.gb_setSpriteVisible((ii+5000), true);
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
				
				Game.board.gb_moveSpriteCoord((ii+5000), starPositionX[ii], starPositionY[ii]);
				
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
	public void positionGenerator(int[] X, int[] Y, int density, int precission) {
		
		int[] tempX = new int[X.length]; //The same length for both
		int[] tempY = new int[Y.length];
		
		tempX[0] = (int)(Math.random()*(Game.width));
		tempY[0] = (int)(Math.random()*(Game.height));
		
		
		
		
		
		//Procedural generator for even distribution of stars
		
		for(int ii = 1; ii < tempX.length; ii++){
			
			int bestIndex = 0;
			
			//Generating ten candidates
			
				int[] genX = new int[precission];
				int[] genY = new int[precission];
	
				for(int kk = 0; kk < precission; kk++) {
					genX[kk] = (int)(Math.random()*(Game.width));
					genY[kk] = (int)(Math.random()*(Game.height));
				}
				
				//Selecting the best candidate between the generated ones
				
				double biggestDistance = 0; //TODO: Arbitrary?
				double totalDistance = 0;
				
				
				
				//for(int jj = 0; jj < ii; jj++) {
					
					for(int kk = 0; kk < precission; kk++) {
						
						totalDistance = 0;
						
						//Calculating the total distance of k = 1 and so on
						for(int ll = 0; ll < ii; ll++) {
							totalDistance = totalDistance + distanceCalculator(genX[kk], genY[kk], tempX[ll], tempY[ll]);
						}
						
						if(biggestDistance < totalDistance) {
							bestIndex = kk;
							biggestDistance = totalDistance;
						}
						
						
					}
					

					
					
					
					
			//	}
	
				
			
			
			
			tempX[ii] = genX[bestIndex];
			tempY[ii] = genY[bestIndex];
			
			
		}
		
		System.arraycopy(tempX, 0, X, 0, X.length);
		System.arraycopy(tempY, 0, Y, 0, Y.length);

	}

	
	


	private double distanceCalculator(int Ax,int Ay, int Bx, int By) {
		
		int dx = Math.abs(Ax-Bx);
		int dy = Math.abs(Ay-By);
		
		double distance = Math.pow(Math.pow(dx, 2) + Math.pow(dy, 2),(0.5));
		
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
	

}
