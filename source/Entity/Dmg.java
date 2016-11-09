package Entity;

public class Dmg {

	private int dmgBlunt;
	private int dmgPiercing;
	private int dmgExplosive;
	private int dmgFire;
	private int dmgIce;

	public Dmg() {
		dmgBlunt = 0;
		dmgPiercing = 0;
		dmgExplosive = 0;
		dmgFire = 0;
		dmgIce = 0;
	}

	public Dmg(int dmgBlunt, int dmgPiercing, int dmgExplosive, int dmgFire, int dmgIce) {
		this.dmgBlunt = dmgBlunt;
		this.dmgPiercing = dmgPiercing;
		this.dmgExplosive = dmgExplosive;
		this.dmgFire = dmgFire;
		this.dmgIce = dmgIce;
	}

	public int getDmgBlunt() {
		return dmgBlunt;
	}

	public int getDmgPiercing() {
		return dmgPiercing;
	}

	public int getDmgExplosive() {
		return dmgExplosive;
	}

	public int getDmgFire() {
		return dmgFire;
	}

	public int getDmgIce() {
		return dmgIce;
	}

	public void setDmgBlunt(int dmgBlunt) {
		this.dmgBlunt = dmgBlunt;
	}

	public void setDmgPiercing(int dmgPiercing) {
		this.dmgPiercing = dmgPiercing;
	}

	public void setDmgExplosive(int dmgExplosive) {
		this.dmgExplosive = dmgExplosive;
	}

	public void setDmgFire(int dmgFire) {
		this.dmgFire = dmgFire;
	}

	public void setDmgIce(int dmgIce) {
		this.dmgIce = dmgIce;
	}

}
