import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;

/**
 * Created by mari.avetisyan on 24/06/2020.
 */
class King extends ChessFigure {
    King(ChessColor color, String position) {
        super(color, position);
        setFigureType(ChessFiguresType.KING);
    }

    @Override
    void canMove(Position nextPosition) throws InvalidFigureMovementException {
        if (!getFigurePosition().isPositionsEqual(nextPosition) || !(getFigurePosition().getPositionX() + 1 >= nextPosition.getPositionX() && getFigurePosition().getPositionX() - 1 <= nextPosition.getPositionX()) &&
                (getFigurePosition().getPositionY() + 1 >= nextPosition.getPositionY() && getFigurePosition().getPositionY() - 1 <= nextPosition.getPositionY())) {
            throw new InvalidFigureMovementException("Your entered position is invalid. " + getFigureType() + " cant go from " + getFigurePosition().toString() + " to " + nextPosition.toString());
        }
    }
}
