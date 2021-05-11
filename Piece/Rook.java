package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Rook extends Piece{
    //Atributos
    public Rook(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.ROOK;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.ROOK, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }

    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = tile.getX();
        int y = tile.getY();

        while(x >= 0){
            moves.add(board.getTile(x, y));
            x -= 1;
        }

        x = tile.getX();
        y = tile.getY();

        while(y >= 0){
            moves.add(board.getTile(x, y));
            y -= 1;
        }
        
        x = tile.getX();
        y = tile.getY();

        while(x < 8){
            moves.add(board.getTile(x, y));
            x += 1;
        }

        x = tile.getX();
        y = tile.getY();

        while(y < 8){
            moves.add(board.getTile(x, y));
            y += 1;
        }
        this.possibleMoves = moves;
    }
    public ArrayList<Tile> getPossibleMoves(){
        return possibleMoves;
    }
}
