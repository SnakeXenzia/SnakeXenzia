import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Snakejava extends JFrame {
	
	GameScreen game;
	
	public static ArrayList<User> users;
	
	public Snakejava() {
		setSize(750,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		users = new ArrayList<>();
		ReadData();
		game = new GameScreen();
		add(game);
		
		
		this.addKeyListener(new handler());
		
		this.addWindowListener(new WindowAdapter() {
			public void  windowClosing(WindowEvent e) {
				UpdateData();
			}
			
		});
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
	public static void UpdateData() {
		FileWriter fw;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("data/data.txt");
			bw = new BufferedWriter(fw);
			
			for (User u: users) {
				bw.write(u.getName()+" "+u.getLevel());
				bw.newLine();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void ReadData() {
		try {
			FileReader fr = new FileReader("data/data.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				String[] str = line.split(" ");
				users.add(new User(str[0], str[1]));
			}
			
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
