package model.items;

import model.board.Content;
import model.element.Valuable;
import model.fighter.Fighter;
import model.fighter.hero.Hero;
import model.fighter.hero.HeroSwordedImp;

public class Sword implements Valuable {
	int increment;
	public Sword (int num){
		increment=num;
	}

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {

		Hero swordedHero = new HeroSwordedImp((Hero) hero,increment);
		return swordedHero;
	}

	@Override
	public int getValue() {
		return increment;
	}

}
