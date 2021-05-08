package Piece;
import Board.*;
import Draw.DrawPiece;
import java.util.ArrayList;

public abstract class Piece {
    protected Board board;
    protected Tile tile;
    protected PieceType type;
    protected PieceAlignment alignment;
    protected DrawPiece dp;
    protected boolean clicked = false;

    public Piece(Board board, Tile tile, PieceAlignment alignment){
        this.board = board;
        this.tile = tile;
        this.alignment = alignment;

        this.tile.setPieceInTile(this);
    }

    public void move(int x, int y, int deltaX, int deltaY){
        if(!board.getTile(deltaX,deltaY).getIsTileOccupied()){
            tile.reset();
            tile = board.getTile(deltaX, deltaY);
            dp.setX(deltaX);
            dp.setY(deltaY);
            board.getTile(deltaX, deltaY).setPieceInTile(this);
        }
    }
    //public abstract void capture();
    public abstract ArrayList<Tile> possibleMoves();
    
    public abstract DrawPiece getDp();

    public PieceType getPieceType(){
        return this.type;
    }

    public PieceAlignment getPieceAlignment(){
        return this.alignment;
    }
    public boolean getClicked(){
        return clicked;
    }

    public int getX(){
        return tile.getX();
    }

    public int getY(){
        return tile.getY();
    }

    public void setClicked(boolean b){
        this.clicked = b;
    }
}
