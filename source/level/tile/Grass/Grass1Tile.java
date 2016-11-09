package level.tile.Grass;

import level.tile.Tile;
import system.Screen;
import graphics.Sprite;

public class Grass1Tile extends Tile {

	public Grass1Tile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 6, y << 6, this.sprite);
	}

}
