package Piece;

import Draw.DrawPiece;
import Board.*;
import java.util.ArrayList;

public class King extends Piece {
    // Atributos
    private boolean firstMove;

    // Construtora
    public King(Board board, Tile tile, PieceAlignment alignment) {
        super(board, tile, alignment);
        firstMove = true;
        type = PieceType.KING;

        dp = new DrawPiece(tile.getX(), tile.getY(), PieceType.KING, alignment);
    }

    // Metodos
    public DrawPiece getDp() {
        return dp;
    }

    // Adicona todos os movimentos possiveis desta peca nesta posicao a uma array de
    // Tiles
    public void setPossibleMoves() {
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int x = getX();
        int y = getY();
        // Para todas as casas adjacentes do rei, verifica se ela esta ocupada ou acabar
        // o tabuleiro
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // Para todas as casas adjacentes do rei, verifica se ela esta ocupada, se nao
                // estiver adiciona
                // a lista de movimentos possiveis
                if ((x + i) >= 0 && (x + i) < 8 && (y + j) < 8 && (y + j) >= 0
                        && (!board.getTile(x + i, y + j).getIsTileOccupied())) {
                    moves.add(board.getTile((x + i), y + j));
                }
                // Se for ocupada por uma peca de outra cor adiciona tambem
                if (x + i >= 0 && x + i < 8 && y + j >= 0 && y + j < 8) {
                    if (board.getTile(x + i, y + j).getIsTileOccupied()) {
                        if (board.getTile(x + i, y + j).getPieceInTile().getPieceAlignment() != alignment) {
                            moves.add(board.getTile(x + i, y + j));
                        }
                    }
                }
            }
        }
        if (firstMove) {
            if (alignment == PieceAlignment.BLACK) {
                Tile borderTile = board.getTile(0, 0);
                if (!board.getTile(1, 0).getIsTileOccupied() && !board.getTile(2, 0).getIsTileOccupied()
                        && !board.getTile(3, 0).getIsTileOccupied()) {
                    if (borderTile.getIsTileOccupied()) {
                        if (borderTile.getPieceInTile().getPieceType() == PieceType.ROOK) {
                            if (borderTile.getPieceInTile().getFirstMove()) {
                                moves.add(board.getTile(2, 0));
                            }
                        }
                    }
                }
                borderTile = board.getTile(7, 0);
                if (!board.getTile(5, 0).getIsTileOccupied() && !board.getTile(6, 0).getIsTileOccupied()) {
                    if (borderTile.getIsTileOccupied()) {
                        if (borderTile.getPieceInTile().getPieceType() == PieceType.ROOK) {
                            if (borderTile.getPieceInTile().getFirstMove()) {
                                moves.add(board.getTile(6, 0));
                            }
                        }
                    }
                }
            }
            if (alignment == PieceAlignment.WHITE) {
                Tile borderTile = board.getTile(0, 7);
                if (!board.getTile(1, 7).getIsTileOccupied() && !board.getTile(2, 7).getIsTileOccupied()
                        || !board.getTile(3, 7).getIsTileOccupied()) {
                    if (borderTile.getIsTileOccupied()) {
                        if (borderTile.getPieceInTile().getPieceType() == PieceType.ROOK) {
                            if (borderTile.getPieceInTile().getFirstMove()) {
                                moves.add(board.getTile(2, 7));
                            }
                        }
                    }
                }
                borderTile = board.getTile(7, 7);
                if (!board.getTile(5, 7).getIsTileOccupied() && !board.getTile(6, 7).getIsTileOccupied()) {
                    if (borderTile.getIsTileOccupied()) {
                        if (borderTile.getPieceInTile().getPieceType() == PieceType.ROOK) {
                            if (borderTile.getPieceInTile().getFirstMove()) {
                                moves.add(board.getTile(6, 7));
                            }
                        }
                    }
                }
            }
        }
        this.possibleMoves = moves;
    }

    @Override
    public void move(int x, int y, ArrayList<Piece> pieces) {
        // Se a casa clicada nao estiver ocupada, move para a casa desejada
        if (!board.getTile(x, y).getIsTileOccupied()) {
            tile.reset();
            tile = board.getTile(x, y);
            dp.setX(x);
            dp.setY(y);
            board.getTile(x, y).setPieceInTile(this);

            if (x == 2 || x == 6) {
                castle(x, y, pieces);
            }
            firstMove = false;
            System.out.println("Peca movida");
        }
        // Se estiver ocupada e for da mesma cor que ela, nao realiza o movimento
        else {
            // Se estiver ocupada e for da mesma cor que ela, nao realiza o movimento
            if (board.getTile(x, y).getPieceInTile().getPieceAlignment() == alignment) {
                System.out.println("Peca aliada");
                return;
            }
            // Se estiver ocupada e for de outra cor, captura a peça
            capture(x, y, pieces);
        }
    }

    public void castle(int x, int y, ArrayList<Piece> pieces) {
        if (y == 0) {
            if (x == 2) {
                board.getTile(0, 0).getPieceInTile().move(3, 0, pieces);
            }
            if (x == 6) {
                board.getTile(7, 0).getPieceInTile().move(5, 0, pieces);
            }
        }
        if (y == 7) {
            if (x == 2) {
                board.getTile(0, 7).getPieceInTile().move(3, 7, pieces);
            }
            if (x == 6) {
                board.getTile(7, 7).getPieceInTile().move(5, 7, pieces);
            }
        }
    }

    public boolean getFirstMove() {
        return firstMove;
    }
}
