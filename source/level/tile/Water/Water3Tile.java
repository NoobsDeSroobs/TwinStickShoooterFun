package level.tile.Water;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class Water3Tile extends Tile {
	public Water3Tile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
}
