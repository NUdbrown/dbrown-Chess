package dbrown_Chess;

import java.util.ArrayList;

public class Pawn extends Piece{

	private boolean firstMove = true;

	public Pawn(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
		int direction = 1;
		if (this.getPieceColorCode().equals("l")) direction = -1;

		if(firstMove){
			addAvailablePosition(thePosition.getRow() + (direction * 2),thePosition.getCol(), theBoard, validMoves, false);
		}
		addAvailablePosition(thePosition.getRow() + (direction * 1),thePosition.getCol(), theBoard, validMoves, false);
		addAvailablePosition(thePosition.getRow() + (direction * 1),thePosition.getCol() + 1, theBoard, validMoves, true);
		addAvailablePosition(thePosition.getRow() + (direction * 1),thePosition.getCol() - 1, theBoard, validMoves, true);
		
		firstMove = false;
		return validMoves;
	}


	


}
