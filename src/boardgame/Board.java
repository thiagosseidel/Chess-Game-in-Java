package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		super();
		
		this.rows = rows;
		this.columns = columns;

		pieces = new Piece[rows][columns]; 
	}

	public int getRows() {
		
		return rows;
	}

	public int getColumns() {
		
		return columns;
	}
	
	public Piece piece(int row, int column) {
		
		if (row >= this.rows || column >= this.columns) {
			
			return null;
		}
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		
		return piece(position.getRow(), position.getColumn());
	}
	
	public boolean placePiece(Piece piece, Position position) {
		
		if (position.getRow() >= rows || position.getColumn() >= columns) {
			
			return false;
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		
		piece.position = position;
		
		return true;
	}
}
