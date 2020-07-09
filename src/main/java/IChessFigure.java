import enums.ChessColor;
import enums.ChessFiguresType;

/**
 * Created by mari.avetisyan on 26/06/2020.
 */
public interface IChessFigure {
    ChessColor getFigureColor();
    ChessFiguresType getFigureType();
    Position getFigurePosition();
    void setFigureType(ChessFiguresType figuresType);
    void setFigurePosition(Position position);
}
