package dbrown_Chess;

import java.io.ObjectInputStream.GetField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dbrown_Chess.Command.CommandType;

public class CommandParser {

	public Pattern placementPattern() {
		Pattern placementPattern = Pattern
				.compile("^(?<piece>[qkpbnr])(?<color>[ld])(?<placement>[A-Ha-h][1-8])$");
		return placementPattern;
	}

	public Pattern movePattern() {
		Pattern movePattern = Pattern
				.compile("^(?<moves1>[A-Ha-h][1-8])(?<moves2>[A-Ha-h][1-8])$");
		return movePattern;
	}

	public Pattern capturePattern() {
		Pattern capturePattern = Pattern
				.compile("^(?<move1>[A-Ha-h][1-8][ ])(?<move2>[A-Ha-h][1-8])(?<capture>\\*)$");
		return capturePattern;
	}

	public Pattern doubleMovePattern() {
		Pattern doubleMovePattern = Pattern
				.compile("^(?<move1>[A-Ha-h][1-8][ ])(?<move2>[A-h][1-8][ ])(?<move3>[A-Ha-h][1-8][ ])(?<move4>[A-Ha-h][1-8])$");
		return doubleMovePattern;
	}

	public Command parseCommand(String move) {
		Matcher placementMatch = placementPattern().matcher(move);
		Matcher moveMacth = movePattern().matcher(move);
		// Matcher captureMatch = capturePattern().matcher(move);
		// Matcher doubleMatch = doubleMovePattern().matcher(move);

		if (placementMatch.find()) {
			String thePiece = null;
			String pieceSymbol = placementMatch.group("piece");
			String pieceColor = placementMatch.group("color");
			if (pieceSymbol.equalsIgnoreCase("k")) {
				thePiece = "King";
			} else if (pieceSymbol.equalsIgnoreCase("q")) {
				thePiece = "Queen";
			} else if (pieceSymbol.equalsIgnoreCase("b")) {
				thePiece = "Bishop";
			} else if (pieceSymbol.equalsIgnoreCase("r")) {
				thePiece = "Rook";
			} else if (pieceSymbol.equalsIgnoreCase("n")) {
				thePiece = "Knight";
			} else if (pieceSymbol.equalsIgnoreCase("p")) {
				thePiece = "Pawn";
			}

			System.out.println(thePiece
					+ " "
					+ placementMatch.group("color").replaceAll("l", "light")
					.replaceAll("d", "dark") + " to "
					+ placementMatch.group("placement"));
			return new Command(thePiece, pieceColor.replaceAll("l", "light")
					.replaceAll("d", "dark"),
					placementMatch.group("placement"),null, pieceColor, pieceSymbol,
					CommandType.PLACEMENT);

		} else if (moveMacth.find()) {
			System.out.println("Moves piece on "
			 + moveMacth.group("moves1") + " to "
			 + moveMacth.group("moves2"));
			return new Command(moveMacth.group("moves1"),
					moveMacth.group("moves2"), CommandType.MOVE);
		}

		// double and capture not needed.

		// else if (captureMatch.find()) {
		// String astrik = null;
		// if (captureMatch.group("capture").contains("*")) {
		// astrik = "captures the piece on ";
		// }
		// System.out.println("Moves piece on "
		// + captureMatch.group("move1") + "to "
		// + captureMatch.group("move2") + " and " + astrik
		// + "" + captureMatch.group("move2"));
		// } else if (doubleMatch.find())
		// {
		// System.out.println("Moves piece on "
		// + doubleMatch.group("move1") + "to "
		// + doubleMatch.group("move2")
		// + "and moves piece on "
		// + doubleMatch.group("move3") + "to "
		// + doubleMatch.group("move4"));
		//
		// }

		else
			System.out.println("This is an invalid move!");
			return null;

	}
	
	public static CommandType chooseCommand(Command command, Board theBoard)
	{
		
		Piece piece = null;
		String pieceType = command.getPiece();
		String pieceColor = command.getPossiblePieceColor();
		String pieceCode = command.getPossiblePieceCode();
		String colorCode = command.getPossibleColorCode();
	
		switch(command.typeCommand)
		{
		case PLACEMENT:
			if(pieceType.equals("Pawn")) {
				piece = new Pawn(pieceType, pieceColor, pieceCode,colorCode );
				
			}
			else if(pieceType.equals("King")) {
				piece = new King(pieceType, pieceColor, pieceCode,colorCode);
			}
			else if(pieceType.equals("Queen")) {
				piece = new Queen(pieceType, pieceColor,pieceCode,colorCode);
			}
			else if(pieceType.equals("Rook")) {
				piece = new Rook(pieceType, pieceColor, pieceCode,colorCode);
			}
			else if(pieceType.equals("Knight")) {
				piece = new Knight(pieceType, pieceColor, pieceCode,colorCode);
			}
			else if(pieceType.equals("Bishop")) {
				piece = new Bishop(pieceType, pieceColor, pieceCode,colorCode);
			}
			theBoard.placePiece(command.getDestinRow(), command.getDestinColumn(), piece);
			
			break;
		case MOVE:
//			Move theMove = new Move(new Position(command.getSourceRow(), command.getSourceColumn()), new Position(command.getDestinRow(), command.getDestinColumn()));
//			Piece thePiece = theBoard.getPiece(theMove.getSource());
//			if(thePiece.isValidMove(theMove, theBoard)){
//				theBoard.makeMove(theMove);
//				theBoard.print();
//			}
//			
			break;
		case DOUBLE_MOVE:
			
			break;
		case CAPTURE:
			
			break;
		}
	
		
		
		return command.typeCommand;
	}
}