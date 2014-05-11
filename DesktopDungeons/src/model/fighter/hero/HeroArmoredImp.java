package model.fighter.hero;

import model.board.Content;
import model.fighter.Fighter;

public class HeroArmoredImp implements Hero{

	private Hero hero;
	private int percent;
	
	public HeroArmoredImp(Hero hero,int percent)
	{
		this.hero=hero;
		this.percent=percent;
	}
	
	@Override
	public boolean isAlive() {
		return hero.isAlive();
	}

	@Override
	public void injured(int value) {
		hero.injured((int)(value*(1-(double) percent*10/100)));
	}

	@Override
	public void heal(int value) {
		hero.heal(value);
	}

	@Override
	public void healFull() {
		hero.healFull();
	}

	@Override
	public int getStrength() {
		return hero.getStrength();
	}

	@Override
	public int getHealth() {
		return hero.getHealth();
	}

	@Override
	public int getMaxHealth() {
		return hero.getMaxHealth();
	}

	@Override
	public int getLevel() {
		return hero.getLevel();
	}

	@Override
	public boolean canWalkOver() {
		return hero.canWalkOver();
	}

	@Override
	public Content interact(Fighter fighter) {
		hero.interact(fighter);
		return this;
	}

	@Override
	public void addExperience(int value) {
		hero.addExperience(value);
	}

	@Override
	public int getExperience() {
		return hero.getExperience();
	}

	@Override
	public int getMaxExperience() {
		return hero.getMaxExperience();
	}

	@Override
	public void temporalStrenght(int value) {
		hero.temporalStrenght(value);
	}

	@Override
	public void stronger(int increment) {
		hero.stronger(increment);
	}

	@Override
	public void resetTermporalStreght() {
		hero.resetTermporalStreght();
	}

	
}
