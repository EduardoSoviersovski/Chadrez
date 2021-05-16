package Game;
import Piece.PieceAlignment;
import Piece.Piece;

public class GameFlowManager {
    private PieceAlignment turn;

    public GameFlowManager(){
        turn = PieceAlignment.WHITE;
    }

    public void turnChange(){
        if(turn == PieceAlignment.WHITE){
            turn = PieceAlignment.BLACK;
        }
        else{
            turn = PieceAlignment.WHITE;
        }
    }

    public void setWhiteTurn(){
        turn = PieceAlignment.WHITE;
    }

    public void setBlackTurn(){
        turn = PieceAlignment.BLACK;
    }
    
    public boolean checkMovingPiece(Piece piece){
        if(piece.getPieceAlignment() == turn){
            return true;
        }
        else{
            return false;
        }
    }
    public PieceAlignment getTurn(){
        return turn;
    }
}
