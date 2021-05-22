package Game;

import java.util.ArrayList;

import Piece.Piece;
import Piece.PieceType;

public class EndGameManager {
    private ArrayList<Piece> pieces;

    public EndGameManager(ArrayList<Piece> pieces){
        this.pieces = pieces;
    }

    public boolean checkGameEnd(){
        int kingCounter = 0;
        for(int i = 0; i < pieces.size(); i++){
            if(pieces.get(i).getPieceType() == PieceType.KING){
                kingCounter++;
            }
        }

        if(kingCounter == 2){
            return false;
        }
        else{
            return true;
        }
    }
}
