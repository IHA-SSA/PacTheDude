package xolmes;

import tools.Graph;

public class WorldUtils {

    public static boolean leftIsClear(Graph labirinth, int x, int y) {
        for (Integer i : labirinth.adj(x + labirinth.X() * y)) {
            if (i == x - 1 + labirinth.X() * y) {
                return true;
            }
        }
        return false;
    }

    public static boolean rightIsClear(Graph labirinth, int x, int y) {
        for (Integer i : labirinth.adj(x + labirinth.X() * y)) {
            if (i == x + 1 + labirinth.X() * y) {
                return true;
            }
        }
        return false;
    }

    public static boolean topIsClear(Graph labirinth, int x, int y) {
        for (Integer i : labirinth.adj(x + labirinth.X() * y)) {
            if (i == x + labirinth.X() * y - labirinth.X()) {
                return true;
            }
        }
        return false;
    }

    public static boolean bottomIsClear(Graph labirinth, int x, int y) {
        for (Integer i : labirinth.adj(x + labirinth.X() * y)) {
            if (i == x + labirinth.X() * y + labirinth.X()) {
                return true;
            }
        }
        return false;
    }
}
