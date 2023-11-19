

public class GameManager {

	public static void main(String[] args) {
		int boardRows = 5;
		int boardCols = 5;
		
		Position start = new Position(0, 0);
		ChessPiece knight = new Knight(start, boardRows, boardCols);
		
		ChessBoard board = new ChessBoard(boardRows, boardCols);
		board.addChessPiece(knight);
		
		BoardTraverser traversalManager = new BoardTraverser(knight, board);
		System.out.println("Is it possible to traverse the board: " + traversalManager.traverseBoard());
		
		System.out.print(traversalManager);
	}
	

}
