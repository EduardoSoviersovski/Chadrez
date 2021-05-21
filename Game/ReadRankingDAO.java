package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadRankingDAO {

    public ReadRankingDAO(){
    }
    
    public void readRankingFile(Player blackPlayer, Player whitePlayer){
        try(BufferedReader reader = new BufferedReader(new FileReader("./Ranking/Ranking.txt"))){
            if(isNewPlayer(blackPlayer)){
                readWins(blackPlayer);
            }
            if(isNewPlayer(whitePlayer)){
                readWins(whitePlayer);
            }

        }catch(IOException e){
            System.err.println("Error occurred!");
        }
    }

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

    public void readWins(Player player){
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.txt"));
            String line;
            while((line = buffer.readLine()) != null){
                if(line.split("-")[0].equals(player.getName())){
                    player.setWins(Integer.parseInt(line.split("-")[1]));
                }
                    
            }
            buffer.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            //e1.printStackTrace();
        }
    }
}
