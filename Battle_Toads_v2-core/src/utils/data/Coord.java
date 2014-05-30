package utils.data;

public class Coord {
	
	public int X, Y;
	
	public Coord(int X, int Y)
	{
		this.X = X;
		this.Y = Y;
	}
	
	public int getX()
	{
		return X;
	}
	
	public int getY()
	{
		return Y;
	}
	
	public void set(Coord coordinates)
	{
		this.X = coordinates.X;
		this.Y = coordinates.Y;
	}
	
	public void set(int X, int Y)
	{
		this.X = X;
		this.Y = Y;
	}

}
