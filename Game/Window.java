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
    private JButton surrenderBlack;
    private JButton surrenderWhite;
    private JButton saveButton;
    private JTextField player1;
    private JTextField player2;
    private ArrayList<JLabel> labels;
    private DrawGame dg;
    private ArrayList<Piece> pieces;
    private MoveManager mm;
    private GameFlowManager gfm;
    private SaveGameDAO saveGame;
    private LoadGameDAO loadGame;

    //Método construtor
    public Window(){
        //Inicialização dos atributos
        board = new Board();
        gfm = new GameFlowManager();

        player1 = new JTextField("Jogador1");
        player2 = new JTextField("Jogador2");

        pieces = new ArrayList<Piece>();
        labels = new ArrayList<JLabel>();

        mm = new MoveManager(board, pieces, gfm);

        labels.add(new JLabel(""));
        labels.add(new JLabel(""));
        labels.add(new JLabel(""));

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                saveGame = new SaveGameDAOImpl(board, gfm, labels);
                saveGame.setSave();
                saveGame.createSave();
            }
        });

        surrenderBlack = new JButton("Surrender");
        surrenderBlack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                while(!pieces.isEmpty()){
                    pieces.remove(0);
                }
                gfm.setWhiteTurn();
                board.startBoard();
                dg.updateDpList(pieces);

                // saveRanking.createRanking();
                showMenu();
                hideLabels();
                repaint();
                revalidate(); 
            }
        });
        surrenderWhite = new JButton("Surrender");
        surrenderWhite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                while(!pieces.isEmpty()){
                    pieces.remove(0);
                }
                gfm.setWhiteTurn();
                board.startBoard();
                dg.updateDpList(pieces);

                showMenu();
                hideLabels();
                repaint();
                revalidate(); 
            }
        });
        //definicao de action listener para startButton
        startButton = new JButton("New Game");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String name1 = player1.getText();
                String name2 = player2.getText();
                labels.get(0).setText(name1);
                labels.get(1).setText(name2);
                labels.get(2).setText("0 - 0");
                //esconde todos os botoes e espacos para nome
                hideMenu();
                showLabels();
                newGame();
                dg.updateDpList(pieces);
                repaint();
                revalidate(); 
            }
        
        });

        allPawnStartButton = new JButton("All Pawn");
        allPawnStartButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                labels.get(0).setText(player1.getText());
                labels.get(1).setText(player2.getText());
                labels.get(2).setText("0 - 0");

                //esconde todos os botoes e espacos para nome
                hideMenu();
                showLabels();
                pawnNewGame();
                dg.updateDpList(pieces);
                repaint();
                revalidate(); 
            }
        
        });

        randStartButton = new JButton("Random");
        randStartButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                labels.get(0).setText(player1.getText());
                labels.get(1).setText(player2.getText());
                labels.get(2).setText("0 - 0");

                //esconde todos os botoes e espacos para nome
                hideMenu();
                showLabels();
                randNewGame();
                dg.updateDpList(pieces);
                repaint();
                revalidate(); 
            }
        
        });

        loadButton = new JButton("Load Game");
        loadButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                dg.updateDpList(pieces);
                
                loadGame = new LoadGameDAOImpl(board, gfm, labels, pieces, player1, player2);

                loadGame.loadGame();;
                hideMenu();
                showLabels();
                repaint();
                revalidate();
            }
        });

        addMouseListener(this);
        addMouseMotionListener(this);
        //Posicionamento dos componentes
        player1.setBounds(360, 50, 100, 30);
        player2.setBounds(360, 90, 100, 30);
        startButton.setBounds(360, 130, 99, 30);
        allPawnStartButton.setBounds(360, 170, 99, 30);
        randStartButton.setBounds(360, 210, 99, 30);
        loadButton.setBounds(360, 260, 99, 30);
        surrenderBlack.setBounds(360, 40, 99, 30);
        surrenderWhite.setBounds(360, 320, 99, 30);
        saveButton.setBounds(390, 165, 80, 30);        
        labels.get(0).setBounds(350, 10, 100, 30);
        labels.get(1).setBounds(350, 290, 100, 30);
        labels.get(2).setBounds(360, 165, 100, 30);



        surrenderBlack.setVisible(false);
        surrenderWhite.setVisible(false);
        saveButton.setVisible(false);

        board.startBoard();
        
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
        this.add(player1);
        this.add(player2);
        this.add(surrenderBlack);
        this.add(surrenderWhite);
        this.add(saveButton);
        for(int i = 0; i < labels.size(); i++){
            this.add(labels.get(i));
        }
        this.add(dg);
    }

    public void hideLabels(){
        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setVisible(false);
        }
    }

    public void showLabels(){
        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setVisible(true);
        }
    }
    
    public void hideMenu(){
        startButton.setVisible(false);
        allPawnStartButton.setVisible(false);
        randStartButton.setVisible(false);
        loadButton.setVisible(false);
        player1.setVisible(false);
        player2.setVisible(false);
        saveButton.setVisible(false);

        surrenderBlack.setVisible(true);
        surrenderWhite.setVisible(true);
        saveButton.setVisible(true);
    }

    public void showMenu(){
        startButton.setVisible(true);
        allPawnStartButton.setVisible(true);
        randStartButton.setVisible(true);
        loadButton.setVisible(true);
        player1.setVisible(true);
        player2.setVisible(true);

        surrenderBlack.setVisible(false);
        surrenderWhite.setVisible(false);
        saveButton.setVisible(false);
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
    public void mousePressed(MouseEvent e) {
        mm.makeMove((e.getX()-20)/40, (e.getY()-40)/40);
        dg.updateDpList(pieces);
        repaint();
        revalidate();  
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}  
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
