import javax.swing.JFrame;

public class Snakejava extends JFrame {
	
	GameScreen game;
	
	public Snakejava() {
		setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		game = new GameScreen();
		add(game);
	}
	
	public static void main(String[] args) {
		Snakejava f = new Snakejava();
	}
}
