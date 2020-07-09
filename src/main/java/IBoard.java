import enums.ChessColor;
import exeptions.InvalidFigureMovementException;
import exeptions.NoFigureException;

import java.util.List;

/**
 * Created by mari.avetisyan on 24/06/2020.
 */
interface IBoard<F> {
    void createBoard();
    void printBoard();
    void moveFigure(Position from, Position to)throws InvalidFigureMovementException;
    ChessColor getCellColor(Position position);
    F getFigureOnCell(Position position);
    void placeFigures(List<F> figures);
    void isThereAFigureInPosition(Position a)throws NoFigureException;
}
