package Board;
import Draw.DrawBoard;

public class Board{
    //Atributos
    private Tile[][] tiles;
    private DrawBoard db;

    //Contrutora
    public Board(){
        tiles = new Tile[8][8];
        db = new DrawBoard();
    }
    
    //Metodos

    //Inicia e o tabuleiro com uma matriz de 8x8 Tiles
    //e chama a classe que desenha
    public void startBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile(i, j);
                db.startDrawBoard(i, j, tiles[i][j].getDt());
            }
        }
    }

    //Retorna o tile nas coordenadas (x,y)
    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public DrawBoard getDb(){
        return db;
    }

}