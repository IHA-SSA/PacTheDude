package xolmes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import tools.Graph;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.BFSSolver;
import truelecter.problem_solving.pacthedude.state.WorldState;
import truelecter.problem_solving.pacthedude.state.WorldState.Location;
import voidstorm.BreadthFirstPaths;
import voidstorm.LinkedQueue;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

public class World extends GraphicsProgram {

    public static final int BLOCK_SIZE = 30;
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    WorldCreator wc;
    Graph labirinth;
    PacTheDude pac;
    GPolygon diamond;
    int aim_x = 0;
    int aim_y = 0;

    public void run() {
        // Initial
        // wc = new WorldCreator();
        // labirinth = new Graph("labirinth_test.txt");
        // pac = new PacTheDude(0, 9);
        // drawWorld();
        // add(pac.getPac());
        // add(pac.getPath());
        //
        // //ADD AIM
        // diamond = new GPolygon();
        // diamond.addVertex(BLOCK_SIZE/6, 0);
        // diamond.addVertex(BLOCK_SIZE/3, BLOCK_SIZE/6);
        // diamond.addVertex(BLOCK_SIZE/6, BLOCK_SIZE/3);
        // diamond.addVertex(0, BLOCK_SIZE/6);
        // diamond.setFilled(true);
        // diamond.setFillColor(Color.GRAY);
        // diamond.sendBackward();
        // add(diamond,aim_x*BLOCK_SIZE + BLOCK_SIZE/3, aim_y*BLOCK_SIZE +
        // BLOCK_SIZE/3);
        //
        // this.getGCanvas().addKeyListener(new KeyListener() {
        //
        // @Override
        // public void keyTyped(KeyEvent e) {
        //
        // }
        //
        // @Override
        // public void keyReleased(KeyEvent e) {
        //
        // if (e.getKeyChar() == 'w') {
        // if (pac.getY() > 0) {
        // pac.move(pac.getX(), pac.getY() - 1);
        // }
        // }
        // if (e.getKeyChar() == 'a') {
        // if (pac.getX() > 0) {
        // pac.move(pac.getX() - 1, pac.getY());
        // }
        // }
        // if (e.getKeyChar() == 's') {
        // if (pac.getY() < labirinth.Y() - 1) {
        // pac.move(pac.getX(), pac.getY() + 1);
        // }
        // }
        // if (e.getKeyChar() == 'd') {
        // if (pac.getX() < labirinth.X() - 1) {
        // pac.move(pac.getX() + 1, pac.getY());
        // }
        // }
        // // TODO Auto-generated method stub
        //
        // }
        //
        // @Override
        // public void keyPressed(KeyEvent e) {
        // // TODO Auto-generated method stub
        //
        // }
        // });
//        // after rework
//        Graph labirinth = new Graph("labirinth_test.txt");
//        BreadthFirstPaths bfs = new BreadthFirstPaths(labirinth, 0 + 9 * labirinth.X());
//        System.out.println("Drawing...");
//        visualize(bfs.pathTo(aim_x + aim_y * labirinth.Y()), labirinth, 0, 9, 3, 2);
        // acm don't want to visualize in another class (
        Graph world = new Graph("labirinth_test.txt");
        Location pacmanLocation = new Location(0, 18);
        Location diamondLocation = new Location(16, 0);
        WorldState startingState = new WorldState(null, null, pacmanLocation, diamondLocation, world);

        BFSSolver solver = new BFSSolver(startingState);
        State finish = solver.solve();

        if (finish != null) {
            System.out.println("Solution found!");
            LinkedQueue<State> path = BFSSolver.path(finish);
            System.out.println(path.size());

            LinkedQueue<Integer> toDraw = new LinkedQueue<>();
            for (State s : path) {
                if (s instanceof WorldState) {
                    WorldState state = (WorldState) s;
                    toDraw.enqueue(state.getPacmanLocation().x + state.getPacmanLocation().y * world.X());
                }
            }

            visualize(toDraw, world, pacmanLocation.x, pacmanLocation.y, diamondLocation.x, diamondLocation.y);
        } else {
            System.out.println("Unable to find solution!");
        }
    }

