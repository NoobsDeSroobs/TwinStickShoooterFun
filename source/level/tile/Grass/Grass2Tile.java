package level.tile.Grass;

import level.tile.Tile;
import system.Screen;
import graphics.Sprite;

public class Grass2Tile extends Tile{

	public Grass2Tile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}

}