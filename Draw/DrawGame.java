package Draw;
import java.awt.Graphics;
import java.util.Vector;
import Piece.Piece;

public class DrawGame extends Draw{
    //Atributos
    private DrawBoard db;
    private Vector<DrawPiece> vectorDp;

    //Construtora/
    public DrawGame(DrawBoard db, Vector<Piece> vectorPiece){
        this.db = db;

        vectorDp = new Vector<DrawPiece>();
        for(int i = 0; i < vectorPiece.size(); i++){
            vectorDp.add(vectorPiece.get(i).getDp());
        }
    }

    //Métodos
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        db.paintComponent(g);
        for(int i = 0; i < vectorDp.size(); i++){
            vectorDp.get(i).paintComponent(g);
        }
    }
}
