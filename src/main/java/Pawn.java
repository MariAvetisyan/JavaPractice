import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;

/**
 * Created by mari.avetisyan on 26/06/2020.
 */
class Pawn extends ChessFigure {
    Pawn(ChessColor color, String position) {
        super(color, position);
        setFigureType(ChessFiguresType.PAWN);
    }

    @Override
    void canMove(Position nextPosition)throws InvalidFigureMovementException {
        if (!(getFigureColor() == ChessColor.WHITE && ((getFigurePosition().getPositionY() + 1 == nextPosition.getPositionY() || (getFigurePosition().getPositionY() == 2 && getFigurePosition().getPositionY() + 2 == nextPosition.getPositionY()))
                && getFigurePosition().getPositionX() == nextPosition.getPositionX()) || (getFigureColor() == ChessColor.BLACK && ((getFigurePosition().getPositionY() - 1 == nextPosition.getPositionY() || (getFigurePosition().getPositionY() == 7 && getFigurePosition().getPositionY() - 2 == nextPosition.getPositionY()))
                && getFigurePosition().getPositionX() == nextPosition.getPositionX())))) {
            throw new InvalidFigureMovementException("Your entered position is invalid. " + getFigureType() + " cant go from " + getFigurePosition().toString() + " to " + nextPosition.toString());
        }
    }
}
