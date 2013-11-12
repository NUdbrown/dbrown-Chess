package dbrown_Chess;

public class BoardSquare {

	//location
	//has a piece or not
	//what color it is
	
	boolean squareColor;
	private boolean isOccupied; 
	Board theBoard = new Board();
	
	String d;
	String location;
	
	
	public BoardSquare(String dark) 
	{
		d= dark;
		
		
				
	}
	
	public void setPiece()
	{
	}
	
	public String getColor()
	{
		return d;
	}

	
	
	
	
	
	
	
	
//	public void spaceOccupied()
//	{
//			if(isOccupied = true)
//			{
//				
//			}
//	}
//	
//	public void notOccupied()
//	{
//		if(!isOccupied)
//		{
//			
//		}
//	}

}
