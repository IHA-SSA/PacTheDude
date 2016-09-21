package xolmes;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;


public class WorldCreator {
	
	
	public WorldCreator(){
		
	}
	
	public GCompound createBlock(int x,int y, boolean top, boolean right, boolean bottom, boolean left, boolean border){
		GCompound block = new GCompound();
		
		//BORDER
		if(border){
			GLine border_01 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE);
			border_01.setColor(Color.RED);
			block.add(border_01);
			GLine border_02 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			border_02.setColor(Color.RED);
			block.add(border_02);
			GLine border_03 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE, x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			border_03.setColor(Color.RED);
			block.add(border_03);
			GLine border_04 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE, x*World.BLOCK_SIZE, y*World.BLOCK_SIZE);
			border_04.setColor(Color.RED);
			block.add(border_04);
		}
		
		if(top){
			GLine line_03 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			block.add(line_03);
			GLine line_04 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			block.add(line_04);
		}
		else {
			GLine line_09 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			block.add(line_09);
		}
		if(right){
			GLine line_05 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			block.add(line_05);
			GLine line_06 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			block.add(line_06);
		}
		else {
			GLine line_12 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			block.add(line_12);
		}
		
		if(bottom){
			GLine line_07 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			block.add(line_07);
			GLine line_08 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			block.add(line_08);
		}
		else {
			GLine line_10 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			block.add(line_10);
		}
		
		if(left){
			GLine line_01 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			block.add(line_01);
			GLine line_02 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			block.add(line_02);
		}
		else {
			GLine line_11 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			block.add(line_11);
		}

		return block;
	}
	
	
}
