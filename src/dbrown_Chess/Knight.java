package dbrown_Chess;

import java.util.ArrayList;

public class Knight extends Piece {


	public Knight(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();


		addAvailablePosition(thePosition.getRow()+2, thePosition.getCol()+1, theBoard, validMoves);
		addAvailablePosition(thePosition.getRow()+2, thePosition.getCol()-1, theBoard, validMoves); 	
		addAvailablePosition(thePosition.getRow()-2, thePosition.getCol()+1, theBoard, validMoves);
		addAvailablePosition(thePosition.getRow()-2, thePosition.getCol()-1, theBoard, validMoves); 
		addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()+2, theBoard, validMoves); //up 1 over 2 to the right
		addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()-2, theBoard, validMoves); //up 1 over to the left
		addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()+2, theBoard, validMoves); //down 1 over 2 to the right
		addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()-2, theBoard, validMoves); //down 1 over 2 to the left



		return validMoves;
	}



}
