import enums.ChessColor;
import exeptions.InvalidFigureMovementException;
import exeptions.NoFigureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by mari.avetisyan on 24/06/2020.
 */
class ChessBoard implements IBoard<ChessFigure> {
    private static final Logger LOG = LoggerFactory.getLogger(ChessBoard.class);
    private ChessBoardCell[][] board;
    static String movement;

    ChessBoard(int xSize, int ySize) {
        board = new ChessBoardCell[xSize][ySize];
        createBoard();
    }

    @Override
    public void createBoard() {
        LOG.info("Starting chess board creating.");
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                board[i][j] = new ChessBoardCell(i , j, null);
            }
        }
        LOG.info("Finished chess board creating.");
    }

    @Override
    public void printBoard() {
        for(int i = 0; i < board.length; ++i) {
            System.out.print(i+1 + "| ");
            for(int j = 0; j < board[i].length; ++j) {
                if(board[i][j].isCellEmpty()) {
                    System.out.print("*  ");
                } else {
                    System.out.print(board[i][j].getFigure().getFigureType().toString().charAt(0) +""+ board[i][j].getFigure().getFigureType().toString().charAt(1)+ " ");
                }
            }
            System.out.println();
        }
        System.out.println("  ________________________");
        System.out.println("   A  B  C  D  E  F  G  H");
    }

    @Override
    public ChessFigure getFigureOnCell(Position position) {
        return board[position.getPositionY()-1][position.getPositionXNumericValue()].getFigure();
    }

    @Override
    public void placeFigures(List<ChessFigure> figures) {
        for (ChessFigure figure: figures) {
            board[figure.getFigurePosition().getPositionY() - 1][figure.getFigurePosition().getPositionXNumericValue()].setFigure(figure);
        }
    }

    @Override
    public void moveFigure(Position from, Position to)throws InvalidFigureMovementException {
        LOG.info("Start moving figure.");
        ChessFigure figure =  board[from.getPositionY()-1][from.getPositionXNumericValue()].getFigure();
        figure.canMove(to);
        movementToString(from, to, figure);
        figure.setFigurePosition(to);
        board[to.getPositionY()-1][to.getPositionXNumericValue()].setFigure(getFigureOnCell(from));
        board[from.getPositionY()-1][from.getPositionXNumericValue()].setFigure(null);
        LOG.info("Finished moving figure.");
    }

    private void movementToString(Position from, Position to, ChessFigure figure) {
        movement = figure.getFigureType().toString() + " " + from.toString() + "-" + to.toString();
        if(Game.isWhiteLine) {
            movement += "  --  ";
        } else {
            movement += "\n";
        }
    }

    @Override
    public ChessColor getCellColor(Position position) {
        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if(((i % 2 == 0 && j % 2 == 1) || (i % 2 == 1 && j % 2 == 0))
                        && (j == position.getPositionXNumericValue() && i == position.getPositionY())) {
                    return ChessColor.BLACK;
                }
            }
        }
        return ChessColor.WHITE;
    }

    @Override
    public void isThereAFigureInPosition(Position a)throws NoFigureException {
        if(board[a.getPositionY()-1][a.getPositionXNumericValue()].isCellEmpty()) {
            throw new NoFigureException("No figure in current position");
        }
    }
}
