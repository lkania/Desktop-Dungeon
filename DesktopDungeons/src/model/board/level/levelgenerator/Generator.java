package model.board.level.levelgenerator;

public abstract class  Generator {
	
	protected static final char EARTH=' ';
	protected static final char WALL='W';
	
	protected char[][] level;
	protected int levelH;
	protected int levelW;

	protected int countAdjacent(int x,int y,int scopeX,int scopeY,char element)
	{
		 int startX = x - scopeX;
		 int startY = y - scopeY;
		 int endX = x + scopeX;
		 int endy = y + scopeY;
		
		int counter = 0;
		
		for(int i = startX; i < endX; i++) {
			for(int j = startY; j < endy; j++)
			{
				if(!(i==x && j==y) && this.iselement(i,j,element))
				{
					counter++;
				}
			}
		}
		return counter;
	}
	
	private boolean iselement(int i,int j,char element) {
		if(i<0 || i>= levelW || j<0 || j>= levelH || level[i][j]==(element))
			return true;
			
		return false;
		}

	protected char[][] getLevel() {
		return level;
	}
		
}
