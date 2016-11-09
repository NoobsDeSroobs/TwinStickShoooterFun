package level;

import graphics.Sprite;

import java.util.ArrayList;
import java.util.Random;

import Entity.Entity;
import Entity.Mob.Player;
import Entity.Mob.Enemies.JellyHater;

import level.tile.Tile;
import system.Screen;

public class Level {

	protected int width, height;
	public int[] tiles;
	private Random random;
	protected Player player;
	public ArrayList<Entity> eList = new ArrayList<>();
	public ArrayList<JellyHater> NPCList = new ArrayList<>();
	int timer = 30;

	public Level(int width, int height, Player player) {
		this.height = height;
		this.width = width;
		this.player = player;
		tiles = new int[width * height];
		random = new Random();
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public void update() {
		// AI, events in the world etc goes here
		timer--;
		timer = updateTiles(timer);

		for (Entity e : eList) {
			e.update();
		}
		for (JellyHater e : NPCList) {
			e.AIUpdate();
		}
		clear();
		if (NPCList.size() == 0) {
			for(int i = 0; i < 10; i++){
				JellyHater temp = new JellyHater(random.nextInt(100) + 300, random.nextInt(100) + 200, player);
				temp.initialize(this);
				this.NPCList.add(temp);
			}
		}
	}

	private void clear() {
		for (int i = 0; i < NPCList.size(); i++) {
			Entity p = NPCList.get(i);
			if (p.isRemoved()) {
				NPCList.remove(i);
			}
		}
//		for (int i = 0; i < eList.size(); i++) {
//			Entity p = eList.get(i);
//			if (p.isRemoved()) {
//				eList.remove(i);
//			}
//		}
	}

	private int updateTiles(int timer) {
		boolean updated = false;
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i] == 12 || tiles[i] == 13 || tiles[i] == 14
					|| tiles[i] == 15)
				if (timer < 0) {
					tiles[i] = 12 + random.nextInt(4);
					updated = true;
				}
		}
		if (updated)
			timer = 30;
		return timer;
	}

	@SuppressWarnings("unused")
	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		// cornerpins
		int x0 = xScroll >> 6;
		int x1 = (xScroll + screen.width) >> 6;
		int y0 = yScroll >> 6;
		int y1 = (yScroll + screen.height) >> 6;

		for (int y = y0; y < y1 + 1; y++) {
			for (int x = x0; x < x1 + 1; x++) {
				getTile(x, y).render(x, y, screen);

			}
		}
	}

	public void renderFG(int xScroll, int yScroll, Screen screen) {
		// cornerpins
		int x0 = xScroll >> 6;
		int x1 = (xScroll + screen.width) >> 6;
		int y0 = yScroll >> 6;
		int y1 = (yScroll + screen.height) >> 6;

		for (int y = y0; y < y1 + 1; y++) {
			for (int x = x0; x < x1 + 1; x++) {
				if (x < 0 || y < 0 || x >= width || y >= height) {

				} else {
					if (tiles[x + y * width] == 20) {
						screen.renderWithMask(x << 6, y << 6, Sprite.liveTreeFG1);
					}
					if (tiles[x + y * width] == 21) {
						screen.renderWithMask(x << 6, y << 6, Sprite.liveTreeFG2);
					}
					if (tiles[x + y * width] == 22) {
						screen.renderWithMask(x << 6, y << 6, Sprite.liveTreeFG3);
					}
					if (tiles[x + y * width] == 23) {
						screen.renderWithMask(x << 6, y << 6, Sprite.liveTreeFG4);
					}
					if (tiles[x + y * width] == 24) {
						screen.renderWithMask(x << 6, y << 6, Sprite.deadTreeFG1);
					}
					if (tiles[x + y * width] == 25) {
						screen.renderWithMask(x << 6, y << 6, Sprite.deadTreeFG2);
					}
					if (tiles[x + y * width] == 26) {
						screen.renderWithMask(x << 6, y << 6, Sprite.deadTreeFG3);
					}
					if (tiles[x + y * width] == 27) {
						screen.renderWithMask(x << 6, y << 6, Sprite.deadTreeFG4);
					}
				}
			}
		}

	}

	public void add(Entity e) {
		e.initialize(this);
		eList.add(e);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.voidTile;
		}

		if (tiles[x + y * width] == 0) {
			return Tile.grass1;
		} else if (tiles[x + y * width] == 1) {
			return Tile.grass2;
		} else if (tiles[x + y * width] == 2) {
			return Tile.grass3;
		} else if (tiles[x + y * width] == 3) {
			return Tile.grass4;
		} else if (tiles[x + y * width] == 4) {
			return Tile.stone1;
		} else if (tiles[x + y * width] == 5) {
			return Tile.stone2;
		} else if (tiles[x + y * width] == 6) {
			return Tile.stone3;
		} else if (tiles[x + y * width] == 7) {
			return Tile.stone4;
		} else if (tiles[x + y * width] == 8) {
			return Tile.dirt1;
		} else if (tiles[x + y * width] == 9) {
			return Tile.dirt2;
		} else if (tiles[x + y * width] == 10) {
			return Tile.dirt3;
		} else if (tiles[x + y * width] == 11) {
			return Tile.dirt4;
		} else if (tiles[x + y * width] == 12) {
			return Tile.water1;
		} else if (tiles[x + y * width] == 13) {
			return Tile.water2;
		} else if (tiles[x + y * width] == 14) {
			return Tile.water3;
		} else if (tiles[x + y * width] == 15) {
			return Tile.water4;
		} else if (tiles[x + y * width] == 16) {
			return Tile.flower1;
		} else if (tiles[x + y * width] == 17) {
			return Tile.rock1;
		} else if (tiles[x + y * width] == 18) {
			return Tile.dirt1;
		} else if (tiles[x + y * width] == 19) {
			return Tile.dirt1;
		} else if (tiles[x + y * width] == 20) {
			return Tile.liveTreeTile1;
		} else if (tiles[x + y * width] == 21) {
			return Tile.liveTreeTile2;
		} else if (tiles[x + y * width] == 22) {
			return Tile.liveTreeTile3;
		} else if (tiles[x + y * width] == 23) {
			return Tile.liveTreeTile4;
		} else if (tiles[x + y * width] == 24) {
			return Tile.deadTreeTile1;
		} else if (tiles[x + y * width] == 25) {
			return Tile.deadTreeTile2;
		} else if (tiles[x + y * width] == 26) {
			return Tile.deadTreeTile3;
		} else if (tiles[x + y * width] == 27) {
			return Tile.deadTreeTile4;
		} else {
			return Tile.voidTile;
		}

	}

	public void initPlayer(Player player) {
		this.player = player;
	}

	public void miscRender(Screen s) {
		for (Entity e : eList) {
			e.render(s);
		}
		for (JellyHater e : NPCList) {
			e.render(s);
		}
	}

}
