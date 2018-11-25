package src;

public class Stars implements Runnable {
	
	int density;
	int speed;
	int[] starPositionX;
	int[] starPositionY;

	
	
	
	
	
	public void generateSky() {
		
		starPositionX = new int[this.density];
		starPositionY = new int[this.density];
		
		//Procedural generator
		positionGenerator(starPositionX, starPositionY, this.density);
		
		
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
	public void positionGenerator(int[] X, int[] Y, int density) {
		
		int[] tempX = new int[X.length];
		int[] tempY = new int[Y.length];
		
		int sep = (int)((17-1-this.density)/(this.density+2));
		
		//Procedural generator for even distribution of stars
		
		for(int ii = 0; ii < tempX.length; ii++){
			
			
			boolean passed = true;
			int genX;
			int genY;
			
			//Checking if the stars have been generated nearly
			do {
				
				passed = true;

				//X axis
				genX = (int)(Math.random()*(Game.width-5));
				
				for(int jj = 0; jj < ii; jj++) {
					if(Math.abs((genX - tempX[jj])) <= sep) {
						passed = false;
					}
				}
				
				//Y axis
				genY = (int)(Math.random()*Game.height);
				
				for(int jj = 0; jj < ii; jj++) {
					if(Math.abs((genY - tempY[jj])) <= 5) {
						passed = false;
					}
				}
				
			} while(!passed);
			
			
			
			tempX[ii] = genX;
			tempY[ii] = genY;
			
			
		}
		
		System.arraycopy(tempX, 0, X, 0, X.length);
		System.arraycopy(tempX, 0, Y, 0, Y.length);

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
