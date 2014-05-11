package model.items;

import model.board.Content;
import model.element.Valuable;
import model.fighter.Fighter;
import model.fighter.hero.*;


public class Armor implements Valuable {

	private int percent;
	
	public Armor(int percent) {
		this.percent=percent;
	}
	
	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		Hero ArmoredHero = new HeroArmoredImp((Hero) hero,this.percent);
		return ArmoredHero;
	}

	@Override
	public int getValue() {
		return percent;
	}

}
