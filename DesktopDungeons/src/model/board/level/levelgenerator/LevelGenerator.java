package model.board.level.levelgenerator;

import java.awt.Point;
import java.util.Random;



public class LevelGenerator extends Generator{

	private final char[] enemies = {'G','O','K'}; 
	private final char[] bonusses = {'A','S','P','B','H'};
	private Point heroPosition;
	private static int PROPORTIONAL=48;
	
	public LevelGenerator(int levelW,int levelH,int PercentWalls)
	{
		this.level = (new GroundGenerator(levelW,levelH,PercentWalls)).getLevel();
		this.levelW=levelW;
		this.levelH=levelH;
		this.putEI();
		this.putHero();
	}
	public Point getHeroPosition()
	{
		return heroPosition;
	}
	
	public char[][] getMap()
	{
		return level;
	}
	

	private Point randomPosition()
	{
		Random random = new Random();

		return new Point(random.nextInt(levelW-1),random.nextInt(levelH-1));
	}


	private void putContent(char element)
	{
		Point p = this.randomPosition();
		if(!this.correct(p))
		{
			this.putContent(element);
			return;
		}

			level[(int) p.getX()][(int) p.getY()] = element;
	}

	private boolean correct(Point p) {
		int count = this.countAdjacent((int)p.getX(),(int) p.getY(), 1,1,EARTH);
		if(count >=3)
			return true;

		return false;
	}

	private void putEI()
	{
		char[][] elements={bonusses,enemies};
		for(int i,j=0;j<2;j++)
		{
			i=0;
			while(i<(levelW*levelH)/PROPORTIONAL)
			{
				this.putContent(elements[j][(int) (Math.random()*elements[j].length)]);
				i++;
			}
		}
	}
	
	private void putHero()
	{
		for(int i=1;i<levelH;i++)
		{
			for(int j=1;j<levelW;j++)
			{
				Point p = new Point(i,j);
				if(this.correct(p) && noEnemy(p))
				{
					this.heroPosition=p;
					return;
				}
			}
		}
	}
	private boolean noEnemy(Point p) {
		int i= (int) p.getX(), j=(int)p.getY();
		for(int f=0;f<enemies.length;f++)
		{
			if(level[i][j]==enemies[f])
				return false;
		}
		return true;
	}

}
