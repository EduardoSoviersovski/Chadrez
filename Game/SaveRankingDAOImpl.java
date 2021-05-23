package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

public class SaveRankingDAOImpl implements SaveRankingDAO{
    // Atributos
    private Player whitePlayer;
    private Player blackPlayer;

    // Construtora
    public SaveRankingDAOImpl(Player blackPlayer, Player whitePlayer) {
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
    }

    // Metodos
    // Se for um jogador novo, adicona a lista de jogadores
    @Override
    public void createPlayerListTxt() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("./Ranking/Players.txt", true))) {
            boolean blackPlayerFound;
            boolean whitePlayerFound;

            blackPlayerFound = isNewPlayerTxt(blackPlayer);
            whitePlayerFound = isNewPlayerTxt(whitePlayer);

            if (!blackPlayerFound) {
                out.append(blackPlayer.getName() + "\n");
                newPlayerTxt(blackPlayer);
            }
            if (!whitePlayerFound) {
                out.append(whitePlayer.getName() + "\n");
                newPlayerTxt(whitePlayer);
            }
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
    }

    // Adiciona um jogador novo a lista de jogadores com suas pontuacoes
    @Override
    public void newPlayerTxt(Player newPlayer) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("./Ranking/Ranking.txt", true))) {
            try {
                BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.txt"));
                out.append(newPlayer.getName() + "-" + newPlayer.getWins() + "\n");
                buffer.close();
            } catch (IOException e1) {
                System.err.println("Error occurred");
                // e1.printStackTrace();
            }
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
    }

    // Retorna true se o jogodor nao estiver presente na lista de jogadores
    @Override
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

    @Override
    public void updateRankingTxt(String name, int wins) {
        try {
            Path path = Paths.get("./Ranking/Ranking.txt");
            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(path));

            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).equals(name + "-" + wins)) {
                    fileContent.set(i, name + "-" + String.valueOf(wins + 1));
                    break;
                }
            }

            fileContent = orderRanking(fileContent);
            Files.write(path, fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error occurred!");
        }

    }

    @Override
    public void createPlayerListDoc() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("./Ranking/Players.doc", true))) {
            boolean blackPlayerFound;
            boolean whitePlayerFound;

            blackPlayerFound = isNewPlayerDoc(blackPlayer);
            whitePlayerFound = isNewPlayerDoc(whitePlayer);

            if (!blackPlayerFound) {
                out.append(blackPlayer.getName() + "\n");
                newPlayerDoc(blackPlayer);
            }
            if (!whitePlayerFound) {
                out.append(whitePlayer.getName() + "\n");
                newPlayerDoc(whitePlayer);
            }
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
    }

    // Adiciona um jogador novo a lista de jogadores com suas pontuacoes
    @Override
    public void newPlayerDoc(Player newPlayer) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter("./Ranking/Ranking.doc", true))) {
            try {
                BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Ranking.doc"));
                out.append(newPlayer.getName() + "-" + newPlayer.getWins() + "\n");
                buffer.close();
            } catch (IOException e1) {
                System.err.println("Error occurred");
                // e1.printStackTrace();
            }
        } catch (IOException e1) {
            System.err.println("Error occurred");
            // e1.printStackTrace();
        }
    }

    // Retorna true se o jogodor nao estiver presente na lista de jogadores
    @Override
    public boolean isNewPlayerDoc(Player player) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("./Ranking/Players.doc"));
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

    @Override
    public void updateRankingDoc(String name, int wins) {
        try {
            Path path = Paths.get("./Ranking/Ranking.doc");
            ArrayList<String> fileContent = new ArrayList<>(Files.readAllLines(path));

            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).equals(name + "-" + wins)) {
                    fileContent.set(i, name + "-" + String.valueOf(wins + 1));
                    break;
                }
            }

            fileContent = orderRanking(fileContent);
            Files.write(path, fileContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error occurred!");
        }

    }

    @Override
    public ArrayList<String> orderRanking(ArrayList<String> file) {
        ArrayList<Integer> organizedWins = new ArrayList<Integer>();

        for (int i = 0; i < file.size(); i++) {
            organizedWins.add(Integer.parseInt(file.get(i).split("-")[1]));
        }

        // Insertion sort para organizar as listas
        for (int i = 1; i < organizedWins.size(); i++) {
            int key = organizedWins.get(i);
            String stringKey = file.get(i);
            int j = i - 1;
            while ((j > -1) && (organizedWins.get(j) < key)) {
                organizedWins.set(j + 1, organizedWins.get(j));
                file.set(j + 1, file.get(j));
                j--;
            }
            organizedWins.set(j + 1, key);
            file.set(j + 1, stringKey);
        }

        return file;
    }
}
