package Draw;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Piece.PieceType;
import Piece.PieceAlignment;

public class DrawPiece extends Draw {
    // Atributos
    private int x;
    private int y;
    private Image image;

    // Construtora
    public DrawPiece(int x, int y, PieceType type, PieceAlignment color) {
        this.x = x;
        this.y = y;

        try { // Leitura do arquivo da imagem
            image = ImageIO.read(new File("./Sprites/" + color + "/" + type + ".png"));
        } catch (IOException e) { // Pega o erro caso o endereço passado não seja o de uma imagem
            e.printStackTrace();
        }

        image = image.getScaledInstance(34, 34, Image.SCALE_DEFAULT);
    }

    // Metodos
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, x * 40 + 23, y * 40 + 23, this);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // retorna a imagem correspondente a peça
    public Image getImage() {
        return image;
    }
}
