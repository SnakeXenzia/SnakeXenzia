import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Snakejava extends JFrame {
	
	GameScreen game;
	
	public Snakejava() {
		setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game = new GameScreen();
		add(game);
		
		
		this.addKeyListener(new handler());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Snakejava f = new Snakejava();
	}
	private class handler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("key is pressed");
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				GameScreen.isPlaying=!GameScreen.isPlaying;
				if(GameScreen.isGameOver) {
					GameScreen.isGameOver=false;
					game.snake.resetGame();
				}
			}
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				game.snake.setVecto(Snake.GO_UP);
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				game.snake.setVecto(Snake.GO_DOWN);
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				game.snake.setVecto(Snake.GO_LEFT);
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				game.snake.setVecto(Snake.GO_RIGHT);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
