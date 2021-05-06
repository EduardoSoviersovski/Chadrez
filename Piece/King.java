package Piece;
import Draw.DrawPiece;
import Board.*;

public class King extends Piece{
    //Atributos
    public King(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.KING;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KING, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
