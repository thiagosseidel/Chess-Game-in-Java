package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {

		boolean[][] matPossibleMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(this.position.getRow() - 1, this.position.getColumn());
		
		// above
		{
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setRow(p.getRow() - 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		// left
		{
			p.setValues(this.position.getRow(), this.position.getColumn() - 1);
			
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setColumn(p.getColumn() - 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		// right
		{
			p.setValues(this.position.getRow(), this.position.getColumn() + 1);
			
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setColumn(p.getColumn() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		// below
		{
			p.setValues(this.position.getRow() + 1, this.position.getColumn());
			
			while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
				
				p.setRow(p.getRow() + 1);
			}
			
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				
				matPossibleMoves[p.getRow()][p.getColumn()] = true;
			}
		}
		
		// nw
		{
			p.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
			
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
