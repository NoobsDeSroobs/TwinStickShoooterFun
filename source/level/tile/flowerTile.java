package level.tile;

import graphics.Sprite;
import system.Screen;

public class flowerTile extends Tile {
	public flowerTile(Sprite sprite) {
		super(sprite);
		
	}

	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
}
