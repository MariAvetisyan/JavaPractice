import enums.ChessColor;
import exeptions.InvalidFigureMovementException;
import exeptions.NoFigureException;

import java.util.List;

/**
 * Created by mari.avetisyan on 24/06/2020.
 */
class ChessBoard implements IBoard<ChessFigure> {
    private ChessBoardCell[][] board;
    public static String movement;

    ChessBoard(int xSize, int ySize) {
        board = new ChessBoardCell[xSize][ySize];
        createBoard();
    }

    @Override
    public void createBoard() {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                board[i][j] = new ChessBoardCell(i+1 , j+1, null);
            }
        }
    }

    @Override
    public void printBoard() {
        for(int i = 0; i < board.length; ++i) {
            System.out.print(i+1 + "| ");
            for(int j = 0; j < board[i].length; ++j) {
                if(board[i][j].isCellEmptyn()) {
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

    public void moveFigure(Position from, Position to)throws InvalidFigureMovementException {
        ChessFigure figure =  board[from.getPositionY()-1][from.getPositionXNumericValue()].getFigure();
        figure.canMove(to);
        movementToString(from, to, figure);
        figure.setFigurePosition(to);
        board[to.getPositionY()-1][to.getPositionXNumericValue()].setFigure(getFigureOnCell(from));
        board[from.getPositionY()-1][from.getPositionXNumericValue()].setFigure(null);
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

    public void isThereAFigureInPosition(Position a)throws NoFigureException {
        if(board[a.getPositionY()-1][a.getPositionXNumericValue()].isCellEmptyn()) {
            throw new NoFigureException("No figure in current position");
        }
    }
}
