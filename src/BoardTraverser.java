import java.util.*;

// a class that takes a chess piece and a chess board and evaluates if it is possible for the piece to 
// traverse the whole board without visiting any given position twice.
public class BoardTraverser {

	protected Stack<boolean[][]> trajectoryHistory;	// hold the history of the tried trajectories 
	protected boolean[][] visitedPositions;					// holds the visited positions in the current trajectory (updates over time)
	protected Stack<Position> positionHistory;	// stack of the previous visited positions
	protected ChessPiece chessPiece;
	protected ChessBoard chessBoard;
	
	public BoardTraverser(ChessPiece chessPiece, ChessBoard board){
		this.chessBoard = board;
		this.chessPiece = chessPiece;
		this.positionHistory = new Stack<Position>();
		Position startPosition = chessPiece.getCurrentPosition();
		this.positionHistory.push(startPosition);
		
		this.trajectoryHistory = new Stack<boolean[][]>();
		this.trajectoryHistory.push(new boolean[board.getBoardRows()][board.getBoardCols()]);
		
		this.visitedPositions = new boolean[board.getBoardRows()][board.getBoardCols()];
		this.visitedPositions[startPosition.x][startPosition.y] = true; 
	}
	
	public void clear(){
		this.positionHistory = new Stack<Position>();
		Position startPosition = chessPiece.getCurrentPosition();
		this.positionHistory.push(startPosition);
		
		this.trajectoryHistory = new Stack<boolean[][]>();
		this.trajectoryHistory.push(new boolean[this.chessBoard.getBoardRows()][this.chessBoard.getBoardCols()]);
		
		this.visitedPositions = new boolean[this.chessBoard.getBoardRows()][this.chessBoard.getBoardCols()];
		this.visitedPositions[startPosition.x][startPosition.y] = true; 
	}
	
	
	public Stack<Position> getPositionHistory(){
		return this.positionHistory;
	}
	
	
	public boolean traverseBoard(){
		final int numberOfPositions = this.chessBoard.getBoardRows() * this.chessBoard.getBoardCols();
		
		while(this.positionHistory.size() < numberOfPositions){
			if(this.positionHistory.isEmpty() || this.trajectoryHistory.isEmpty()){
				return false;
			}
				
			List<Position> possibleMoves = this.chessPiece.possibleMoves(this.positionHistory.peek());
			boolean[][] trajectory = this.trajectoryHistory.peek();
			
			List<Position> usefulMoves = new ArrayList<Position>();
			for(Position move : possibleMoves){
				if(!trajectory[move.x][move.y] && !this.visitedPositions[move.x][move.y]){
					usefulMoves.add(move);
				}
			}
			
			if(usefulMoves.isEmpty()){
				this.tracebackHistory();
			} else {
				this.takeNextMove(usefulMoves.get(0));
			}
		}
		
		return true;
	}
	
	private void takeNextMove(Position nextMove){
		this.positionHistory.push(nextMove);
		this.trajectoryHistory.push(new boolean[this.chessBoard.getBoardRows()][this.chessBoard.getBoardCols()]);
		this.visitedPositions[nextMove.x][nextMove.y] = true;
	}
	private void tracebackHistory(){
		Position currentPosition = this.positionHistory.pop();
		
		this.visitedPositions[currentPosition.x][currentPosition.y] = false;

		this.trajectoryHistory.pop();
		if(!this.trajectoryHistory.isEmpty()){
			this.trajectoryHistory.peek()[currentPosition.x][currentPosition.y] = true;
		}
	}
	
	
	public String toString(){
		String boardString = "\n";
		Stack<Position> positions = this.getPositionHistory();
		
		int[][] board = new int[this.chessBoard.getBoardRows()][this.chessBoard.getBoardCols()];
		
		int i = 0;
		for(Position p : positions){
			board[p.x][p.y] = i;
			i++;
		}
		
		for(int[] d1 : board){
			for(int d2 : d1){
				boardString += d2 + "\t";
			}
			boardString += "\n";
		}
		return boardString;
	}
}
