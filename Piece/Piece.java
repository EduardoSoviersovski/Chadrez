package Piece;
import Board.*;
import Draw.DrawPiece;

public abstract class Piece {
    protected Board board;
    protected Tile tile;
    protected PieceType type;
    protected PieceAlignment alignment;
    protected DrawPiece dp;

    public Piece(Board board, Tile tile, PieceAlignment alignment){
        this.board = board;
        this.tile = tile;
        this.alignment = alignment;

        this.tile.setPieceInTile(this);
    }

    public void move(int x, int y){
        tile.reset();
        tile = board.getTile(x, y);
        dp.setX(x);
        dp.setY(y);
    }
    //public abstract void capture();
    //public abstract void possibleMoves();
    
    public abstract DrawPiece getDp();
}
