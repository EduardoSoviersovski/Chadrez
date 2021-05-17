package Piece;
import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pawn extends Piece{
    //Atributos
    private boolean firstMove = true;
    private JTextField promote;
    private JButton promoteButton;
    public Pawn(Board board, Tile tile, PieceAlignment alignment, JTextField promote, JButton promoteButton){
        super(board, tile, alignment);
        this.promoteButton = promoteButton;
        this.promote = promote;
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
            System.out.println("Peça movida");
        }
        else{
            if(board.getTile(x, y).getPieceInTile().getPieceAlignment() == alignment){
                System.out.println("Peca aliada");
                return;
            }
            capture(x, y, pieces);
        }
        if(y == 7 || y == 0){
            promote(tile, pieces);
        }
    }
    public void promote(Tile tile, ArrayList<Piece> pieces){

        promote.setVisible(true);
        promoteButton.setVisible(true);

        promoteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                char prom = promote.getText().toLowerCase().charAt(0);       
                pieces.remove(tile.getPieceInTile());
                System.out.println("(q)ueen, k(n)ight, (r)ook, (b)ishop");
                
                int y = tile.getY();
                if(prom == 'q'){
                    if(y == 0){
                        pieces.add(new Queen(board, tile, PieceAlignment.WHITE));
                    }
                    else{
                        pieces.add(new Queen(board, tile, PieceAlignment.BLACK));
                    }
                }
                if(prom == 'n'){
                    if(y == 0){
                        pieces.add(new Knight(board, tile, PieceAlignment.WHITE));
                    }
                    else{
                        pieces.add(new Knight(board, tile, PieceAlignment.BLACK));
                    }
                }
                if(prom == 'r'){
                    if(y == 0){
                        pieces.add(new Rook(board, tile, PieceAlignment.WHITE));
                    }
                    else{
                        pieces.add(new Rook(board, tile, PieceAlignment.BLACK));
                    }
                }
                if(prom == 'b'){
                    if(y == 0){
                        pieces.add(new Bishop(board, tile, PieceAlignment.WHITE));
                    }
                    else{
                        pieces.add(new Bishop(board, tile, PieceAlignment.BLACK));
                    }
                }
                promote.setVisible(false);
                promoteButton.setVisible(false);
             }
        });
    }
    
    
    //adicona todos os movimentos possiveis desta peca nesta posicao a uma array de Tiles    
    public void setPossibleMoves(){
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = getX();
        int y = getY();
        
        if(alignment ==  PieceAlignment.BLACK){
            if(y+1 < 8){
                if(!board.getTile(x, y+1).getIsTileOccupied()){
                    moves.add(board.getTile(x, y+1));
                }
                if(firstMove){  
                    if(y+2 < 8){
                        if(!board.getTile(x, y+2).getIsTileOccupied()){ 
                            moves.add(board.getTile(x, y+2));
                        }
                    }
                }   
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
            if(y-1 >= 0){
                if(!board.getTile(x, y-1).getIsTileOccupied()){
                    moves.add(board.getTile(x, y-1));
                }
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
    public ArrayList<Tile> getPossibleMoves(){
        return possibleMoves;
    }
}
