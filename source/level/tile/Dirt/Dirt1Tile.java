package level.tile.Dirt;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class Dirt1Tile  extends Tile{

	public Dirt1Tile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
}
