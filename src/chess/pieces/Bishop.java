package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		
boolean[][] matPossibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(this.position.getRow() - 1, this.position.getColumn() - 1);
		
		// nw
		{
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setRow(p.getRow() - 1);
				p.setColumn(p.getColumn() - 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		// ne
		{
			p.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
			
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setRow(p.getRow() - 1);
				p.setColumn(p.getColumn() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		// sw
		{
			p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
			
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setRow(p.getRow() + 1);
				p.setColumn(p.getColumn() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		// se
		{
			p.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
			
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setRow(p.getRow() + 1);
				p.setColumn(p.getColumn() - 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return matPossibleMoves;
	}
}
