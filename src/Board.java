import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {

    private int[][] board=new int[3][3];

    public Board() {
        Arrays.fill(board[0],0);
        Arrays.fill(board[1],0);
        Arrays.fill(board[2],0);
    }

    public boolean setPosition(int x, int y, char c) {

        if (board[x][y]!=0) {
            return false;
        }

        return true;
    }


}
