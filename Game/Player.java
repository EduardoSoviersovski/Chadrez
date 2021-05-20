package Game;

public class Player {
    String name;
    int wins;

    public Player(String name, int wins){
        this.name = name;
        this.wins = wins;
    }

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
