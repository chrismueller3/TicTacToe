import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer implements Player {

    char player;
    Scanner keyboard = new Scanner(System.in);
    @Override
    /**
     * Not really used, this method is more important for the computer player class
     */
    public void setXO(char c) {
        player=c;
    }

    @Override
    public int Move(Board board) {
        int x,y,location=100;
        boolean valid=false;
        System.out.println("Enter desired location in the from xy, with 0,0 being the lower left corner");
        while (valid==false) {
            valid=true;
            location = this.setLocation();
            x=location%100/10;
            y=location%10;
            if (location>22||location<0) {
                valid=false;
                System.err.println("Invalid location entered, try again");
            } else if (x>2) {
                valid=false;
                System.err.println("Invalid location entered, try again");
            } else if(y>2) {
                valid=false;
                System.err.println("Invalid location entered, try again");
            } else if (board.CheckPosition(x,y)==false) {
                valid=false;
                System.err.println("Location occupied, try again");
            }
        }
        return location;
    }

    private int setLocation() {
        int location=100;
        boolean valid=false;
        while (valid==false) {
            try {
                location = keyboard.nextInt();
                valid=true;
            } catch (InputMismatchException e) {
                System.err.println("Invalid location entered, try again");
                valid=false;
                keyboard.next();
            }
        }
        return location;
    }
}
