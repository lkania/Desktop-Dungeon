package model.fighter.enemies;

import model.board.Content;
import model.items.Sword;

public class Golem extends Enemy{

	public static final double healthConst = 1.35;
	public static final double strenghtConst = 1;
	
	public Golem (int level)
	{
		super(level,healthConst,strenghtConst);
	}
	public Content getDieContent()
	{
		return new Sword(this.getLevel());
	}
	
}
