package xolmes;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import tools.Graph;
import xolmes.tools.WorldAbstractClass;

public class World_checkers extends WorldAbstractClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BLOCK_SIZE = 60;
	private GCompound desk;
	public World_checkers() {
		desk = new GCompound();
		
	
	}

	public void visualize(Iterable<Integer> path, Graph lab, int pacX,
			int pacY, int aimX, int aimY) {
		add(desk);
		resize(8*BLOCK_SIZE+20, 8*BLOCK_SIZE+70);
		drawDesk();
	}
	
	private void drawDesk(){
		Color color;
		int change_color = 0;
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				if(change_color==0){
					color = Color.BLACK;
					change_color = 1;
				}
				else {
					color = Color.WHITE;
					change_color = 0;
				}
				addBlock(x,y,color);
			}
			if(change_color==0){
				change_color = 1;
			}
			else {
				change_color = 0;
			}
		}
	}
	
	private void addBlock(int x, int y, Color color){
		GRect block = new GRect(x*BLOCK_SIZE,y*BLOCK_SIZE,BLOCK_SIZE, BLOCK_SIZE);
		block.setFilled(true);
		block.setFillColor(color);
		desk.add(block);
	}


}
