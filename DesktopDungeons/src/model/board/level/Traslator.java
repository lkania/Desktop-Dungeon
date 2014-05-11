package model.board.level;

import java.util.Random;

import model.board.Content;
import model.fighter.enemies.*;
import model.items.*;

public abstract class Traslator {
	
	protected Content traslate(int e,int levelvalue) {
		switch (e) {
		case 'G':  return new Goblin(getLevel());
		case 'W':	return new Wall();
		case 'O':  return new Golem(getLevel());
		case 'K':  return new Snake(getLevel());
		case 'S':  return new Sword(getLevel());
		case 'P':  return new Potion();
		case 'A':  return new Armor(((new Random().nextInt(9))%levelvalue)+1);
		case 'H':  return new Health(getLevel());
		case 'B':	return new BonusStrength(getLevel());
		default: 	return null;
		}
	}
	
	protected abstract int getLevel();
	
	
	
	
	
	
}
