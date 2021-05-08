package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Pawn extends Piece{
    //Atributos
    boolean firstMove = true;

    public Pawn(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.PAWN;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.PAWN, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }
    
    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles    
    public ArrayList<Tile> possibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = tile.getX();
        int y = tile.getY();
        
        moves.add(board.getTile(x, y + 1));
        if(firstMove){   
            moves.add(board.getTile(x, y + 2));
            this.firstMove = false;
        }

        return moves;
    }
}
