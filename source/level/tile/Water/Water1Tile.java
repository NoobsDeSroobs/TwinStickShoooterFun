package level.tile.Water;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class Water1Tile  extends Tile{

	public Water1Tile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
	
	public int speedmod(){
		return 3;
	}
}
