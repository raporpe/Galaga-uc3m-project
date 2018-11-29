//package src;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//import edu.uc3m.game.GameBoardGUI;
//
//public class timeupdater implements KeyListener {
//	
//	
//	
//	public timeupdater(GameBoardGUI board) {
//		this.board = board;
//	}
//	
//	int rightFactor = 0;
//	int leftfactor = 0;
//	
//	board.addKeyListener(new KeyListener(){
//		
//
//		@Override
//		public void keyPressed(KeyEvent e) {
//			int key = e.getKeyCode();
//			if(key == KeyEvent.VK_0) {
//				rightFactor = 1;
//			}	
//			if(key == KeyEvent.VK_B) {
//				leftfactor = 1;
//			}				
//		}
//
//		@Override
//		public void keyReleased(KeyEvent e) {
//			int key = e.getKeyCode();
//			if(key == KeyEvent.VK_0) {
//				rightFactor = 0;
//			}	
//			if(key == KeyEvent.VK_B) {
//				leftfactor = 0;
//			}				
//		}
//
//		@Override
//		public void keyTyped(KeyEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//
//	//});
//
//}
