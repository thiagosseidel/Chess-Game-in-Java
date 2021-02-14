package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);

		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		
		return "K";
	}

	private boolean canMove(Position position) {
		
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0; 
	}
	
	@Override
	public boolean[][] possibleMoves() {

		boolean[][] matPossibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		final int iInit = position.getRow() - 1;
		final int jInit = position.getColumn() - 1;
		
		final int iSize = position.getRow() + 1;
		final int jSize = position.getColumn() + 1;
		
		Position p = new Position(iInit, jInit);
		
		for (int i = iInit; i <= iSize; ++i) {
			
			p.setRow(i);
			
			for (int j = jInit; j <= jSize; ++j) {
				
				p.setColumn(j);

				if (getBoard().positionExists(p) && canMove(p)) {
					
					matPossibleMoves[p.getRow()][p.getColumn()] = true;
				}
			}
		}
		
		// #specialmove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			
			// #specialmove castling kingside rook
			Position posRook1 = new Position(position.getRow(), position.getColumn() + 3);
			
			if (testRookCastling(posRook1)) {
				
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					
					matPossibleMoves[p2.getRow()][p2.getColumn()] = true;
				}
			}
			
			// #specialmove castling queenside rook
			Position posRook2 = new Position(position.getRow(), position.getColumn() - 4);
			
			if (testRookCastling(posRook2)) {
				
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					
					matPossibleMoves[p2.getRow()][p2.getColumn()] = true;
				}
			}
		}
		
		return matPossibleMoves;
	}
}
