package Piece;
import Draw.DrawPiece;
import Board.Tile;

public class Knight extends Piece{
    //Atributos
    public Knight(Tile tile, PieceAlignment alignment){
        super(tile, alignment);
        type = PieceType.KNIGHT;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KNIGHT, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
