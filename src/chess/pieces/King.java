package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		
		return "K";
	}

	private boolean canMove(Position position) {
		
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		
		return p == null || p.getColor() != getColor();
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
		
		return matPossibleMoves;
	}
}
