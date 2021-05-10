package Game;
import Board.Board;
import Piece.Piece;

public class MoveManager {
    private Board board;
    private Piece pieceToMove;
    private boolean pieceSelected;

    public MoveManager(Board board){
        this.board = board;

        pieceToMove = null;
        pieceSelected = false;

    }

    public void makeMove(int x, int y){
        if(x >= 0 && x <= 7 && y >=0 && y <=7){
            if(!pieceSelected){
                if(board.getTile(x, y).getIsTileOccupied()){
                    System.out.println("Peça selecionada");
                    pieceToMove = board.getTile(x, y).getPieceInTile();
                    pieceSelected = true;
                }
            }
            else{
                System.out.println("Peça movida");
                pieceToMove.move(x, y);
                pieceSelected = false;
            }
        }
    }
}
