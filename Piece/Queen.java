package Piece;
import Draw.DrawPiece;
import Board.Tile;

public class Queen extends Piece{
    //Atributos
    public Queen(Tile tile, PieceAlignment alignment){
        super(tile, alignment);
        type = PieceType.QUEEN;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.QUEEN, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
