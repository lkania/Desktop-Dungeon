package model.board;

import java.awt.Point;
import model.fighter.hero.*;

public abstract class Board {

	public static final int SIZE = 12;
	protected ContentCollection instances=new ContentCollection();
	
	protected Hero hero;
	private Cell[][] g = new Cell[SIZE][SIZE];
	private Point heroPosition;
	
	public Board (Hero h){
		this.hero=h;
	}

	public void initialize() {

		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				g[y][x] = new Cell();
			}
		}

		this.setContents();
		heroPosition = getHeroInitPosition();
		g[heroPosition.y][heroPosition.x].setContent(hero);
		cleanFog(heroPosition);
	}	

	public void heroMove(Move move) {
		if (getHero().isAlive()) {
			Point newPosition = new Point(heroPosition.x + move.getX(), heroPosition.y + move.getY());

			if (newPosition.x >= 0 && newPosition.y >= 0 && newPosition.x < SIZE && newPosition.y < SIZE) {
				if (g[newPosition.y][newPosition.x].canWalkOver()) {
					g[newPosition.y][newPosition.x].onWalk(getHero());
					g[heroPosition.y][heroPosition.x].removeContent();
					heroPosition = newPosition;
					cleanFog(heroPosition);
				} else if (g[newPosition.y][newPosition.x].canInteract()) {
					g[newPosition.y][newPosition.x].interact(getHero());
				}
			}
		}
	}

	private void cleanFog(Point p){
		for (int i = p.y-1; i <= p.y+1; i++) {
			for (int j = p.x-1; j <= p.x+1 ; j++) {
				if (i>=0 && i<SIZE && j>=0 && j<SIZE) {
					if (g[i][j].hasFog()) {
						g[i][j].removeFog();
						getHero().heal(getHero().getLevel());
					}
				}
			}
		}
	}


	public Point getHeroPosition(){
		return heroPosition;
	}

	public Cell get(int x, int y) {
		return g[y][x];
	}

	public Hero getHero() {
		return (Hero) g[heroPosition.y][heroPosition.x].getContent();
	}

	protected Cell[][] g(){
		return g;
	}

	public Board nextLevel() {
		hero.resetTermporalStreght();
		return this.next();
	}

	public abstract void setContents() ;

	public abstract Point getHeroInitPosition();

	public abstract boolean gameOver();

	public abstract boolean playerWon();

	public abstract Board next();
	
	public  MoveListener[] getMoveListener(){
		return instances.getMoveListener();
	}






}
