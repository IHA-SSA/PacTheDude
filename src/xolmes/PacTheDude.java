package xolmes;

import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GCompound;
import acm.graphics.GOval;
		
public class PacTheDude {
	
	GCompound obj;
	GCompound path;
	private int curr_x;
	private int curr_y;
	private final int RADIUS = World.BLOCK_SIZE/2;
	private boolean mouth_opened = true;
	private GOval oval;
	public PacTheDude(int x, int y){
		curr_x = x;
		curr_y = y;
		obj = new GCompound();
		path = new GCompound();
		oval = new GOval(RADIUS, RADIUS);
		oval.setFilled(true); 
		oval.setColor(Color.YELLOW); 
		//obj.add(oval);
		obj.move(curr_x*World.BLOCK_SIZE + World.BLOCK_SIZE/4 + RADIUS/6, curr_y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
		GArc arc = new GArc(RADIUS, RADIUS, 45, 270);
		arc.setColor(Color.YELLOW);
		arc.setFilled(true);
		arc.setFillColor(Color.YELLOW);
		obj.add(arc);
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
		obj.removeAll();
		if(mouth_opened){
			obj.add(oval);
			mouth_opened = false;
		}
		else {
			int angle1 = 0;
			int angle2 = 0;
			//LEFT
			if(x1 > x2){
				angle1 = 180;
				angle2 = 270;
			}
			//RIGHT
			if(x1 < x2) {
				angle1 = 45;
				angle2 = 270;
			}
			//TOP
			if(y1 > y2){
				angle1 = 135;
				angle2 = 270;
			}
			//BOTT
			if(y1 < y2) {
				angle1 = 315;
				angle2 = 270;
			}
			
			GArc arc = new GArc(RADIUS, RADIUS, angle1, angle2);
			arc.setColor(Color.YELLOW);
			arc.setFilled(true);
			arc.setFillColor(Color.YELLOW);
			obj.add(arc);
			mouth_opened = true;
		}
		for(int i = 0; i < steps; i++){
			
			long time = System.currentTimeMillis();
			while (System.currentTimeMillis()-time<=20){
				
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
			//path.add(dot);
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
