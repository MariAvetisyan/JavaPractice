import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;

/**
 * Created by mari.avetisyan on 02/07/2020.
 */
class Knight extends ChessFigure {
    Knight(ChessColor color, String position) {
        super(color, position);
        setFigureType(ChessFiguresType.KNIGHT);
    }

    @Override
    void canMove(Position nextPosition)throws InvalidFigureMovementException {
        if( !( nextPosition.getPositionX() == getFigurePosition().getPositionX() - 1 && nextPosition.getPositionY() == getFigurePosition().getPositionY() + 2 ||
                nextPosition.getPositionX() == getFigurePosition().getPositionX() + 1 && nextPosition.getPositionY() == getFigurePosition().getPositionY() + 2 ||
                nextPosition.getPositionX() == getFigurePosition().getPositionX() + 2 && nextPosition.getPositionY() == getFigurePosition().getPositionY() + 1 ||
                nextPosition.getPositionX() == getFigurePosition().getPositionX() + 2 && nextPosition.getPositionY() == getFigurePosition().getPositionY() - 1 ||
                nextPosition.getPositionX() == getFigurePosition().getPositionX() + 1 && nextPosition.getPositionY() == getFigurePosition().getPositionY() - 2 ||
                nextPosition.getPositionX() == getFigurePosition().getPositionX() - 1 && nextPosition.getPositionY() == getFigurePosition().getPositionY() - 2 ||
                nextPosition.getPositionX() == getFigurePosition().getPositionX() - 2 && nextPosition.getPositionY() == getFigurePosition().getPositionY() - 1 ||
                nextPosition.getPositionX() == getFigurePosition().getPositionX() - 2 && nextPosition.getPositionY() == getFigurePosition().getPositionY() + 1)) {
            throw new InvalidFigureMovementException("Your enterder position is invalid. " + getFigureType() + " cant go from" + getFigurePosition().toString() + " to " + nextPosition.toString());
        }
    }
}
