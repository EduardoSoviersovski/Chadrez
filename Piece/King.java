package Piece;
import Draw.DrawPiece;
import Board.Tile;

public class King extends Piece{
    //Atributos
    public King(Tile tile, PieceAlignment alignment){
        super(tile, alignment);
        type = PieceType.KING;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KING, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
