public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Start of a Tic Tac Toe Command Line Game");
        Board board=new Board();
//        board.setPosition(0,2,'X');
//        board.setPosition(2,2,'X');
////        board.setPosition(0,2,'o');
////        board.setPosition(1,1,'o');
////        board.setPosition(1,2,'o');
//        board.setPosition(1,2,'o');
//        board.displayBoard();
//        boolean test= board.checkBoard();
//        System.out.println(test);
        HumanPlayer player1= new HumanPlayer();
//        player1.setXO('X');
//        player1.Move(board);
        ComputerPlayer player2 = new ComputerPlayer();
//        player2.Move(board);
        boolean winner=false;
        int move;
        while (winner==false) {
            board.displayBoard();
            move=player1.Move(board);
            board.setPosition(move/10,move%10,'x');
            winner=board.checkBoard();
            if (winner==false) {
                move=player2.Move(board);
                board.setPosition(move/10,move%10,'o');
                winner=board.checkBoard();
            }
        }

    }
}
