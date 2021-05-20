package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
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
        try(BufferedWriter out = new BufferedWriter(new FileWriter("Players.txt", true))) {
            String line;
            int i = 0;
            BufferedReader buffer = new BufferedReader(new FileReader("Players.txt"));
            while((line = buffer.readLine()) != null && !line.equals(nameBlack)){
                
            }
            //out.append("\n" + nameBlack + " - " + winBlack);
            //out.append("\n" + nameWhite + " - " + winWhite);

            buffer.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            //e1.printStackTrace();
        }
    }
}
