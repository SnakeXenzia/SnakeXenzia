import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Data {
	
	
	public static Image imageHead;
	public static Image imageBody;
	public static Image imageLayBug;
	
	public static void loadImage() {
		try {
			imageHead = ImageIO.read(new File("snake/dau.png"));
			imageBody = ImageIO.read(new File("snake/than.png"));
			imageLayBug = ImageIO.read(new File("snake/moi.png"));
		} catch (Exception e) {}
	}
}
