package Piece;

import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class Knight extends Piece {
    // Construtora
    public Knight(Board board, Tile tile, PieceAlignment alignment) {
        super(board, tile, alignment);
        type = PieceType.KNIGHT;

        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KNIGHT, alignment);
    }

    // Adicona todos os movimentos possiveis desta peca nesta posicao a uma array de
    // Tiles
    public void setPossibleMoves() {
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = tile.getX();
        int y = tile.getY();

        // Para todos os movimentos em 'L', verifica se a casa esta ocupada e dentro do
        // tabuleiro
        // se nao estiver adiciona a lista de movimentos possiveis
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (board.getTile(x - 1, y - 2).getIsTileOccupied()) {
                // Se estiver ocupada por uma peca de outra cor, adiciona a lista de movimentos
                // possiveis
                if (board.getTile(x - 1, y - 2).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x - 1, y - 2));
                }
            }
            // se nao estiver ocupada, adiciona a lista de movimentos
            else {
                moves.add(board.getTile(x - 1, y - 2));
            }
        }
        if (x + 1 < 8 && y - 2 >= 0) {
            if (board.getTile(x + 1, y - 2).getIsTileOccupied()) {
                if (board.getTile(x + 1, y - 2).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x + 1, y - 2));
                }
            } else {
                moves.add(board.getTile(x + 1, y - 2));
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (board.getTile(x - 2, y - 1).getIsTileOccupied()) {
                if (board.getTile(x - 2, y - 1).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x - 2, y - 1));
                }
            } else {
                moves.add(board.getTile(x - 2, y - 1));
            }
        }
        if (x + 2 < 8 && y - 1 >= 0) {
            if (board.getTile(x + 2, y - 1).getIsTileOccupied()) {
                if (board.getTile(x + 2, y - 1).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x + 2, y - 1));
                }
            } else {
                moves.add(board.getTile(x + 2, y - 1));
            }
        }

        if (x - 1 >= 0 && y + 2 < 8) {
            if (board.getTile(x - 1, y + 2).getIsTileOccupied()) {
                if (board.getTile(x - 1, y + 2).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x - 1, y + 2));
                }
            } else {
                moves.add(board.getTile(x - 1, y + 2));
            }
        }
        if (x - 2 >= 0 && y + 1 < 8) {
            if (board.getTile(x - 2, y + 1).getIsTileOccupied()) {
                if (board.getTile(x - 2, y + 1).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x - 2, y + 1));
                }
            } else {
                moves.add(board.getTile(x - 2, y + 1));
            }
        }
        if (x + 1 < 8 && y + 2 < 8) {
            if (board.getTile(x + 1, y + 2).getIsTileOccupied()) {
                if (board.getTile(x + 1, y + 2).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x + 1, y + 2));
                }
            } else {
                moves.add(board.getTile(x + 1, y + 2));
            }
        }
        if (x + 2 < 8 && y + 1 < 8) {
            if (board.getTile(x + 2, y + 1).getIsTileOccupied()) {
                if (board.getTile(x + 2, y + 1).getPieceInTile().getPieceAlignment() != alignment) {
                    moves.add(board.getTile(x + 2, y + 1));
                }
            } else {
                moves.add(board.getTile(x + 2, y + 1));
            }
        }
        this.possibleMoves = moves;
    }

    public boolean getFirstMove() {
        return false;
    }

    public void setFirstMove(boolean b) {
    }
}
