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
	
	static int CurrentLevel = 1;
	static int diem = 0;
	
	static boolean isGameOver = false;
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
		g.fillRect(0, 0, WIDTH+padding*2+280, HEIGHT+padding*2);
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
	
		g.drawRect(0, 0, WIDTH+padding*2+280, HEIGHT+padding*2);
		g.drawRect(1, 1, WIDTH+padding*2-2+280, HEIGHT+padding*2-2);
		g.drawRect(2, 2, WIDTH+padding*2-4+280, HEIGHT+padding*2-4);
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
		if(isGameOver) {
				g.setColor(Color.LIGHT_GRAY);
				g.setFont(g.getFont().deriveFont(28.0f));
				g.drawString("GAME OVER", 150, 300);
			}
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(g.getFont().deriveFont(28.0f));
		g.drawString("LEVEL: "+CurrentLevel, 450, 100);	
		
		g.setFont(g.getFont().deriveFont(20.0f));
		g.drawString("Diem: "+diem, 450, 150);
		
		for (int i = 0; i < Snakejava.users.size(); i++) {
			g.drawString(Snakejava.users.get(i).toString(), 450, i*30 + 200);
		}
	}
		
	}


