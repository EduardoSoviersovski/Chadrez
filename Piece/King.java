package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class King extends Piece{
    //Atributos
    public King(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.KING;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KING, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                
                if((getX()+i) >= 0 && (getX()+i) < 8 && (getY()+j) < 8 && (getY()+j) >= 0 && 
                    !board.getTile(getX()+i, getY()+j).getIsTileOccupied()){
                        
                    moves.add(board.getTile((getX()+i), getY()+j));
                }
            }
        }
        this.possibleMoves = moves;
    }
    public ArrayList<Tile> getPossibleMoves(){
        return possibleMoves;
    }
}
