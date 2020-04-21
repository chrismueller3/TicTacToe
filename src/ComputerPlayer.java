import java.util.Random;

public class ComputerPlayer implements Player {


    int playerValue;
    @Override
    /**
     * Sets if this is X or O. Not used now, might be used later.
     */
    public void setXO(char c) {
        char player;
        player=c;
        if (player=='x'||player=='X') {
            playerValue=1;
        }
        if (player=='o'||player=='O') {
            playerValue=4;
        }
    }

    /**
     * The part that goes over the board to determine if there is a move to block, or a move to take to win.
     * Checks horizontally first, then vertically.
     * Records the position where there isn't a value so it knows where to place it's value
     * Finally it checks the diagonals.
     * If there are no moves that fulfill the above requirements, random values are tried until it's determined they're a valid position.
     * @param board The current board
     * @return Returns the move the computer has decided to take
     */
    @Override
    public int Move(Board board) {
        int checkValue=0,i,j,xLocation=4,yLocation=4,location=0;
        boolean possibleMove=false, vertical=false;
        for (j=0;j<3;j++) {
            checkValue=0;
            for (i=0;i<3;i++) {
                if (board.GetPosition(i,j)==0) {
                    xLocation=i;
                }
                checkValue=board.GetPosition(i,j)+checkValue;
            }
            if (checkValue==2) {
                yLocation=j;
                possibleMove=true;
                break;
            } else if (checkValue==8) {
                yLocation=j;
                possibleMove=true;
                break;
            }
        }
        if (possibleMove==false) {
            for (i=0;i<3;i++) {
                checkValue=0;
                for (j=0;j<3;j++) {
                    if (board.GetPosition(i,j)==0) {
                        yLocation=j;
                    }
                    checkValue=board.GetPosition(i,j)+checkValue;
                }
                if (checkValue==2) {
                    xLocation=i;
                    possibleMove=true;
                    vertical=true;
                    break;
                } else if (checkValue==8) {
                    xLocation=i;
                    possibleMove=true;
                    vertical=true;
                    break;
                }
            }
        }
        if (possibleMove==false) {
            location=this.checkDiagonal(board);
            if (location!=-1) {
                return location;
            }
        }

        if (possibleMove==true) {
            location=xLocation*10+yLocation;
        } else {
            while (possibleMove==false) {
                Random random = new Random();
                xLocation = random.nextInt(3);
                yLocation = random.nextInt(3);
                possibleMove=board.CheckPosition(xLocation,yLocation);
            }
            location = xLocation * 10 + yLocation;
        }
        return location;
    }

    /**
     * Checks the diagonals of the board. Returns -1 if there is nothing there, otherwise it returns the location to place a value.
     * Quite a crude method at the moment, it might be improved later.
     * @param board
     * @return Location to place value.
     */
    private int checkDiagonal(Board board) {
        int checkValue,location=-1;
        checkValue=board.GetPosition(0,0)+board.GetPosition(1,1)+board.GetPosition(2,2);
        if (checkValue==2||checkValue==8) {
            if (board.CheckPosition(0,0)==true) {
                return 0;
            }
            if (board.CheckPosition(1,1)==true) {
                return 11;
            }
            if (board.CheckPosition(2,2)==true) {
                return 22;
            }
        }
        checkValue=board.GetPosition(0,2)+board.GetPosition(1,1)+board.GetPosition(2,0);
        if (checkValue==2||checkValue==8) {
            if (board.CheckPosition(0,2)==true) {
                return 02;
            }
            if (board.CheckPosition(1,1)==true) {
                return 11;
            }
            if (board.CheckPosition(2,0)==true) {
                return 20;
            }
        }
        return location;
    }
}
