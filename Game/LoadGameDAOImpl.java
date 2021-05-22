package Game;

import Board.Board;
import Piece.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoadGameDAOImpl implements LoadGameDAO {
    // Atributos
    private Board board;
    private ArrayList<Piece> pieces;
    private ArrayList<JLabel> labels;
    private GameFlowManager gfm;
    private String player1;
    private String player2;

    // Construtora
    public LoadGameDAOImpl(Board board, GameFlowManager gfm, ArrayList<JLabel> labels, ArrayList<Piece> pieces,
            JTextField player1, JTextField player2) {
        this.board = board;
        this.gfm = gfm;
        this.labels = labels;
        this.pieces = pieces;
        this.player1 = player1.getText();
        this.player2 = player2.getText();
    }

    // Metodos
    @Override
    public boolean loadGameDoc() {
        // Se existir um jogo salvo entre os jogadores
        try (FileReader fr = new FileReader("./SavedGames/" + player1 + "_" + player2 + ".doc")) {
            char i;
            int cont;
            int j = 0;
            int x = 0;
            int y = 0;

            labels.get(0).setText(player1);
            labels.get(1).setText(player2);

            StringBuilder load = new StringBuilder("");

            // Preenche uma variavel StringBuilder com todos os caracteres do do documento
            // lido
            while ((cont = fr.read()) != -1) {
                i = (char) cont;
                load.append(i);
                i++;
            }

            // Salva em uma string os caractertes do comeco ate o primero espaco
            String loadP = load.toString().split(" ")[0];

            while (j < loadP.length()) {
                i = loadP.charAt(j);
                if (i == 'r') {
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'n') {
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'b') {
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'q') {
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'k') {
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.BLACK, false));
                } else if (i == 'p') {
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.BLACK));
                }

                else if (i == 'R') {
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'N') {
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'B') {
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'Q') {
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'K') {
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.WHITE, false));
                } else if (i == 'P') {
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.WHITE));
                }

                else if (i == '2') {
                    x = x + 1;
                } else if (i == '3') {
                    x = x + 2;
                } else if (i == '4') {
                    x = x + 3;
                } else if (i == '5') {
                    x = x + 4;
                } else if (i == '6') {
                    x = x + 5;
                } else if (i == '7') {
                    x = x + 6;
                } else if (i == '8') {
                    x = x + 7;
                }
                if (x < 7) {
                    x++;
                }

                if (i == '/') {
                    y++;
                    x = 0;
                }
                j++;
            }
            j = 0;

            // Salva em uma string os caractertes do primeiro espaco ate o segundo espaco
            loadP = load.toString().split(" ")[1];
            while (j < loadP.length()) {
                i = loadP.charAt(j);
                if (i == 'w') {
                    gfm.setWhiteTurn();
                }
                if (i == 'b') {
                    gfm.setBlackTurn();
                }
                j++;
            }

            j = 0;

            // Se existirem caracteres depois do segundo espaco
            if (load.toString().split(" ").length > 2) {
                // Salva em uma string os caractertes do segundo espaco ate o fim da
                // StringBuilder
                loadP = load.toString().split(" ")[2];

                // Para cada caracter que encontrar, muda os atributos das torres e reis
                // correspondentes para realizar a o roque
                while (j < loadP.length()) {
                    i = loadP.charAt(j);
                    if (i == 'K') {
                        board.getTile(4, 7).getPieceInTile().setFirstMove(true);
                        board.getTile(0, 7).getPieceInTile().setFirstMove(true);
                    }
                    if (i == 'Q') {
                        board.getTile(4, 7).getPieceInTile().setFirstMove(true);
                        board.getTile(7, 7).getPieceInTile().setFirstMove(true);
                    }
                    if (i == 'k') {
                        board.getTile(4, 0).getPieceInTile().setFirstMove(true);
                        board.getTile(0, 0).getPieceInTile().setFirstMove(true);
                    }
                    if (i == 'q') {
                        board.getTile(4, 0).getPieceInTile().setFirstMove(true);
                        board.getTile(7, 0).getPieceInTile().setFirstMove(true);
                    }
                    j++;
                }
            }
            return true;
        } catch (IOException e1) {
            System.err.println("Nao ha um jogo salvo com esses jogadores.");
            // e1.printStackTrace();
            return false;
        }
    }

    // Igual ao LoadGameDoc
    @Override
    public boolean loadGameTxt() {
        try (FileReader fr = new FileReader("./SavedGames/" + player1 + "_" + player2 + ".txt")) {
            char i;
            int cont;
            int j = 0;
            int x = 0;
            int y = 0;

            labels.get(0).setText(player1);
            labels.get(1).setText(player2);
            StringBuilder load = new StringBuilder("");

            while ((cont = fr.read()) != -1) {
                i = (char) cont;
                load.append(i);
                i++;
            }
            String loadP = load.toString().split(" ")[0];

            while (j < loadP.length()) {
                i = loadP.charAt(j);
                if (i == 'r') {
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'n') {
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'b') {
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'q') {
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.BLACK));
                } else if (i == 'k') {
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.BLACK, false));
                } else if (i == 'p') {
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.BLACK));
                }

                else if (i == 'R') {
                    pieces.add(new Rook(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'N') {
                    pieces.add(new Knight(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'B') {
                    pieces.add(new Bishop(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'Q') {
                    pieces.add(new Queen(board, board.getTile(x, y), PieceAlignment.WHITE));
                } else if (i == 'K') {
                    pieces.add(new King(board, board.getTile(x, y), PieceAlignment.WHITE, false));
                } else if (i == 'P') {
                    pieces.add(new Pawn(board, board.getTile(x, y), PieceAlignment.WHITE));
                }

                else if (i == '2') {
                    x = x + 1;
                } else if (i == '3') {
                    x = x + 2;
                } else if (i == '4') {
                    x = x + 3;
                } else if (i == '5') {
                    x = x + 4;
                } else if (i == '6') {
                    x = x + 5;
                } else if (i == '7') {
                    x = x + 6;
                } else if (i == '8') {
                    x = x + 7;
                }
                if (x < 7) {
                    x++;
                }

                if (i == '/') {
                    y++;
                    x = 0;
                }
                j++;
            }
            j = 0;
            loadP = load.toString().split(" ")[1];
            while (j < loadP.length()) {
                i = loadP.charAt(j);
                if (i == 'w') {
                    gfm.setWhiteTurn();
                }
                if (i == 'b') {
                    gfm.setBlackTurn();
                }
                j++;
            }

            j = 0;
            if (load.toString().split(" ").length > 2) {
                loadP = load.toString().split(" ")[2];
                while (j < loadP.length()) {
                    i = loadP.charAt(j);
                    if (i == 'K') {
                        board.getTile(4, 7).getPieceInTile().setFirstMove(true);
                        board.getTile(7, 7).getPieceInTile().setFirstMove(true);
                    }
                    if (i == 'Q') {
                        board.getTile(4, 7).getPieceInTile().setFirstMove(true);
                        board.getTile(0, 7).getPieceInTile().setFirstMove(true);
                    }
                    if (i == 'k') {
                        board.getTile(4, 0).getPieceInTile().setFirstMove(true);
                        board.getTile(7, 0).getPieceInTile().setFirstMove(true);
                    }
                    if (i == 'q') {
                        board.getTile(4, 0).getPieceInTile().setFirstMove(true);
                        board.getTile(0, 0).getPieceInTile().setFirstMove(true);
                    }
                    j++;
                }
            }
            return true;
        } catch (IOException e1) {
            System.err.println("Nao ha um jogo salvo com esses jogadores.");
            // e1.printStackTrace();
            return false;
        }
    }
}
