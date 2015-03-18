package dbrown_Chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by dbrown on 12/8/2014.
 */
public class BoardModel {

    private BufferedReader buff;
    private Board theBoard;

    public void readCommandsFromFile(Path filePath) throws IOException {
        try {
            CommandParser parser = new CommandParser();
            buff = Files.newBufferedReader(filePath, Charset.defaultCharset());
            do {
                String line = buff.readLine();
                Command command = parser.parseCommand(line);
                if (command.getTypeCommand().equals(Command.CommandType.PLACEMENT)) {
                    placePiece(command);
                }

            } while (buff.ready());
        } catch (Exception e) {
            System.out.println("File not found or doesn't exist!");
            e.printStackTrace();
        } finally {
            buff.close();
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


}
