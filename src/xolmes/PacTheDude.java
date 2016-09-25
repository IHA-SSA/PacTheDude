package xolmes;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GOval;
		
public class PacTheDude {
	
	GCompound obj;
	GCompound path;
	private int curr_x;
	private int curr_y;
	private final int RADIUS = World.BLOCK_SIZE/3 - World.BLOCK_SIZE/10;
	
	public PacTheDude(int x, int y){
		curr_x = x;
		curr_y = y;
		obj = new GCompound();
		path = new GCompound();
		GOval oval = new GOval(RADIUS, RADIUS);
		oval.setFilled(true); 
		oval.setColor(Color.ORANGE); 
		obj.add(oval);
		obj.move(curr_x*World.BLOCK_SIZE + World.BLOCK_SIZE/3 + RADIUS/4, curr_y*World.BLOCK_SIZE + World.BLOCK_SIZE/3+RADIUS/4);
	}
	
	public GCompound getPac(){
		return obj;
	}
	
	public GCompound getPath(){
		return path;
	}
	
	public void move(int x, int y){
		animate(curr_x, curr_y,x,y,10);
		curr_x = x;
		curr_y = y;
	}
	
	private void animate(int x1, int y1, int x2, int y2, int steps){
		
		double delta_x = (double)(x2 - x1)/steps;
		double delta_y = (double)(y2 - y1)/steps;
		GOval dot = new GOval(x1*World.BLOCK_SIZE+World.BLOCK_SIZE/2,y1*World.BLOCK_SIZE+World.BLOCK_SIZE/2,World.BLOCK_SIZE/15, World.BLOCK_SIZE/15);

		for(int i = 0; i < steps; i++){
			
			long time = System.currentTimeMillis();
			while (System.currentTimeMillis()-time<=40){
				
			}
			obj.move(delta_x*World.BLOCK_SIZE, delta_y*World.BLOCK_SIZE);
			
			dot = new GOval(x1*World.BLOCK_SIZE+World.BLOCK_SIZE/2 + (double)delta_x*i*World.BLOCK_SIZE-World.BLOCK_SIZE/30,y1*World.BLOCK_SIZE+World.BLOCK_SIZE/2+ (double)delta_y*i*World.BLOCK_SIZE - World.BLOCK_SIZE/30,World.BLOCK_SIZE/15, World.BLOCK_SIZE/15);
			dot.setColor(Color.GREEN);
			dot.setFilled(true);
			dot.setFillColor(Color.GREEN);
			if(i == 0){
				dot.setColor(Color.red);
				dot.setFillColor(Color.red);
			}
			path.add(dot);
			obj.sendForward();
		}
	}
	
	public int getX(){
		return curr_x;
	}
	
	public int getY(){
		return curr_y;
	}
}
