package Entity.Projectile;

import Entity.Dmg;
import Entity.Mob.Enemies.JellyHater;
import system.Screen;
import graphics.Sprite;

public class SquidProjectile extends Projectile {

	public static final int FIRE_RATE = 10;

	public SquidProjectile(int xOrig, int yOrig, double angle) {
		super(xOrig, yOrig, angle);
		RoF = 30;
		dmg = new Dmg(0, 10, 0, 0, 0);
		range = random.nextInt(20) + 200;
		speed = 6;
		this.sprite = Sprite.inkBlobb;
		dx = speed * Math.cos(angle);
		dy = speed * Math.sin(angle);
		deathTimer = 180;
		size = 64;
		lethal = true;
	}

	public void update() {
		if(!dead){
			for (JellyHater j : level.NPCList) {
				if (Math.abs(j.getCenterX() - getCenterX()) < 32 && Math.abs(j.getCenterY() - getCenterY()) < 32){
					this.dead = true;
					j.dmg(dmg);
				}
			}
		}
		move();
	}

	private void move() {
		if (dead)
			deathTimer--;
		if (deathTimer <= 0)
			remove();
		if (collision(x, y, dx, dy) || dead) {
			this.sprite = Sprite.inkSplash;
			dead = true;
		} else {
			x += dx + random.nextDouble() * 4 - random.nextDouble() * 4;
			y += dy + random.nextDouble() * 4 - random.nextDouble() * 4;
		}
		if (distance() > range) {
			this.sprite = Sprite.inkSplash;
			dead = true;
		}
	}

	protected boolean collision(double x, double y, double xa, double ya) {
		boolean col = false;
		for (int corner = 0; corner < 4; corner++) {
			double xt = ((x + xa) + corner % 2+ 30);
			double yt = ((y + ya) + corner / 2 + 30);
			if (level.getTile((int) xt >> 6, (int) yt >> 6).solid())
				col = true;
		}

		return col;
	}

	public void render(Screen screen) {
		screen.renderWithMask((int) x, (int) y, sprite);
	}

}
