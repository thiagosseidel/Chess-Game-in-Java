package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;


public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);

		this.chessMatch = chessMatch;
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
		
		// #specialmove en passant
		ChessPiece cpVulnerable = chessMatch.getEnPassantVulnerable();
		
		if (cpVulnerable != null && getColor() != cpVulnerable.getColor())
		{
			final Position posVulnerable = cpVulnerable.getPosition();
			
			final int initialRowEnPassant = (getColor() ==  Color.WHITE) ? 3 : 4;
			
			if (position.getRow() == initialRowEnPassant &&
				posVulnerable.getRow() == initialRowEnPassant &&
				Math.abs(position.getColumn() - posVulnerable.getColumn()) == 1) {
				
				matPossibleMoves[position.getRow() + aux][posVulnerable.getColumn()] = true;
			}
		}

		return matPossibleMoves;
	}
}
