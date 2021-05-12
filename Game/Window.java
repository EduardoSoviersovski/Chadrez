package Game;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Board.Board;
import Draw.DrawGame;
import Piece.*;

public class Window extends JFrame implements MouseListener, MouseMotionListener{
    //Atributos
    private Board board;
    private JButton startButton;
    private JButton allPawnStartButton;
    private JButton randStartButton;
    private JButton loadButton;
    private JTextField jogador1;
    private JTextField jogador2;
    private ArrayList<JLabel> labels;
    private DrawGame dg;
    private ArrayList<Piece> pieces;
    private MoveManager mm;


    //Método construtor
    public Window(){
        //Inicialização dos atributos
        board = new Board();

        jogador1 = new JTextField("Jogador 1");
        jogador2 = new JTextField("Jogador 2");

        pieces = new ArrayList<Piece>();
        labels = new ArrayList<JLabel>();

        mm = new MoveManager(board, pieces);

        //definicao de action listener para startButton
        startButton = new JButton("New Game");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String j1 = jogador1.getText();
                String j2 = jogador2.getText();
                String s = "0 - 0";
                
                JLabel nome1 = new JLabel(j1);
                JLabel nome2 = new JLabel(j2);
                JLabel score = new JLabel(s);

                //adiciona labels com nomes escolhidos e placar
                labels.add(nome1);
                labels.add(nome2);
                labels.add(score);

                //esconde todos os botoes e espacos para nome
                startButton.setVisible(false);
                allPawnStartButton.setVisible(false);
                randStartButton.setVisible(false);
                loadButton.setVisible(false);
                jogador1.setVisible(false);
                jogador2.setVisible(false);

                //Posicionamento dos componentes
                nome1.setBounds(350, 10, 100, 30);
                nome2.setBounds(350, 290, 100, 30);
                score.setBounds(360, 165, 100, 30);

                newGame();
                dg.updateDpList(pieces);
                
                addLabels();
            }
        
        });

        allPawnStartButton = new JButton("All Pawn");
        allPawnStartButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String j1 = jogador1.getText();
                String j2 = jogador2.getText();
                String s = "0 - 0";
                
                JLabel nome1 = new JLabel(j1);
                JLabel nome2 = new JLabel(j2);
                JLabel score = new JLabel(s);

                //adiciona labels com nomes escolhidos e placar
                labels.add(nome1);
                labels.add(nome2);
                labels.add(score);

                //esconde todos os botoes e espacos para nome
                startButton.setVisible(false);
                allPawnStartButton.setVisible(false);
                randStartButton.setVisible(false);
                loadButton.setVisible(false);
                jogador1.setVisible(false);
                jogador2.setVisible(false);

                //Posicionamento dos componentes
                nome1.setBounds(350, 10, 100, 30);
                nome2.setBounds(350, 290, 100, 30);
                score.setBounds(360, 165, 100, 30);

                pawnNewGame();
                dg.updateDpList(pieces);
                
                addLabels();
            }
        
        });

        randStartButton = new JButton("Random");
        randStartButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String j1 = jogador1.getText();
                String j2 = jogador2.getText();
                String s = "0 - 0";
                
                JLabel nome1 = new JLabel(j1);
                JLabel nome2 = new JLabel(j2);
                JLabel score = new JLabel(s);

                //adiciona labels com nomes escolhidos e placar
                labels.add(nome1);
                labels.add(nome2);
                labels.add(score);

                //esconde todos os botoes e espacos para nome
                startButton.setVisible(false);
                allPawnStartButton.setVisible(false);
                randStartButton.setVisible(false);
                loadButton.setVisible(false);
                jogador1.setVisible(false);
                jogador2.setVisible(false);

                //Posicionamento dos componentes
                nome1.setBounds(350, 10, 100, 30);
                nome2.setBounds(350, 290, 100, 30);
                score.setBounds(360, 165, 100, 30);

                randNewGame();
                dg.updateDpList(pieces);
                
                addLabels();
            }
        
        });

        loadButton = new JButton("Load Game");
        loadButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                allPawnStartButton.setVisible(false);
                randStartButton.setVisible(false);
                loadButton.setVisible(false);
                jogador1.setVisible(false);
                jogador2.setVisible(false);
            }
        });

        addMouseListener(this);
        addMouseMotionListener(this);
        //Posicionamento dos componentes
        jogador1.setBounds(360, 50, 100, 30);
        jogador2.setBounds(360, 90, 100, 30);
        startButton.setBounds(360, 130, 99, 30);
        allPawnStartButton.setBounds(360, 170, 99, 30);
        randStartButton.setBounds(360, 210, 99, 30);
        loadButton.setBounds(360, 260, 99, 30);

        board.startBoard();
        
        //newGame();
        //pawnNewGame();
        //randNewGame();
        
        dg = new DrawGame(board.getDb(), pieces);
        setup();
    }

    //Método que seta todas as configurações da janela e adiciona os componentes a ela
    public void setup(){
        //Configuração da janela
        this.setTitle("Chádrez");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);

        //Adição dos componentes
        this.add(startButton);
        this.add(loadButton);
        this.add(allPawnStartButton);
        this.add(randStartButton);
        this.add(jogador1);
        this.add(jogador2);
        this.add(dg);
    }

    public void addLabels(){
        for(int i = 0; i < labels.size(); i++){
            this.add(labels.get(i));
            labels.get(i).setVisible(true);
        }

        this.setResizable(false);
        this.add(dg);
    }

    //Inicia um novo jogo, adicionando as peças a janela
    public void newGame(){
        for(int i = 0; i < 8; i++){
            if(i == 0 || i == 7){
                pieces.add(new Rook(board, board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Rook(board, board.getTile(i,7), PieceAlignment.WHITE));
                
            }
            else if(i == 1 || i == 6){
                pieces.add(new Knight(board, board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Knight(board, board.getTile(i,7), PieceAlignment.WHITE));
            }
            else if(i == 2 || i == 5){
                pieces.add(new Bishop(board, board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Bishop(board, board.getTile(i,7), PieceAlignment.WHITE));
            }
            else if(i == 3){
                pieces.add(new Queen(board, board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Queen(board, board.getTile(i,7), PieceAlignment.WHITE));
            }
            else if(i == 4){
                pieces.add(new King(board, board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new King(board, board.getTile(i,7), PieceAlignment.WHITE));
            }
            pieces.add(new Pawn(board, board.getTile(i,1), PieceAlignment.BLACK));
            pieces.add(new Pawn(board, board.getTile(i,6), PieceAlignment.WHITE));

        }
    }

    public void pawnNewGame(){
        for(int i = 0; i < 8; i++){
            if(i == 4){
                pieces.add(new King(board, board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new King(board, board.getTile(i,7), PieceAlignment.WHITE));
                pieces.add(new Pawn(board, board.getTile(i,1), PieceAlignment.BLACK));
                pieces.add(new Pawn(board, board.getTile(i,6), PieceAlignment.WHITE));
            }
            else{
                pieces.add(new Pawn(board, board.getTile(i,0), PieceAlignment.BLACK));
                pieces.add(new Pawn(board, board.getTile(i,7), PieceAlignment.WHITE));
                pieces.add(new Pawn(board, board.getTile(i,1), PieceAlignment.BLACK));
                pieces.add(new Pawn(board, board.getTile(i,6), PieceAlignment.WHITE));
            }
        }
    }

    public void randNewGame(){
        Random rand = new Random();
        int num;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 2; j++){
                if(i == 4 && j == 0){
                    pieces.add(new King(board, board.getTile(i,0), PieceAlignment.BLACK));
                    pieces.add(new King(board, board.getTile(i,7-j), PieceAlignment.WHITE));
                }
                else{
                    num = rand.nextInt(451);
                    if(num >= 0 && num <= 99){
                        pieces.add(new Pawn(board, board.getTile(i,j), PieceAlignment.BLACK));
                    }
                    else if(num >= 100 && num <= 199){
                        pieces.add(new Rook(board, board.getTile(i,j), PieceAlignment.BLACK));
                    }
                    else if(num >= 200 && num <= 299){
                        pieces.add(new Knight(board, board.getTile(i,j), PieceAlignment.BLACK));
                    }
                    else if(num >= 300 && num <= 399){
                        pieces.add(new Bishop(board, board.getTile(i,j), PieceAlignment.BLACK));
                    }
                    else if(num >= 400 && num <= 450){
                        pieces.add(new Queen(board, board.getTile(i,j), PieceAlignment.BLACK));
                    }

                    num = rand.nextInt(451);
                    if(num >= 0 && num <= 99){
                        pieces.add(new Pawn(board, board.getTile(i,7-j), PieceAlignment.WHITE));
                    }
                    else if(num >= 100 && num <= 199){
                        pieces.add(new Rook(board, board.getTile(i,7-j), PieceAlignment.WHITE));
                    }
                    else if(num >= 200 && num <= 299){
                        pieces.add(new Knight(board, board.getTile(i,7-j), PieceAlignment.WHITE));
                    }
                    else if(num >= 300 && num <= 399){
                        pieces.add(new Bishop(board, board.getTile(i,7-j), PieceAlignment.WHITE));
                    }
                    else if(num >= 400 && num <= 450){
                        pieces.add(new Queen(board, board.getTile(i,7-j), PieceAlignment.WHITE));
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mm.makeMove((e.getX()-20)/40, (e.getY()-40)/40);
        dg.updateDpList(pieces);
        repaint();
        revalidate();  
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }  

    @Override
    public void mouseEntered(MouseEvent e) {
       
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
