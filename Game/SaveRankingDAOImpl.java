package Game;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JLabel;

public class SaveRankingDAOImpl {
    private String nameBlack;
    private String nameWhite;
    private int winBlack;
    private int winWhite;

    public SaveRankingDAOImpl(ArrayList<JLabel> labels){
        this.nameBlack = labels.get(0).getText();
        this.nameWhite = labels.get(1).getText();
    }

    public void createRanking(){
        try(PrintWriter out = new PrintWriter(new FileWriter("Ranking.txt"))) {
            out.append("\n" + nameBlack + " - " + winBlack);
            out.append("\n" + nameWhite + " - " + winWhite);
        } catch (IOException e1) {
            System.err.println("Error occurred");
            e1.printStackTrace();
        }
    }
}
