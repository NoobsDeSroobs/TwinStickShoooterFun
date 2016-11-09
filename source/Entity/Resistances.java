package Entity;

public class Resistances {

	private int resistanceBlunt;
	private int resistancePiercing;
	private int resistanceExplosive;
	private int resistanceFire;
	private int resistanceIce;

	private int capProcent = 70;
	
	public Resistances() {
		resistanceBlunt = 0;
		resistancePiercing = 0;
		resistanceExplosive = 0;
		resistanceFire = 0;
		resistanceIce = 0;
	}

	public Resistances(int resistanceBlunt, int resistancePiercing, int resistanceExplosive, int resistanceFire, int resistanceIce) {
		this.resistanceBlunt = resistanceBlunt;
		this.resistancePiercing = resistancePiercing;
		this.resistanceExplosive = resistanceExplosive;
		this.resistanceFire = resistanceFire;
		this.resistanceIce = resistanceIce;
	}

	public int getResistanceBlunt() {
		return resistanceBlunt;
	}

	public int getResistancePiercing() {
		return resistancePiercing;
	}

	public int getResistanceExplosive() {
		return resistanceExplosive;
	}

	public int getResistanceFire() {
		return resistanceFire;
	}

	public int getResistanceIce() {
		return resistanceIce;
	}

	public void setResistanceBlunt(int resistanceBlunt) {
		this.resistanceBlunt = resistanceBlunt;
	}

	public void setResistancePiercing(int resistancePiercing) {
		this.resistancePiercing = resistancePiercing;
	}

	public void setResistanceExplosive(int resistanceExplosive) {
		this.resistanceExplosive = resistanceExplosive;
	}

	public void setResistanceFire(int resistanceFire) {
		this.resistanceFire = resistanceFire;
	}

	public void setResistanceIce(int resistanceIce) {
		this.resistanceIce = resistanceIce;
	}

}

