package Piece;
import Draw.DrawPiece;
import Board.*;

public class Knight extends Piece{
    //Atributos
    public Knight(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.KNIGHT;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KNIGHT, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
