import enums.ChessColor;
import enums.ChessFiguresType;
import exeptions.InvalidFigureMovementException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Created by mari.avetisyan on 09/07/2020.
 */
public class ChessFigureTest {
    private ChessFigure whiteKing = new King(ChessColor.WHITE, "e5");
    private ChessFigure whitePawn = new Pawn(ChessColor.WHITE, "c8");
    private ChessFigure blackRook = new Rook(ChessColor.BLACK, "h8");
    private ChessFigure blackQueen = new Queen(ChessColor.BLACK, "d1");
    private ChessFigure blackBishop = new Bishop(ChessColor.BLACK, "a1");
    private ChessFigure whiteKnight = new Knight(ChessColor.WHITE, "f1");
    private Position position1  = new Position("e5");
    private Position position2  = new Position("C8");
    private Position position3  = new Position("e1");
    private Position position5  = new Position("c6");
    private Position position7  = new Position("h8");
    private Position position8  = new Position("d1");
    private Position position9  = new Position("a1");
    private Position position10 = new Position("f1");

    @Test
    public void getFigureColor() {
        assertEquals(ChessColor.WHITE, whiteKing.getFigureColor());
        assertEquals(ChessColor.BLACK, blackQueen.getFigureColor());
    }

    @Test
    public void getFigureType() {
        assertEquals(ChessFiguresType.KING, whiteKing.getFigureType());
        assertEquals(ChessFiguresType.PAWN, whitePawn.getFigureType());
        assertEquals(ChessFiguresType.ROOK, blackRook.getFigureType());
        assertEquals(ChessFiguresType.QUEEN, blackQueen.getFigureType());
    }

    @Test
    public void canMove() {
        assertThrows(InvalidFigureMovementException.class, () -> {
            whiteKing.canMove(position1);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            whitePawn.canMove(position2);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            blackRook.canMove(position7);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            blackQueen.canMove(position8);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            blackBishop.canMove(position9);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            whiteKnight.canMove(position10);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            whitePawn.canMove(position5);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            blackRook.canMove(position3);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            blackQueen.canMove(position1);
        });

        assertThrows(InvalidFigureMovementException.class, () -> {
            whiteKnight.canMove(position3);
        });
    }
}
