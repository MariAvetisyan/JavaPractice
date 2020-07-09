import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;

/**
 * Created by mari.avetisyan on 02/07/2020.
 */
class Rook extends ChessFigure {
    Rook(ChessColor color, String position) {
        super(color, position);
        setFigureType(ChessFiguresType.ROOK);
    }

    @Override
    void canMove(Position nextPosition)throws InvalidFigureMovementException {
        if(getFigurePosition().isPositionsEqual(nextPosition) || !(getFigurePosition().getPositionY() == nextPosition.getPositionY() || getFigurePosition().getPositionX() == nextPosition.getPositionX())) {
            throw new InvalidFigureMovementException("Your enterder position is invalid. " + getFigureType() + " cant go from" + getFigurePosition().toString() + " to " + nextPosition.toString());
        }
    }
}
