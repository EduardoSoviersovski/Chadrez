package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Pawn extends Piece{
    //Atributos
    private boolean firstMove = true;

    //Construtora
    public Pawn(Board board, Tile tile, PieceAlignment alignment){
        super(board, tile, alignment);
        type = PieceType.PAWN;
        
        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.PAWN, alignment);
    }

    public DrawPiece getDp(){
        return dp;
    }

    //Realiza o movimento da peca
    @Override
    public void move(int x, int y, ArrayList<Piece> pieces){
        //Se a casa clicada nao estiver ocupada, move para a casa desejada
        if(!board.getTile(x, y).getIsTileOccupied()){
            tile.reset();
            tile = board.getTile(x, y);
            dp.setX(x);
            dp.setY(y);
            board.getTile(x, y).setPieceInTile(this);
            firstMove = false;
            System.out.println("Peça movida");
        }
        //Se estiver ocupada e for da mesma cor que ela, nao realiza o movimento
        else{
            //Se estiver ocupada e for da mesma cor que ela, nao realiza o movimento
            if(board.getTile(x, y).getPieceInTile().getPieceAlignment() == alignment){
                System.out.println("Peca aliada");
                return;
            }
            //Se estiver ocupada e for de outra cor, captura a peça
            capture(x, y, pieces);
        }
    }
    
    
    //Adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles    
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = getX();
        int y = getY();
        
        //Para os peaoes pretos
        if(alignment ==  PieceAlignment.BLACK){
            if(y+1 < 8){
                //Se a casa seguinte nao estiver ocupada ou e estiver dentro do tabuleiro, adiciona a lista de movimentos possiveis
                if(!board.getTile(x, y+1).getIsTileOccupied()){
                    moves.add(board.getTile(x, y+1));
                }
                //Se for o primeiro movimento do peao e a casa com y+2 nao estiver ocupada, adiciona a lista de movimentos possiveis
                if(firstMove){  
                    if(y+2 < 8){
                        if(!board.getTile(x, y+2).getIsTileOccupied()){ 
                            moves.add(board.getTile(x, y+2));
                        }
                    }
                }   
            }
            //Se as casas das diagonais adjacentes estiverem ocupadas por pecas de outra cor, adiciona elas a lista de movimentos possiveis
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
        //Para peoes brancos
        else{
            if(y-1 >= 0){
                if(!board.getTile(x, y-1).getIsTileOccupied()){
                    moves.add(board.getTile(x, y-1));
                }
                //se for o primeiro movimento do peao e a casa com y+2 nao estiver ocupada, adiciona a lista de movimentos possiveis
                if(firstMove){  
                    if(y-2 >= 0){
                        if(!board.getTile(x, y-2).getIsTileOccupied()){ 
                            moves.add(board.getTile(x, y-2));
                        }
                    }
                }   
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
}
