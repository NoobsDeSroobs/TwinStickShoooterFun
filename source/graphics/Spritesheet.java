package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Spritesheet {

	private String path;
	private final int SIZE;
	public int[] pixels;
	
	public static Spritesheet SHEET = new Spritesheet("/Spritesheet.png", 1024);
	
	public Spritesheet(String path, int size){
		this.path = path;
		this.SIZE = size;
		pixels = new int[getSIZE()*getSIZE()];
		load();
		
	}
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getSIZE() {
		return SIZE;
	}

}
