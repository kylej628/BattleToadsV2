package utils.selection;

import utils.data.Justify;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button {
	
	protected String NAME, DEFAULTNAME, HOVERNAME;
	protected int XPOS, YPOS, WIDTH, HEIGHT, BUTTON_STATE = 0;
	protected boolean DISPLAYNAME, CUSTOM_ART = false, Disregard = false, Clicked = false, hasBeenClicked = false;
	private Texture[] button; // [0] = up [1] = down [2] = hover;
	private int MouseX, MouseY;
	private int[] BOUNDS;
	private BitmapFont FONT;
	private Justify Justification;
	
	/**
	 * A button that can be used to trigger things
	 * @param Name = Used for writing on button
	 * @param positionX = X position of center
	 * @param positionY = Y position of center
	 * @param justification = Justify.*
	 * @param width = width of the button
	 * @param height = height of the button
	 * @param displayName = toggles if the button will show text or not
	 */
	public Button(String Name, int positionX, int positionY, Justify justification, int width, int height, boolean displayName)
	{
		//Since no custom art was given, defaults are assumed
		button = new Texture[]{
			new Texture(Gdx.files.internal("defaults/button_up_default.png")), new Texture(Gdx.files.internal("defaults/button_down_default.png")), new Texture(Gdx.files.internal("defaults/button_hover_default.png"))	
		};
		FONT = new BitmapFont();
		this.DEFAULTNAME = Name;
		this.HOVERNAME = Name;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.DISPLAYNAME = displayName;
		this.MouseX = Gdx.input.getX();
		this.MouseY = Gdx.input.getY();
		this.Justification = justification;
		setJustification(Justification, positionX, positionY);
		VerifyOnScreen();
		this.BOUNDS = new int[]
				{
					XPOS, (XPOS + width),
					YPOS, (YPOS + height)
				};
	}
	
	/**
	 * A button that can be used to trigger things w/custom art
	 * @param Name = Used for writing on button
	 * @param positionX = X position of center
	 * @param positionY = Y position of center
	 * @param justification = Justify.*
	 * @param width = width of the button
	 * @param height = height of the button
	 * @param displayName = toggles if the button will show text or not
	 * @param buttonUp = texture for normal state
	 * @param buttonDown = texture for down state
	 * @param buttonHover = texture for hover state
	 */
	public Button(String Name, int positionX, int positionY, Justify justification, int width, int height, boolean displayName, Texture buttonUp, Texture buttonDown, Texture buttonHover)
	{
		//assigns custom art directly to the button since given in the constructor
		button = new Texture[]{
			buttonUp, buttonDown, buttonHover
		};
		this.DEFAULTNAME = Name;
		this.HOVERNAME = Name;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.DISPLAYNAME = displayName;
		this.MouseX = Gdx.input.getX();
		this.MouseY = Gdx.input.getY();
		setJustification(justification, positionX, positionY);
		/*
		 * { 
		 *   LeftSide(0), RightSide(1),
		 *   Top(2), Bottom(3)
		 * }
		 */
		this.BOUNDS = new int[]
				{
					XPOS, (XPOS + width),
					YPOS, (YPOS + height)
				};
	}
	
	/**
	 * Sends a message to the console if button is off screen.
	 * Can also be called to report back
	 * @return boolean - T=On screen F=Off Screen
	 */
	public boolean VerifyOnScreen()
	{
		if(this.XPOS + WIDTH > Gdx.graphics.getWidth() || this.XPOS < 0 || this.YPOS + HEIGHT > Gdx.graphics.getHeight() || this.YPOS < 0)
			{System.out.println("[WARNING]: Button \"" + this.DEFAULTNAME + "\" is off-screen "); return false;}
		else
			return true;
	}
	
	public void setPosition(int XPos, int YPos)
	{
		this.setJustification(Justification, XPos, YPos);
	}
	
	public void setPosition(Justify j, int XPos, int YPos)
	{
		this.setJustification(j, XPos, YPos);
	}
	
	public void setCustomArt(FileHandle buttonUp, FileHandle buttonDown, FileHandle buttonHover)
	{
		this.button[0] = new Texture(buttonUp);
		this.button[1] = new Texture(buttonDown);
		this.button[2] = new Texture(buttonHover);
		this.CUSTOM_ART = true;
	}
	
	public void setCustomArt(String buttonUp, String buttonDown, String buttonHover)
	{
		this.button[0] = new Texture(Gdx.files.internal(buttonUp));
		this.button[1] = new Texture(Gdx.files.internal(buttonDown));
		this.button[2] = new Texture(Gdx.files.internal(buttonHover));
		this.CUSTOM_ART = true;
	}
	
	public void setCustomFont(BitmapFont font)
	{
		this.FONT = font;
	}
	
	public void update()
	{
		pollPointer();
		if(insideBounds())
			{
				if(Gdx.input.isButtonPressed(0))
					{this.BUTTON_STATE = 1;} // Down
				else
					{this.BUTTON_STATE = 2; this.NAME = HOVERNAME;} // Hover
			}
		else
			{this.BUTTON_STATE = 0; this.NAME = DEFAULTNAME;} // Up
		ClickMonitor();
	}
	
	private void ClickMonitor()
	{
		if(Gdx.input.isButtonPressed(0) == false)
		{
			Disregard = false;
			Clicked = false;
		}
		else if(insideBounds() && Disregard == false)
			{Clicked = true; hasBeenClicked = true;}
		else
			Disregard = true;
	}
	
	public void manualDisregard()
	{
		Disregard = true;
	}
	
	public void render(SpriteBatch batch)
	{
		this.update();
		batch.draw(button[BUTTON_STATE], XPOS, YPOS, this.WIDTH, this.HEIGHT);
		FONT.draw(batch, NAME, XPOS + WIDTH/2 - FONT.getBounds(NAME).width/2, YPOS + HEIGHT/2 + FONT.getCapHeight()/2);
	}
	
	public void debug(SpriteBatch batch)
	{
		FONT.draw(batch, "X: " + MouseX + ", Y: " + MouseY, XPOS, YPOS);
		FONT.draw(batch, "Hover: " + this.insideBounds(), XPOS + 100, YPOS);
	}
	
	public void dispose()
	{
		this.button[0].dispose();
		this.button[1].dispose();
		this.button[2].dispose();
	}
	
	/**
	 * Polls the pointer to obtain coordinates for the button
	 */
	private void pollPointer()
	{
		MouseX = Gdx.input.getX();
		MouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
	}

	private boolean insideBounds()
	{
		if(BOUNDS[0] <= MouseX && MouseX <= BOUNDS[1] && BOUNDS[2] <= MouseY && MouseY <= BOUNDS[3])
			return true;
		else
			return false;
	}
	
	public boolean isClicked()
	{
		return Clicked;
	}
	
	public boolean wasClicked()
	{
		return hasBeenClicked;
	}

	public void setHoverText(String text)
	{
		this.HOVERNAME = text;
	}
	
	public void setDefaultText(String text)
	{
		this.NAME = text;
	}

	public void manualClickReset()
	{
		Clicked = false;
		hasBeenClicked = false;
	}
	
	/**
	 * Justifies the button depending on a string input.
	 * @param j : Convention <X>_<Y> ie: Center-Top = centered X, top Y
	 * @param positionX
	 * @param positionY
	 */
	private void setJustification(Justify j, int positionX, int positionY)
	{
		switch(j)
		{
		case LEFT_TOP: JustifyX_Left(positionX); JustifyY_Top(positionY);
			break;
		case LEFT_CENTER: JustifyX_Left(positionX); JustifyY_Center(positionY);
			break;
		case LEFT_BOTTOM: JustifyX_Left(positionX); JustifyY_Bottom(positionY);
			break;
		case CENTER_TOP: JustifyX_Center(positionX); JustifyY_Top(positionY);
			break;
		case CENTER_CENTER: JustifyX_Center(positionX); JustifyY_Center(positionY);
			break;
		case CENTER_BOTTOM: JustifyX_Center(positionX); JustifyY_Bottom(positionY);
			break;
		case RIGHT_TOP: JustifyX_Right(positionX); JustifyY_Top(positionY);
			break;
		case RIGHT_CENTER: JustifyX_Right(positionX); JustifyY_Center(positionY);
			break;
		case RIGHT_BOTTOM: JustifyX_Right(positionX); JustifyY_Bottom(positionY);
			break;
		default : System.out.println("ERROR: Unable to justify, check code! \n Button Name: " + this.DEFAULTNAME);
		}
	}
	
	private void JustifyX_Left(int positionX)  {this.XPOS = positionX;				 }
	private void JustifyX_Center(int positionX){this.XPOS = positionX - (WIDTH / 2); }
	private void JustifyX_Right(int positionX) {this.XPOS = positionX - WIDTH;		 }
	private void JustifyY_Top(int positionY)   {this.YPOS = positionY - HEIGHT;		 }
	private void JustifyY_Center(int positionY){this.YPOS = positionY - (HEIGHT / 2);}
	private void JustifyY_Bottom(int positionY){this.YPOS = positionY;				 }
}
