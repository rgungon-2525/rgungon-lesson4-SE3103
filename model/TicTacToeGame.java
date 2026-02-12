package model;

public class TicTacToeGame {
    
    private Marking[] board = new Marking[9];
    private Marking turn = Marking.X; // X starts first
    private int moves = 0;
    private Marking winner = null; // O or X or U (draw)
    private GameState state = GameState.INIT;
    private PlayStrategy strategy = PlayStrategy.VsHuman;

    public TicTacToeGame() {
        reset();
    }

    public void reset() {
        for (int i = 0; i <board.length; i++) {
            board[i] = Marking.U;
        }
        turn = Marking.X;
        moves = 0;
        winner = null;
    }
}
