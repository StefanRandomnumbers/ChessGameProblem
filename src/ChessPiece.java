import java.util.*;


public abstract class ChessPiece {
	
	protected Position boardSize;	// the pieces need to know the end of the chess board to generate all possible moves 
	protected Position currentPosition;
	
	
	// constructor
	public ChessPiece(Position startingPosition, int boardRows, int boardCols){
		
		this.currentPosition = startingPosition;
		this.boardSize = new Position(boardRows, boardCols);
	}
	
	public boolean moveTo(Position newPosition) {
		boolean moveIsLegal = false;
		
		if(this.possibleMoves().contains(newPosition)){
			this.currentPosition = newPosition;
			moveIsLegal = true;
		}
		
		return moveIsLegal;
	}
	
	
	public Position getCurrentPosition(){
		return this.currentPosition;
	}
	
	// return a list with all the possible end locations the piecee could move to
	public abstract List<Position> possibleMoves();
	public abstract List<Position> possibleMoves(Position position);
	
}
