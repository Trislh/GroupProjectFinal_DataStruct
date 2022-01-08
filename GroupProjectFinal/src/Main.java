import java.util.Arrays;

public class Main {

    // All properties
    static int size = 6;
    static Mine mine = new Mine(size);
    static char[][] used = new char[size][size];          // for marking path purpose
    static char[][] sampleMineTest = mine.getMine();            // test sample

    // Main function --> where everything start.
    public static void main(String[] args) {



        // display Mine onto console
        mine.displayMine();

        // run search
        doExhaustiveSearch(mine, used, 0, 0);
    }

    private static void doExhaustiveSearch(Mine mine, char[][] used, int x, int y) {

        // get the mine from Mine --> for scanning
        char[][] currentMine = mine.getMine();

        // check if current location is being reached the edge or not.
        // break case
//        if (x == mine.getMineLen()) {
//            if (currentMine[x][y] == 'X' || y == mine.getMineLen()) {
//                System.out.println("END");
//                displayPath(used);
//                return;
//            }
//        }
        if (y == mine.getMineLen()) {
            System.out.println("END");
            displayPath(used);
            return;
        }
        System.out.println("Checking position: " + currentMine[x][y]);
        // check if the path is marked yet.
        // if yes, ignore it.
//        for (int i = 0; i < sampleMineTest.length; i++) {
//            for (int j = 0; j < sampleMineTest[i].length; j++) {
//                if (used[i][j]) {
//                    continue;
//                }
//            }
//        }
        used[x][y] = '+';  // mark the current coordination

        if (currentMine[x][y] == 'X') {               // check whether right side is blocked
            System.out.println("Move down");
            used[x][y] = 'x';             // change back to false
            if (y < 0) return;
            doExhaustiveSearch(mine, used, x+1, y-1); // if yes --> move down
        } else {
            System.out.println("Move right");
            doExhaustiveSearch(mine, used, x, y+1);     // if no --> move right
        }


    }

    private static void displayPath(char[][] used) {
        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used[i].length; j++) {
                System.out.print(used[i][j] + " ");
            }
            System.out.println();
        }
    }

}
