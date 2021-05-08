package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Knight extends Piece{
    //Atributos
    public Knight(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.KNIGHT;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KNIGHT, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
    
    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles
    public ArrayList<Tile> possibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = tile.getX();
        int y = tile.getY();

        if(!board.getTile(x - 1, y + 2).getIsTileOccupied()){
            moves.add(board.getTile(x - 1, y + 2));
        }
        if(!board.getTile(x + 1, y + 2).getIsTileOccupied()){
            moves.add(board.getTile(x - 1, y + 2));
        }
        if(!board.getTile(x - 2, y + 1).getIsTileOccupied()){
            moves.add(board.getTile(x - 2, y + 1));
        }
        if(!board.getTile(x - 2, y + 1).getIsTileOccupied()){
            moves.add(board.getTile(x - 2, y + 1));
        }
        if(!board.getTile(x - 1, y - 2).getIsTileOccupied()){
            moves.add(board.getTile(x - 1, y - 2));
        }
        if(!board.getTile(x + 1, y - 2).getIsTileOccupied()){
            moves.add(board.getTile(x + 1, y - 2));
        }
        if(!board.getTile(x - 2, y - 1).getIsTileOccupied()){
            moves.add(board.getTile(x - 2, y - 1));
        }
        if(!board.getTile(x + 2, y - 1).getIsTileOccupied()){
            moves.add(board.getTile(x + 2, y - 1));
        }
        return moves;
    }
}
