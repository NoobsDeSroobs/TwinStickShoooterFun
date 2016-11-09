package Entity;

import java.util.Random;

import system.Screen;

import level.Level;

public abstract class Entity {
	public double x, y;
	protected int speedMod;
	protected boolean removed = false;
	protected Health health;
	protected boolean lethal = false;
	protected int deathTimer;
	protected final Random random = new Random();
	protected Level level;
	protected Dmg dmg;
	protected Resistances res;
	
	
	public void update() {

	}

	public void render(Screen screeen) {

	}

	public void remove() {
		//Sets removed to true so our cleaner cleans it up
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void initialize(Level level){
		this.level = level;
	}

	public void kill() {
		health.alive = false;
		lethal = false;
	}
	
	public boolean isLethal() {
		return lethal;
	}
	
}
