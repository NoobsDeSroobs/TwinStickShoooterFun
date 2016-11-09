package Entity.Mob;

import java.util.ArrayList;

import graphics.Sprite;
import Entity.Entity;
import Entity.Health;
import Entity.Mob.Enemies.JellyHater;
import Entity.Projectile.Projectile;
import Entity.Projectile.SquidProjectile;

public class Mob extends Entity {
	private final int NORTH = 0;
	private final int EAST = 1;
	private final int SOUTH = 2;
	private final int WEST = 3;

	protected Sprite[] sprite;
	protected int size;
	protected int dir = 0;
	protected boolean moving = false;
	protected int agroRange;
	// protected int

	protected int spriteDir = 2;

	public ArrayList<Entity> eList = new ArrayList<>();

	protected void move(double xa, double ya, int speedMod) {
		if (xa > 0)
			dir = EAST;
		if (xa < 0)
			dir = WEST;
		if (ya > 0)
			dir = SOUTH;
		if (ya < 0)
			dir = NORTH;

		if (!collision(xa, 0)) {
			x = x + (xa);
		}
		if (!collision(0, ya)) {
			y = y + (ya);
		}
	}

	public void update() {

	}

	protected void shoot(double x, double y, double dir) {
		// dir = Math.toDegrees(dir);
		// System.out.println("Direction: " + dir);
		Projectile p = new SquidProjectile((int) x, (int) y, dir);
		eList.add(p);
		level.add(p);
	}

	private boolean collision(double xa, double ya) {
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) {
			double xt = ((x + xa) + corner % 2 * 40+12);
			double yt = ((y + ya) + corner / 2 * 22 + 18);
			if (level.getTile((int) xt >> 6, (int) yt >> 6).solid())
				solid = true;
		}
		return solid;
	}

	protected void checkNPC() {
		for (JellyHater j : level.NPCList) {
			if (Math.abs(j.x - x) < 30 && Math.abs(j.y - y) < 30)
				health.dmg(j.getDmg(), res);
		}
	}

	public void render() {

	}

	private void AIUpdate() {

	}

	public int getSize() {
		return size;
	}
	
	public int getCenterX(){
		return (int) (x + (size/2));
	}
	
	public int getCenterY(){
		return (int) (y + (size/2));
	}
}
