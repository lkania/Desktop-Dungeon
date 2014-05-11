package model.fighter.enemies;

import model.board.Content;
import model.items.BloodSplash;

public class Snake extends Enemy{

	public static final double healthConst = 1;
	public static final double strenghtConst = 1;
	
	public Snake (int level)
	{
		super(level,healthConst,strenghtConst);
	}

	public Content getDieContent()
	{
		return new BloodSplash();
	}
	
	
	
	
	
}
