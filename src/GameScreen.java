

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable {
	
	static int [][] bg = new int [20][20];
	
	static int padding = 10;
	static int WIDTH = 400;
	static int HEIGHT = 400;
	
	static boolean isPlaying = false;
	static boolean enableTextStartGame = true;
	
	Snake snake;
	
	Thread thread;
	public GameScreen() {
		snake = new Snake();
		Data.loadImage();
		Data.loadAllAnim();
		bg[10][10]=2;

		thread = new Thread(this);
		thread.start();
	
	}
	public void run() {
		long t2 = 0;
		while(true) {

			if(System.currentTimeMillis()-t2>500) {
				enableTextStartGame=!enableTextStartGame;
				t2 = System.currentTimeMillis();
			}
			if(isPlaying) {
				snake.update();
			}
			
			repaint();
			try {
				sleep(20);
			} catch (InterruptedException ex) {}
		}
	}
	public void paintBg( Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH+padding*2, HEIGHT+padding*2);
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++) {
				//g.fillRect(i*20 + 1, j*20 + 1, 18, 18);
				if(bg [i][j]==2) {
				g.drawImage(Data.imageLayBug, i*20+1+padding, j*20+1+padding, null);
			}
		}

	}
	private void veKhung(Graphics g) {
		g.setColor(Color.orange);
		g.drawRect(0, 0, WIDTH+padding*2, HEIGHT+padding*2);
		g.drawRect(1, 1, WIDTH+padding*2-2, HEIGHT+padding*2-2);
		g.drawRect(2, 2, WIDTH+padding*2-4, HEIGHT+padding*2-4);
	}
	public void paint(Graphics g) {
		paintBg(g);
		snake.veSnake(g);
		veKhung(g);
		
		if(!isPlaying) {
			if(enableTextStartGame) {
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(g.getFont().deriveFont(18.0f));
				g.drawString("PRESS SPACE TO PLAY GAME", 60, 200);
			}
		
		}
	}
	public void paintBg( Graphics g) {
		g.setColor(Color.gray);
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++) {
				g.fillRect(i*20 + 1, j*20 + 1, 18, 18);
			if(bg [i][j]==2) {
				g.setColor(Color.red);
				g.fillRect(i*20 + 1, j*20 + 1, 18, 18);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 400, 400);
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++) {
				//g.fillRect(i*20 + 1, j*20 + 1, 18, 18);
			if(bg [i][j]==2) {
				g.drawImage(Data.imageLayBug, i*20+1, j*20+1, null);
			}
			}

	}
	public void paint(Graphics g) {
		paintBg(g);
		snake.veSnake(g);
	}
}

