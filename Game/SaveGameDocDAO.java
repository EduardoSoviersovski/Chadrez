package Game;

import Board.Board;
import Piece.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JLabel;


public class SaveGameDocDAO implements SaveGameDAO{
    //Atributos
    private Board board;
    private GameFlowManager gfm;
    private String save = "";
    private String nameBlack;
    private String nameWhite;

    //Construtora
    public SaveGameDocDAO(Board board, GameFlowManager gfm, ArrayList<JLabel> labels){
        this.board = board;
        this.gfm = gfm;
        this.nameBlack = labels.get(0).getText();
        this.nameWhite = labels.get(1).getText();
    }

    //Metodos

    //Salva o jogo na notacao FEN
    @Override
    public void setSave(){
        int cont = 0;
        //Para todas as casas do tabuleiro, verifica se possui uma peca ou nao
        //se possuir, adiciona a uma string a quantidade de casas vazias antes dele
        //e seu caracter correspondente e zera o contador de casas vazias.
        for(int j = 0; j < 8; j++){
            for(int i = 0; i < 8; i++){
                if(board.getTile(i, j).getIsTileOccupied()){
                    if(board.getTile(i, j).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK){
                        if(cont != 0){
                            save = save + cont;
                            cont = 0;
                        }
                        if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.BISHOP){
                            save = save + "b";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KNIGHT){
                            save = save + "n";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.ROOK){
                            save = save + "r";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.PAWN){
                            save = save + "p";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.QUEEN){
                            save = save + "q";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KING){
                            save = save + "k";
                        }
                    }
                    else{
                        if(cont != 0){
                            save = save + cont;
                            cont = 0;
                        }
                        if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.BISHOP){
                            save = save + "B";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KNIGHT){
                            save = save + "N";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.ROOK){
                            save = save + "R";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.PAWN){
                            save = save + "P";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.QUEEN){
                            save = save + "Q";
                        }
                        else if(board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KING){
                            save = save + "K";
                        }  
                    }  
                }
                else{
                    if(i < 8){
                        cont++;
                    }
                }
                //Se chegar no final da linha e nao encontrar uma peca, 
                //salva o numero de casas vagas ate o fim da linha e zera o contador
                if(i == 7 && j != 7){
                    if(cont != 0){
                        save = save + cont;
                    }
                    save = save + "/";
                    cont = 0;
                }
            }
        }
        //adiciona a string 'd' se o proximo a jogar for o jogador com as pecas pretas
        // e 'w', se for o jogador com as pecas brancas
        if(gfm.getTurn() == PieceAlignment.BLACK){
            save = save + " d";
        }
        else{
            save = save + " w";
        }
    }

    //Cria um save no formato Jogador1_Jogador2.doc na pasta de jogos salvos
    @Override
    public void createSave(){
        try(PrintWriter out = new PrintWriter(new FileWriter(new File("./SavedGames", nameBlack + "_" + nameWhite + ".doc")))) {
            out.write(save);
        } catch (IOException e1) {
            System.err.println("Error occurred");
            e1.printStackTrace();
        }
    }

    @Override
    public String getSave(){
        return save;
    }
}
