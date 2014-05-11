package model.items;

import model.board.Content;
import model.element.Valuable;
import model.fighter.Fighter;
import model.fighter.hero.Hero;

public class BonusStrength implements Valuable{

private int increment;
	
	public BonusStrength (int num){
		increment=num;
	}

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		Hero h = (Hero) hero;
		h.temporalStrenght(increment);
		return hero;
	}

	@Override
	public int getValue() {
		return increment;
	}

	

}
