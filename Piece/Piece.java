package Piece;

import Board.*;
import Draw.DrawPiece;
import java.util.ArrayList;

public abstract class Piece {
    // Atributos
    protected Board board;
    protected Tile tile;
    protected PieceType type;
    protected PieceAlignment alignment;
    protected DrawPiece dp;
    protected ArrayList<Tile> possibleMoves;

    // Construtora
    public Piece(Board board, Tile tile, PieceAlignment alignment) {
        this.board = board;
        this.tile = tile;
        this.alignment = alignment;

        this.tile.setPieceInTile(this);
    }

    // Metodos
    // Realiza o movimento da peca
    public void move(int x, int y, ArrayList<Piece> pieces) {
        // Se a casa clicada nao estiver ocupada, move para a casa desejada
        if (!board.getTile(x, y).getIsTileOccupied()) {
            tile.reset();
            tile = board.getTile(x, y);
            dp.setX(x);
            dp.setY(y);
            board.getTile(x, y).setPieceInTile(this);
            System.out.println("Peca movida");
        } else {
            // Se estiver ocupada e for de outra cor, captura a peça
            capture(x, y, pieces);
        }
    }

    // Captura de peca
    public void capture(int x, int y, ArrayList<Piece> pieces) {
        // Remove a peca na casa selecionada da lista
        // Muda os atributos do objeto peca para a casa selecionada
        pieces.remove(board.getTile(x, y).getPieceInTile());
        tile.reset();
        tile = board.getTile(x, y);
        tile.reset();
        dp.setX(x);
        dp.setY(y);
        board.getTile(x, y).setPieceInTile(this);
        System.out.println("Peca capturada");
    }

    public abstract void setPossibleMoves();

    public abstract DrawPiece getDp();

    public abstract boolean getFirstMove();

    public ArrayList<Tile> getPossibleMoves() {
        return possibleMoves;
    }

    public PieceType getPieceType() {
        return this.type;
    }

    public PieceAlignment getPieceAlignment() {
        return this.alignment;
    }

    public Tile getTile() {
        return tile;
    }

    public int getX() {
        return tile.getX();
    }

    public int getY() {
        return tile.getY();
    }
}
