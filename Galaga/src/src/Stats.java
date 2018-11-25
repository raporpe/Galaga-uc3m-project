package src;

public class Stats {

	public static boolean playing = true;
	
	public static int level = 1;
	
	
	
	public void nextLevel() {
		Stats.level++;
		Game.board.gb_setValueLevel(Stats.level);
	}
	

	
	public Stats() {
		Game.board.gb_setValueLevel(Stats.level);
	}
	
	 
	
	
	
}
