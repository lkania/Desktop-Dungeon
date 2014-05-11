package model.items;

import model.board.Content;
import model.fighter.Fighter;

public class Potion implements Content {
	int increment;
	

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.healFull();
		return hero;
	}

}
