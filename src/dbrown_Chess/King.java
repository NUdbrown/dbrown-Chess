package dbrown_Chess;

import java.util.ArrayList;


public class King extends Piece{

	public King(String pieceType, String pieceColor, String pieceTypeCode,
			String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
		
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();		
	
		addAvailablePosition(thePosition.getRow()+1, thePosition.getCol(), theBoard, validMoves, true);
		addAvailablePosition(thePosition.getRow()-1, thePosition.getCol(), theBoard, validMoves, true); 
		addAvailablePosition(thePosition.getRow(), thePosition.getCol()+1, theBoard, validMoves, true); 
		addAvailablePosition(thePosition.getRow(), thePosition.getCol()-1, theBoard, validMoves, true); 
		addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()+1, theBoard, validMoves, true); 
		addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()-1, theBoard, validMoves, true); 
		addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()-1, theBoard, validMoves, true); 
		addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()+1, theBoard, validMoves, true); 
		
		return validMoves;
	}
	
	

		


}

