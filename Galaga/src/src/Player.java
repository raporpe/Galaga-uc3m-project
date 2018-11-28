package src;

import java.awt.event.KeyEvent;

import edu.uc3m.game.GameBoardGUI;

public class Player {
	
	private int x = (int)(Game.BOARD_WIDTH/2);
	private final int Y = (Game.BOARD_HEIGHT-20);
	private int id= 1;
	
	private int lives;
	private int maxLives = 3;
	private int score;
	private String name = "NO_NAME";
	
	private int rightBullets;
	private int shoots;
	private int speed;
	private int level = 1;
	
	private GameBoardGUI board;


		
	//Constructor
	public Player (String name, int maxLives, GameBoardGUI b) {
		
		if(maxLives > 0) {
			this.maxLives = maxLives;
		}
		this.name = name;

		this.lives = this.maxLives;
		this.board=b;
		//Creating player in board
		this.board.gb_addSprite(1, "player.png", true);
		this.board.gb_moveSpriteCoord(1, this.x, this.Y);
		this.board.gb_setSpriteVisible(1, true);
		
		//Generating text
		
		this.board.gb_setValueHealthCurrent(this.lives);
		this.board.gb_setValueHealthMax(this.maxLives);
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
	
	
	//Public setters and getters
	
	public int getX() {
		return x;
	}
	public int getY() {
		return Y;
	}
	public int getId() {
		return id;
	}

	
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
	
	
	//Testing
	
	//Testing

	public void keyTyped(KeyEvent e) {		
		int test = e.getKeyCode();
		if(test == KeyEvent.VK_0) {
			moveRight(1);
		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
