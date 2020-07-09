/**
 * Created by mari.avetisyan on 02/07/2020.
 */
public interface IBoardCell {
    void setFigure(ChessFigure figure);
    ChessFigure getFigure();
    void setPosition(int positionX, int positionY);
    Position getPosition();
    boolean isCellEmpty();
}
