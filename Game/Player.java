package Game;

public class Player {
    //Atributos
    private String name;
    private int wins;
    private int rankingLine;

    //Construtora
    public Player(String name){
        this.name = name;
        wins = 0;
        rankingLine = 0;
    }

    //Metodos

    //Acrescenta a vitoria do jogador em 1;
    public void updateWins(){
        wins++;
    }
    

    public void setWins(int wins){
        this.wins = wins;
    }

    public void setRankingLine(int line){
        rankingLine = line;
    }

    public String getName(){
        return name;
    }

    public int getWins(){
        return wins;
    }

    public int getRankingLine(){
        return rankingLine;
    }
}
