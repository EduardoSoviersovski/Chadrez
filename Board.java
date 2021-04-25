public class Board{
    private Tile[][] tiles;
    private DrawBoard db;

    public Board(){
        tiles = new Tile[8][8];
        db = new DrawBoard();
    }

    public void startBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile(i, j);
                db.startDrawBoard(i, j, tiles[i][j].getDrawTile());
            }
        }
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public DrawBoard getDb(){
        return db;
    }

    public void draw(){
        db.drawing();
    }

}