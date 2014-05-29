package dbrown_Chess;

import java.util.ArrayList;

public class Queen extends Piece {

	
	public Queen(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
	    
		for(int i = 1; i < 8; i++){
			addAvailablePosition(thePosition.getRow()+i, thePosition.getCol(), theBoard, validMoves, true); //moving up the rows
			addAvailablePosition(thePosition.getRow()-i, thePosition.getCol(), theBoard, validMoves, true); //moving down the rows
			addAvailablePosition(thePosition.getRow(), thePosition.getCol()+i, theBoard, validMoves, true); //moving across the columns
			addAvailablePosition(thePosition.getRow(), thePosition.getCol()-i, theBoard, validMoves, true); //moving down across the columns
			addAvailablePosition(thePosition.getRow()+i, thePosition.getCol()+i, theBoard, validMoves, true); //moving up diagonally to the right
			addAvailablePosition(thePosition.getRow()+i, thePosition.getCol()-i, theBoard, validMoves, true); //moving up diagonally to the left
			addAvailablePosition(thePosition.getRow()-i, thePosition.getCol()+i, theBoard, validMoves, true); //moving down diagonally to the left
			addAvailablePosition(thePosition.getRow()-i, thePosition.getCol()-i, theBoard, validMoves, true); //moving down diagonally to the right
		}
		return validMoves;
	}
	




}
