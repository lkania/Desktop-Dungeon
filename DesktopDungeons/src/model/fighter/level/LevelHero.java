package model.fighter.level;

public class LevelHero extends Level {

	private int strenght=0;
	
	public LevelHero(int level)
	{
		super(level);
		this.initialize();
		strenght+=5*this.getValue();
	}
	
	public int getMaxExperience()
	{
		return 5*this.getValue();		
	}

	@Override
	public int calcMaxHealth() {
		return 10*this.getValue();
	}

	public void stronger(int value)
	{
		strenght+=value;
	}

	@Override
	public int getStrength() {
		return strenght;
	}
	
	public void levelUp()
	{
		super.levelUp();
		this.stronger(5);
	}
	
	
}
