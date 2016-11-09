package level.tile.Dirt;

import level.tile.Tile;
import system.Screen;
import graphics.Sprite;

public class Dirt2Tile extends Tile{

	public Dirt2Tile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}

}