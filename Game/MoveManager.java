package Game;
import java.util.ArrayList;
import Board.Board;
import Board.Tile;
import Piece.Piece;

public class MoveManager {
    private Board board;
    private Piece pieceToMove;
    private boolean pieceSelected;
    private ArrayList<Piece> pieces;

    public MoveManager(Board board, ArrayList<Piece> pieces){
        this.board = board;
        this.pieces = pieces;

        pieceToMove = null;
        pieceSelected = false;

    }

    public void makeMove(int x, int y){
        if(x >= 0 && x <= 7 && y >=0 && y <=7){
            Tile selectedTile = board.getTile(x, y);
            if(!pieceSelected){
                if(selectedTile.getIsTileOccupied()){
                    System.out.println("Peça selecionada");
                    pieceToMove = selectedTile.getPieceInTile();
                    pieceSelected = true;
                }
            }
            else{
                pieceToMove.setPossibleMoves();
                if(pieceToMove.getPossibleMoves().contains(selectedTile)){
                    pieceToMove.move(x, y, pieces);
                }
                else{
                        System.out.println("Movimento invalido");
                }
                pieceSelected = false;
            }
        }
    }
}
