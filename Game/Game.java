package Game;

public class Game {
    private Window window;    

    public Game(){
        window = new Window();
    }

    public void startGame(){
        window.setVisible(true);
    }
}