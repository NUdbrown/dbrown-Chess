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
		boolean foundPiece = false;
		
		//available row movements
		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow()+i, thePosition.getCol());

			if(targetPos.isOnBoard() && !thePosition.equals(targetPos)){
				
				if(theBoard.hasPiece(targetPos))
				{
					if(!theBoard.getPiece(targetPos).getPieceColor().equals(pieceColor)){
						addAvailablePosition(thePosition.getRow()+i, thePosition.getCol(), theBoard, validMoves, true);
					}
					break;
				}
				addAvailablePosition(thePosition.getRow()+i, thePosition.getCol(), theBoard, validMoves, true);
			}
		}

		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow()-i, thePosition.getCol());
			if(targetPos.isOnBoard() && !thePosition.equals(targetPos)){
				
				if(theBoard.hasPiece(targetPos))
				{			
					if(!theBoard.getPiece(targetPos).getPieceColor().equals(pieceColor))
					{
						addAvailablePosition(thePosition.getRow()-i, thePosition.getCol(), theBoard, validMoves, true);
					}
					break;
				}
				addAvailablePosition(thePosition.getRow()-i, thePosition.getCol(), theBoard, validMoves, true);
			}
		}

		//available column movements
		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow(), thePosition.getCol()-i);
			if(targetPos.isOnBoard() && !thePosition.equals(targetPos)){
				

				if(theBoard.hasPiece(targetPos))
				{			
					if(!theBoard.getPiece(targetPos).getPieceColor().equals(pieceColor))
					{
						addAvailablePosition(thePosition.getRow(), thePosition.getCol()-i, theBoard, validMoves, true);
					}
					break;
				}
				addAvailablePosition(thePosition.getRow(), thePosition.getCol()-i, theBoard, validMoves, true);
			}
		}

		for(int i = 1; !foundPiece && (i <= SIZE); i++){
			Position targetPos = new Position(thePosition.getRow(), thePosition.getCol()+i);
			if(targetPos.isOnBoard() && !thePosition.equals(targetPos)){
				

				if(theBoard.hasPiece(targetPos))
				{			
					if(!theBoard.getPiece(targetPos).getPieceColor().equals(pieceColor))
					{
						addAvailablePosition(thePosition.getRow(), thePosition.getCol()+i, theBoard, validMoves, true);
					}
					break;
				}
				addAvailablePosition(thePosition.getRow(), thePosition.getCol()+i, theBoard, validMoves, true);
			}
		}	


		return validMoves;
	}




}
