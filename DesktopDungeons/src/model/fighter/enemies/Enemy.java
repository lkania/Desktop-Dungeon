package model.fighter.enemies;

import model.board.Content;
import model.fighter.hero.Hero;
import model.fighter.Fighter;
import model.fighter.FighterImp;
import model.fighter.level.LevelEnemy;

public abstract class Enemy extends FighterImp{
	
	
	public Enemy(int level,double healthConst, double strenghtConst)
	{
		super(new LevelEnemy(level,healthConst,strenghtConst));
	}

	public Content interact(Fighter hero)
	{
		
		hero.injured(this.getStrength());
		if(hero.isAlive()){
			this.injured(hero.getStrength());
		}
		if(this.isAlive())
			return this;
		else
		{
			((Hero) hero).addExperience(this.getLevel());
			return this.getDieContent();
		}
	}
	
	public abstract Content getDieContent();
	
}

	