package src;

//Importing the Locale object to change the default
//configuration of the computer to English

import java.util.Locale;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;


public class Game {



	
	private static boolean running = true;
	
	public static void stopGame() {
		Game.running = false;
	}
	
	public static Boolean isRunning() {
		if(Game.running) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//Great variables declaration
	
	static double initialTime;

	


	
	//Testing
	

	
	
	
	


	
	
	
	public static void main(String[] args) {
		
		String playerName = "test";
		
		
		//To change the GUI to English
		Locale.setDefault(new Locale("en"));

		
		
		//Create a 17x22 board
		GameBoardGUI board = new GameBoardGUI(Constants.BOARD_WIDTH_BIG_COORDINATES, Constants.BOARD_HEIGHT_BIG_COORDINATES);
		
		//After startup, setting board visible.
		board.setVisible(true);
		
		//Grid color setter
		board.gb_setGridColor(40, 40, 40);		
		
		for(int ii = 0; ii < (Constants.BOARD_WIDTH_BIG_COORDINATES); ii++) {
			for(int jj = 0; jj < (Constants.BOARD_HEIGHT_BIG_COORDINATES); jj++) {
				board.gb_setSquareColor(ii, jj, 0, 0, 0);
			}
		}
		
		
		Torpedo[] playerTorpedo = new Torpedo[Constants.BOARD_HEIGHT_BIG_COORDINATES];
		Player player = new Player(board, playerName, playerTorpedo);
		Game game = new Game();
		CollisionChecker collisionChecker = new CollisionChecker(board, Constants.COLLISION_RADIUS);
		
		
		Constants positionAssingner = new Constants();

		Zako[] zako = new Zako[positionAssingner.getNumberOfAvailablePositions("Zako",1)];
		Goei[] goei = new Goei[positionAssingner.getNumberOfAvailablePositions("Goei",1)];
		Commander[] commander = new Commander[positionAssingner.getNumberOfAvailablePositions("Commander",1)];
		
		// create swarmPositions
		// create currentPositions (x,y)

		//Initialize torpedoes array
		for(int ii = 0; ii < playerTorpedo.length; ii++) {
			playerTorpedo[ii] = new Torpedo(board);
		}
		
		
		
		//Star declaration
		
		
		Star[] fastStar = new Star[positionAssingner.getNumberOfAvailablePositions("Star",1)];

		Star[] slowStar = new Star[positionAssingner.getNumberOfAvailablePositions("Star",1)];
		
		
		//Stars initialization
		for (int ii = 0; ii < fastStar.length; ii++) {
			fastStar[ii] = new Star(board, 0.01, 60);
		}
		
		for (int ii = 0; ii < slowStar.length; ii++) {
			slowStar[ii] = new Star(board, 1, 0);
		}
		
		
		
		//Enemies initialization
		for(int ii = 0; ii < zako.length; ii++){
			zako[ii] = new Zako(board);
		}
		
		for(int ii = 0; ii < goei.length; ii++){
			goei[ii] = new Goei(board);
		}
		
		for(int ii = 0; ii < commander.length; ii++){
			commander[ii] = new Commander(board);
		}

		double lastShotTime = 0;


//----------------------THE MAIN WHILE-------------------------//
		
		
/* 
 				  ("`-''-/").___..--''"`-._
				   `6_ 6  )   `-.  (     ).`-.__.`)
				   (_Y_.)'  ._   )  `._ `. ``-..-'			//This cat will keep our code efficient, clean and organised.				   												
				 _..`--'_..-_/  /--'_.' ,'					//She likes eating bugs.
				(il),-''  (li),'  ((!.-'						
*/
		
		do {
			
			//we take at the beginning the time
			//THIS IS AN IMPLEMENTATION OF FPS SYSTEM
			initialTime = System.nanoTime();
			
			
						
			
			String lastAction;
			lastAction = board.gb_getLastAction();
			if(lastAction.equals("right")) {	
				player.moveRight(Constants.PLAYER_MOVEMENT_SPACE);

			}
			if(lastAction.equals("left")) {
				player.moveLeft(Constants.PLAYER_MOVEMENT_SPACE);
			}
			
			if(lastAction.equals("space")) {
				
				if(System.currentTimeMillis() - lastShotTime > (Constants.MAX_TORPEDOES_PER_SQAURE*10*1000/Constants.FPS)) {
					player.shootTorpedo();
					lastShotTime = System.currentTimeMillis();
					System.out.println(lastShotTime + "    s");
				}
				
			}
			
			//create function to know when has touched left and right bounds
			
			//MOVE SWARM

			for(int i=0;i<goei.length;i++) {
				if (goei[i].boundRight==false) {
					goei[i].xSwarm++;
					if (goei[i].xSwarm == Constants.BOARD_WIDTH-20) {
						goei[i].ySwarm++;
						goei[i].boundRight=true;

					}
				}else {
					goei[i].xSwarm--;
					if (goei[i].xSwarm == 20) {
						goei[i].boundLeft=true;
						goei[i].boundRight=false;
						goei[i].ySwarm++;
					}
				}
			}
			
			for(int i=0;i<commander.length;i++) {
				if (commander[i].boundRight==false) {
					commander[i].xSwarm++;
					if (commander[i].xSwarm == Constants.BOARD_WIDTH-20) {
						commander[i].ySwarm++;
						commander[i].boundRight=true;

					}
				}else {
					commander[i].xSwarm--;
					if (commander[i].xSwarm == 20) {
						commander[i].boundLeft=true;
						commander[i].boundRight=false;
						commander[i].ySwarm++;
					}
				}
			}
			
			for(int i=0;i<zako.length;i++) {
				if (zako[i].boundRight==false) {
					zako[i].xSwarm++;
					if (zako[i].xSwarm == Constants.BOARD_WIDTH-20) {
						zako[i].ySwarm++;
						zako[i].boundRight=true;

					}
				}else {
					zako[i].xSwarm--;
					if (zako[i].xSwarm == 20) {
						zako[i].boundLeft=true;
						zako[i].boundRight=false;
						zako[i].ySwarm++;
					}
				}
			}
			for(int i=0;i<goei.length;i++) {
				goei[i].xSwarm= goei[i].xSwarm++;
			}
			for(int i=0;i<commander.length;i++) {
				commander[i].xSwarm= commander[i].xSwarm++;
			}

			game.update(playerTorpedo);
			game.update(slowStar);
			game.update(fastStar);

			game.update(zako);
			game.update(commander);
			game.update(goei);

			//Checking all possible collisions
			
			collisionChecker.check(playerTorpedo, zako, true, true);
			collisionChecker.check(playerTorpedo, goei, true, true);
			collisionChecker.check(playerTorpedo, commander, true, true);

			
			collisionChecker.check(player, zako, true, true);
			collisionChecker.check(player, goei, true, true);
			collisionChecker.check(player, commander, true, true);

			
			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\   FPS CONTROLLER  \::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */
		
					double computingTime = System.nanoTime() - initialTime;
					long sleepFor = (long)(Constants.EXPECTED_TIME - computingTime) / 1000000;
					
					if(sleepFor < 0) {
						sleepFor = 0;
						System.out.println("Warning: FPS decrease!");
					}
					
					try {
						Thread.sleep(sleepFor);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//Displaying speed factor
					System.out.println(Constants.EXPECTED_TIME/computingTime);
				
			 /* .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.
			  :::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\::::::::.\
			  '      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      ` */
			
			
		}while (Game.isRunning());
		
//----------------------END OF THE MAIN WHILE-------------------------//

	
	}
	

	private void update(Sprite[] sprite) {
		for(Sprite spriteToUpdate : sprite) {
			if(spriteToUpdate.isVisible() && spriteToUpdate != null) {
				spriteToUpdate.update();
			}
		}
	}

	
}