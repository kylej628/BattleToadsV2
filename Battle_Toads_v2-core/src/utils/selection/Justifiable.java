package utils.selection;

import utils.data.Coord;
import utils.data.Justify;

public class Justifiable {
	
	public Coord setJustification(Justify j, int positionX, int positionY, int Width, int Height)
	{
		switch(j)
		{
			case LEFT_TOP: return new Coord(JustifyX_Left(positionX), JustifyY_Top(positionY, Height));
			case LEFT_CENTER: return new Coord(JustifyX_Left(positionX), JustifyY_Center(positionY, Height));
			case LEFT_BOTTOM: return new Coord(JustifyX_Left(positionX), JustifyY_Bottom(positionY));
			case CENTER_TOP: return new Coord(JustifyX_Center(positionX, Width), JustifyY_Top(positionY, Height));
			case CENTER_CENTER: return new Coord(JustifyX_Center(positionX, Width), JustifyY_Center(positionY, Height));
			case CENTER_BOTTOM: return new Coord(JustifyX_Center(positionX, Width), JustifyY_Bottom(positionY));
			case RIGHT_TOP: return new Coord(JustifyX_Right(positionX, Width), JustifyY_Top(positionY, Height));
			case RIGHT_CENTER: return new Coord(JustifyX_Right(positionX, Width), JustifyY_Center(positionY, Height));
			case RIGHT_BOTTOM: return new Coord(JustifyX_Right(positionX, Width), JustifyY_Bottom(positionY));
			default : System.out.println("ERROR: Unable to justify, check code!"); return new Coord(0,0);
		}
	}
	
	private int JustifyX_Left(int positionX)  				{return positionX;				 }
	private int JustifyX_Center(int positionX, int WIDTH)	{return positionX - (WIDTH / 2); }
	private int JustifyX_Right(int positionX, int WIDTH) 	{return positionX -  WIDTH;		 }
	private int Justify_Center(int position, int Dimension) {return position - (Dimension/2);}
	private int JustifyY_Top(int positionY, int HEIGHT)   	{return positionY -  HEIGHT;	 }
	private int JustifyY_Center(int positionY, int HEIGHT)	{return positionY - (HEIGHT / 2);}
	private int JustifyY_Bottom(int positionY)				{return positionY;				 }
	
	public int setJustification(Justify j, int position, int dimension)
	{
		switch(j)
		{
		case LEFT: return JustifyX_Left(position);
		case RIGHT: return JustifyX_Right(position, dimension);
		case CENTER: return Justify_Center(position, dimension);
		case TOP: return JustifyY_Top(position, dimension);
		case BOTTOM: return JustifyY_Bottom(position);
		default: System.out.println("ERROR: Unable to justify, check code!"); return 0;
		}
	}

}
