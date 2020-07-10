import enums.ChessColor;
import exeptions.InvalidFigureMovementException;
import exeptions.NoFigureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * Created by mari.avetisyan on 02/07/2020.
 */
class Game {
    private static final Logger LOG = LoggerFactory.getLogger(Game.class);
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

    void initGame() {
        LOG.info("Start game initialisation");
        List<ChessFigure> figures = new ArrayList<ChessFigure>();
        Collections.addAll(figures, whiteKing, whiteQueen, whiteRook1, whiteRook2, whiteBishop1, whiteBishop2, whiteKnight1, whiteKnight2,
                whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7, whitePawn8,
                blackKing, blackQueen, blackRook1, blackRook2, blackBishop1, blackBishop2, blackKnight1, blackKnight2,
                blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7, blackPawn8);
        chessBoard.placeFigures(figures);
        LOG.info("Game is initialised");
    }

    private Position getPositionFromConsole(Scanner scanner, String positionType) {
        System.out.print("Enter figure " + positionType + " position: ");
        String tmp1 = scanner.nextLine();
        return new Position(tmp1);
    }

    void startGame() {
        LOG.info("Start game.");
        System.out.println("The game is started. Have a good game. In case you want to finish, please enter 'End'.");

        try {
            LOG.info("Create gameHistory folder for recording moves.");
            BufferedWriter gameHistory = new BufferedWriter(new FileWriter("gameHistory.txt"));
            while (true) {
                chessBoard.printBoard();

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter figure current position: ");
                String tmp1 = scanner.nextLine();
                Position currentPosition;

                if(tmp1.toUpperCase().equals("END")) {
                    LOG.info("Game is finished.");
                    break;
                } else {
                    currentPosition = new Position(tmp1);

                    while(true) {
                        while (currentPosition.getPosition() == null) {
                            currentPosition = getPositionFromConsole(scanner, "current");
                        }

                        try {
                            chessBoard.isThereAFigureInPosition(currentPosition);
                            LOG.info("Get current position.");
                            break;
                        } catch (NoFigureException e) {
                            LOG.warn("Something gonna wrong. " + e);
                            currentPosition = getPositionFromConsole(scanner, "current");
                        }
                    }
                }


                System.out.print("Enter figure next position: ");
                String tmp2 = scanner.nextLine();
                Position nextPosition;

                if(tmp2.toUpperCase().equals("END")) {
                    LOG.info("Game is finished.");
                    break;
                } else {
                    nextPosition = new Position(tmp2);
                    while(nextPosition.getPosition() == null) {
                        nextPosition = getPositionFromConsole(scanner, "next");
                    }
                    LOG.info("Get next position.");
                }
                try {
                    if(isWhiteLine) {
                        LOG.info("Now White’s move.");
                        if (chessBoard.getFigureOnCell(currentPosition).getFigureColor() == ChessColor.WHITE) {
                            chessBoard.moveFigure(currentPosition, nextPosition);
                            gameHistory.write(ChessBoard.movement);
                            isWhiteLine = false;
                            LOG.info("White’s movement is done.");
                        } else {
                            LOG.error("Now White’s move.");
                        }
                    } else {
                        LOG.info("Now Black’s move.");
                        if (chessBoard.getFigureOnCell(currentPosition).getFigureColor() == ChessColor.BLACK) {
                            chessBoard.moveFigure(currentPosition, nextPosition);
                            gameHistory.write(ChessBoard.movement);
                            isWhiteLine = true;
                            LOG.info("Black’s movement is done.");
                        } else {
                            LOG.error("Now Black’s move.");
                        }
                    }
                } catch (InvalidFigureMovementException e) {
                    LOG.error("Something gonna wrong. " + e);
                }
            }
            gameHistory.close();
        } catch (IOException e) {
            LOG.error("Something gonna wrong. GameHistory file cannot be created.");
        }
    }

    void arrangeThePosition()throws Exception {
        FileReader fr = new FileReader("fileRorArrangeThePosition.txt");
        BufferedReader br=new BufferedReader(fr);
        List<String> listOfFileLines = new ArrayList<>();
        String[] arrOfFileLines;
        String fileLine;

        while((fileLine = br.readLine()) != null){
            fileLine = fileLine.trim();
            if ((fileLine.length()!=0))
            {
                listOfFileLines.add(fileLine);
            }
        }
        arrOfFileLines = (String[])listOfFileLines.toArray(new String[listOfFileLines.size()]);
        Map<String, ChessFigure> map = new HashMap<>();
        for(int i = 0; i < arrOfFileLines.length; ++i) {
            String[] tempArray;
            tempArray = arrOfFileLines[i].split(" ");
            if(tempArray.length == 3) {
                switch (tempArray[1].toLowerCase()) {
                    case "king":
                        map.put("figure" + i, new King(ChessColor.valueOf(tempArray[0].toUpperCase()), tempArray[2]));
                        break;
                    case "queen":
                        map.put("figure" + i, new Queen(ChessColor.valueOf(tempArray[0].toUpperCase()), tempArray[2]));
                        break;
                    case "rook":
                        map.put("figure" + i, new Rook(ChessColor.valueOf(tempArray[0].toUpperCase()), tempArray[2]));
                        break;
                    case "bishop":
                        map.put("figure" + i, new Bishop(ChessColor.valueOf(tempArray[0].toUpperCase()), tempArray[2]));
                        break;
                    case "knight":
                        map.put("figure" + i, new Knight(ChessColor.valueOf(tempArray[0].toUpperCase()), tempArray[2]));
                        break;
                    case "pawn":
                        map.put("figure" + i, new Pawn(ChessColor.valueOf(tempArray[0].toUpperCase()), tempArray[2]));
                        break;
                    default:
                        LOG.error("You write invalid figure type. I cant arrange " + tempArray[1].toUpperCase() + " figure. Please recheck fileRorArrangeThePosition.txt file.");
                        break;
                }
            } else {
                isWhiteLine = tempArray[0].toLowerCase().equals("white");
            }
        }
        List<ChessFigure> figures = new ArrayList<ChessFigure>(map.values());
        chessBoard.placeFigures(figures);
        startGame();
        br.close();
        fr.close();
    }
}
