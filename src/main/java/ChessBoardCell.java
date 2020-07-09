/**
 * Created by mari.avetisyan on 24/06/2020.
 */
public class ChessBoardCell implements IBoardCell {
    private ChessFigure figure;
    private int x;
    private int y;

    ChessBoardCell(int xPos, int yPos, ChessFigure figure) {
        setX(xPos);
        setY(yPos);
        setFigure(figure);
    }

    public ChessFigure getFigure() {
        return this.figure;
    }

    public void setFigure(ChessFigure figure) {
        this.figure = figure;
    }

    public int getX() {
        return x;
    }

    public void setX(int xPosition) {
        if(xPosition >= 1 && xPosition <=8)  {
            this.x = xPosition;
        } else {
            System.err.println("Your entered xPosition is invalid.");
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int yPosition) {
        if(yPosition >= 1 && yPosition <=8)  {
            this.y = yPosition;
        } else {
            System.err.println("Your entered yPosition is invalid.");
        }

    }

    public boolean isCellEmptyn() {
        return this.figure == null;
    }

}
