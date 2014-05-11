package model.fighter.level;

public abstract class Level {

	private int level;
	private int maxHealth;
	
	public Level(int level) {
		this.level = level;
	}
	
	public void initialize() {
		this.maxHealth = this.calcMaxHealth();
	}	
	
	public int getValue() {
		return level;
	}
	
	public void levelUp() {
		this.level++;
		maxHealth=this.calcMaxHealth();
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public abstract int getStrength();
	
	public abstract int calcMaxHealth();



}
