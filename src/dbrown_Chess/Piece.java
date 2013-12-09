package dbrown_Chess;

import java.util.ArrayList;

public abstract class Piece {
	
	
	private String pieceType;
	private String pieceColor;
	private String pieceTypeCode;
	private String pieceColorCode;
	


public Piece(String pieceType, String pieceColor, String pieceTypeCode, String pieceColorCode) {
		this.pieceType = pieceType;
		this.pieceColor = pieceColor;
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
	return false;
	
}

public abstract ArrayList<Position> getMoves(Position thePosition, Board theBoard); 

public String getPieceColor() {
	return pieceColor;
}


public void setPieceColor(String pieceColor) {
	this.pieceColor = pieceColor;
}


public String getPieceType() {
	return pieceType;
}


public void setPieceType(String pieceType) {
	this.pieceType = pieceType;
}


public String getPieceColorCode() {
	return pieceColorCode;
}


public void setPieceColorCode(String pieceColorCode) {
	this.pieceColorCode = pieceColorCode;
}


public String getPieceTypeCode() {
	return pieceTypeCode;
}


public void setPieceTypeCode(String pieceTypeCode) {
	this.pieceTypeCode = pieceTypeCode;
}


}