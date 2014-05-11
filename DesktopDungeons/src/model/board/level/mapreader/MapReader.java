package model.board.level.mapreader;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.LinkedList;

import model.board.Content;
import model.board.level.Traslator;


public class MapReader extends Traslator{
	LinkedList<Integer> levels=new LinkedList<Integer>();
	int let,x=0,y=-1;
	FileInputStream inStream = null;
	int size;
	Content content;
	Point p;
	int lvl;
	
	public MapReader(int size,int lvl){
		this.size=size;
		this.lvl=lvl;
	}
	
	public void  openMapReader(String s) throws IOException {
		inStream = new FileInputStream(s);
		while(((char)(let=inStream.read()))!='\n' ){
			levels.push(let-'0');
		}
		x=0;
		y=-1;
	}
	
	public boolean hasFinish() throws IOException{
		let=inStream.read();
		if(((char)let)=='\n'){
			x ++;
			y=-1;
		}else{
			y++;
		}
		if (let==-1 && inStream!=null){
			inStream.close();
		}
		return let==-1;
	}
	
	public Content getContent(){
		if(x<size && y<size){
			return traslate(let,lvl);
		}
		return null;
	}
	
	protected int getLevel()
	{
		return levels.pop();
	}
	
	public Point getPoint(){
		return new Point(x,y);
	}

}
