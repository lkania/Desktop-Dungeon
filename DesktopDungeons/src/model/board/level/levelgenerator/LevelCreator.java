package model.board.level.levelgenerator;

import java.awt.Point;


import model.board.Content;
import model.board.level.Traslator;


public class LevelCreator extends Traslator {

	private Content[][] map;
	private int levelvalue;
	private Point heroPosition;
	
	public LevelCreator(int levelvalue,int levelW,int levelH,int percentWalls)
	{
		LevelGenerator level = new LevelGenerator(levelW,levelH,percentWalls);
		this.levelvalue=levelvalue;
		this.map = traslateMap(level.getMap());
		this.heroPosition=level.getHeroPosition();
	}
	
	public Content[][] getMap()
	{
		return map;
	}
	public Point getHeroPosition()
	{
		return heroPosition;
	}
	
	private Content[][] traslateMap(char[][] map) {
		Content[][] newmap = new Content[map.length][map[0].length];
		for(int i=0;i<map.length;i++)
		{
			for(int j=0;j<map[0].length;j++)
			{
				newmap[i][j]=traslate(map[i][j],this.levelvalue);
			}
		}
		return newmap;
	}

	protected int getLevel() {
		return (int)(Math.random()*(this.levelvalue+1)+1);
	}
		
	
	
}
