import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.Assert.*;

@RunWith(Suite.class)
@SuiteClasses({})
public class AllTests {
	public AllTests(){
		int boardRows = 5;
		int boardCols = 5;
		
		Position start = new Position(0, 0);
		ChessPiece knight = new Knight(start, boardRows, boardCols);
		
		ChessBoard board = new ChessBoard(boardRows, boardCols);
		board.addChessPiece(knight);
		
		BoardTraverser traversalManager = new BoardTraverser(knight, board);
		
		assertEquals(true, traversalManager.traverseBoard());
		assertEquals(true, board.moveFromTo(new Position(0,0), new Position(2,1)));
		assertEquals(false, traversalManager.traverseBoard());
	}
}
