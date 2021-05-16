package Game;

import Board.Board;
import Piece.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JLabel;

public class SaveGameDAOImpl implements SaveGameDAO{
    private Board board;
    private GameFlowManager gfm;
    private String save = "";
    private String nameBlack;
    private String nameWhite;

    public SaveGameDAOImpl(Board board, GameFlowManager gfm, ArrayList<JLabel> labels){
        this.board = board;
        this.gfm = gfm;
        this.nameBlack = labels.get(0).getText();
        this.nameWhite = labels.get(1).getText();
    }

    @Override
    public void setSave(){
        int cont = 0;
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
                if(i == 7 && j != 7){
                    if(cont != 0){
                        save = save + cont;
                    }
                    save = save + "/";
                    cont = 0;
                }
            }
        }
        if(gfm.getTurn() == PieceAlignment.BLACK){
            save = save + " d";
        }
        else{
            save = save + " w";
        }
    }

    @Override
    public void createSave(){
        try(PrintWriter out = new PrintWriter(new FileWriter(new File("./SavedGames", nameBlack + "_" + nameWhite + ".txt")))) {
            out.write(save);
        } catch (IOException e1) {
            System.err.println("Error occurred");
            e1.printStackTrace();
        }
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
