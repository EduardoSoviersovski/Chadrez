package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Queen extends Piece{
    //Atributos
    public Queen(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.QUEEN;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.QUEEN, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
    
    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles
    public ArrayList<Tile> possibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();

        int x = tile.getX();
        int y = tile.getY();
        while(x >= 0 || y >=0 || board.getTile(x, y).getIsTileOccupied()){
            x -= 1;
            y -= 1;
            moves.add(board.getTile(x, y));
        }

        x = tile.getX();
        y = tile.getY();
        while(x >= 0 || y < 8 || board.getTile(x, y).getIsTileOccupied()){
            x -= 1;
            y += 1;
            moves.add(board.getTile(x, y));
        }

        x = tile.getX();
        y = tile.getY();
        while(x < 8 || y >= 0 || board.getTile(x, y).getIsTileOccupied()){
            x += 1;
            y -= 1;
            moves.add(board.getTile(x, y));
        }

        x = tile.getX();
        y = tile.getY();
        while(x < 8 || y < 8 || board.getTile(x, y).getIsTileOccupied()){
            x += 1;
            y += 1;
            moves.add(board.getTile(x, y));
        }

        x = tile.getX();
        y = tile.getY();

        while(x >= 0 || board.getTile(x, y).getIsTileOccupied()){
            x -= 1;
            moves.add(board.getTile(x, y));
        }

        x = tile.getX();
        y = tile.getY();

        while(y >= 0 || board.getTile(x, y).getIsTileOccupied()){
            y -= 1;
            moves.add(board.getTile(x, y));
        }
        
        x = tile.getX();
        y = tile.getY();

        while(x < 8 || board.getTile(x, y).getIsTileOccupied()){
            x += 1;
            moves.add(board.getTile(x, y));
        }

        x = tile.getX();
        y = tile.getY();

        while(y < 8 || board.getTile(x, y).getIsTileOccupied()){
            y += 1;
            moves.add(board.getTile(x, y));
        }

        return moves;
    }
}
