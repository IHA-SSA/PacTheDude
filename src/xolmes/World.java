package xolmes;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import tools.Graph;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class World extends GraphicsProgram {

	public static final int BLOCK_SIZE = 80;
	private static final Color BACKGROUND_COLOR = Color.WHITE;
	WorldCreator wc;
	Graph labirinth;
	public void run() {

		wc = new WorldCreator();
		labirinth = new Graph("labirinth_test.txt");
		
		drawWorld();
		
		/*
		 * GRect rect = new GRect(100, 50, 100, 100 / PHI);
		 * rect.setFilled(true); rect.setColor(Color.RED); add(rect); GOval oval
		 * = new GOval(150, 50 + 50 / PHI, 100, 100 / PHI);
		 * oval.setFilled(true); oval.setColor(Color.GREEN); add(oval);
		 */

	}

	public void drawWorld() {
		this.resize(labirinth.X() * BLOCK_SIZE, labirinth.Y() * BLOCK_SIZE);
		this.setBackground(BACKGROUND_COLOR);
		
		ArrayList<Integer> sides = new ArrayList<Integer>();
		for (int i = 0; i < labirinth.X() * labirinth.Y(); i++) {

			boolean top = false;
			boolean right = false;
			boolean bottom = false;
			boolean left = false;
			sides.add(i + 1);
			sides.add(i - 1);
			sides.add(i + labirinth.X());
			sides.add(i - labirinth.X());
			for (Integer in : labirinth.adj(i)) {

				if (sides.contains(in)) {
					if (in == i + 1) {
						right = true;
					}
					if (in == i - 1) {
						left = true;
					}
					if (in == i + labirinth.X()) {
						bottom = true;
					}
					if (in == i - labirinth.X()) {
						top = true;
					}
				}

			}
			sides.clear();
			if (!top && !bottom && !left && !right) {
				add(wc.createBlock(i % labirinth.X(), i / labirinth.X(), top,
						right, bottom, left, true));
			} else {
				add(wc.createBlock(i % labirinth.X(), i / labirinth.X(), top,
						right, bottom, left, false));
			}
		}
	}

}
