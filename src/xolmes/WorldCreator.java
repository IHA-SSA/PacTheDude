package xolmes;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;


public class WorldCreator {
	
	private Color line_color = Color.BLUE;
	private Color border_color = Color.RED;
	
	public WorldCreator(){
		
	}
	
	public GCompound createBlock(int x,int y, boolean top, boolean right, boolean bottom, boolean left, boolean border){
		GCompound block = new GCompound();
		
		//BORDER
		if(border){
			GLine border_01 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE);
			border_01.setColor(border_color);
			block.add(border_01);
			GLine border_02 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			border_02.setColor(border_color);
			block.add(border_02);
			GLine border_03 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE, x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			border_03.setColor(border_color);
			block.add(border_03);
			GLine border_04 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE, x*World.BLOCK_SIZE, y*World.BLOCK_SIZE);
			border_04.setColor(border_color);
			block.add(border_04);
		}
		
		if(top){
			GLine line_03 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			line_03.setColor(line_color);
			block.add(line_03);
			GLine line_04 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			line_04.setColor(line_color);
			block.add(line_04);
		}
		else {
			GLine line_09 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			line_09.setColor(line_color);
			block.add(line_09);
		}
		if(right){
			GLine line_05 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			line_05.setColor(line_color);
			block.add(line_05);
			GLine line_06 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			line_06.setColor(line_color);
			block.add(line_06);
		}
		else {
			GLine line_12 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			line_12.setColor(line_color);
			block.add(line_12);
		}
		
		if(bottom){
			GLine line_07 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			line_07.setColor(line_color);
			block.add(line_07);
			GLine line_08 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE);
			line_08.setColor(line_color);
			block.add(line_08);
		}
		else {
			GLine line_10 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			line_10.setColor(line_color);
			block.add(line_10);
		}
		
		if(left){
			GLine line_01 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3);
			line_01.setColor(line_color);
			block.add(line_01);
			GLine line_02 = new GLine(x*World.BLOCK_SIZE, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			line_02.setColor(line_color);
			block.add(line_02);
		}
		else {
			GLine line_11 = new GLine(x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3, x*World.BLOCK_SIZE + World.BLOCK_SIZE/3, y*World.BLOCK_SIZE + World.BLOCK_SIZE/3*2);
			line_11.setColor(line_color);
			block.add(line_11);
		}

		return block;
	}
	
	
}
