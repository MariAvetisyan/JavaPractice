import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;
import org.slf4j.LoggerFactory;

/**
 * Created by mari.avetisyan on 02/07/2020.
 */
public class Bishop extends ChessFigure {
    Bishop(ChessColor color, String position) {
        super(color, position);
        setFigureType(ChessFiguresType.BISHOP);
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
