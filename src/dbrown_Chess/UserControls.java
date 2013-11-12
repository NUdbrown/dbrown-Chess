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
			
				switch(command.typeCommand)
				{
				case PLACEMENT:
					Piece piece = null;
					if(command.getPiece().equals("Pawn")) {
						piece = new Pawn(command.getPiece(), command.getPossiblePieceColor(), command.getPossiblePieceCode(),command.getPossibleColorCode() );
						
					}
					else if(command.getPiece().equals("King")) {
						piece = new King(command.getPiece(), command.getPossiblePieceColor(), command.getPossiblePieceCode(),command.getPossibleColorCode());
					}
					else if(command.getPiece().equals("Queen")) {
						piece = new Queen(command.getPiece(), command.getPossiblePieceColor(), command.getPossiblePieceCode(),command.getPossibleColorCode());
					}
					else if(command.getPiece().equals("Rook")) {
						piece = new Rook(command.getPiece(), command.getPossiblePieceColor(), command.getPossiblePieceCode(),command.getPossibleColorCode());
					}
					else if(command.getPiece().equals("Knight")) {
						piece = new Knight(command.getPiece(), command.getPossiblePieceColor(), command.getPossiblePieceCode(),command.getPossibleColorCode());
					}
					else if(command.getPiece().equals("Bishop")) {
						piece = new Bishop(command.getPiece(), command.getPossiblePieceColor(), command.getPossiblePieceCode(),command.getPossibleColorCode());
					}
					theBoard.chessPieces.put(command.getDestinationSquare() , piece);
					theBoard.print();
					break;
				case MOVE:
					//add a board and move the chess pieces
//					Piece p = theBoard.getChessBoard().get(command.getPieceSquare());
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
