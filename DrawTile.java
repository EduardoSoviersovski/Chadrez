import java.awt.*;

public class DrawTile extends Draw{
    private int x;
    private int y;

    public DrawTile(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawRect(x * 40 + 20, y * 40 + 20, 40, 40);
    }
}
