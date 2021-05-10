package Game;
import Board.Board;
import Board.Tile;
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

                    System.out.println("Peça movida");
                    pieceToMove.move(x, y);
                }
                else{
                        System.out.println("Movimento invalido");
                }
                pieceSelected = false;
            }
        }
    }
}