    public void visualize(Iterable<Integer> path, Graph lab, int pacX, int pacY, int aimX, int aimY) {
        wc = new WorldCreator();

        labirinth = lab;

        pac = new PacTheDude(pacX, pacY);
        drawWorld();
        add(pac.getPac());
        add(pac.getPath());

        aim_x = aimX;
        aim_y = aimY;

        diamond = new GPolygon();
        diamond.addVertex(BLOCK_SIZE / 6, 0);
        diamond.addVertex(BLOCK_SIZE / 3, BLOCK_SIZE / 6);
        diamond.addVertex(BLOCK_SIZE / 6, BLOCK_SIZE / 3);
        diamond.addVertex(0, BLOCK_SIZE / 6);
        diamond.setFilled(true);
        diamond.setFillColor(Color.GRAY);
        diamond.sendBackward();
        add(diamond, aim_x * BLOCK_SIZE + BLOCK_SIZE / 3, aim_y * BLOCK_SIZE + BLOCK_SIZE / 3);

        followThePath(path);
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
                 //add(wc.createBlock(i % labirinth.X(), i / labirinth.X(), top, right, bottom, left, true));
            } else {
                add(wc.createBlock2(i % labirinth.X(), i / labirinth.X(), top, right, bottom, left, false));
            }
        }
    }

    private void randomMakesMeCrazy() {
        Random r = new Random();
        while (true) {
            int x = r.nextInt(3) - 1;
            int y = r.nextInt(3) - 1;

            if (pac.getY() + y >= 0 && pac.getX() + x >= 0 && pac.getY() + y <= labirinth.Y() - 1
                    && pac.getX() + x <= labirinth.X() - 1) {
                pac.move(pac.getX() + x, pac.getY() + y);
            }
        }
    }

    private void followThePath(Iterable<Integer> iterable) {
        LinkedQueue<Integer> arr = (LinkedQueue<Integer>) iterable;
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for (Integer i : arr) {
            arr2.add(i);
        }
        int prev_step = pac.getX() + pac.getY() * labirinth.X();
        for (int k = arr2.size() - 1; k >= 0; k--) {
            int last_x = pac.getX();
            int last_y = pac.getY();
            int i = arr2.get(k);
            // DOWN
            if (prev_step - i == labirinth.X()) {
                pac.move(pac.getX(), pac.getY() - 1);
                // add(new GLine(last_x*BLOCK_SIZE +BLOCK_SIZE/2,
                // last_y*BLOCK_SIZE +BLOCK_SIZE/2,last_x*BLOCK_SIZE
                // +BLOCK_SIZE/2, pac.getY()*BLOCK_SIZE +BLOCK_SIZE/2));
            }
            // TOP
            if (prev_step - i == -labirinth.X()) {
                pac.move(pac.getX(), pac.getY() + 1);
                // add(new GLine(last_x*BLOCK_SIZE +BLOCK_SIZE/2,
                // last_y*BLOCK_SIZE +BLOCK_SIZE/2,last_x*BLOCK_SIZE
                // +BLOCK_SIZE/2, pac.getY()*BLOCK_SIZE +BLOCK_SIZE/2));
            }
            // LEFT
            if (prev_step - i == 1) {
                pac.move(pac.getX() - 1, pac.getY());
                // add(new GLine(last_x*BLOCK_SIZE +BLOCK_SIZE/2,
                // last_y*BLOCK_SIZE +BLOCK_SIZE/2,pac.getX()*BLOCK_SIZE
                // +BLOCK_SIZE/2, last_y*BLOCK_SIZE +BLOCK_SIZE/2));
            }
            // RIGHT
            if (prev_step - i == -1) {
                pac.move(pac.getX() + 1, pac.getY());
                // add(new GLine(last_x*BLOCK_SIZE +BLOCK_SIZE/2,
                // last_y*BLOCK_SIZE +BLOCK_SIZE/2,pac.getX()*BLOCK_SIZE
                // +BLOCK_SIZE/2, last_y*BLOCK_SIZE +BLOCK_SIZE/2));
            }
            prev_step = i;
             System.out.println("GOTO " + i);
        }
        this.remove(diamond);
    }

}
