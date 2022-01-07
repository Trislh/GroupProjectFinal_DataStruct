import java.util.ArrayList;

public class Algorithm {
    private char[][]  mine;
    private int minSteps;
    private int maxGolds;
    ArrayList<Character> Optimal = new ArrayList<>();


    public Algorithm(char[][] mine) {
        this.mine = mine;
    }

    public void exhaustiveSearch() {
        for (int i = 0; i <= mine.length; i++)
        {
            for (int j = 0; j <= (Math.pow(2.0,mine.length)-1); j++)
            {
                ArrayList<Character> Path = new ArrayList<>();
                for (int k = 0; k <= i - 1; k++)
                {
                    j = (j >> k) & 1;
                    if (j == 1)
                    {
                        if (mine[i][j+1] != 'X')
                        {
                            i++;
                        }
                        if (mine[i+1][j] != 'X')
                        {
                            j++;
                        }
                    }
                }
            }
        }
    }

    public void dynamicProgrammingSearch() {

    }
}
