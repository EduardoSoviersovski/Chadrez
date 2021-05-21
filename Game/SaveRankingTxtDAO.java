package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class SaveRankingTxtDAO {
    //Atributos
    private Player whitePlayer;
    private Player blackPlayer;

    //Construtora
    public SaveRankingTxtDAO(Player blackPlayer, Player whitePlayer){
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    //Metodos
    //Se for um jogador novo, adicona a lista de jogadores
    public void createPlayerList(){
        try(BufferedWriter out = new BufferedWriter(new FileWriter("./Ranking/Players.txt", true))) {
            boolean blackPlayerFound;
            boolean whitePlayerFound;

            blackPlayerFound = isNewPlayer(blackPlayer);
            whitePlayerFound = isNewPlayer(whitePlayer);

            if(!blackPlayerFound){
                out.append(blackPlayer.getName() + "\n");
                newPlayer(blackPlayer);
            }
            if(!whitePlayerFound){
                out.append(whitePlayer.getName() + "\n");
                newPlayer(whitePlayer);
            }
        } catch (IOException e1) {
            System.err.println("Error occurred");
            //e1.printStackTrace();
        }
    }

    //Adiciona um jogador novo a lista de jogadores com suas pontuacoes
    public void newPlayer(Player newPlayer){
        try(BufferedWriter out = new BufferedWriter(new FileWriter("./Ranking/Ranking.txt", true))) {
            try{
                BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.txt"));
                out.append(newPlayer.getName() + " - " + newPlayer.getWins() + "\n");
                buffer.close();
            } catch (IOException e1) {
                System.err.println("Error occurred");
                //e1.printStackTrace();
            }
        } catch (IOException e1) {
            System.err.println("Error occurred");
            //e1.printStackTrace();
        }
    }

    //Retorna true se o jogodor nao estiver presente na lista de jogadores
    public boolean isNewPlayer(Player player){
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Players.txt"));
            String line;
            while((line = buffer.readLine()) != null){
                if(line.equals(player.getName())){
                    buffer.close();
                    return true;
                }
            }
            buffer.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            //e1.printStackTrace();
        }
        return false;
    }
}
