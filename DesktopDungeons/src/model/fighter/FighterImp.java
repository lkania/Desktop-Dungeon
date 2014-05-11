package model.fighter;

import model.fighter.level.Level;

public abstract class FighterImp implements Fighter {

	private int health;
	private Level level;
		
	public FighterImp(Level level){
		this.level=level;
		this.health=this.getMaxHealth();
	}
	
	public int getStrength()
	{
		return level.getStrength();
	}
	
	public int getMaxHealth()
	{
		return level.getMaxHealth();
	}
	
	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public boolean isAlive() {
		return this.getHealth()!=0;
	}

	@Override
	public void injured(int value) {
		health= (value>health) ? 0:health-value;
	}

	@Override
	public void heal(int value) {
		health = (health+value>this.getMaxHealth()) ? this.getMaxHealth():health+value;
	}

	@Override
	public void healFull() {
		this.health=this.getMaxHealth();
		
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getLevel() {
		return level.getValue();
	}

	protected Level getLevelObj()
	{
		return level;
	}
	

}
