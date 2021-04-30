package Draw;
import Board.TileColor;
import java.awt.*;

public class DrawTile extends Draw{
    private int x;
    private int y;
    private TileColor color;

    public DrawTile(int x, int y, TileColor color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(color == TileColor.DARK){
            g.setColor(Color.getHSBColor((float)20.5, (float)0.5, (float)0.5));
            g.fillRect(x * 40 + 20, y * 40 + 20, 40, 40);
        }

        else if(color == TileColor.LIGHT){
            g.setColor(Color.WHITE);
            g.fillRect(x * 40 + 20, y * 40 + 20, 40, 40);
        }
    }
}
