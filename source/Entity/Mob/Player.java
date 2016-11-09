package Entity.Mob;

import system.Game;
import system.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import Entity.Entity;
import Entity.Health;
import Entity.Resistances;
import Entity.Mob.Enemies.JellyHater;
import Entity.Projectile.SquidProjectile;
import Input.KeyboardInput;
import Input.Mouse;

public class Player extends Mob {
	private KeyboardInput input;
	double xa = 0, ya = 0;
	private int fireRate = 0;

	public Player(KeyboardInput input, Sprite player0) {
		sprite = new Sprite[5];
		this.input = input;
		this.sprite[0] = Sprite.playerLeft;
		this.sprite[1] = Sprite.playerRight;
		this.sprite[2] = Sprite.playerDown;
		this.sprite[3] = Sprite.playerUp;
		this.sprite[4] = Sprite.playerDeath;
	}

	public Player(int xPos, int yPos, KeyboardInput input) {
		size = 64;
		sprite = new Sprite[5];
		this.x = xPos;
		this.y = yPos;
		this.input = input;
		this.sprite[0] = Sprite.playerRight;
		this.sprite[1] = Sprite.playerLeft;
		this.sprite[2] = Sprite.playerDown;
		this.sprite[3] = Sprite.playerUp;
		this.sprite[4] = Sprite.playerDeath;
		health = new Health(this, 500);
		res = new Resistances();
	}

	public void update() {
		if (!health.isAlive()) {
			spriteDir = 4;
			return;
		}
		xa = 0; ya = 0;

		checkNPC();

		shooting();
		clear();

		fireRate--;

		getMoveValues();
		
		if (xa != 0 || ya != 0) {
			move(xa * 4, ya * 4, speedMod);
		}
	}

	private void clear() {
		for (int i = 0; i < eList.size(); i++) {
			Entity p = eList.get(i);
			if (p.isRemoved()) {
				eList.remove(i);
				level.eList.remove(i);
			}
		}

	}

	private void shooting() {
		if (!input.controller) {
			if (Mouse.getButton() == 1 && fireRate <= 0) {
				int dx = Mouse.getX() - (Game.width * Game.scale / 2 + 31);
				int dy = Mouse.getY() - (Game.height * Game.scale / 2 + 31);
				double dir = Math.atan2(dy, dx);
				shoot(x, y, dir);
				fireRate = SquidProjectile.FIRE_RATE;
			}
		} else {
			if (input.deltaXValue() != 0 || input.deltaYValue() != 0) {
				if (fireRate > 0)
					return;
				double dx = input.deltaXValue();
				double dy = input.deltaYValue();
				double dir = Math.atan2(dy, dx);
				shoot(x, y, dir);
				fireRate = SquidProjectile.FIRE_RATE;
			}
		}
	}

	protected void getMoveValues() {
		xa += input.getXMove();
		ya += input.getYMove();
		input.resetMoveValues();
		if (Math.abs(xa) > Math.abs(ya)) {
			if (xa > 0) {
				spriteDir = 0;
			} else if (xa < 0) {
				spriteDir = 1;
			}
		} else {
			if (ya > 0) {
				spriteDir = 2;
			} else if (ya < 0) {
				spriteDir = 3;
			}
		}
	}

	public void render(Screen screen) {
		screen.renderWithMask((int) x, (int) y, sprite[spriteDir]);
		health.render(screen);
	}
}
