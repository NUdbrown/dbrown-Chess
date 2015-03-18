package dbrown_Chess;

import dbrown_Chess.Command.CommandType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    public Pattern placementPattern() {
        Pattern placementPattern = Pattern
                .compile("^(?<piece>[qkpbnr])(?<color>[ld])(?<placement>[A-Ha-h][1-8])$");
        return placementPattern;
    }

    public Pattern movePattern() {
        Pattern movePattern = Pattern
                .compile("^(?<current>[A-Ha-h][1-8])(?<newPos>[A-Ha-h][1-8])$");
        return movePattern;
    }

    public Pattern capturePattern() {
        Pattern capturePattern = Pattern
                .compile("^(?<move1>[A-Ha-h][1-8]) (?<move2>[A-Ha-h][1-8])(?<capture>\\*)$");
        return capturePattern;
    }

//    public Pattern doubleMovePattern() {
//        Pattern doubleMovePattern = Pattern
//                .compile("^(?<move1>[A-Ha-h][1-8]) (?<move2>[A-h][1-8]) (?<move3>[A-Ha-h][1-8]) (?<move4>[A-Ha-h][1-8])$");
//        return doubleMovePattern;
//    }

    public Command parseCommand(String move) {
        Matcher placementMatch = placementPattern().matcher(move);
        Matcher moveMacth = movePattern().matcher(move);
        Matcher captureMatch = capturePattern().matcher(move);
//	    Matcher doubleMatch = doubleMovePattern().matcher(move);

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

//			System.out.println(thePiece+ " "+ placementMatch.group("color").replaceAll("l", "light").replaceAll("d", "dark") + " to "+ placementMatch.group("placement"));
            return new Command(thePiece, pieceColor.replaceAll("l", "light").replaceAll("d", "dark"), placementMatch.group("placement"), null, pieceSymbol, pieceColor, CommandType.PLACEMENT);

        } else if (moveMacth.find()) {
            System.out.println("Moves piece on " + moveMacth.group("current") + " to " + moveMacth.group("newPos"));
            return new Command(moveMacth.group("current"), moveMacth.group("newPos"), CommandType.MOVE);
        } else if (captureMatch.find()) {
            String astrik = null;
            if (captureMatch.group("capture").contains("*")) {
                astrik = "captures the piece on ";
            }
            System.out.println("Moves piece on " + captureMatch.group("move1") + " to " + captureMatch.group("move2") + " and " + astrik + "" + captureMatch.group("move2"));
            return new Command(captureMatch.group("move1"), captureMatch.group("move2"), CommandType.CAPTURE);
        }
//		else if (doubleMatch.find())
//		{
//		    System.out.println("Moves piece on " + doubleMatch.group("move1") + " to " + doubleMatch.group("move2") + "and moves piece on "+ doubleMatch.group("move3") + " to " + doubleMatch.group("move4"));
//            return new Command(doubleMatch.group("move1"),doubleMatch.group("move2"), doubleMatch.group("move3"), doubleMatch.group("move4"),CommandType.DOUBLE_MOVE );
//		}

        else
            System.out.println("This is an invalid move!");
        return null;

    }

}