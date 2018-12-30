import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Data {
	
	public static BufferedImage sprite;
	
	public static Image imageHead;
	public static Image imageHead_GoLeft;
	public static Image imageHead_GoRight;
	public static Image imageHead_GoUp;
	public static Image imageHead_GoDown;
	
	public static Image imageBody;
	public static Image imageLayBug;
	
	public static Animation HeadGoUp;
	public static Animation HeadGoDown;
	public static Animation HeadGoRight;
	public static Animation HeadGoLeft;
	
	public static void loadImage() {
		try {
			sprite = ImageIO.read(new File("snake/sprite1.png"));
			
			imageHead = sprite.getSubimage(0, 0, 18, 18);
			imageBody = sprite.getSubimage(0, 18, 18, 18);
			imageLayBug = sprite.getSubimage(0, 36, 18, 18);
			imageHead_GoLeft = sprite.getSubimage(36, 0, 18, 18);
			imageHead_GoRight = sprite.getSubimage(54, 0, 18, 18);
			imageHead_GoUp = sprite.getSubimage(72, 0, 18, 18);
			imageHead_GoDown = sprite.getSubimage(18, 0, 18, 18);
		} catch (Exception e) {}
	}
	public static void loadAllAnim() {
		HeadGoUp = new Animation();
		HeadGoUp.addImage(imageHead);
		HeadGoUp.addImage(imageHead_GoUp);
		
		HeadGoDown = new Animation();
		HeadGoDown.addImage(imageHead);
		HeadGoDown.addImage(imageHead_GoDown);
		
		HeadGoRight = new Animation();
		HeadGoRight.addImage(imageHead);
		HeadGoRight.addImage(imageHead_GoRight);
		
		HeadGoLeft = new Animation();
		HeadGoLeft.addImage(imageHead);
		HeadGoLeft.addImage(imageHead_GoLeft);
	}
}
