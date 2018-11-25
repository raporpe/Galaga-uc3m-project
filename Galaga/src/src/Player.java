package src;

public class Player {
	
	private int X = (int)(Game.width/2);
	private final int Y = (Game.height-20);
	private int id= 1;
	
	private int lives;
	private int maxLives = 3;
	private int score;
	private String name = "NO_NAME";
	
	private int rightBullets;
	private int shoots;
	private int speed;
	
	
	

		
	//Constructor
	public Player (String name, int maxLives) {
		
		if(maxLives > 0) {
			this.maxLives = maxLives;
		}
		this.name = name;

		this.lives = this.maxLives;
		
		//Creating player in board
		Game.board.gb_addSprite(1, "player.png", true);
		Game.board.gb_moveSpriteCoord(1, this.X, this.Y);
		Game.board.gb_setSpriteVisible(1, true);
		
		//Generating text
		
		Game.board.gb_setValueHealthCurrent(this.lives);
		Game.board.gb_setValueHealthMax(this.maxLives);
		Game.board.gb_setTextPlayerName(this.name);
		Game.board.gb_setTextLevel("Level");
		
		Game.board.gb_setTextAbility1("Shootings");
		Game.board.gb_setTextAbility2("Right Bullets");
		Game.board.gb_setValueAbility1(this.shoots);
		Game.board.gb_setValueAbility2(this.rightBullets);
		
		Game.board.gb_setPortraitPlayer("galago.jpeg");
		Game.board.gb_setTextPointsUp("Score");
		Game.board.gb_setTextPointsDown("Speed");
		Game.board.gb_setValuePointsDown(this.speed);
		//TODO: Invent another value different to speed

		

		

	}
	
	
	//Public setters and getters
	
	public int getX() {
		return X;
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
		Game.board.gb_setTextPlayerName(this.name);
	}
	
	
	

	
		
	//Movements
	public void moveRight() {
		if(this.X < Game.width-5) {
			this.X = this.X + 1;
		}
	}
	
	public void moveLeft() {
		if(this.X > 6) {
			this.X = this.X - 1;
		}
	}
	
	public void torpedo() {

	}
	
	public void loseLife() {
		this.lives = this.lives-1;
		if(this.lives == 0) {
			Stats.playing = false;
		}
	}
	
	public void increaseScore(int plusScore) {
		if(plusScore > 0) {
			this.score = this.score + plusScore;	
		}
		Game.board.gb_setValuePointsUp(this.score);
	}
	
	

	
}
