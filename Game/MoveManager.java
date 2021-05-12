package Game;
import java.util.ArrayList;
import Board.Board;
import Board.Tile;
import Piece.Piece;

public class MoveManager {
    private Board board;
    private Piece pieceToMove;
    private boolean pieceSelected;
    private GameFlowManager gfm;
    private ArrayList<Piece> pieces;

    public MoveManager(Board board, ArrayList<Piece> pieces){
        gfm = new GameFlowManager();
        
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
                    if(gfm.checkMovingPiece(selectedTile.getPieceInTile())){
                        System.out.println("Peça selecionada");
                        pieceToMove = selectedTile.getPieceInTile();
                        pieceSelected = true;
                    }
                }
            }
            else{
                pieceToMove.setPossibleMoves();
                if(pieceToMove.getPossibleMoves().contains(selectedTile)){
                    pieceToMove.move(x, y, pieces);
                    gfm.turnChange();
                }
                else{
                        System.out.println("Movimento invalido");
                }
                pieceSelected = false;
            }
        }
    }
}
