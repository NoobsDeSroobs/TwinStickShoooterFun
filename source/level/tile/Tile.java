package level.tile;

import level.tile.Dirt.*;
import level.tile.Grass.*;
import level.tile.LargeSprites.Trees.*;
import level.tile.Stone.*;
import level.tile.Water.*;

import system.Screen;
import graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile grass1 = new Grass1Tile(Sprite.grass1);
	public static Tile grass2 = new Grass2Tile(Sprite.grass2);
	public static Tile grass3 = new Grass3Tile(Sprite.grass3);
	public static Tile grass4 = new Grass3Tile(Sprite.grass4);
	public static Tile dirt1 = new Dirt1Tile(Sprite.dirt1);
	public static Tile dirt2 = new Dirt2Tile(Sprite.dirt2);
	public static Tile dirt3 = new Dirt3Tile(Sprite.dirt3);
	public static Tile dirt4 = new Dirt3Tile(Sprite.dirt4);
	public static Tile stone1 = new Stone1Tile(Sprite.stone1);
	public static Tile stone2 = new Stone2Tile(Sprite.stone2);
	public static Tile stone3 = new Stone3Tile(Sprite.stone3);
	public static Tile stone4 = new Stone3Tile(Sprite.stone4);
	public static Tile water1 = new Water1Tile(Sprite.water1);
	public static Tile water2 = new Water2Tile(Sprite.water2);
	public static Tile water3 = new Water3Tile(Sprite.water3);
	public static Tile water4 = new Water4Tile(Sprite.water4);
	public static Tile flower1 = new flowerTile(Sprite.flower1);
	public static Tile liveTreeTile1 = new LiveTreeTile1(Sprite.liveTree1);
	public static Tile liveTreeTile2 = new LiveTreeTile2(Sprite.liveTree2);
	public static Tile liveTreeTile3 = new LiveTreeTile3(Sprite.liveTree3);
	public static Tile liveTreeTile4 = new LiveTreeTile4(Sprite.liveTree4);
	public static Tile deadTreeTile1 = new DeadTreeTile1(Sprite.deadTree1);
	public static Tile deadTreeTile2 = new DeadTreeTile2(Sprite.deadTree2);
	public static Tile deadTreeTile3 = new DeadTreeTile3(Sprite.deadTree3);
	public static Tile deadTreeTile4 = new DeadTreeTile4(Sprite.deadTree4);
	public static Tile rock1 = new rock1Tile(Sprite.rock1);
	public static Tile voidTile = new voidTile(Sprite.void1);
	
	
	//FG Tiles

	
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}

	public int speedmod() {
		return 1;
	}
}
