package Piece;
import Draw.DrawPiece;
import Board.*;

public class Queen extends Piece{
    //Atributos
    public Queen(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.QUEEN;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.QUEEN, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
