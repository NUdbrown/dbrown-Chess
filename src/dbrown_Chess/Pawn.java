package dbrown_Chess;

import java.util.ArrayList;

public class Pawn extends Piece{

	//add in the pawn promotion

	/**
	 * if the pawn reaches the opposite end of the board,
	 * prompt user to pick what to turn it into
	 * can turn into a (Queen, Rook, Knight, Bishop)
	 */

	public Pawn(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
		int direction = 1;
		if (this.getPieceColorCode().equals("l")) direction = -1;

		if(firstMove){
			addAvailablePositionForPawn(thePosition.getRow() + (direction * 2),thePosition.getCol(), theBoard, validMoves, false);
		}
		addAvailablePositionForPawn(thePosition.getRow() + (direction * 1),thePosition.getCol(), theBoard, validMoves, false);
		addAvailablePositionForPawn(thePosition.getRow() + (direction * 1),thePosition.getCol() + 1, theBoard, validMoves, true);
		addAvailablePositionForPawn(thePosition.getRow() + (direction * 1),thePosition.getCol() - 1, theBoard, validMoves, true);

		
		return validMoves;
	}

	public void addAvailablePositionForPawn(int row, int col, Board theBoard,ArrayList<Position> validMoves, boolean mustCapture) {
		Position newPosition = new Position(row, col);
		
		if(newPosition.isOnBoard() &&
				((mustCapture && theBoard.isPieceAtPosition(newPosition) && !theBoard.getPiece(newPosition).hasSameColor(this)) ||
						(!mustCapture && !theBoard.isPieceAtPosition(newPosition)))){

			validMoves.add(newPosition);

		}		

	}

	public Piece promotion(){


		return null;
	}

}
