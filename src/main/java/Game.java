import enums.ChessColor;
import exeptions.InvalidFigureMovementException;
import exeptions.NoFigureException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mari.avetisyan on 02/07/2020.
 */
public class Game {
    static boolean isWhiteLine = true;

    private ChessBoard chessBoard   = new ChessBoard(8, 8);
    private ChessFigure whiteKing    = new King(ChessColor.WHITE, "e1");
    private ChessFigure whiteQueen   = new Queen(ChessColor.WHITE, "d1");
    private ChessFigure whiteRook1   = new Rook(ChessColor.WHITE, "a1");
    private ChessFigure whiteRook2   = new Rook(ChessColor.WHITE, "h1");
    private ChessFigure whiteBishop1 = new Bishop(ChessColor.WHITE, "c1");
    private ChessFigure whiteBishop2 = new Bishop(ChessColor.WHITE, "f1");
    private ChessFigure whiteKnight1 = new Knight(ChessColor.WHITE, "b1");
    private ChessFigure whiteKnight2 = new Knight(ChessColor.WHITE, "g1");
    private ChessFigure whitePawn1   = new Pawn(ChessColor.WHITE, "A2");
    private ChessFigure whitePawn2   = new Pawn(ChessColor.WHITE, "b2");
    private ChessFigure whitePawn3   = new Pawn(ChessColor.WHITE, "c2");
    private ChessFigure whitePawn4   = new Pawn(ChessColor.WHITE, "d2");
    private ChessFigure whitePawn5   = new Pawn(ChessColor.WHITE, "e2");
    private ChessFigure whitePawn6   = new Pawn(ChessColor.WHITE, "f2");
    private ChessFigure whitePawn7   = new Pawn(ChessColor.WHITE, "g2");
    private ChessFigure whitePawn8   = new Pawn(ChessColor.WHITE, "h2");

    private ChessFigure blackKing    = new King(ChessColor.BLACK, "e8");
    private ChessFigure blackQueen   = new Queen(ChessColor.BLACK, "d8");
    private ChessFigure blackRook1   = new Rook(ChessColor.BLACK, "a8");
    private ChessFigure blackRook2   = new Rook(ChessColor.BLACK, "h8");
    private ChessFigure blackBishop1 = new Bishop(ChessColor.BLACK, "c8");
    private ChessFigure blackBishop2 = new Bishop(ChessColor.BLACK, "f8");
    private ChessFigure blackKnight1 = new Knight(ChessColor.BLACK, "b8");
    private ChessFigure blackKnight2 = new Knight(ChessColor.BLACK, "g8");
    private ChessFigure blackPawn1   = new Pawn(ChessColor.BLACK, "A7");
    private ChessFigure blackPawn2   = new Pawn(ChessColor.BLACK, "b7");
    private ChessFigure blackPawn3   = new Pawn(ChessColor.BLACK, "c7");
    private ChessFigure blackPawn4   = new Pawn(ChessColor.BLACK, "d7");
    private ChessFigure blackPawn5   = new Pawn(ChessColor.BLACK, "e7");
    private ChessFigure blackPawn6   = new Pawn(ChessColor.BLACK, "f7");
    private ChessFigure blackPawn7   = new Pawn(ChessColor.BLACK, "g7");
    private ChessFigure blackPawn8   = new Pawn(ChessColor.BLACK, "h7");

    private void initGame() {
        List<ChessFigure> figures = new ArrayList<ChessFigure>();
        Collections.addAll(figures, whiteKing, whiteQueen, whiteRook1, whiteRook2, whiteBishop1, whiteBishop2, whiteKnight1, whiteKnight2,
                whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8,
                blackKing, blackQueen, blackRook1, blackRook2, blackBishop1, blackBishop2, blackKnight1, blackKnight2,
                blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8);
        chessBoard.placeFigures(figures);
    }

    private Position getPositionFromConsole(Scanner scanner, String positionType) {
        System.out.print("Enter figure " + positionType + " position: ");
        String tmp1 = scanner.nextLine();
        return new Position(tmp1);
    }

    void startGame() {
        initGame();
        System.out.println("The game is started. Have a good game. In case you want to finish, please enter 'End'.");

        try {
            BufferedWriter gameHistory = new BufferedWriter(new FileWriter("gameHistory.txt"));
            while (true) {
                chessBoard.printBoard();

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter figure current position: ");
                String tmp1 = scanner.nextLine();
                Position currentPosition;

                if(tmp1.toUpperCase().equals("END")) {
                    break;
                } else {
                    currentPosition = new Position(tmp1);

                    while(true) {
                        while (currentPosition.getPosition() == null) {
                            currentPosition = getPositionFromConsole(scanner, "current");
                        }

                        try {
                            chessBoard.isThereAFigureInPosition(currentPosition);
                            break;
                        } catch (NoFigureException e) {
                            System.err.println(e);
                            currentPosition = getPositionFromConsole(scanner, "current");
                        }
                    }
                }


                System.out.print("Enter figure next position: ");
                String tmp2 = scanner.nextLine();
                Position nextPosition;

                if(tmp2.toUpperCase().equals("END")) {
                    break;
                } else {
                    nextPosition = new Position(tmp2);
                    while(nextPosition.getPosition() == null) {
                        nextPosition = getPositionFromConsole(scanner, "next");
                    }
                }
                try {
                    if(isWhiteLine) {
                        if (chessBoard.getFigureOnCell(currentPosition).getFigureColor() == ChessColor.WHITE) {
                            chessBoard.moveFigure(currentPosition, nextPosition);
                            gameHistory.write(ChessBoard.movement);
                            isWhiteLine = false;
                        } else {
                            System.err.println("Now White’s move.");
                        }
                    } else {
                        if (chessBoard.getFigureOnCell(currentPosition).getFigureColor() == ChessColor.BLACK) {
                            chessBoard.moveFigure(currentPosition, nextPosition);
                            gameHistory.write(ChessBoard.movement);
                            isWhiteLine = true;
                        } else {
                            System.err.println("Now Black’s move.");
                        }
                    }
                } catch (InvalidFigureMovementException e) {
                    System.err.println(e);
                }
            }
            gameHistory.close();
        } catch (IOException e) {
            System.err.println("Something gonna wrong. File cannot be created.");
        }
    }
}
