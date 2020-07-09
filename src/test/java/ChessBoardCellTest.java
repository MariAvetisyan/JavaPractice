import enums.ChessColor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mari.avetisyan on 09/07/2020.
 */

public class ChessBoardCellTest {
    private ChessFigure figure1 = new King(ChessColor.WHITE, "a5");
    private ChessFigure figure2 = new Pawn(ChessColor.BLACK, "h7");
    private ChessBoardCell cell1 = new ChessBoardCell(1, 5, figure1);
    private ChessBoardCell cell2 = new ChessBoardCell(3, 8, figure2);
    private ChessBoardCell cell3 = new ChessBoardCell(1, 5, null);

    @Test
    public void isCellEmptyn() {
        assertEquals(false, cell1.isCellEmptyn());
        assertEquals(false, cell2.isCellEmptyn());
        assertEquals(true, cell3.isCellEmptyn());
    }
}
