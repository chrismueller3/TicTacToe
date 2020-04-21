public class Main {

    public static void main(String[] args) {
        System.out.println("Start of a Tic Tac Toe Command Line Game");
        Board board=new Board();
        HumanPlayer player1= new HumanPlayer();
        ComputerPlayer player2 = new ComputerPlayer();
        boolean winner=false;
        int move;
        //TODO: Make the winner/boardfull check more elegant
        while (winner==false) {
            board.displayBoard();
            move=player1.Move(board);
            board.setPosition(move/10,move%10,'x');
            winner=board.checkBoard();
            if (winner==true) {
                break;
            }
            winner=board.BoardFull();
            if (winner==false) {
                move=player2.Move(board);
                board.setPosition(move/10,move%10,'o');
                winner=board.checkBoard();
                if (winner==true) {
                    break;
                }
                winner=board.BoardFull();
            }
        }

    }
}
