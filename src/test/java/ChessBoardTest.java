import enums.ChessColor;
import exeptions.NoFigureException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Created by mari.avetisyan on 07/07/2020.
 */
public class ChessBoardTest {
    private ChessBoard board = new ChessBoard(8,8);
    private Position position1 = new Position("h4");
    private Position position2 = new Position("d7");
    private Position position3 = new Position("e5");
    private Position position4 = new Position("c8");
    private Position position5 = new Position("h8");
    private Position position6 = new Position("d1");
    private ChessFigure whiteKing = new King(ChessColor.WHITE, "e5");
    private ChessFigure whitePawn = new Pawn(ChessColor.WHITE, "c8");
    private ChessFigure blackRook = new Rook(ChessColor.BLACK, "h8");
    private ChessFigure blackQueen = new Queen(ChessColor.BLACK, "d1");

    @Before
    public void init() {
        List<ChessFigure> figures = new ArrayList<ChessFigure>();
        Collections.addAll(figures, whiteKing, whitePawn, blackRook, blackQueen);
        board.placeFigures(figures);
    }


    @Test
    public void getCellColor() {
        assertEquals(ChessColor.BLACK, board.getCellColor(position1));
        assertEquals(ChessColor.WHITE, board.getCellColor(position2));
    }

    @Test
    public void getFigureOnCell() {
        assertEquals(whiteKing, board.getFigureOnCell(position3));
        assertEquals(whitePawn, board.getFigureOnCell(position4));
        assertEquals(blackRook, board.getFigureOnCell(position5));
        assertEquals(blackQueen, board.getFigureOnCell(position6));
    }

    @Test
    public void isThereAFigureInPosition() {
        assertThrows(NoFigureException.class, () -> {
            board.isThereAFigureInPosition(position1);
        });

        assertThrows(NoFigureException.class, () -> {
            board.isThereAFigureInPosition(position2);
        });
    }
}
