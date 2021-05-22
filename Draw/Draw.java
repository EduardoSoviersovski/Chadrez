package Draw;

import javax.swing.*;
import java.awt.*;

//definição generica de Draw
public class Draw extends JPanel {

    // Metodos
    public void drawing() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
