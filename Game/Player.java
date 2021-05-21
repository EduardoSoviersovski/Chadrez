package Game;

public class Player {
    //Atributos
    String name;
    int wins;

    //Construtora
    public Player(String name, int wins){
        this.name = name;
        this.wins = wins;
    }

    //Metodos

    //Acrescenta a vitoria do jogador em 1;
    public void updateWins(){
        wins++;
    }
    
    public String getName(){
        return name;
    }

    public int getWins(){
        return wins;
    }
}
