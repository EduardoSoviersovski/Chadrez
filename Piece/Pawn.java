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

    @Override
    public void move(int x, int y, ArrayList<Piece> pieces){
        if(!board.getTile(x, y).getIsTileOccupied()){
            tile.reset();
            tile = board.getTile(x, y);
            dp.setX(x);
            dp.setY(y);
            board.getTile(x, y).setPieceInTile(this);
            firstMove = false;
        }
        else{
            if(board.getTile(x, y).getPieceInTile().getPieceAlignment() == alignment){
                System.out.println("Peca aliada");
                return;
            }
            capture(x, y, pieces);
        }
    }
    
    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles    
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = getX();
        int y = getY();
        
        if(alignment ==  PieceAlignment.BLACK){
            moves.add(board.getTile(x, y + 1));
            if(firstMove){   
                moves.add(board.getTile(x, y + 2));
            }
            if(x+1 < 8 && y+1 < 8){
                if(board.getTile(x+1, y+1).getIsTileOccupied()){
                    if(board.getTile(x+1, y+1).getPieceInTile().getPieceAlignment() != this.getPieceAlignment()){
                        moves.add(board.getTile(x+1, y+1));
                    }
                }
            }
            if(x-1 >= 0 && y+1 < 8){
                if(board.getTile(x-1, y+1).getIsTileOccupied()){
                    if(board.getTile(x-1, y+1).getPieceInTile().getPieceAlignment() != this.getPieceAlignment()){
                        moves.add(board.getTile(x-1, y+1));
                    }
                }
            }
        }
        else{
            moves.add(board.getTile(x, y - 1));
            if(firstMove){  
                moves.add(board.getTile(x, y - 2));
            }
            if(x+1 < 8 && y-1 >= 0){
                if(board.getTile(x+1, y-1).getIsTileOccupied()){
                    if(board.getTile(x+1, y-1).getPieceInTile().getPieceAlignment() != this.getPieceAlignment()){
                        moves.add(board.getTile(x+1, y-1));
                    }
                }
            }
            if(x-1 >= 0 && y-1 >= 0){
                if(board.getTile(x-1, y-1).getIsTileOccupied()){
                    if(board.getTile(x-1, y-1).getPieceInTile().getPieceAlignment() != this.getPieceAlignment()){
                        moves.add(board.getTile(x-1, y-1));
                    }
                }
            }
        }


        this.possibleMoves = moves;
    }
    public ArrayList<Tile> getPossibleMoves(){
        return possibleMoves;
    }


}
