package xolmes;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import tools.Graph;
import voidstorm.LinkedQueue;
import xolmes.tools.WorldAbstractClass;

public class World_checkers extends WorldAbstractClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int BLOCK_SIZE;
	private GCompound desk;
	Checker your_checker;
	Graph graph;

	public World_checkers() {
		desk = new GCompound();
		BLOCK_SIZE = your_checker.RADIUS * 2;
	}

	public void visualize(Iterable<Integer> path, Graph lab, int your_checkerX,
			int your_checkerY, int aimX, int aimY) {
		graph = lab;
		your_checker = new Checker(your_checkerX,your_checkerY);
		add(desk);
		add(your_checker.getGChecker());
		resize(8 * BLOCK_SIZE + 20, 8 * BLOCK_SIZE + 70);
		drawDesk();
		followThePath(path);
	}

	private void drawDesk() {
		Color color;
		int change_color = 0;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (change_color == 0) {
					color = Color.WHITE;
					change_color = 1;
				} else {
					color = Color.BLACK;
					change_color = 0;
				}
				addBlock(x, y, color);
			}
			if (change_color == 0) {
				change_color = 1;
			} else {
				change_color = 0;
			}
		}
	}

	private void addBlock(int x, int y, Color color) {
		GRect block = new GRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE,
				BLOCK_SIZE);
		block.setFilled(true);
		block.setFillColor(color);
		desk.add(block);
	}

	private void followThePath(Iterable<Integer> iterable) {
		LinkedQueue<Integer> arr = (LinkedQueue<Integer>) iterable;
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		for (Integer i : arr) {
			arr2.add(i);
		}
		int prev_step = your_checker.getX() + your_checker.getY() * graph.X();
		for (int k = arr2.size() - 1; k >= 0; k--) {
			int last_x = your_checker.getX();
			int last_y = your_checker.getY();
			int i = arr2.get(k);
			System.out.println(prev_step + " -> " + i);
			// LEFT
			if (prev_step - i == graph.X()+1) {
				your_checker.move(your_checker.getX() - 1, your_checker.getY()-1);
				
			}
			// RIGHT
			if (prev_step - i == graph.X()-1) {
				your_checker.move(your_checker.getX() + 1, your_checker.getY()-1);
				
			}
			prev_step = i;
			// System.out.println("GOTO " + i);
		}
	}

}
