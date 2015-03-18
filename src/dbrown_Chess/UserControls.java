package dbrown_Chess;

import dbrown_Chess.Command.CommandType;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserControls {

    BufferedReader buff;
    BufferedReader buff2;
    Board theBoard = new Board();
    Piece piece;

    public static void main(String[] args) throws IOException {

        (new UserControls()).readCommandsFromFile(Paths.get(args[0]), Paths.get(args[1]));

    }

    public void readCommandsFromFile(Path filePath, Path moveFilePath) throws IOException {
        try {
            CommandParser parser = new CommandParser();
            buff = Files.newBufferedReader(filePath, Charset.defaultCharset());
            do {
                String line = buff.readLine();
                Command command = parser.parseCommand(line);
                if (command.getTypeCommand().equals(CommandType.PLACEMENT)) {
                    placePiece(command);
                }

            } while (buff.ready());
        } catch (Exception e) {
            System.out.println("File not found or doesn't exist!");
            e.printStackTrace();
        } finally {
            buff.close();
        }

        try {
            CommandParser parser = new CommandParser();
            buff2 = Files.newBufferedReader(moveFilePath, Charset.defaultCharset());
            do {
                String line = buff2.readLine();
                Command command = parser.parseCommand(line);

                System.out.println(theBoard.printMoves(theBoard.currentTurnColor()).toString());

                if (command.getTypeCommand().equals(CommandType.MOVE)) {
                    makeMove(command);
                } else if (command.getTypeCommand().equals(CommandType.CAPTURE)) {
                    capturing(command);

                }

            } while (!theBoard.isInCheckmate(theBoard.currentTurnColor()) && buff2.ready());

        } catch (Exception e) {
            System.out.println("File not found or doesn't exist!");
            e.printStackTrace();
        } finally {
            buff2.close();
        }


    }

    private void placePiece(Command command) {
        Piece piece = null;
        String pieceType = command.getPiece();
        String pieceColor = command.getPossiblePieceColor();
        String pieceCode = command.getPossiblePieceCode();
        String colorCode = command.getPossibleColorCode();


        if (pieceType.equals("Pawn")) {
            piece = new Pawn(pieceType, pieceColor, pieceCode, colorCode);

        } else if (pieceType.equals("King")) {
            piece = new King(pieceType, pieceColor, pieceCode, colorCode);
        } else if (pieceType.equals("Queen")) {
            piece = new Queen(pieceType, pieceColor, pieceCode, colorCode);
        } else if (pieceType.equals("Rook")) {
            piece = new Rook(pieceType, pieceColor, pieceCode, colorCode);
        } else if (pieceType.equals("Knight")) {
            piece = new Knight(pieceType, pieceColor, pieceCode, colorCode);
        } else if (pieceType.equals("Bishop")) {
            piece = new Bishop(pieceType, pieceColor, pieceCode, colorCode);
        }
        theBoard.placePiece(command.getDestinRow(), command.getDestinColumn(), piece);

    }

    private void makeMove(Command command) {
        Position source = new Position(Board.getRow(command.getSourceRow()), Board.getColumn(command.getSourceColumn()));
        Position destination = new Position(Board.getRow(command.getDestinRow()), Board.getColumn(command.getDestinColumn()));
        Move theMove = new Move(source, destination);
        theBoard.turnTaking(theMove);
        theBoard.print();


    }

    private void capturing(Command command) {
        Position source = new Position(Board.getRow(command.getSourceRow()), Board.getColumn(command.getSourceColumn()));
        Position destination = new Position(Board.getRow(command.getDestinRow()), Board.getColumn(command.getDestinColumn()));
        Move theMove = new Move(source, destination);
        theBoard.turnTaking(theMove);
        theBoard.print();

    }



}
