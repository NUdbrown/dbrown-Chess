package dbrown_Chess;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserControls {

	BufferedReader buff;
	Board theBoard = new Board();

	

	public static void main(String[] args) throws IOException {

		(new UserControls()).readCommandsFromFile(Paths.get(args[0]));

	}

	public void readCommandsFromFile(Path filePath) throws IOException {
		try {
			String move;
			CommandParser parser = new CommandParser();
			 buff = Files.newBufferedReader(filePath, Charset.defaultCharset());
			while(buff.ready()) {
				move = buff.readLine();
				Command command = parser.parseCommand(move);
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
					theBoard.placePiece(command.getDestinColumn(), command.getDestinRow() , piece);
					theBoard.print();
					break;
				case MOVE:
					//add a board and move the chess pieces
					theBoard.init();
					
					break;
				case DOUBLE_MOVE:
					
					break;
				case CAPTURE:
					
					break;
				}
				
				
				
				}
			theBoard.init();

		}catch (FileNotFoundException e) {
				
			System.out.println("File not found or doesn't exist!");
				e.printStackTrace();
			}
			finally {
				buff.close();
			}
		}
			


		
	
}
