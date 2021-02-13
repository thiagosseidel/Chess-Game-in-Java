package chess.pieces;

import chess.Color;
import chess.ChessPiece;
import boardgame.Board;
import boardgame.Position;


public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		
		return "P";
	}
	
	@Override
	public boolean[][] possibleMoves() {

		boolean[][] matPossibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		final int aux = (getColor() ==  Color.BLACK) ? + 1 : - 1;
		
		final int row = position.getRow();
		final int column = position.getColumn();
		
		Position p = new Position(row + aux, column);
		
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			
			matPossibleMoves[p.getRow()][p.getColumn()] = true;
			
			if (getMoveCount() == 0)
			{
				p.setRow(row + (2 * aux));
				
				if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					
					matPossibleMoves[p.getRow()][p.getColumn()] = true;
				}
			}
		}
		
		p.setRow(row + aux);
		p.setColumn(column + 1);
		
		if (getBoard().positionExists(p)) {
		
			ChessPiece chessPiece = (ChessPiece) getBoard().piece(p);
			
			if (chessPiece != null && getColor() != chessPiece.getColor()) {
					
					matPossibleMoves[p.getRow()][p.getColumn()] = true;
				}
		}

		p.setColumn(column - 1);

		if (getBoard().positionExists(p)) {
			
			ChessPiece chessPiece = (ChessPiece) getBoard().piece(p);
			
			if (chessPiece != null && getColor() != chessPiece.getColor()) {
					
					matPossibleMoves[p.getRow()][p.getColumn()] = true;
				}
		}

		return matPossibleMoves;
	}
}
