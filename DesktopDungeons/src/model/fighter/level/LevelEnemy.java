package model.fighter.level;

public class LevelEnemy extends Level{
	
	private final double Strenghtconst;
	private final double Healthconst;
	
	public LevelEnemy (int level,double Strenghtconst,double Healthconst)
	{
		super(level);
		this.Strenghtconst=Strenghtconst;
		this.Healthconst=Healthconst;
		this.initialize();
	}
	
	
	@Override
	public int getStrength() {
		return (int) Math.floor((((Math.pow(this.getValue(), 2)+5*this.getValue())*0.5*Strenghtconst)));
	}

	@Override
	public int calcMaxHealth() {
		return (int) Math.floor((((Math.pow(this.getValue()+3, 2)-10)*Healthconst)));
	}




	
	
	
}
