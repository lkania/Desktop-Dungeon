package model.fighter.hero;

import model.board.Content;
import model.fighter.Fighter;
import model.fighter.FighterImp;
import model.fighter.level.LevelHero;
import model.items.BloodSplash;

public class HeroImp extends FighterImp implements Hero {

	private int experience=0;
	private int temporalStrenght=0;
	
	
	public HeroImp(int level) {
		super(new LevelHero(level));
	}
	
	@Override
	public int getStrength()
	{
		return super.getStrength()+temporalStrenght;
	}
		
	@Override
	public void addExperience(int value) {
		
		if(experience+value>=this.getMaxExperience())
		{
			value=(experience+value)-this.getMaxExperience();

			this.levelUp();
			experience=0;
			
		}
		
		experience+=value;
	}

	@Override
	public int getExperience() {
		return experience;
	}

	
	@Override
	public Content interact(Fighter enemy) {
		if(this.isAlive())
		{
			enemy.injured(this.getStrength());
			return this;
		}
		else
			return new BloodSplash();
	}

	@Override
	public void temporalStrenght(int value) {
		temporalStrenght += value;
	}

	
	private void levelUp() {
		this.getLevelObj().levelUp();
		this.healFull();
	}

	public void stronger(int increment)
	{
		((LevelHero) this.getLevelObj()).stronger(increment);
	}

	@Override
	public int getMaxExperience() {
		return ((LevelHero) this.getLevelObj()).getMaxExperience();
	}

	@Override
	public void resetTermporalStreght() {
		this.temporalStrenght=0;
	}

	



	

	
	
	
	
	
	
}
