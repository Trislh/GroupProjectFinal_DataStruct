import java.util.Random;

public class Mine {
    private char[][] mine;
    private final int size;
    private int amountRock = 6;
    private int amountGold = 8;
    private char land = '.';
    private int row, col;
    private char currentDirection;

    Random rand = new Random();

    public Mine(int size) {
        this.size = size;
        createMine();
    }

    public int getSize() { return this.size; }

    private void createMine() {

        // create Mine
        mine = new char[size][size];
        // add Land
        addLand(mine);
        addRock(mine);
        addGold(mine);

    }

    public int getMineLen() { return mine.length; }

    private char addGold(char[][] mine) {
        int goldValue = getRandomNumber(49, 54);
//        char goldValue = (char) rand.nextInt(6);

        row = rand.nextInt(size);
        col = rand.nextInt(size);
        char currentPosition = mine[row][col];

        // exit case
        if (amountGold == 0) return '.';

        // compare whether value at currentPosition has value other than '.' or not
        int compareValue = Character.compare('.', currentPosition );
        if (compareValue < 0) {
            return addGold(mine);
        }

        // successfully added
        mine[row][col] = (char) goldValue;
        amountGold--;
        return addGold(mine);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private char addRock(char[][] mine) {

        // get random coordinates
        row = rand.nextInt(size);
        col = rand.nextInt(size);

        currentDirection = mine[row][col];
        // check exit stage
        if (amountRock == 0 || row == 0 && col == 0 ) return '.';
        // check duplicated positions
        if (currentDirection == 'X') {
            return addRock(mine);
        }

        // if all conditions met, add X to the position
        mine[row][col] = 'X';
        amountRock--;
        return addRock(mine);
    }

    public char[][] getMine() {

        // print out the mine
        return mine;
    }

    private void addLand(char[][] mine) {
        // 2d array loop to add '.' to the array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mine[i][j] != 'X') {
                    mine[i][j] = '.';
                }

            }
        }
    }

    public void displayMine() {
        for (char[] chars : mine) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

}
