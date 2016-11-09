package level.tile.LargeSprites.Trees;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class LiveTreeTile1  extends Tile{

	public LiveTreeTile1(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
	
	public boolean solid(){
		return false;
	}
}
