package model.board;

import java.awt.Point;
import java.io.IOException;

import model.board.level.mapreader.MapReader;
import model.fighter.hero.Hero;

public abstract class FileStages extends Board {
	String s;
	
	
	public FileStages(String s,Hero h){
		super(h);
		this.s=s;
	}
	
	public void setContents() {
		initializeContent(s);
		
	}
	
	 public void initializeContent(String s) { 
	        MapReader reader= new MapReader(SIZE,hero.getLevel()); 
	        Content cont;
	        try { 
	            reader.openMapReader(s); 
	  
	            while(!reader.hasFinish()){ 
	                if((cont=reader.getContent())!=null){
	                	this.get(reader.getPoint().x,reader.getPoint().y).setContent(cont);
	                	instances.put(cont);

	                } 
	  
	            } 
	        } catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	  } 

	
	@Override
	public abstract Point getHeroInitPosition();

	@Override
	public abstract boolean gameOver();

	@Override
	public abstract boolean playerWon();

	@Override
	public abstract  Board next();

}
