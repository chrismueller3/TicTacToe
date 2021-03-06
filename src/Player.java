public interface Player {

    char player = 0;
    /**
     * Sets if the player is going to be X or O
     * @param c The X or O character
     */
    public void setXO(char c);

    /**
     * The part that allows a player to set a location to X or O. Takes a board in for the player to use.
     * @param board
     * @return Returns the desired location in the form xy, with 0,0 being on the bottom left corner.
     */
    public int Move(Board board);
}
