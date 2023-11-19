

public class ChessBoard {
	private ChessPiece[][] board;
	private int boardRows;
	private int boardCols;
	
	
	public ChessBoard(int boardRows, int boardCols){
		this.board = new ChessPiece[boardRows][boardCols];
		this.boardRows = boardRows;
		this.boardCols = boardCols;
	}
	
	public void addChessPiece(ChessPiece piece){
		Position piecePosition = piece.getCurrentPosition();
		this.board[piecePosition.x][piecePosition.y] = piece;
	}
	
	public boolean moveFromTo(Position p1, Position p2){
		boolean moveIsLegal = false;
		if(this.board[p1.x][p1.y] != null){
			if(this.board[p1.x][p1.y].moveTo(p2)){
				this.board[p2.x][p2.y] = this.board[p1.x][p1.y];
				this.board[p1.x][p1.y] = null;
				moveIsLegal = true;
			}
		}
		return moveIsLegal;
	}
	
	public ChessPiece getChessPiece(Position pos){
		return this.board[pos.x][pos.y];
	}
	
	public int getBoardRows(){
		return this.boardRows;
	}
	public int getBoardCols(){
		return this.boardCols;
	}
}
