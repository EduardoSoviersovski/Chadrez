package Game;

import Piece.PieceAlignment;
import Piece.Piece;

public class GameFlowManager {
    // Atributos
    private PieceAlignment turn;

    // Construtora
    public GameFlowManager() {
        turn = PieceAlignment.WHITE;
    }

    // Metodos

    // Muda o valor de turno para o próximo jogador
    public void turnChange() {
        if (turn == PieceAlignment.WHITE) {
            turn = PieceAlignment.BLACK;
        } else {
            turn = PieceAlignment.WHITE;
        }
    }

    // Muda a o valor de turno para WHITE
    public void setWhiteTurn() {
        turn = PieceAlignment.WHITE;
    }

    // Muda o valor de turno para BLACK
    public void setBlackTurn() {
        turn = PieceAlignment.BLACK;
    }

    // Verifica se a peca selecionada possui a mesma cor do turno
    public boolean checkMovingPiece(Piece piece) {
        if (piece.getPieceAlignment() == turn) {
            return true;
        } else {
            return false;
        }
    }

    // Retorna o turno
    // BLACK ou WHITE
    public PieceAlignment getTurn() {
        return turn;
    }
}
