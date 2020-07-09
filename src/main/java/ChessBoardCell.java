/**
 * Created by mari.avetisyan on 24/06/2020.
 */
public class ChessBoardCell implements IBoardCell {
    private ChessFigure cellFigure;
    private Position cellPosition;

    ChessBoardCell(int positionX, int positionY, ChessFigure figure) {
        setPosition(positionX, positionY);
        setFigure(figure);
    }

    public void setFigure(ChessFigure figure) {
        this.cellFigure = figure;
    }

    public ChessFigure getFigure() {
        return this.cellFigure;
    }

    public void setPosition(int positionX, int positionY) {
        ++positionY;
        String position = ((char)(65+positionX)) + "" + positionY;
        this.cellPosition = new Position(position);
        if(!isCellEmpty()) {
            cellFigure.setFigurePosition(this.cellPosition);
        }
    }

    public Position getPosition() {
        return this.cellPosition;
    }

    public boolean isCellEmpty() {
        return this.cellFigure == null;
    }

}
