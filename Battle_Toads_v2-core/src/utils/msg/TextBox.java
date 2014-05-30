package utils.msg;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utils.data.Coord;

public class TextBox {
	
	//Variables --------//
	int Width, Height, X, Y;
	String Msg;
	BitmapFont font;
	
	public TextBox(int passedWidth, int passedHeight, int positionX, int positionY)
	{
		this.Width = passedWidth;
		this.Height = passedHeight;
		this.Msg = "This is a text box!";
		this.X = positionX;
		this.Y = positionY;
		this.font = new BitmapFont();
	}
	
	public TextBox(int passedWidth, int passedHeight, Coord position)
	{
		this.Width = passedWidth;
		this.Height = passedHeight;
		this.Msg = "This is a text box!";
		this.X = position.X;
		this.Y = position.Y;
		this.font = new BitmapFont();
	}
	
	public TextBox(int passedWidth, int passedHeight, int positionX, int positionY, BitmapFont passedFont)
	{
		this.Width = passedWidth;
		this.Height = passedHeight;
		this.Msg = "This is a text box!";
		this.X = positionX;
		this.Y = positionY;
		this.font = passedFont;
	}
	
	public TextBox(int passedWidth, int passedHeight, Coord position, BitmapFont passedFont)
	{
		this.Width = passedWidth;
		this.Height = passedHeight;
		this.Msg = "This is a text box!";
		this.X = position.X;
		this.Y = position.Y;
		this.font = passedFont;
	}
	
	//--------------RENDER METHOD----------------//
	public void render(SpriteBatch batch)
	{
		font.drawWrapped(batch, Msg, X, Y, Width);
	}
	
	public void setMessage(String passedMsg)
	{
		this.Msg = passedMsg;
	}
	
	public int getWidth()
	{
		return Width;
	}
	
	public int getHeight()
	{
		return Height;
	}

}
