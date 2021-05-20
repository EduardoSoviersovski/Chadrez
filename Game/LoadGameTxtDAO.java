package Game;

import Board.Board;
import Piece.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoadGameTxtDAO implements LoadGameDAO{
    private Board board;
    private ArrayList<Piece> pieces;
    private ArrayList<JLabel> labels;
    private GameFlowManager gfm;
    private String player1;
    private String player2;

    public LoadGameTxtDAO(Board board, GameFlowManager gfm, ArrayList<JLabel> labels, ArrayList<Piece> pieces,
        JTextField player1, JTextField player2, JTextField promote, JButton promoteButton){
        this.board = board;
        this.gfm = gfm;
        this.labels = labels;
        this.pieces = pieces;
        this.player1 = player1.getText();
        this.player2 = player2.getText();
    }
    @Override
    public boolean loadGame(){
        try(FileReader fr = new FileReader("./SavedGames/" + player1 + "_" + player2 + ".txt")){
            int i;
            int x=0;
            int y=0;

            labels.get(0).setText(player1);
            labels.get(1).setText(player2);
            labels.get(2).setText("0 - 0");

            while((i = fr.read()) != -1){
                if((char)i == 'r'){
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                else if((char)i == 'n'){
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                else if((char)i == 'b'){
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                else if((char)i == 'q'){
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                else if((char)i == 'k'){
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                else if((char)i == 'p'){
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.BLACK));
                }

                else if((char)i == 'R'){
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                else if((char)i == 'N'){
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                else if((char)i == 'B'){
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                else if((char)i == 'Q'){
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                else if((char)i == 'K'){
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                else if((char)i == 'P'){
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.WHITE));
                }

                else if((char)i == 'w'){
                    gfm.setWhiteTurn();
                }
                else if((char)i == 'd'){
                    gfm.setBlackTurn();
                }
            
                else if((char)i == '2'){
                    x = x+1;
                }
                else if((char)i == '3'){
                    x = x+2;
                }
                else if((char)i == '4'){
                    x = x+3;
                }
                else if((char)i == '5'){
                    x = x+4;
                }
                else if((char)i == '6'){
                    x = x+5;
                }
                else if((char)i == '7'){
                    x = x+6;
                }
                else if((char)i == '8'){
                    x = x+7;
                }
                if(x < 7){
                    x++;
                }

                if((char)i == '/'){
                    y++;
                    x=0;
                }
            }
            return true;
        } catch (IOException e1){
            System.err.println("Não há um jogo salvo com esses jogadores.");
            //e1.printStackTrace();
            return false;
        }
    }
}
