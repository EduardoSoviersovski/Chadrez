import javax.swing.*;
import Board.*;

public class Game {
    JFrame window;
    Board board;

    public Game(){
        window = new JFrame();
        board = new Board();
        board.startBoard();

        setup();
    }

    public void startGame(){
        window.setVisible(true);
    }

    public void setup(){
        window.setSize(600, 400);
        window.setDefaultCloseOperation(3);
        window.add(board.getDb());
    }
}
