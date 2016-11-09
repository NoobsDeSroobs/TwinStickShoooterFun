package Entity;

import java.awt.Color;

import graphics.Sprite;
import system.Screen;
import Entity.Mob.Mob;
import Entity.Mob.Player;

public class Health {

	double x, y;
	Sprite barSprite;
	double maxHealth, currentHealth;
	int regen;
	double healthPerPixel;
	int colour = 0xFF05b6f6;
	boolean alive = true;
	boolean invulnerable = false;
	Mob mob;
	int dmgColour = 0x840c24;

	public Health(Mob m, int health) {
		mob = m;
		this.maxHealth = health;
		this.currentHealth = health;
		this.x = m.x;
		this.y = m.y;
		healthPerPixel = maxHealth / m.getSize();
		barSprite = new Sprite(m.getSize(), 7, colour);
	}

	public void render(Screen screen) {
		screen.renderSquare((int) mob.x, (int) mob.y - barSprite.getYSIZE() + 5, false, barSprite);
	}

	public boolean isAlive() {
		return alive;
	}

	public void dmg(Dmg dmg, Resistances res) {
		if (!invulnerable && alive) {
			int total = 0;
			int dmgBlunt = (dmg.getDmgBlunt() * (100-res.getResistanceBlunt()))/100;
			int dmgPiercing = (dmg.getDmgPiercing() * (100-res.getResistancePiercing()))/100;
			int dmgExplosive = (dmg.getDmgExplosive() * (100-res.getResistanceExplosive()))/100;
			int dmgFire = (dmg.getDmgFire() * (100-res.getResistanceFire()))/100;
			int dmgIce = (dmg.getDmgIce() * (100-res.getResistanceIce()))/100;
			
			
			total = dmgBlunt + dmgPiercing + dmgExplosive + dmgFire + dmgIce;
			currentHealth -= total;
			if (currentHealth <= 0)
				alive = false;

			int xPixels = (int) (currentHealth / healthPerPixel) - 1;
			for (int y = 0; y < barSprite.getYSIZE(); y++) {
				for (int x = 0; x < barSprite.getXSIZE(); x++) {
					if (x > xPixels) {
						barSprite.pixels[x+y*64] = dmgColour;
					}
				}
			}
		}
	}
}
