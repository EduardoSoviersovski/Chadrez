package Game;

import Board.Board;
import Piece.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JLabel;

public class SaveGameDAOImpl implements SaveGameDAO {
    // Atributos
    private Board board;
    private GameFlowManager gfm;
    private String save = "";
    private String nameBlack;
    private String nameWhite;

    // Construtora
    public SaveGameDAOImpl(Board board, GameFlowManager gfm, ArrayList<JLabel> labels) {
        this.board = board;
        this.gfm = gfm;
        this.nameBlack = labels.get(0).getText().split("-")[0];
        this.nameWhite = labels.get(1).getText().split("-")[0];
    }

    // Metodos

    // Salva o jogo na notacao FEN
    @Override
    public void setSaveDoc() {
        int cont = 0;
        // Para todas as casas do tabuleiro, verifica se possui uma peca ou nao
        // se possuir, adiciona a uma string a quantidade de casas vazias antes dele
        // e seu caracter correspondente e zera o contador de casas vazias.
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (board.getTile(i, j).getIsTileOccupied()) {
                    if (board.getTile(i, j).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK) {
                        if (cont != 0) {
                            save = save + cont;
                            cont = 0;
                        }
                        if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.BISHOP) {
                            save = save + "b";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KNIGHT) {
                            save = save + "n";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.ROOK) {
                            save = save + "r";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.PAWN) {
                            save = save + "p";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.QUEEN) {
                            save = save + "q";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KING) {
                            save = save + "k";
                        }
                    } else {
                        if (cont != 0) {
                            save = save + cont;
                            cont = 0;
                        }
                        if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.BISHOP) {
                            save = save + "B";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KNIGHT) {
                            save = save + "N";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.ROOK) {
                            save = save + "R";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.PAWN) {
                            save = save + "P";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.QUEEN) {
                            save = save + "Q";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KING) {
                            save = save + "K";
                        }
                    }
                } else {
                    if (i < 8) {
                        cont++;
                    }
                }
                if (i == 7 && j != 7) {
                    if (cont != 0) {
                        save = save + cont;
                    }
                    save = save + "/";
                    cont = 0;
                }
            }
        }
        // Se o proximo a jogar for o jogador de pecas pretas, adiciona b separado por
        // um espaco antes e depois
        if (gfm.getTurn() == PieceAlignment.BLACK) {
            save = save + " b ";
        } else {
            save = save + " w ";
        }
        // Se a casa inicial do rei e das torres estiverem ocupadas pelas proprias pecas
        // e
        // elas nao tiverem se movido durante o jogo, adiciona o roque valido a string
        if (board.getTile(4, 7).getIsTileOccupied() && board.getTile(7, 7).getIsTileOccupied()) {
            if (board.getTile(4, 7).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(7, 7).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE
                    && board.getTile(7, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE) {
                if (board.getTile(4, 7).getPieceInTile().getFirstMove()
                        && board.getTile(7, 7).getPieceInTile().getFirstMove()) {
                    save = save + "K";
                }
            }
        }
        if (board.getTile(4, 7).getIsTileOccupied() && board.getTile(0, 7).getIsTileOccupied()) {
            if (board.getTile(4, 7).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(0, 7).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE
                    && board.getTile(0, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE) {
                if (board.getTile(4, 7).getPieceInTile().getFirstMove()
                        && board.getTile(0, 7).getPieceInTile().getFirstMove()) {
                    save = save + "Q";
                }
            }
        }

        if (board.getTile(4, 0).getIsTileOccupied() && board.getTile(7, 0).getIsTileOccupied()) {
            if (board.getTile(4, 0).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(7, 0).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK
                    && board.getTile(7, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK) {
                if (board.getTile(4, 0).getPieceInTile().getFirstMove()
                        && board.getTile(7, 0).getPieceInTile().getFirstMove()) {
                    save = save + "k";
                }
            }
        }

        if (board.getTile(4, 0).getIsTileOccupied() && board.getTile(0, 0).getIsTileOccupied()) {
            if (board.getTile(4, 0).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(0, 0).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK
                    && board.getTile(0, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK) {
                if (board.getTile(4, 0).getPieceInTile().getFirstMove()
                        && board.getTile(0, 0).getPieceInTile().getFirstMove()) {
                    save = save + "q";
                }
            }
        }
    }

    @Override
    public String getSaveDoc() {
        return save;
    }

    // Cria um save no formato Jogador1_Jogador2.doc na pasta de jogos salvo
    @Override
    public void createSaveDoc() {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(new File("./SavedGames", nameBlack + "_" + nameWhite + ".doc")))) {
            out.write(save);
        } catch (IOException e1) {
            System.err.println("Error occurred");
            e1.printStackTrace();
        }
    }

    public void deleteSaveDoc(String nameBlack, String nameWhite) {
        File file = new File("./SavedGames", nameBlack + "_" + nameWhite + ".doc");
        file.delete();
    }

    // Igual ao LoadGameDoc
    @Override
    public void setSaveTxt() {
        int cont = 0;
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (board.getTile(i, j).getIsTileOccupied()) {
                    if (board.getTile(i, j).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK) {
                        if (cont != 0) {
                            save = save + cont;
                            cont = 0;
                        }
                        if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.BISHOP) {
                            save = save + "b";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KNIGHT) {
                            save = save + "n";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.ROOK) {
                            save = save + "r";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.PAWN) {
                            save = save + "p";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.QUEEN) {
                            save = save + "q";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KING) {
                            save = save + "k";
                        }
                    } else {
                        if (cont != 0) {
                            save = save + cont;
                            cont = 0;
                        }
                        if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.BISHOP) {
                            save = save + "B";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KNIGHT) {
                            save = save + "N";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.ROOK) {
                            save = save + "R";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.PAWN) {
                            save = save + "P";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.QUEEN) {
                            save = save + "Q";
                        } else if (board.getTile(i, j).getPieceInTile().getPieceType() == PieceType.KING) {
                            save = save + "K";
                        }
                    }
                } else {
                    if (i < 8) {
                        cont++;
                    }
                }
                if (i == 7 && j != 7) {
                    if (cont != 0) {
                        save = save + cont;
                    }
                    save = save + "/";
                    cont = 0;
                }
            }
        }
        if (gfm.getTurn() == PieceAlignment.BLACK) {
            save = save + " b ";
        } else {
            save = save + " w ";
        }
        if (board.getTile(4, 7).getIsTileOccupied() && board.getTile(7, 7).getIsTileOccupied()) {
            if (board.getTile(4, 7).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(7, 7).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE
                    && board.getTile(7, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE) {
                if (board.getTile(4, 7).getPieceInTile().getFirstMove()
                        && board.getTile(7, 7).getPieceInTile().getFirstMove()) {
                    save = save + "K";
                }
            }
        }
        if (board.getTile(4, 7).getIsTileOccupied() && board.getTile(0, 7).getIsTileOccupied()) {
            if (board.getTile(4, 7).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(0, 7).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE
                    && board.getTile(0, 7).getPieceInTile().getPieceAlignment() == PieceAlignment.WHITE) {
                if (board.getTile(4, 7).getPieceInTile().getFirstMove()
                        && board.getTile(0, 7).getPieceInTile().getFirstMove()) {
                    save = save + "Q";
                }
            }
        }

        if (board.getTile(4, 0).getIsTileOccupied() && board.getTile(7, 0).getIsTileOccupied()) {
            if (board.getTile(4, 0).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(7, 0).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK
                    && board.getTile(7, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK) {
                if (board.getTile(4, 0).getPieceInTile().getFirstMove()
                        && board.getTile(7, 0).getPieceInTile().getFirstMove()) {
                    save = save + "k";
                }
            }
        }

        if (board.getTile(4, 0).getIsTileOccupied() && board.getTile(0, 0).getIsTileOccupied()) {
            if (board.getTile(4, 0).getPieceInTile().getPieceType() == PieceType.KING
                    && board.getTile(0, 0).getPieceInTile().getPieceType() == PieceType.ROOK
                    && board.getTile(4, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK
                    && board.getTile(0, 0).getPieceInTile().getPieceAlignment() == PieceAlignment.BLACK) {
                if (board.getTile(4, 0).getPieceInTile().getFirstMove()
                        && board.getTile(0, 0).getPieceInTile().getFirstMove()) {
                    save = save + "q";
                }
            }
        }
    }

    @Override
    public String getSaveTxt() {
        return save;
    }

    // Cria um save no formato Jogador1_Jogador2.txt na pasta de jogos salvo
    @Override
    public void createSaveTxt() {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(new File("./SavedGames", nameBlack + "_" + nameWhite + ".txt")))) {
            out.write(save);
        } catch (IOException e1) {
            System.err.println("Error occurred");
            e1.printStackTrace();
        }
    }

    public void deleteSaveTxt(String nameBlack, String nameWhite) {
        File file = new File("./SavedGames", nameBlack + "_" + nameWhite + ".txt");
        file.delete();
    }
}
