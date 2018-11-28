package src;

import java.awt.event.KeyEvent;

import edu.uc3m.game.GameBoardGUI;

public class Player extends Sprite{
	
//	private int x = (int)(Game.BOARD_WIDTH/2);
//	private final int Y = (Game.BOARD_HEIGHT-20);
	
	private final int MAX_LIVES = 3;
	private int lives = 3;
	private int score;
	private String name = "NO_NAME";
	
	private int rightBullets;
	private int shoots;
	private int speed;
	private int level = 1;
	

		
	//Constructor
	public Player (String name, GameBoardGUI board) {
		super(0, board, "player.png", (int)(Game.BOARD_WIDTH/2), (Game.BOARD_HEIGHT-20));
		
		this.name = name;

		//Creating player in board
		setVisibility(true);
		initializeStats();

	}
	
	
	//Public setters and getters
		
	public int getLives() {
		return this.lives;
	}
	
	public void setName(String name) {
		this.name = name;
		this.board.gb_setTextPlayerName(this.name);
	}
	
	public int getLevel() {
		return this.level;
	}
	
		
	//Functions
	public void moveRight(int quantity) {
		if(this.x < Game.BOARD_WIDTH-5) {
			this.x = this.x + quantity;
		}
	}
	
	public void moveLeft(int quantity) {
		if(this.x > 6) {
			this.x = this.x - quantity;
		}
	}
	
	
	public void loseLife() {
		this.lives = this.lives-1;
		if(this.lives == 0) {
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
