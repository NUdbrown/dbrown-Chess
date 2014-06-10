package dbrown_Chess;

import java.util.ArrayList;

public abstract class Piece {
	
	
	private String pieceType;
	protected String pieceColor;
	protected String pieceTypeCode;
	private String pieceColorCode;
	protected final int ROW_LENGTH = 8;
	protected final int COL_LENGTH = 8;
	protected final int SIZE = 8;
	


public Piece(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		this.pieceType = pieceType; //this.getClass().getSimpleName();
		this.pieceColor = pieceColor; //pieceColorCode.equals("l")?"light":"dark";
		this.pieceTypeCode = pieceTypeCode;
		this.pieceColorCode = pieceColorCode;
	}
public Piece(String pieceTypeCode, String pieceColorCode){
	this.pieceTypeCode = pieceTypeCode;
	this.pieceColorCode = pieceColorCode;
}

public boolean isValidMove(Move theMove, Board theBoard){
	ArrayList<Position> listOfMoves = getMoves(theMove.getSource(), theBoard);
	for( Position p: listOfMoves ){
		if(p.equals(theMove.getDestination())){
			return true;
		}
	}
	System.out.println("Invalid Move");
	return false;
	
}

public abstract ArrayList<Position> getMoves(Position thePosition, Board theBoard); 

public void addAvailablePosition(int row, int col, Board theBoard,ArrayList<Position> validMoves, boolean isCapturable) {
	
	Position newPosition = new Position(row, col);
	addAvailablePosition(newPosition, theBoard, validMoves, isCapturable);
}

public void addAvailablePosition(Position newPosition, Board theBoard,ArrayList<Position> validMoves, boolean isCapturable) {

	if(newPosition.isOnBoard()){
		if(theBoard.hasPiece(newPosition)){
			if(theBoard.getPiece(newPosition).getPieceColorCode()!= this.getPieceColorCode()&&isCapturable){
				validMoves.add(newPosition);
			}
		}		
		else {
			validMoves.add(newPosition);
		}
		
	}
}

protected boolean firstMove = true;

public void setMoved(){
	firstMove = false;
}

public String getPieceColor() {
	return pieceColor;
}

public String getPieceType() {
	return pieceType;
}

public String getPieceColorCode() {
	return pieceColorCode;
}


public String getPieceTypeCode() {
	return pieceTypeCode;
}


}