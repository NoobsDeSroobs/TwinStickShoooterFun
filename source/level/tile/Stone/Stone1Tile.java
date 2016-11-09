package level.tile.Stone;

import level.tile.Tile;
import system.Screen;
import graphics.Sprite;

public class Stone1Tile extends Tile {

	public Stone1Tile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 6, y << 6, this.sprite);
	}

}
