package model.items;

import model.board.Content;
import model.element.Valuable;
import model.fighter.Fighter;

public class Health implements Valuable {
	int increment;
	
	public Health(int inc){
		this.increment=inc;
	}
	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.heal(increment);
		return hero;
	}
	
	@Override
	public int getValue() {
		return increment;
	}

}
