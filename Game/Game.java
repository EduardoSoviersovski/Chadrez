package Game;

public class Game {
    // Atributos
    private Window window;

    // Construtora
    public Game() {
        window = new Window();
    }

    // Metodos

    // Inicia a Janela do jogo
    public void startGame() {
        window.setVisible(true);
    }
}