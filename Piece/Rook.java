package Piece;
import Draw.DrawPiece;
import Board.*;

public class Rook extends Piece{
    //Atributos
    public Rook(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.ROOK;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.ROOK, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
