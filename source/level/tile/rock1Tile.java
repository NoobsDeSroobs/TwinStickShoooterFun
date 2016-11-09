package level.tile;

import graphics.Sprite;
import system.Screen;

public class rock1Tile  extends Tile{

	public rock1Tile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
	
	public boolean solid(){
		return true;
	}
}
