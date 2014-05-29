package dbrown_Chess;

import java.util.ArrayList;

public class Rook extends Piece{
	
	
	public Rook(String pieceType, String pieceColor, String pieceTypeCode,
			String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
		
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
	    
		for(int i = 0; i < 8; i++){
			addAvailablePosition(thePosition.getRow()+i, thePosition.getCol(), theBoard, validMoves, true); //moving up the rows
			addAvailablePosition(thePosition.getRow()-i, thePosition.getCol(), theBoard, validMoves, true); //moving down the rows
			addAvailablePosition(thePosition.getRow(), thePosition.getCol()+i, theBoard, validMoves, true); //moving across the columns
			addAvailablePosition(thePosition.getRow(), thePosition.getCol()-i, theBoard, validMoves, true); //moving down across the columns
		}
		return validMoves;
	}
	



}
