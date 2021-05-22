package Game;

import java.util.ArrayList;
import Board.Board;
import Board.Tile;
import Piece.Piece;

public class MoveManager {
    // Atributos
    private Board board;
    private Piece pieceToMove;
    private boolean pieceSelected;
    private GameFlowManager gfm;
    private ArrayList<Piece> pieces;

    // Construtora
    public MoveManager(Board board, ArrayList<Piece> pieces, GameFlowManager gfm) {
        this.gfm = gfm;
        this.board = board;
        this.pieces = pieces;

        pieceToMove = null;
        pieceSelected = false;

    }

    // Metodos
    public void makeMove(int x, int y) {
        // Se o jogador clicar em algum lugar dentro do tabuleiro
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            Tile selectedTile = board.getTile(x, y);
            // Se nenhuma peca ja estiver sido selecionada, seleciona esta
            if (!pieceSelected) {
                if (selectedTile.getIsTileOccupied()) {
                    if (gfm.checkMovingPiece(selectedTile.getPieceInTile())) {
                        System.out.println("Peça selecionada");
                        pieceToMove = selectedTile.getPieceInTile();
                        pieceSelected = true;
                    }
                }
            }
            // Se ja tiver uma peca selecionada
            else {
                // Define os movimentos possiveis dela
                pieceToMove.setPossibleMoves();
                // Se a casa selecionada estiver contida nos movimentos possiveis da peca
                // move ela para a nova casa
                if (pieceToMove.getPossibleMoves().contains(selectedTile)) {
                    pieceToMove.move(x, y, pieces);
                    gfm.turnChange();
                }
                // Se nao, tira a selecao de peça
                else {
                    System.out.println("Movimento invalido");
                }
                pieceSelected = false;
            }
        }
    }
}
