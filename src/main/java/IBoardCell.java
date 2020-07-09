/**
 * Created by mari.avetisyan on 02/07/2020.
 */
public interface IBoardCell {
    ChessFigure getFigure();
    void setFigure(ChessFigure figure);
    int getX();
    void setX(int xPosition);
    int getY();
    void setY(int yPosition);
    boolean isCellEmptyn();
}
