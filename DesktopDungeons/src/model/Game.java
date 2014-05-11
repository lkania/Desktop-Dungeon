package model;

import java.awt.Point;

import model.board.Board;
import model.board.Cell;
import model.board.Move;
import model.board.MoveListener;
import model.fighter.hero.Hero;

public class Game {
	
	private Board board;
	private MoveListener[] movelisteners;

	public <T> Game(Class<T> boardClass) throws InstantiationException, IllegalAccessException {
		
		this.board = (Board)boardClass.newInstance();
		board.initialize();
		movelisteners=board.getMoveListener();
	}
	
	public void onMove(Move move) {
	
		for(MoveListener enemy: movelisteners){
			enemy.moveAbilty();
		}
		board.heroMove(move);
	}
	
	public int getBoardSize() {
		return Board.SIZE;
	}
	
	public Point getHeroPosition() {
		return board.getHeroPosition();
	}
	
	public Cell get(int x, int y) {
		return board.get(x, y);
	}
	
	
	public Hero getHero() {
		return board.getHero();
	}
	
	public boolean isOver() {
		return board.gameOver();
	}
	
	public boolean playerWon() {
		return board.playerWon();
		
	}

	public void nextLevel() {
		Board newboard = board.nextLevel();
		if(newboard!=null)
		{
			board = newboard;
			movelisteners=board.getMoveListener();
		}
	}
}