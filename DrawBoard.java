import java.awt.*;

public class DrawBoard extends Draw{
    DrawTile[][] dt;

    public DrawBoard(){
        dt = new DrawTile[8][8];
    }

    public void startDrawBoard(int x, int y, DrawTile dt){
        this.dt[x][y] = dt;

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                dt[i][j].paintComponent(g);
            }
        }
    }
}
