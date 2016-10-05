package xolmes;

import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GCompound;
import acm.graphics.GOval;

public class Checker {

	private GCompound obj;
	private int curr_x;
	private int curr_y;
	private GCompound path;
	private Color checker_color = Color.GRAY;
	
	
	public static final int RADIUS = 30;
	
	public Checker(int x, int y){
		obj = new GCompound();
		GOval oval = new GOval(RADIUS, RADIUS);
		oval.setFilled(true);
		oval.setFillColor(checker_color);
		curr_x = x;
		curr_y = y;
		obj.add(oval);
		obj.move(curr_x*World_checkers.BLOCK_SIZE + World_checkers.BLOCK_SIZE/4 + RADIUS/6, curr_y*World_checkers.BLOCK_SIZE + World_checkers.BLOCK_SIZE/3);
		
	}
	
	public Checker(){
	
	}
	
	public GCompound getGChecker(){
		return obj;
	}
	
	public void move(int x, int y){
		System.out.println(curr_x + " " + curr_y + " -> " + x + " " + y);
		animate(curr_x, curr_y,x,y,10);
		curr_x = x;
		curr_y = y;
	}
	
	private void animate(int x1, int y1, int x2, int y2, int steps){
		
		double delta_x = (double)(x2 - x1)/steps;
		double delta_y = (double)(y2 - y1)/steps;
		GOval dot = new GOval(x1*World_checkers.BLOCK_SIZE+World_checkers.BLOCK_SIZE/2,y1*World_checkers.BLOCK_SIZE+World_checkers.BLOCK_SIZE/2,World_checkers.BLOCK_SIZE/15, World_checkers.BLOCK_SIZE/15);
		
		for(int i = 0; i < steps; i++){
			
			long time = System.currentTimeMillis();
			while (System.currentTimeMillis()-time<=40){
				
			}
			obj.move(delta_x*World_checkers.BLOCK_SIZE, delta_y*World_checkers.BLOCK_SIZE);
			
			dot = new GOval(x1*World_checkers.BLOCK_SIZE+World_checkers.BLOCK_SIZE/2 + (double)delta_x*i*World_checkers.BLOCK_SIZE-World_checkers.BLOCK_SIZE/30,y1*World_checkers.BLOCK_SIZE+World_checkers.BLOCK_SIZE/2+ (double)delta_y*i*World_checkers.BLOCK_SIZE - World_checkers.BLOCK_SIZE/30,World_checkers.BLOCK_SIZE/15, World_checkers.BLOCK_SIZE/15);
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
	public GCompound getPath(){
		return path;
	}
	
}
