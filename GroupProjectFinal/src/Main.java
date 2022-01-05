import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // All properties
        int size = 6;
        Mine mine = new Mine(size);

        Algorithm algo = new Algorithm(mine.getMine());
        // display Mine onto console
        mine.displayMine();


    }

}
