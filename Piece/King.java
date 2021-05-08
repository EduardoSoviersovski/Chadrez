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
    public ArrayList<Tile> possibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();        

        for(int x = tile.getX() - 1; x < 2; x++){
            for(int y = tile.getY() - 1; y < 2; y++){
                if(x < 8 && y < 8 && tile.getIsTileOccupied() == false){
                    moves.add(board.getTile(x, y));
                }
            }
        }
        return moves;
    }
}
