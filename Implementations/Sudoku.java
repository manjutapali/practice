/*
  Given sudoku board, check if it is valid
*/

public class Sudoku
{
    public static void main(String[] args)
    {
        String board[] = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};

        System.out.println(isSudokuValid(board));
    }

    static boolean isSudokuValid(String board[])
    {
        boolean r[][] = new boolean[9][9], c[][] = new boolean[9][9], box[][][] = new boolean[3][3][9];

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i].charAt(j) > 0 && board[i].charAt(j) <= 9)
                {
                    int k = board[i].charAt(j) - 1;

                    if(r[i][k])
                        return false;
                    r[i][k] = true;

                    if(c[j][k])
                        return false;
                    r[j][k] = true;

                    if(box[i/3][j/3][k])
                        return false;
                    box[i/3][j/3][k] = true;
                }
            }
        }

        return true;
    }
}
