package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class King extends Piece{
    //Construtora
    public King(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.KING;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KING, alignment);
    }

    //Metodos
    public DrawPiece getDp(){
        return dp;
    }
    //Adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = getX();
        int y = getY();
        //Para todas as casas adjacentes do rei, verifica se ela esta ocupada
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                //Para todas as casas adjacentes do rei, verifica se ela esta ocupada, se nao estiver adiciona
                //a lista de movimentos possiveis
                if((x+i) >= 0 && (x+i) < 8 && (y+j) < 8 && (y+j) >= 0 && 
                    (!board.getTile(x+i, y+j).getIsTileOccupied())){  
                    moves.add(board.getTile((x+i), y+j));
                }
                //Se for ocupada por uma peca de outra cor adiciona tambem
                if(x+i >= 0 && x+i < 8 && y+j >= 0 && y+j < 8){
                    if(board.getTile(x+i, y+j).getIsTileOccupied()){
                        if(board.getTile(x+i, y+j).getPieceInTile().getPieceAlignment() != alignment){
                            moves.add(board.getTile(x+i, y+j));
                        }
                    }
                }
            }
        }
        this.possibleMoves = moves;
    }
}
