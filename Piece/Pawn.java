package Piece;
import Draw.DrawPiece;
import Board.Tile;

public class Pawn extends Piece{
    //Atributos
    public Pawn(Tile tile, PieceAlignment alignment){
        this.tile = tile;
        this.alignment = alignment;
        type = PieceType.PAWN;

        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.PAWN, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
}
