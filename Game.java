import javax.swing.*;
import Board.Board;
import Draw.DrawGame;
import Piece.*;
import java.util.Vector;

public class Game {
    private JFrame window;
    private Board board;
    private DrawGame dg;
    private Vector<Piece> pieces;

    public Game(){
        window = new JFrame();
        board = new Board();
        board.startBoard();

        pieces = new Vector<Piece>();
        pieces.add(new Pawn(board.getTile(0, 0), PieceAlignment.BLACK));

        dg = new DrawGame(board.getDb(), pieces);

        setup();
    }

    public void startGame(){
        window.setVisible(true);
    }

    public void setup(){
        window.setSize(600, 400);
        window.setDefaultCloseOperation(3);
        window.add(dg);
    }
}
