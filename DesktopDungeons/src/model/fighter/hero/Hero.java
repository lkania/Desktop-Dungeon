package model.fighter.hero;

import model.fighter.Fighter;

public interface Hero extends Fighter {

	public void addExperience(int value) ;
	
	public int getExperience();
	
	public int getMaxExperience();
	
	public void temporalStrenght(int value);
	
	public void stronger(int increment);

	public void resetTermporalStreght();

		
}
