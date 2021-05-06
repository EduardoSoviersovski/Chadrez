package Piece;
import Draw.DrawPiece;
import Board.*;

public class Bishop extends Piece{
    //Atributos
    public Bishop(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.BISHOP;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.BISHOP, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
