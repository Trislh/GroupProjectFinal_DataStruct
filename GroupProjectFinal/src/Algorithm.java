import java.util.ArrayList;
import java.util.Arrays;

public class Algorithm {
    private final char[][] mine;
    private int size;
    private int i,j;    // idx of current location
    private final boolean[][] used = new boolean[size][size];
    private int mineLength = size;
    private int minSteps;
    private int maxGolds;
    char currentPosition;
    ArrayList<Character> Optimal = new ArrayList<>();
    ArrayList<Character> Path = new ArrayList<>();


    /*
    * start at [0][0]
    * loop moving to the right
    * when meet X, move to the other side
    * when i or j reach limited range --> break
    * marks the moved path as used into used[] */

    public Algorithm(char[][] mine, int size) {
        this.mine = mine;
        this.size = size;
    }

    public void doExhaustiveSearch() {
//        for (int i = 0; i < mine.length; i++) {
//            for (int j = 0; j < mine[i].length; j++) {
//                // check if right next position is X or reach the rightmost position --> break
//
//            }
//        }
        if (i == size || j == size) {
            doExhaustiveSearch();
        }

    }


    public void dynamicProgrammingSearch() {

    }

    public void getPath() {
        System.out.println(Path.toString());
    }

}
