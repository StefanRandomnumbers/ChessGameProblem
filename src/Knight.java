import java.util.*;

public final class Knight extends ChessPiece {

	public Knight(Position startingPosition, int boardRows, int boardCols){
		super(startingPosition, boardRows, boardCols);
	}
	
	
	@Override
	public List<Position> possibleMoves() {
		return this.possibleMoves(this.currentPosition);
	}
	@Override
	public List<Position> possibleMoves(Position position) {
		List<Position> listOfMoves = new ArrayList<Position>();
		
		int[] x_moves = { 2, 1, -1, -2, -2, -1,  1,  2 };	
	    int[] y_moves = { 1, 2,  2,  1, -1, -2, -2, -1 };
		
	    for(int i = 0; i < x_moves.length; i++){
	    	int x_tmp = position.x + x_moves[i];
	    	int y_tmp = position.y + y_moves[i];
	    	
	    	if(x_tmp < this.boardSize.x && x_tmp >= 0 && 
	    	   y_tmp < this.boardSize.y && y_tmp >= 0){
	    		listOfMoves.add(new Position(x_tmp, y_tmp));
	    	}
	    }
		return listOfMoves;
	}

}
