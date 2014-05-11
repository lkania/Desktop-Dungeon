package model.board.level.levelgenerator;

import java.util.Random;

/* El GroundGenerator se basa en el Cellular Automata Method for Generating Random Cave-Like Levels, para saber mas sobre el consultar
 * http://roguebasin.roguelikedevelopment.org/index.php?title=Cellular_Automata_Method_for_Generating_Random_Cave-Like_Levels
 */


public class GroundGenerator extends Generator {

	private int PercentAreWalls;

	public GroundGenerator(int levelW,int levelH,int PercentWalls)
	{
		this.levelW=levelW;
		this.levelH=levelH;
		this.PercentAreWalls=PercentWalls;
		this.level = new char[levelH][levelW];
		this.initGround();
		for(int i=0;i<2;i++)
			this.retouchGround(i);
	}

	private void retouchGround(int inc)
	{
		for(int row=0; row < levelH; row++)
			{
			for(int column = 0; column < levelW; column++)
			{
				level[row][column] = PlaceWallLogic(row,column,inc);
			}
		}
	
		
	}
	
	private char PlaceWallLogic(int x, int y, int inc) {

		int numWalls = countAdjacent(x,y,1,1,WALL);

		if(level[x][y]==(WALL))
		{
			if( numWalls >= 5 )
			{
				return WALL;
			}
			return EARTH;   
		}

		/*Si es EARTH*/
		if(numWalls>=inc/2)
		{
			return WALL;
		}
		return EARTH;

	}
	
	private void initGround() {

		int center = 0;

		for(int row=0; row < levelH; row++)
		{
			for(int column = 0; column < levelW; column++)
			{
				center = (levelH / 2);
				if(row == center)
				{
					level[row][column] = EARTH;
				}
				else
				{
					level[row][column] = RandomPercent(PercentAreWalls);
				}
			}
		}

	}

	private char RandomPercent(int percent) {

		if(percent>=(new Random()).nextInt(100)+1)
		{
			return WALL;
		}
		return EARTH;


	}

	



}
