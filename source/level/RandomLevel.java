package level;

import java.util.Random;

import Entity.Mob.Player;
import Entity.Mob.Enemies.JellyHater;

public class RandomLevel extends Level {

	private static final Random random = new Random();
	
	public RandomLevel(int width, int height, Player player) {
		super(width, height, player);
	}

	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x + y * width] = random.nextInt(20);
			}
		}
		
		for (int i = 0; i < random.nextInt(5)+5; i++) {
			generateCircle(random.nextInt(100), random.nextInt(100), random.nextInt(10)+10, random.nextInt(17));
		}
		
		for (int i = 0; i < random.nextInt(5)+5; i++) {
			generateSquare(random.nextInt(100), random.nextInt(100), random.nextInt(10)+10, random.nextInt(10)+10, random.nextInt(17), random.nextInt(17));
		}
		
		for(int i = 0; i < 1; i++){
			JellyHater temp = new JellyHater(random.nextInt(100) + 300, random.nextInt(100) + 200, player);
			temp.initialize(this);
			this.NPCList.add(temp);
		}
		
		placeLargeSprite(3, 3, 2, 2, 20);
		placeLargeSprite(0, 0, 2, 2, 24);
		
		int xs = 147 / 64;
		int ys = 77 / 64;
		for (int y = ys; y < ys + 2; y++) {
			for (int x = xs; x < xs + 2; x++) {
				tiles[x + y * width] = 3;
			}
		}
	}

	//Generates a filled circle
	private void generateCircle(int xc, int yc, int r, int tile){
		for (int y = yc-r; y < yc+r; y++) {
			for (int x = xc-r; x < xc+r; x++) {
				if (Math.sqrt(Math.pow(Math.abs((x - xc)), 2)
						+ Math.pow(Math.abs((y - yc)), 2)) < r) {
					if(x + y * width >= 0 && x + y * width< tiles.length) tiles[x + y * width] = tile;
				}
			}
		}
	}
	
	//Generates a square with walls and filling.
	private void generateSquare(int xOrig, int yOrig, int xLength, int yLength, int wallTile, int fillTile){
		for (int y = yOrig; y < yOrig + yLength; y++) {
			for (int x = xOrig; x < xOrig + xLength; x++) {
				if (y == yOrig || y == yOrig + yLength - 1 || x == xOrig || x == xOrig + xLength - 1) {
					if(x + y * width >= 0 && x + y * width< tiles.length) tiles[x + y * width] = wallTile;
				}else{
					if(x + y * width >= 0 && x + y * width< tiles.length) tiles[x + y * width] = fillTile;
				}
			}
		}
	}
	
	private void placeLargeSprite(int x, int y, int xSize, int ySize, int spriteStartID){
		int nextTile = 0;
		for (int i = 0; i < ySize; i++) {
			for (int j = 0; j < xSize; j++) {
				tiles[(x+j) + (y+i) * width] = spriteStartID + nextTile++;
			}
		}
	}
	
}
