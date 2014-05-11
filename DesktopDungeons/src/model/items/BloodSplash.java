package model.items;

import model.board.Content;
import model.fighter.Fighter;

public class BloodSplash implements Content {

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		return hero;
	}

}
