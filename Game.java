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
        
        for(int i = 0; i < 8; i++){
            if(i == 0 || i == 7){
                pieces.add(new Rook(board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Rook(board.getTile(i,7), PieceAlignment.WHITE));
            }
            else if(i == 1 || i == 6){
                pieces.add(new Knight(board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Knight(board.getTile(i,7), PieceAlignment.WHITE));
            }
            else if(i == 2 || i == 5){
                pieces.add(new Bishop(board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Bishop(board.getTile(i,7), PieceAlignment.WHITE));
            }
            else if(i == 3){
                pieces.add(new Queen(board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Queen(board.getTile(i,7), PieceAlignment.WHITE));
            }
            else if(i == 4){
                pieces.add(new King(board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new King(board.getTile(i,7), PieceAlignment.WHITE));
            }
            pieces.add(new Pawn(board.getTile(i,1), PieceAlignment.BLACK));
            pieces.add(new Pawn(board.getTile(i,6), PieceAlignment.WHITE));
        }
        dg = new DrawGame(board.getDb(), pieces);

        setup();
    }

    public void startGame(){
        window.setVisible(true);
    }

    public void setup(){
        window.setSize(380, 400);
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.add(dg);
    }
}
