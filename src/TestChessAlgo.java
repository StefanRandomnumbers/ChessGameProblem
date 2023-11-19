import static org.junit.Assert.*;

import org.junit.Test;

public class TestChessAlgo {

	@Test
	public void testBoardTraversalAlgorithm() {
		int boardRows = 5;
		int boardCols = 5;
		
		Position start = new Position(0, 0);
		ChessPiece knight = new Knight(start, boardRows, boardCols);
		
		ChessBoard board = new ChessBoard(boardRows, boardCols);
		board.addChessPiece(knight);
		
		BoardTraverser traversalManager = new BoardTraverser(knight, board);
		
		assertEquals(true, traversalManager.traverseBoard());
		assertEquals(true, board.moveFromTo(new Position(0,0), new Position(2,1)));
		assertEquals(2, knight.getCurrentPosition().x);
		assertEquals(1, knight.getCurrentPosition().y);
		traversalManager.clear();
		
		assertEquals(false, traversalManager.traverseBoard());
	}
	
	@Test
	public void testKnight() {
		int boardRows = 8;
		int boardCols = 8;
		
		Position start = new Position(0, 0);
		ChessPiece knight = new Knight(start, boardRows, boardCols);
		
		assertEquals(2, knight.possibleMoves().size());
		assertEquals(false, knight.moveTo(start));
		assertEquals(0, knight.getCurrentPosition().x);
		assertEquals(0, knight.getCurrentPosition().y);
		
		assertEquals(true, knight.moveTo(new Position(2,1)));
		assertEquals(2, knight.getCurrentPosition().x);
		assertEquals(1, knight.getCurrentPosition().y);
	}
	
	@Test
	public void testChessBoard() {
		int boardRows = 8;
		int boardCols = 8;
		
		Position start = new Position(0, 0);
		ChessPiece knight = new Knight(start, boardRows, boardCols);
		
		ChessBoard board = new ChessBoard(boardRows, boardCols);
		board.addChessPiece(knight);
		
		assertEquals(knight, board.getChessPiece(start));
		
		Position p1 = new Position(2, 1);
		Position p2 = new Position(4, 1);
		
		assertEquals(false, board.moveFromTo(p1, p2));
		assertEquals(knight, board.getChessPiece(start));
		
		assertEquals(true, board.moveFromTo(start, p1));
		assertNotEquals(knight, board.getChessPiece(start));
		assertEquals(knight, board.getChessPiece(p1));
	}

}
