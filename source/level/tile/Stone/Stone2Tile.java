package level.tile.Stone;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class Stone2Tile extends Tile {

	public Stone2Tile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 6, y << 6, this.sprite);
	}

}
