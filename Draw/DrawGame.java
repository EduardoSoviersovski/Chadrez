package Draw;
import java.awt.Graphics;
import java.util.ArrayList;
import Piece.Piece;

public class DrawGame extends Draw{
    //Atributos
    private DrawBoard db;
    private ArrayList<DrawPiece> listDp;

    //Construtora/
    public DrawGame(DrawBoard db, ArrayList<Piece> listPiece){
        this.db = db;

        listDp = new ArrayList<DrawPiece>();
        for(int i = 0; i < listPiece.size(); i++){
            listDp.add(listPiece.get(i).getDp());
        }
    }

    //Métodos
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        db.paintComponent(g);
        for(int i = 0; i < listDp.size(); i++){
            listDp.get(i).paintComponent(g);
        }
    }
}
