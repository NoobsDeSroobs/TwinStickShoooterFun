package Entity.Mob.Enemies;

import system.Screen;
import graphics.Sprite;
import Entity.Dmg;
import Entity.Health;
import Entity.Resistances;
import Entity.Mob.Mob;
import Entity.Mob.Player;

public class JellyHater extends Mob {
	int move;
	Player player;

	public JellyHater(Player player) {
		this.player = player;
	}

	public JellyHater(int x, int y, Player player) {
		size = 64;
		deathTimer = 15;
		this.player = player;
		sprite = new Sprite[5];
		this.x = x;
		this.y = y;
		sprite[0] = Sprite.greenJellyRight;
		sprite[1] = Sprite.greenJellyLeft;
		sprite[2] = Sprite.greenJellyDown;
		sprite[3] = Sprite.greenJellyUp;
		sprite[4] = Sprite.greenJellyDeath;
		health = new Health(this, 50);
		dmg = new Dmg(2, 0, 0, 0, 0);
		res = new Resistances(0, 37, 0, 0, 0);
	}

	public void AIUpdate() {
		if (!health.isAlive()) {
			if (deathTimer < 0)
				remove();
			deathTimer--;
			return;
		}

		double xa = player.x - x;
		double ya = player.y - y;
		double dir = Math.atan2(ya, xa);
		double xm = Math.cos(dir);
		double ym = Math.sin(dir);

		if (Math.abs(xm) > Math.abs(ym)) {
			if (xm > 0) {
				move = 0;
			} else if (xm < 0) {
				move = 1;
			}
		} else {
			if (ym > 0) {
				move = 2;
			} else if (ym < 0) {
				move = 3;
			}
		}
		move(xm*2, ym*2, 0);
	}

	public void dmg(Dmg dmg){
		health.dmg(dmg, res);
		if (!health.isAlive()){
			move = 4;
		}
	}
	
	public void render(Screen screen) {
		screen.renderWithMask((int) x, (int) y, sprite[move]);
		health.render(screen);
	}

	public Dmg getDmg() {
		return dmg;
	}

}
