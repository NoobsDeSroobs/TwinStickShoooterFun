package level.tile;

import system.Screen;
import graphics.Sprite;

public class voidTile extends Tile {

	public voidTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
	
	public boolean solid(){
		return true;
	}

}
