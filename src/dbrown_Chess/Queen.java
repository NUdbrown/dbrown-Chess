package dbrown_Chess;

import java.util.ArrayList;

public class Queen extends Piece {


	public Queen(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();
		boolean foundPiece = false;

		//diagonal movements
		for (int i = 1; !foundPiece && (i < SIZE); i++) {
			Position targetPos = new Position(thePosition.getRow() + i,thePosition.getCol() + i);
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}
		}

		for(int i = 1; !foundPiece && (i < SIZE); i++){
			Position targetPos = new Position(thePosition.getRow()+i, thePosition.getCol()-i);
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}


		}

		for(int i = 1; !foundPiece && (i < SIZE); i++){
			Position targetPos = new Position(thePosition.getRow()-i, thePosition.getCol()+i);
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}


		}

		for(int i = 1; !foundPiece && (i < SIZE); i++){
			Position targetPos = new Position(thePosition.getRow()-i, thePosition.getCol()-i);
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}


		}

		// row movement
		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow()+i, thePosition.getCol());
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}


		}

		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow()-i, thePosition.getCol());
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}


		}

		//available column movements
		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow(), thePosition.getCol()-i);
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}

		}

		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow(), thePosition.getCol()+i);
			if(targetPos.isOnBoard()){
				addAvailablePosition(targetPos, theBoard, validMoves);
				if (theBoard.isPieceAtPosition(targetPos)) {
					break;
				}
			}

		}	


		return validMoves;
	}






}
