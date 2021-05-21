package Game;

import Board.Board;
import Piece.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoadGameDocDAO implements LoadGameDAO{
    //Atributos
    private Board board;
    private ArrayList<Piece> pieces;
    private ArrayList<JLabel> labels;
    private GameFlowManager gfm;
    private String player1;
    private String player2;

    //Construtora
    public LoadGameDocDAO(Board board, GameFlowManager gfm, ArrayList<JLabel> labels, ArrayList<Piece> pieces,
        JTextField player1, JTextField player2){
        this.board = board;
        this.gfm = gfm;
        this.labels = labels;
        this.pieces = pieces;
        this.player1 = player1.getText();
        this.player2 = player2.getText(); 
    }

    //Metodos
    @Override
    public boolean loadGame(){
        //Se existir um ojgo salvo entre os jogadores
        try(FileReader fr = new FileReader("./SavedGames/" + player1 + "_" + player2 + ".doc")){
            int i;
            int x=0;
            int y=0;

            //Escreve o nome dos jogadores e as vitorias de cada um
            labels.get(0).setText(player1);
            labels.get(1).setText(player2);
            labels.get(2).setText("0 - 0");

            //Le o arquivo de texto letra por letra
            //Letras maiusculas sao pecas brancas e minusculas para pretas
            while((i = fr.read()) != -1){
                //Se a letra lida for 'r', insere uma Torre na posicao
                if((char)i == 'r'){
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                //Se for 'n', insere um Cavalo na posicao
                else if((char)i == 'n'){
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                //Se for 'b', insere um Bispo na posicao
                else if((char)i == 'b'){
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                //Se for 'q', insere uma Dama na posicao
                else if((char)i == 'q'){
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                //Se for 'k', insere o Rei na posição
                else if((char)i == 'k'){
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                //Se for 'p', insere um peao na posicao
                else if((char)i == 'p'){
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.BLACK));
                }
                //Se for 'R', insere uma torre na posicao
                else if((char)i == 'R'){
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                //Se for 'N', insere um Cavalo na posicao
                else if((char)i == 'N'){
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                //Se for 'B', insere um Bispo na posicao
                else if((char)i == 'B'){
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                //Se for 'Q', insere uma Dama na posicao
                else if((char)i == 'Q'){
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                //Se for 'K', insere um Rei na posicao
                else if((char)i == 'K'){
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.WHITE));
                }
                //Se for 'P', insere um peao na posicao
                else if((char)i == 'P'){
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.WHITE));
                }

                //Se for 'w', inicia o valor de turno como WHITE
                else if((char)i == 'w'){
                    gfm.setWhiteTurn();
                }
                //Se for 'd', inicia o valor de turno como BLACK
                else if((char)i == 'd'){
                    gfm.setBlackTurn();
                }
            
                //Para cada numero, pula a quantidade de casas correspondente -1
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
                //Se o contador for menos que 7, soma 1
                if(x < 7){
                    x++;
                }

                //Se for '/', zera o contador de x e soma 1 ao o de y
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