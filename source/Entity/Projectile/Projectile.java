package Entity.Projectile;

import graphics.Sprite;
import Entity.Dmg;
import Entity.Entity;

public class Projectile extends Entity {

	protected final int xOrig, yOrig;
	protected double angle, distance;
	protected Sprite sprite;
	protected double dx, dy;
	protected boolean dead = false;

	protected double RoF, speed, range;
	protected int size;

	protected Projectile(int x, int y, double angle) {
		super();
		this.xOrig = x;
		this.yOrig = y;
		this.angle = angle;

		this.x = x;
		this.y = y;
	}

	protected double distance() {
		double a = x - xOrig;
		double b = y - yOrig;
		double distance = Math.sqrt(Math.abs(a * a + b * b));

		return distance;
	}

	private void move() {
		if (collision(x, y, dx, dy)) {
			this.sprite = Sprite.inkSplash;
			remove();
		}
		if (dead)
			deathTimer--;
		if (deathTimer >= 0)
			removed = true;
		x += dx;
		y += dy;

		if (distance() > range)
			remove();
	}

	protected boolean collision(double x, double y, double xa, double ya) {
		boolean col = false;
		for (int corner = 0; corner < 4; corner++) {
			double xt = ((x + xa) + corner % 2 * 14);
			double yt = ((y + ya) + corner / 2 * 7 + 6);
			if (level.getTile((int) xt >> 6, (int) yt >> 6).solid())
				col = true;
		}

		return col;
	}

	public int getCenterX() {
		return (int) (x + (size / 2));
	}

	public int getCenterY() {
		return (int) (y + (size / 2));
	}
}
