package src;

import edu.uc3m.game.GameBoardGUI;

public class Player extends Sprite{
		
	private final int MAX_LIVES = 3;
	private int lives = MAX_LIVES;
	private int score;
	private String name = "NO_NAME";
	
	private int rightBullets;
	private int shoots;
	private int speed;
	private int level = 1;
	
	Torpedo[] torpedo;
	private int torpedoIndex;
	

		
	//Constructor
	public Player (GameBoardGUI board, String name, Torpedo[] playerTorpedoes) {
		super(board);
		setName(name);
		initializeStats();
		this.torpedo = playerTorpedoes;

	}
	
	
	//Public setters and getters
		
	public void setName(String name) {
		this.name = name;
		this.board.gb_setTextPlayerName(this.name);
	}
	
		
	//Moving
	public void moveRight(int quantity) {
		if(this.x < Constants.BOARD_WIDTH-5) {
			this.x = this.x + quantity;
			board.gb_moveSpriteCoord(this.id, this.x, this.y);
		}
	}
	
	public void moveLeft(int quantity) {
		if(this.x > 6) {
			this.x = this.x - quantity;
			board.gb_moveSpriteCoord(this.id, this.x, this.y);
		}
	}
	
	
	public void loseLive() {
		this.lives = this.lives-1;
		if(this.getLifes() == 0) {
			Game.stopGame();
		}
	}
	
	public void increaseScore(int plusScore) {
		if(plusScore > 0) {
			this.score = this.score + plusScore;	
		}
		this.board.gb_setValuePointsUp(this.score);
	}
	
	
	
	public void nextLevel() {
		this.level++;
		this.board.gb_setValueLevel(this.level);
	}
	
	
	//Torpedo shooting
	public void shootTorpedo() {
		if(torpedoIndex >= torpedo.length) {
			torpedoIndex = 0;
		}
		this.torpedo[torpedoIndex].initTorpedo(this.x, this.y - Constants.PLAYER_TORPEDOES_OFFSET);
		torpedoIndex++;
	}
	
	@Override
	public void death() {
		setVisibility(false);
		loseLive();
	}
	
	
	protected void update() {
		
	}
	
	
	public void initializeStats() {
		
		//Generating text
		this.board.gb_setValueHealthCurrent(this.lives);
		this.board.gb_setValueHealthMax(this.MAX_LIVES);
		this.board.gb_setTextPlayerName(this.name);
		this.board.gb_setTextLevel("Level");
		
		this.board.gb_setTextAbility1("Shootings");
		this.board.gb_setTextAbility2("Right Bullets");
		this.board.gb_setValueAbility1(this.shoots);
		this.board.gb_setValueAbility2(this.rightBullets);
		
		this.board.gb_setPortraitPlayer("portrait.png");
		this.board.gb_setTextPointsUp("Score");
		this.board.gb_setTextPointsDown("Speed");
		this.board.gb_setValuePointsDown(this.speed);
		//TODO: Invent another value different to speed
		
		this.board.gb_setValueLevel(this.level);

		
	}

	
}
