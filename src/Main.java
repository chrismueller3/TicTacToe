public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Start of a Tic Tac Toe Command Line Game");
        Board board=new Board();
        board.setPosition(0,2,'X');
        board.setPosition(0,2,'o');
        board.setPosition(1,0,'o');
        board.setPosition(1,1,'o');
//        board.setPosition(1,2,'o');
        board.displayBoard();
//        boolean test= board.checkBoard();
//        System.out.println(test);
        HumanPlayer player1= new HumanPlayer();
        player1.setXO('X');
        player1.Move(board);

    }
}
