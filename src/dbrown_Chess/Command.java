package dbrown_Chess;

public class Command {

	private String currentPieceSquare;
	private String destinationSquare;
	private String possiblePiece;
	private String possiblePieceColor;
	private String possiblePieceCode;
	private String possibleColorCode;
	CommandType typeCommand;
	
	
	public enum CommandType {
		CAPTURE, MOVE, DOUBLE_MOVE, PLACEMENT;
	}
	
	
	
	public Command(String piece, String pieceColor, String destinationSquare,String currentPieceSquare,String possiblePieceCode,String possibleColorCode, CommandType typeCommand)
	{
		
		this.possiblePiece = piece;
		this.possiblePieceColor = pieceColor;
		this.destinationSquare = destinationSquare;
		this.currentPieceSquare = currentPieceSquare;
		this.typeCommand = typeCommand;
		this.possiblePieceCode = possiblePieceCode;
		this.possibleColorCode = possibleColorCode;
	}
	
	public CommandType getTypeCommand() {
		return typeCommand;
	}

	public Command(String currentPieceSquare, String destinationSquare, CommandType typeCommand)
	{
		this(null,null, destinationSquare, currentPieceSquare, null, null, typeCommand);
	}
		
	public String getPiece() {
		return possiblePiece;
	}
	public String getCurrentPieceSquare() {
		return currentPieceSquare;
	}

	public String getDestinationSquare() {
		return destinationSquare;
	}

	public char getDestinColumn(){
		char destincol = destinationSquare.charAt(0);
		return destincol;
	}
	@Override
	public String toString() {
		return "Command [currentPieceSquare=" + currentPieceSquare + ", destinationSquare="
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
		char sourceCol = currentPieceSquare.charAt(0);
		return sourceCol;
	}
	public char getSourceRow(){
		char sourceRow = currentPieceSquare.charAt(1);
		return sourceRow;
	}

	public String getPossiblePieceColor() {
		return possiblePieceColor;
	}

	public String getPossiblePieceCode() {
		return possiblePieceCode;
	}

	public String getPossibleColorCode() {
		return possibleColorCode;
	}

}
