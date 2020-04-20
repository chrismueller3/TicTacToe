import java.lang.reflect.Array;
import java.util.Arrays;

public class Board {

    /**
     * The board variable itself.
     * The first index is the x axis, while the second is the y axis. Assumes 0,0 is at the bottom left corner.
     */
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
        int XO;
        if (c=='x'||c=='X') {
            XO=1;
        } else if (c=='o'||c=='O') {
            XO=4;
        } else {
            return false;
        }
        board[x][y]=XO;

        return true;
    }

    /**
     * Checks the board to see if anybody has won that game.
     * Displays the winning board
     * @return Returns false if there isn't a winner, true if there is a winner
     */
    public boolean checkBoard() {

        return true;
    }

    /**
     * Displays the current board.
     */
    public void displayBoard() {
        for (int j=2;j>=0;j--) {
            for (int i=0;i<3;i++) {
                System.out.print(this.getBoardValue(i,j)+" ");
            }
            System.out.println();
        }
    }

    /**
     * Returns a letter representation of an index.
     * Mainly used in the displayBoard method right now.
     * Saves a lot of space in the displayBoard method.
     * @param x The x index one wants
     * @param y The y index one wants
     * @return The letter representation of the index in question
     */
    private char getBoardValue(int x, int y) {
        if (board[x][y]==1) {
            return 'X';
        } else if (board[x][y]==4) {
            return 'O';
        } else if (board[x][y]==0) {
            return '-';
        } else {
            return 'e';
        }
    }


}
