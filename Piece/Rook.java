package Piece;
import Draw.DrawPiece;
import Board.Tile;

public class Rook extends Piece{
    //Atributos
    public Rook(Tile tile, PieceAlignment alignment){
        super(tile, alignment);
        type = PieceType.ROOK;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.ROOK, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
