package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadRankingDAOImpl implements ReadRankingDAO {
    // Tenta criar ou atualizar um documento de texto com o nome dos jogadores e
    // retorna true se conseguir
    public boolean isNewPlayerTxt(Player player) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Players.txt"));
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.equals(player.getName())) {
                    buffer.close();
                    return true;
                }
            }
            buffer.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
        return false;
    }

    // Salva a ordem das pontuacoes em uma string
    public void readWinsTxt(Player player) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.txt"));
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.split("-")[0].equals(player.getName())) {
                    player.setWins(Integer.parseInt(line.split("-")[1]));
                }

            }
            buffer.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
    }

    // Salva a ordem dos nomes e pontuacoes em uma string e retorna
    public String readRankingTxt() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.txt"))) {
            String line;
            StringBuilder ranking = new StringBuilder();

            while ((line = buffer.readLine()) != null) {
                ranking.append(line + "\n");
            }

            return ranking.toString();
        } catch (IOException e) {
            System.err.println("Error occurred!");
            return "";
        }
    }

    // Verifica se algum dos jogadores é um jogador novo
    public void readRankingTxtFile(Player blackPlayer, Player whitePlayer) {
        if (isNewPlayerTxt(blackPlayer)) {
            readWinsTxt(blackPlayer);
        }
        if (isNewPlayerTxt(whitePlayer)) {
            readWinsTxt(whitePlayer);
        }
    }

    public boolean isNewPlayerDoc(Player player) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Players.Doc"));
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.equals(player.getName())) {
                    buffer.close();
                    return true;
                }
            }
            buffer.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
        return false;
    }

    public void readWinsDoc(Player player) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.Doc"));
            String line;
            while ((line = buffer.readLine()) != null) {
                if (line.split("-")[0].equals(player.getName())) {
                    player.setWins(Integer.parseInt(line.split("-")[1]));
                }

            }
            buffer.close();
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
    }

    public String readRankingDoc() {
        try (BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.Doc"))) {
            String line;
            StringBuilder ranking = new StringBuilder();

            while ((line = buffer.readLine()) != null) {
                ranking.append(line + "\n");
            }

            return ranking.toString();
        } catch (IOException e) {
            System.err.println("Error occurred!");
            return "";
        }
    }

    public void readRankingDocFile(Player blackPlayer, Player whitePlayer) {
        if (isNewPlayerDoc(blackPlayer)) {
            readWinsDoc(blackPlayer);
        }
        if (isNewPlayerDoc(whitePlayer)) {
            readWinsDoc(whitePlayer);
        }
    }
}
