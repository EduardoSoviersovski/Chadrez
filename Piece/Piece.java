package Piece;
import Board.Tile;
import Draw.DrawPiece;

public abstract class Piece {
    protected Tile tile;
    protected PieceType type;
    protected PieceAlignment alignment;
    protected DrawPiece dp;

    public Piece(Tile tile, PieceAlignment alignment){
        this.tile = tile;
        this.alignment = alignment;
    }

    //public abstract void move(int deltaX, int deltaY);
    //public abstract void capture();
    //public abstract void possibleMoves();
    
    public abstract DrawPiece getDp();
}
