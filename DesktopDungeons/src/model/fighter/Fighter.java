package model.fighter;

import model.board.Content;

public interface Fighter extends Content {

	public boolean isAlive();
	
	public void injured(int value);
	
	public void heal(int value);
	
	public void healFull();

	public int getStrength();
	
	public int getHealth();
	
	public int getMaxHealth();
	
	public int getLevel();
	
	
}
