package Board;
import Draw.*;
import Piece.*;

public class Tile {
    private int x;
    private int y;
    private boolean isTileOccupied;
    private DrawTile dt;
    private Piece pieceInTile;
    private TileColor color;

    public Tile(int x, int y){
        this.x = x;
        this.y = y;

        isTileOccupied = false;

        if(x % 2 == 0){
            if(y % 2 == 0){
                this.color = TileColor.WHITE;
            }
            else{
                this.color = TileColor.GRAY;
            }
        }
        else{
            if(y % 2 == 0){
                this.color = TileColor.GRAY;
            }
            else{
                this.color = TileColor.WHITE;
            }
        }

        dt = new DrawTile(x, y, color);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean getIsTileOccupied(){
        return isTileOccupied;
    }

    public DrawTile getDt(){
        return dt;
    }

    public Piece getPieceInTile(){
        return pieceInTile;
    }

    public TileColor getColor(){
        return color;
    }

}
