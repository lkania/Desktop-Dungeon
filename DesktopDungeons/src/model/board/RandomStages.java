package model.board;

import java.awt.Point;

import model.board.level.levelgenerator.LevelCreator;
import model.fighter.hero.Hero;
import model.fighter.hero.HeroImp;

public class RandomStages extends Board {
	private LevelCreator level;
	private int lvl;
	
	
	public RandomStages(int n,Hero hero){ 
		super(hero);
		lvl=n;
		level=new LevelCreator(n,SIZE,SIZE,15);
	}
	
	public RandomStages(){ 
		super(new HeroImp(1));
		lvl=1;
		level=new LevelCreator(lvl,SIZE,SIZE,15);
	}
	
	
	@Override
	public void setContents() {
		Content [][] cont=level.getMap();

		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				this.get(x,y).setContent(cont[x][y]);
				instances.put(cont[x][y]);
				
			}
		}

	}

	@Override
	public Point getHeroInitPosition() {
		
		return level.getHeroPosition();
	}

	@Override
	public boolean gameOver() {
		return !this.getHero().isAlive() || this.playerWon();
		
	}

	@Override
	public boolean playerWon() {
		
		return instances.verifyEnemiesDead();
	}

	@Override
	public Board next() {
		Board b= new RandomStages(lvl+1,this.getHero());
		b.initialize();
		return b;
	}

}
