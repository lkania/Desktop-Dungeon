package model.fighter.enemies;

import model.board.Content;
import model.board.MoveListener;
import model.items.BloodSplash;

public class Goblin extends Enemy implements MoveListener{
	int steps=0;
	public static final double healthConst = 1;
	public static final double strenghtConst = 0.7;
	
	public Goblin (int level)
	{
		super(level,healthConst,strenghtConst);
	}

	public Content getDieContent()
	{
		return new BloodSplash();
	}

	@Override
	public void moveAbilty() {
		steps ++;
		if(steps==2 && this.isAlive()){
			this.heal(1);
			steps=0;
		}

		
	}

}
