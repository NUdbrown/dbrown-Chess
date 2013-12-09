package dbrown_Chess;

public class Command {

	private String pieceSquare;
	private String destinationSquare;
	private String possiblePiece;
	private String possiblePieceColor;
	private String possiblePieceCode;
	private String possibleColorCode;
	CommandType typeCommand;
	
	
	public enum CommandType {
		CAPTURE, MOVE, DOUBLE_MOVE, PLACEMENT;
	}
	
	
	
	public Command(String piece, String pieceColor, String destinationSquare,String pieceSquare,String possiblePieceCode,String possibleColorCode, CommandType typeCommand)
	{
		
		this.possiblePiece = piece;
		this.destinationSquare = destinationSquare;
		this.pieceSquare = pieceSquare;
		this.typeCommand = typeCommand;
		this.possiblePieceCode = possiblePieceCode;
		this.possibleColorCode = possibleColorCode;
	}
	
	public CommandType getTypeCommand() {
		return typeCommand;
	}

	public Command(String pieceSquare, String destinationSquare, CommandType typeCommand)
	{
		this(null,null, destinationSquare, pieceSquare, null, null, typeCommand);
	}
		
	public String getPiece() {
		return possiblePiece;
	}
	public void setPiece(String piece) {
		this.possiblePiece = piece;
	}
	public String getPieceSquare() {
		return pieceSquare;
	}
//	public void setPieceSquare(String pieceSquare) {
//		this.pieceSquare = pieceSquare;
//	}



	public String getDestinationSquare() {
		return destinationSquare;
	}

	public char getDestinColumn(){
		char destincol = destinationSquare.charAt(0);
		return destincol;
	}
	@Override
	public String toString() {
		return "Command [pieceSquare=" + pieceSquare + ", destinationSquare="
				+ destinationSquare + ", possiblePiece=" + possiblePiece
				+ ", possiblePieceColor=" + possiblePieceColor
				+ ", possiblePieceCode=" + possiblePieceCode
				+ ", possibleColorCode=" + possibleColorCode + ", typeCommand="
				+ typeCommand + "]";
	}

	public char getDestinRow(){
		char destinRow = destinationSquare.charAt(1);
		return destinRow;
	}
	
	public char getSourceColumn(){
		char sourceCol = pieceSquare.charAt(0);
		return sourceCol;
	}
	public char getSourceRow(){
		char sourceRow = pieceSquare.charAt(1);
		return sourceRow;
	}

	public void setDestinationSquare(String destinationSquare) {
		this.destinationSquare = destinationSquare;
	}

	public String getPossiblePieceColor() {
		return possiblePieceColor;
	}

	public void setPossiblePieceColor(String possiblePieceColor) {
		this.possiblePieceColor = possiblePieceColor;
	}

	public String getPossiblePieceCode() {
		return possiblePieceCode;
	}

	public void setPossiblePieceCode(String possiblePieceCode) {
		this.possiblePieceCode = possiblePieceCode;
	}

	public String getPossibleColorCode() {
		return possibleColorCode;
	}

	public void setPossibleColorCode(String possibleColorCode) {
		this.possibleColorCode = possibleColorCode;
	}
	
}
