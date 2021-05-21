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
        int x = tile.getX()-1;
        int y = tile.getY();

        //Para todas as casas na vertical adiciona as casas para a array de Tiles
        //ate encontrar uma casa ocupada ou acabar o tabuleiro
        while(x >= 0 && !board.getTile(x, y).getIsTileOccupied()){
            moves.add(board.getTile(x, y));
            x -= 1;
        }
        //Se a casa for ocupada por uma peça de outra cor, adiciona a casa a lista de movimentos possiveis
        if(x >= 0){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }

        x = tile.getX();
        y = tile.getY() - 1;

        while(y >= 0 && !board.getTile(x, y).getIsTileOccupied()){
            moves.add(board.getTile(x, y));
            y -= 1;
        }
        if(y >= 0){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }
        
        x = tile.getX() + 1;
        y = tile.getY();

        while(x < 8 && !board.getTile(x, y).getIsTileOccupied()){
            moves.add(board.getTile(x, y));
            x += 1;
        }
        if(x < 8){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }

        x = tile.getX();
        y = tile.getY() + 1;

        while(y < 8 && !board.getTile(x, y).getIsTileOccupied()){
            moves.add(board.getTile(x, y));
            y += 1;
        }
        if(y < 8){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }

        this.possibleMoves = moves;
    }
}
