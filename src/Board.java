import java.util.Arrays;

public class Board {

    /**
     * The board variable itself.
     * The first index is the x axis, while the second is the y axis. Assumes 0,0 is at the bottom left corner.
     * X is represented by a 1, while O is represented by a 4.
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
     * Checks if the position entered has a value besides 0.
     * @param x x co-ord of the location
     * @param y y co-ord of the location
     * @return
     */
    public boolean CheckPosition(int x, int y) {
        if (board[x][y]!=0) {
            return false;
        }
        return true;
    }

    /**
     * Returns the value at the location entered
     * @param x x co-ord of the location
     * @param y y co-ord of the location
     * @return
     */
    public int GetPosition(int x, int y) {
        return board[x][y];
    }

    /**
     * Checks the board to see if anybody has won that game.
     * Displays the winning board
     * @return Returns false if there isn't a winner, true if there is a winner
     */
    public boolean checkBoard() {
        int i,j,winner=0,checkValue;

        //Checks if there was a winner horizontally in the board
        for (j=0;j<3;j++) {
            checkValue=0;
            for (i=0;i<3;i++) {
                checkValue=board[i][j]+checkValue;
            }
            if (checkValue==3) {
                winner=1;
                break;
            } else if (checkValue==12) {
                winner=4;
                break;
            }

        }
        //Checks if there's a winner vertically in the board. Skips it if there is already a winner
        if (winner==0) {
            for (i = 0; i < 3; i++) {
                checkValue = 0;
                for (j = 0; j < 3; j++) {
                    checkValue = board[i][j] + checkValue;
                }
                if (checkValue == 3) {
                    winner = 1;
                    break;
                } else if (checkValue == 12) {
                    winner = 4;
                    break;
                }
            }
        }

        if (winner==1) {
            System.out.println("X wins! \nHere is the final board!");
            this.displayBoard();
            return true;
        }
        if (winner==4) {
            System.out.println("O wins! \nHere is the final board!");
            this.displayBoard();
            return true;
        }
        return false;
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
