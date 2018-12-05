package src;

//Importing the GameBoardGUI library
import edu.uc3m.game.GameBoardGUI;



abstract public class Enemy extends Sprite{
	
	protected String[] explosion = new String[] {"explosion20", "explosion21", "explosion22", "explosion23", "explosion24"};
	Torpedo [] enemyTorpedoes;
	
	public Enemy(int id, GameBoardGUI board, String spriteImageFrame1, String spriteImageFrame2) {
		super(id, board, spriteImageFrame1, spriteImageFrame2 , Constants.enemyCoordinatesLevel1[id][0], Constants.enemyCoordinatesLevel1[id][1]);
		setVisibility(true);
		Torpedo [] enemyTorpedoes = new Torpedo[Game.BOARD_HEIGHT];
		//TO-DO MEJORAR LA COSA ESTA
	}
	

	public Enemy() {
		
	}
	
	private int torpedoArrayCounter;
	protected void shootTorpedo() {
		if(torpedoArrayCounter >= this.enemyTorpedoes.length) {
			torpedoArrayCounter=0;
		}
		
		this.enemyTorpedoes[torpedoArrayCounter].initTorpedo(this.getX(), this.getY()-5);
		torpedoArrayCounter++;
	};




}
