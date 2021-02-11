package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		super();
		
		this.board = board;
		this.position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		
		boolean[][] matPossibleMoves = possibleMoves();
		
		for (int i = 0; i < matPossibleMoves.length; ++i) {
		
			for (int j = 0; j < matPossibleMoves.length; ++j) {
				
				if (matPossibleMoves[i][j]) {
					
					return true;
				}
			}
		}
		
		return false;
	}
}
