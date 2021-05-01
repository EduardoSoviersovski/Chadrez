package Piece;
import Draw.DrawPiece;
import Board.Tile;

public class Bishop extends Piece{
    //Atributos
    public Bishop(Tile tile, PieceAlignment alignment){
        super(tile, alignment);
        type = PieceType.BISHOP;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.BISHOP, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
