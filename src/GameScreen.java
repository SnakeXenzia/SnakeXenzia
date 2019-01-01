

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable {
	
	static int [][] bg = new int [20][20];
	
	Snake snake;
	
	Thread thread;
	public GameScreen() {
		snake = new Snake();
		Data.loadImage();
		bg[10][10]=2;

		thread = new Thread(this);
		thread.start();
	
	}
	public void run() {
		while(true) {
			snake.update();
			repaint();
			try {
				sleep(20);
			} catch (InterruptedException ex) {}
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

