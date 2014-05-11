package model.board;

import java.util.ArrayList;
import model.fighter.Fighter;
import model.board.MoveListener;

public class ContentCollection {
	ArrayList<Fighter> enemies= new ArrayList<Fighter>();
	ArrayList<Content> content=new ArrayList<Content>();
	
	public void put(Content cont){
		if(cont instanceof Fighter){
			enemies.add((Fighter)cont);
		}else{
			content.add(cont);
		}
	}

	public boolean verifyEnemiesDead(){
		

		for(Fighter f:enemies){
			if(f.isAlive())
				return false;
		}


		return true;
	}

	public MoveListener[] getMoveListener(){
		MoveListener[] returnarray;
		ArrayList<MoveListener> a=new ArrayList<MoveListener>();
		this.getEnemyMoveListener(a);
		this.getContMoveListener(a);
		
		returnarray=new MoveListener[a.size()];
		return a.toArray(returnarray);
	}
	
	private void getEnemyMoveListener(ArrayList<MoveListener> a){
		for(Fighter c:enemies){
			if(c instanceof MoveListener)
			{
				a.add((MoveListener)c);
			}
		}
	}
		
	private void getContMoveListener(ArrayList<MoveListener> a){
		for(Content c:content){
			if(c instanceof MoveListener)
			{
				a.add((MoveListener)c);
			}
		}
	}


}
