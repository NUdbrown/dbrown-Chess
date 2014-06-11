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
	
		if(!selfInCheck(theBoard, thePosition)){
			addAvailablePosition(thePosition.getRow()+1, thePosition.getCol(), theBoard, validMoves, true);
			addAvailablePosition(thePosition.getRow()-1, thePosition.getCol(), theBoard, validMoves, true); 
			addAvailablePosition(thePosition.getRow(), thePosition.getCol()+1, theBoard, validMoves, true); 
			addAvailablePosition(thePosition.getRow(), thePosition.getCol()-1, theBoard, validMoves, true); 
			addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()+1, theBoard, validMoves, true); 
			addAvailablePosition(thePosition.getRow()-1, thePosition.getCol()-1, theBoard, validMoves, true); 
			addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()-1, theBoard, validMoves, true); 
			addAvailablePosition(thePosition.getRow()+1, thePosition.getCol()+1, theBoard, validMoves, true); 
		}
	
		return validMoves;
	}
	
	public boolean selfInCheck(Board theBoard, Position pos){
		boolean putSelfInCheck = false;
		
		Position kingsLocation = theBoard.getPositionOfPiece(this);
		
		for(Piece piece: theBoard.piecesOnTheBoard()){
			if(!piece.getPieceColor().equals(pieceColor)){
				for(Position p: piece.getMoves(theBoard.getPositionOfPiece(piece), theBoard)){
					if(kingsLocation.getRow() == p.getRow() || kingsLocation.getCol() == p.getCol()){
						putSelfInCheck = true;
						//System.out.println("No, you cant move..put self in check");
					}
				}
			}
		}
				
		
		return putSelfInCheck;
		
		
	}

		


}

