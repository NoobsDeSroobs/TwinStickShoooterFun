package level.tile.Grass;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class Grass4Tile extends Tile {

	public Grass4Tile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 6, y << 6, this.sprite);
	}

}
