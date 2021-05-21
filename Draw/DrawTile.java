package Draw;
import Board.TileColor;
import java.awt.*;

public class DrawTile extends Draw{
    //Atributos
    private int x;
    private int y;
    private TileColor color;

    //Construtora
    public DrawTile(int x, int y, TileColor color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    //Metodos
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        //Define a cor das casas escuras
        if(color == TileColor.DARK){
            g.setColor(Color.getHSBColor((float)20.5, (float)0.5, (float)0.5));
            g.fillRect(x * 40 + 20, y * 40 + 20, 40, 40);
        }

        //Define a cor das casas claras
        else if(color == TileColor.LIGHT){
            g.setColor(Color.getHSBColor((float)0, (float)0, (float)0.84));
            g.fillRect(x * 40 + 20, y * 40 + 20, 40, 40);
        }
    }
}
