public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Start of a Tic Tac Toe Command Line Game");
        Board board=new Board();
        board.setPosition(0,2,'X');
        board.setPosition(0,2,'o');
        board.setPosition(2,0,'o');
        board.displayBoard();

    }
}
