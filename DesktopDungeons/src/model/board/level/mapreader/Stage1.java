package model.board.level.mapreader;

import java.awt.Point;



import model.board.Board;
import model.board.FileStages;
import model.board.RandomStages;
import model.fighter.hero.Hero;
import model.fighter.hero.HeroImp;

public class Stage1 extends FileStages{

	
	public Stage1(){
		super("Level1",new HeroImp(1));
	}
	
	public Stage1(Hero h){
		super("Level1",h);
	}
	
	
	
	@Override
	public Point getHeroInitPosition() {
		return new Point(0,0);
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
		Board b= new RandomStages(2,this.getHero());
		b.initialize();
		return b;
	}
	
	

}
