package Game;
import java.util.ArrayList;
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

        labels = new ArrayList<JLabel>();

        mm = new MoveManager(board);

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
                loadButton.setVisible(false);
                jogador1.setVisible(false);
                jogador2.setVisible(false);

                //Posicionamento dos componentes
                nome1.setBounds(350, 10, 100, 30);
                nome2.setBounds(350, 290, 100, 30);
                score.setBounds(360, 165, 100, 30);

                //newGame();
                
                addLabels();
                setup();
            }
        
        });

        loadButton = new JButton("Load Game");
        loadButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
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
        loadButton.setBounds(360, 180, 99, 30);

        board.startBoard();

        pieces = new ArrayList<Piece>();
        

        
        newGame();
        
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
        this.add(jogador1);
        this.add(jogador2);
        this.add(dg);
    }

    public void addLabels(){
        //Configuração da janela
        this.setTitle("Chádrez");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);

        //Adição dos componentes
        this.add(startButton);
        this.add(loadButton);
        this.add(jogador1);
        this.add(jogador2);
        this.add(dg);

        for(int i = 0; i < labels.size(); i++){
            this.add(labels.get(i));
        }
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

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mm.makeMove((e.getX()-20)/40, (e.getY()-40)/40);
        
        //System.out.println(board.getTile(x, y).getPieceInTile().getPieceType());  
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
