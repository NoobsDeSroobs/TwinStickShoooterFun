package level.tile.Dirt;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class Dirt4Tile extends Tile {

	public Dirt4Tile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 6, y << 6, this.sprite);
	}

}
