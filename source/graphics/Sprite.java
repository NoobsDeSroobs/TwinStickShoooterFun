package graphics;

public class Sprite {

	private final int XSIZE;
	private final int YSIZE;
	private int x, y;
	public int [] pixels;
	private Spritesheet sheet;
	
	//Here we set all unique sprites.
	//Map Sprites
	public static Sprite grass1 = new Sprite(64, 64, 0, 0, Spritesheet.SHEET);
	public static Sprite grass2 = new Sprite(64, 64, 1, 0, Spritesheet.SHEET);
	public static Sprite grass3 = new Sprite(64, 64, 2, 0, Spritesheet.SHEET);
	public static Sprite grass4 = new Sprite(64, 64, 3, 0, Spritesheet.SHEET);
	public static Sprite stone1 = new Sprite(64, 64, 4, 0, Spritesheet.SHEET);
	public static Sprite stone2 = new Sprite(64, 64, 5, 0, Spritesheet.SHEET);
	public static Sprite stone3 = new Sprite(64, 64, 6, 0, Spritesheet.SHEET);
	public static Sprite stone4 = new Sprite(64, 64, 7, 0, Spritesheet.SHEET);
	public static Sprite dirt1 = new Sprite(64, 64, 8, 0, Spritesheet.SHEET);
	public static Sprite dirt2 = new Sprite(64, 64, 9, 0, Spritesheet.SHEET);
	public static Sprite dirt3 = new Sprite(64, 64, 10, 0, Spritesheet.SHEET);
	public static Sprite dirt4 = new Sprite(64, 64, 11, 0, Spritesheet.SHEET);
	public static Sprite water1 = new Sprite(64, 64, 12, 0, Spritesheet.SHEET);
	public static Sprite water2 = new Sprite(64, 64, 13, 0, Spritesheet.SHEET);
	public static Sprite water3 = new Sprite(64, 64, 14, 0, Spritesheet.SHEET);
	public static Sprite water4 = new Sprite(64, 64, 15, 0, Spritesheet.SHEET);
	public static Sprite flower1 = new Sprite(64, 64, 2, 2, Spritesheet.SHEET);
	public static Sprite rock1 = new Sprite(64, 64, 3, 2, Spritesheet.SHEET);
	public static Sprite bush = new Sprite(64, 64, 0, 2, Spritesheet.SHEET);
	public static Sprite berryBush = new Sprite(64, 64, 1, 2, Spritesheet.SHEET);
	public static Sprite liveTree1 = new Sprite(64, 64, 0, 7, Spritesheet.SHEET);
	public static Sprite liveTree2 = new Sprite(64, 64, 1, 7, Spritesheet.SHEET);
	public static Sprite liveTree3 = new Sprite(64, 64, 0, 8, Spritesheet.SHEET);
	public static Sprite liveTree4 = new Sprite(64, 64, 1, 8, Spritesheet.SHEET);
	public static Sprite deadTree1 = new Sprite(64, 64, 2, 7, Spritesheet.SHEET);
	public static Sprite deadTree2 = new Sprite(64, 64, 3, 7, Spritesheet.SHEET);
	public static Sprite deadTree3 = new Sprite(64, 64, 2, 8, Spritesheet.SHEET);
	public static Sprite deadTree4 = new Sprite(64, 64, 3, 8, Spritesheet.SHEET);
	public static Sprite void1 = new Sprite(64, 64, 0);
	
	
	//Foreground Sprites
	public static Sprite liveTreeFG1 = new Sprite(64, 64, 0, 9, Spritesheet.SHEET);
	public static Sprite liveTreeFG2 = new Sprite(64, 64, 1, 9, Spritesheet.SHEET);
	public static Sprite liveTreeFG3 = new Sprite(64, 64, 0, 10, Spritesheet.SHEET);
	public static Sprite liveTreeFG4 = new Sprite(64, 64, 1, 10, Spritesheet.SHEET);
	public static Sprite deadTreeFG1 = new Sprite(64, 64, 2, 9, Spritesheet.SHEET);
	public static Sprite deadTreeFG2 = new Sprite(64, 64, 3, 9, Spritesheet.SHEET);
	public static Sprite deadTreeFG3 = new Sprite(64, 64, 2, 10, Spritesheet.SHEET);
	public static Sprite deadTreeFG4 = new Sprite(64, 64, 3, 10, Spritesheet.SHEET);
	
	//Projectile Sprites
	public static Sprite inkBlobb = new Sprite(64, 64, 1, 3, Spritesheet.SHEET);
	public static Sprite inkSplash = new Sprite(64, 64, 2, 3, Spritesheet.SHEET);
	
	//NPC sprites
	public static Sprite greenJellyRight = new Sprite(64, 64, 0, 1, Spritesheet.SHEET);
	public static Sprite greenJellyLeft = new Sprite(64, 64, 1, 1, Spritesheet.SHEET);
	public static Sprite greenJellyDown = new Sprite(64, 64, 2, 1, Spritesheet.SHEET);
	public static Sprite greenJellyUp = new Sprite(64, 64, 3, 1, Spritesheet.SHEET);
	public static Sprite greenJellyDeath = new Sprite(64, 64, 4, 1, Spritesheet.SHEET);
	
	public static Sprite blueJellyRight = new Sprite(64, 64, 10, 1, Spritesheet.SHEET);
	public static Sprite blueJellyLeft = new Sprite(64, 64, 11, 1, Spritesheet.SHEET);
	public static Sprite blueJellyDown = new Sprite(64, 64, 12, 1, Spritesheet.SHEET);
	public static Sprite blueJellyUp = new Sprite(64, 64, 13, 1, Spritesheet.SHEET);
	public static Sprite blueJellyDeath = new Sprite(64, 64, 14, 1, Spritesheet.SHEET);
	
	//Player sprites
	public static Sprite playerRight = new Sprite(64, 64, 5, 1, Spritesheet.SHEET);
	public static Sprite playerLeft = new Sprite(64, 64, 6, 1, Spritesheet.SHEET);
	public static Sprite playerDown = new Sprite(64, 64, 7, 1, Spritesheet.SHEET);
	public static Sprite playerUp = new Sprite(64, 64, 8, 1, Spritesheet.SHEET);
	public static Sprite playerDeath = new Sprite(64, 64, 9, 1, Spritesheet.SHEET);
	
	public Sprite(int xSize, int ySize, int x, int y, Spritesheet sheet){
		XSIZE = xSize;	
		YSIZE = ySize;
		pixels = new int[XSIZE*YSIZE];
		this.x = x*getXSIZE();
		this.y = y*getYSIZE();
		this.sheet = sheet;
		load();
	}
	
	

	public Sprite(int xSize, int ySize, int colour) {
		XSIZE = xSize;	
		YSIZE = ySize;
		pixels = new int[XSIZE*YSIZE];
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = colour;
		}
	}



	private void load(){
		for(int y = 0; y < getYSIZE(); y++){
			for(int x = 0; x < getXSIZE(); x++){
				pixels[x+y*getYSIZE()] = sheet.pixels[(x+this.x)+(y+this.y)*sheet.getSIZE()];
			}
		}
	}

	public int getXSIZE() {
		return XSIZE;
	}
	
	public int getYSIZE() {
		return YSIZE;
	}
}
