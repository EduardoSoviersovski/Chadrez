package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    //Construtora
    public Bishop(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.BISHOP;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.BISHOP, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }

    //Metodos
    //Adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = getX()-1;
        int y = getY()-1;

        //Para todas as pecas nas diagonais ate encontrar uma casa ocupada ou acabar o tabuleiro
        while(x >= 0 && y >=0 && !board.getTile(x, y).getIsTileOccupied()){     
            moves.add(board.getTile(x, y));
            x -= 1;
            y -= 1;
        }

        //Se a casa for ocupada por uma peca do outro jogador, adicona ela a lista
        if(x >= 0 && y >= 0){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }

        x = getX()-1;
        y = getY()+1;

        while(x >= 0 && y < 8 && !board.getTile(x, y).getIsTileOccupied()){
            moves.add(board.getTile(x, y));
            x -= 1;
            y += 1;
        }

        if(x >= 0 && y < 8){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }

        x = getX()+1;
        y = getY()-1;

        while(x < 8 && y >= 0 && !board.getTile(x, y).getIsTileOccupied()){
            moves.add(board.getTile(x, y));
            x += 1;
            y -= 1;
        }

        if(x < 8 && y >= 0){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }

        x = getX()+1;
        y = getY()+1;
        
        while(x < 8 && y < 8 && !board.getTile(x, y).getIsTileOccupied()){
            moves.add(board.getTile(x, y));
            x += 1;
            y += 1;
        }

        if(x < 8 && y < 8){
            if(board.getTile(x, y).getIsTileOccupied()){
                if(board.getTile(x, y).getPieceInTile().getPieceAlignment() != alignment){
                    moves.add(board.getTile(x, y));
                }
            }
        }

        this.possibleMoves = moves;
    }
}
