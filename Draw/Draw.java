package Draw;
import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel{
    public void drawing(){
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
