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
    protected boolean clicked;
    protected ArrayList <Tile> possibleMoves;

    public Piece(Board board, Tile tile, PieceAlignment alignment){
        this.board = board;
        this.tile = tile;
        this.alignment = alignment;

        clicked = false;

        this.tile.setPieceInTile(this);
    }

    public void move(int x, int y){
        
        if(!board.getTile(x, y).getIsTileOccupied()){
            tile.reset();
            tile = board.getTile(x, y);
            dp.setX(x);
            dp.setY(y);
            board.getTile(x, y).setPieceInTile(this);
        }
    }
    //public abstract void capture();
    public abstract void setPossibleMoves();

    public abstract ArrayList<Tile> getPossibleMoves();
    
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

    public Tile getTile(){
        return tile;
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
