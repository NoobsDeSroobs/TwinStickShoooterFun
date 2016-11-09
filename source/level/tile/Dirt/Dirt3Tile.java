package level.tile.Dirt;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class Dirt3Tile extends Tile {
	public Dirt3Tile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
}
