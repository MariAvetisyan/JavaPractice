import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;

/**
 * Created by mari.avetisyan on 02/07/2020.
 */
public class Queen extends ChessFigure {
    Queen(ChessColor color, String position) {
        super(color, position);
        setFigureType(ChessFiguresType.QUEEN);
    }

    @Override
    void canMove(Position nextPosition)throws InvalidFigureMovementException {
        for(int i = 1; i <= 8; ++i) {
            if(!((nextPosition.getPositionX() == getFigurePosition().getPositionX() + i && nextPosition.getPositionY() == getFigurePosition().getPositionY() + i)
                    || (nextPosition.getPositionX() == getFigurePosition().getPositionX() - i && nextPosition.getPositionY() == getFigurePosition().getPositionY() - i)
                    || (nextPosition.getPositionX() == getFigurePosition().getPositionX() - i && nextPosition.getPositionY() == getFigurePosition().getPositionY() + i)
                    || (nextPosition.getPositionX() == getFigurePosition().getPositionX() + i && nextPosition.getPositionY() == getFigurePosition().getPositionY() - i))) {
                throw new InvalidFigureMovementException("Your entered position is invalid. " + getFigureType() + " cant go from " + getFigurePosition().toString() + " to " + nextPosition.toString());
            }
        }
    }
}
