package level.tile.LargeSprites.Trees;

import level.tile.Tile;
import graphics.Sprite;
import system.Screen;

public class DeadTreeTile3  extends Tile{

	public DeadTreeTile3(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 6, y << 6, this.sprite);
	}
	
	public boolean solid(){
		return true;
	}
}
