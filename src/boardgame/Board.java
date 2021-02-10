package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		super();
		
		if (rows < 1 || columns < 1) {
			
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
		}
		
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
		
		if (!positionExists(row, column)) {
				
			throw new BoardException("Position not on the board.");
		}
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		
		return piece(position.getRow(), position.getColumn());
	}
	
	public void placePiece(Piece piece, Position position) {
		
		if (thereIsAPiece(position)) {
			
			throw new BoardException("There is already a piece on position " + position + ".");
		}
		
		if (!positionExists(position)) {
			
			throw new BoardException("Position not on the board.");
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		
		piece.position = position;
	}
	
	public boolean positionExists(Position position) {
		
		return positionExists(position.getRow(), position.getColumn());
	}
	
	private boolean positionExists(int row, int column) {
		
		return ((row >= 0 && row < rows) && (column >= 0 && column < columns));
	}
	
	public boolean thereIsAPiece(Position position) {
		
		if (!positionExists(position)) {
			
			throw new BoardException("Position not on the board.");
		}
		
		return piece(position) != null; 
	}
	
	public Piece removePiece(Position position) {
		
		if (!positionExists(position)) {
			
			throw new BoardException("Position not on the board.");
		}
		
		Piece piecePosition = piece(position);
		
		if (piecePosition == null) {
			
			return null;
		}
		
		piecePosition.position = null;
		
		pieces[position.getRow()][position.getColumn()] = null;
		
		return piecePosition;
	}
}
