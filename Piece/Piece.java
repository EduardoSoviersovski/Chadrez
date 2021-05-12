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
    protected ArrayList <Tile> possibleMoves;

    public Piece(Board board, Tile tile, PieceAlignment alignment){
        this.board = board;
        this.tile = tile;
        this.alignment = alignment;

        this.tile.setPieceInTile(this);
    }

    public void move(int x, int y, ArrayList<Piece> pieces){
        if(!board.getTile(x, y).getIsTileOccupied()){
            tile.reset();
            tile = board.getTile(x, y);
            dp.setX(x);
            dp.setY(y);
            board.getTile(x, y).setPieceInTile(this);
            System.out.println("Peça movida");
        }
        else{
            if(board.getTile(x, y).getPieceInTile().getPieceAlignment() == alignment){
                System.out.println("Peca aliada");
                return;
            }
            capture(x, y, pieces);
        }
    }
    public void capture(int x, int y, ArrayList<Piece> pieces){
        //board.getTile(x, y).getPieceInTile().pieceGotCaptured();
        pieces.remove(board.getTile(x, y).getPieceInTile());
        tile.reset();
        tile = board.getTile(x, y);
        tile.reset();
        dp.setX(x);
        dp.setY(y);
        board.getTile(x, y).setPieceInTile(this);
        System.out.println("Peca capturada");
    }

    public abstract void setPossibleMoves();

    public abstract ArrayList<Tile> getPossibleMoves();
    
    public abstract DrawPiece getDp();

    public PieceType getPieceType(){
        return this.type;
    }

    public PieceAlignment getPieceAlignment(){
        return this.alignment;
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
}
