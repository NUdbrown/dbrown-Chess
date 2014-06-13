package dbrown_Chess;

import java.util.ArrayList;

public class Knight extends Piece {


	public Knight(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		super(pieceType, pieceColor, pieceTypeCode, pieceColorCode);
	}

	@Override
	public ArrayList<Position> getMoves(Position thePosition, Board theBoard) {
		ArrayList<Position> validMoves = new ArrayList<Position>();

		Position targetPos1 = new Position(thePosition.getRow()+2, thePosition.getCol()+1);
		Position targetPos2 = new Position(thePosition.getRow()+2, thePosition.getCol()-1);
		Position targetPos3 = new Position(thePosition.getRow()-2, thePosition.getCol()+1);
		Position targetPos4 = new Position(thePosition.getRow()-2, thePosition.getCol()-1);
		Position targetPos5 = new Position(thePosition.getRow()+1, thePosition.getCol()+2);
		Position targetPos6 = new Position(thePosition.getRow()+1, thePosition.getCol()-2);
		Position targetPos7 = new Position(thePosition.getRow()-1, thePosition.getCol()+2);
		Position targetPos8 = new Position(thePosition.getRow()-1, thePosition.getCol()-2);


		if(targetPos1.isOnBoard() && !thePosition.equals(targetPos1)){

			if(theBoard.hasPiece(targetPos1))
			{			
				if(!theBoard.getPiece(targetPos1).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()+2, thePosition.getCol()+1, theBoard, validMoves, true);
				}
			}
			addAvailablePosition(thePosition.getRow()+2, thePosition.getCol()+1, theBoard, validMoves, false);
		}

		if(targetPos2.isOnBoard() && !thePosition.equals(targetPos2)){

			if(theBoard.hasPiece(targetPos2))
			{			
				if(!theBoard.getPiece(targetPos2).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()+2, thePosition.getCol()-1, theBoard, validMoves, true); 
				}
			}
			addAvailablePosition(thePosition.getRow()+2, thePosition.getCol()-1, theBoard, validMoves, false); 
		}

		if(targetPos3.isOnBoard() && !thePosition.equals(targetPos3)){

			if(theBoard.hasPiece(targetPos3))
			{			
				if(!theBoard.getPiece(targetPos3).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()-2, thePosition.getCol()+1, theBoard, validMoves, true);
				}
			}
			addAvailablePosition(thePosition.getRow()-2, thePosition.getCol()+1, theBoard, validMoves, false);
		}

		if(targetPos4.isOnBoard() && !thePosition.equals(targetPos4)){

			if(theBoard.hasPiece(targetPos4))
			{			
				if(!theBoard.getPiece(targetPos4).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()-2, thePosition.getCol()-1, theBoard, validMoves, true); 
				}
			}
			addAvailablePosition(thePosition.getRow()-2, thePosition.getCol()-1, theBoard, validMoves, false); 
		}

		if(targetPos5.isOnBoard() && !thePosition.equals(targetPos5)){

			if(theBoard.hasPiece(targetPos5))
			{			
				if(!theBoard.getPiece(targetPos5).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()+2, theBoard, validMoves, true); //up 1 over 2 to the right

				}
			}
			addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()+2, theBoard, validMoves, false); //up 1 over 2 to the right
		}

		if(targetPos6.isOnBoard() && !thePosition.equals(targetPos6)){

			if(theBoard.hasPiece(targetPos6))
			{			
				if(!theBoard.getPiece(targetPos6).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()-2, theBoard, validMoves, true); //up 1 over to the left

				}
			}
			addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()-2, theBoard, validMoves, false); //up 1 over to the left
		}

		if(targetPos7.isOnBoard() && !thePosition.equals(targetPos7)){

			if(theBoard.hasPiece(targetPos7))
			{			
				if(!theBoard.getPiece(targetPos7).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()+2, theBoard, validMoves, true); //down 1 over 2 to the right

				}
			}
			addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()+2, theBoard, validMoves, false); //down 1 over 2 to the right
		}

		if(targetPos8.isOnBoard() && !thePosition.equals(targetPos8)){

			if(theBoard.hasPiece(targetPos8))
			{			
				if(!theBoard.getPiece(targetPos8).getPieceColor().equals(pieceColor))
				{
					addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()-2, theBoard, validMoves, true); //down 1 over 2 to the left
				}
			}
			addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()-2, theBoard, validMoves, false); //down 1 over 2 to the left

		}

		return validMoves;
	}



}
