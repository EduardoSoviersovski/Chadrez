package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    //Atributos
    public Bishop(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.BISHOP;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.BISHOP, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }

    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = getX();
        int y = getY();
        while(x >= 0 && y >=0){     
            moves.add(board.getTile(x, y));
            x -= 1;
            y -= 1;
        }

        x = getX();
        y = getY();
        while(x >= 0 && y < 8){
            moves.add(board.getTile(x, y));
            x -= 1;
            y += 1;
        }

        x = getX();
        y = getY();
        while(x < 8 && y >= 0){
            moves.add(board.getTile(x, y));
            x += 1;
            y -= 1;
        }

        x = getX();
        y = getY();
        while(x < 8 && y < 8){
            moves.add(board.getTile(x, y));
            x += 1;
            y += 1;
        }

        this.possibleMoves = moves;
    }

    public ArrayList<Tile> getPossibleMoves(){
        return possibleMoves;
    }

}
