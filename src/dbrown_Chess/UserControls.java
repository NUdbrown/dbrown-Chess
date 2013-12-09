package dbrown_Chess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dbrown_Chess.Command.CommandType;

public class UserControls {

	BufferedReader buff;
	Board theBoard = new Board();

	public static void main(String[] args) throws IOException {

		(new UserControls()).readCommandsFromFile(Paths.get(args[0]));

	}

	public void readCommandsFromFile(Path filePath) throws IOException {
		try {
			
			CommandParser parser = new CommandParser();
			buff = Files.newBufferedReader(filePath, Charset.defaultCharset());
			Board theBoard = new Board();
			do {
				String line = buff.readLine();
					Command command = parser.parseCommand(line);
					if(command.getTypeCommand().equals(CommandType.PLACEMENT)){
						CommandParser.chooseCommand(command, theBoard);
						System.out.println("Command Type: "+command.toString());
					}
					else if(command.getTypeCommand().equals(CommandType.MOVE)){
						CommandParser.chooseCommand(command, theBoard);
						Position source = new Position(Board.getRow(command.getSourceRow()), Board.getColumn(command.getSourceColumn()));
						Position destination= new Position(Board.getRow(command.getDestinRow()), Board.getColumn(command.getDestinColumn()));
						Move theMove = new Move(source, destination);
						//theBoard.removePiece(theBoard.getPiece(source),source);
						theBoard.makeMove(theMove);
						System.out.println("Command Type: "+command.toString());
					}
				
			} while (buff.ready());
			theBoard.print();

		} catch (FileNotFoundException e) {

			System.out.println("File not found or doesn't exist!");
			e.printStackTrace();
		} finally {
			buff.close();
		}
	}

}
