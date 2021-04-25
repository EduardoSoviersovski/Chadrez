public class Tile {
    private int x;
    private int y;
    private boolean isTileOccupied;
    private DrawTile dt;
    //private Piece pieceInTile;

    public Tile(int x, int y){
        this.x = x;
        this.y = y;
        isTileOccupied = false;
        dt = new DrawTile(x, y);
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

    public DrawTile getDrawTile(){
        return dt;
    }

}
