import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;

/**
 * Created by mari.avetisyan on 24/06/2020.
 */
public abstract class ChessFigure implements IChessFigure {
    private final ChessColor color;
    private ChessFiguresType figuresType;
    private Position position;

    ChessFigure(ChessColor color, String position) {
        this.color = color;
        this.position = new Position(position);
    }

    public ChessColor getFigureColor() {
        return color;
    }

    public ChessFiguresType getFigureType() {
        return figuresType;
    }

    public void setFigureType(ChessFiguresType figuresType) {
        this.figuresType = figuresType;
    }

    public Position getFigurePosition() {
        return this.position;
    }

    public void setFigurePosition(Position position) {
        this.position.setPosition(position.toString());
    }

    abstract void canMove(Position nextPosition)throws InvalidFigureMovementException;
}
