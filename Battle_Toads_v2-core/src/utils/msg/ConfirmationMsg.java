package utils.msg;

import utils.data.Coord;
import utils.data.Justify;
import utils.selection.Button;
import utils.selection.Justifiable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ConfirmationMsg extends Justifiable{
	
	//Variables ----------//
	Texture Splash;
	BitmapFont font;
	String Message;
	public Button Button_Affirmation, Button_Denial;
	Coord position;
	private TextBox TEXT;
	String TESTMESSAGE = "This is a test for the multi-lined text box. I wonder how long it would take for the"
			+ " box to end up removing the bottom of it because it was cut off";
	private boolean visable = false;
	
	Color shadeColor;
	boolean shadeScreen = false;
	
	public ConfirmationMsg(String msg)
	{
		if(msg == null)
			{System.out.println("[WARNING]: Confirmation message is null"); this.Message = "Null!";}
		else
			this.Message = msg;
		this.Button_Affirmation = new Button("OK!", Gdx.graphics.getWidth()/2 -25, Gdx.graphics.getHeight()/2 - 25, Justify.RIGHT_TOP, 100, 50, false);
		this.Button_Denial = new Button("Cancel!", Gdx.graphics.getWidth()/2 + 25, Gdx.graphics.getHeight()/2 - 25, Justify.LEFT_TOP, 100, 50, false);
		this.Splash = new Texture(Gdx.files.internal("assets/defaults/Default_MsgBack.png"));
	}
	
	public ConfirmationMsg(String msg, String affirmText, String denyText)
	{
		
	}
	
	/**
	 * Creates a confirmation needed message for the screen.
	 * Has ability to only have one instance per screen and reuse.
	 * @param msg
	 * @param AffButton
	 * @param DenyButton
	 * @param Splash
	 */
	public ConfirmationMsg(String msg, Button AffButton, Button DenyButton, Texture passedSplash, int SplashX, int SplashY, Justify J, int HorizontalPadding, int VerticlePadding, boolean ShadeScreen, Color shade)
	{
		//Checks for Splash ------//
		if(passedSplash != null)
			this.Splash = passedSplash;
		else
			this.Splash = new Texture(Gdx.files.internal("defaults/Default_MsgBack.png"));
		
		if(ShadeScreen)
			{this.shadeScreen = true; this.shadeColor = shade;}
		
		//Check for Position -----//
		position = new Coord(0,0);
		//--Set X position -------//
		if(SplashX != -1)
			this.position.X = SplashX;
		else
			this.position.X = Gdx.graphics.getWidth()/2;
		//--Set Y position -------//
		if(SplashY != -1)
			this.position.Y = SplashY;
		else
			this.position.Y = Gdx.graphics.getHeight()/2;
		
		//Set justification ------//
		if(J != null)
			this.position.set(setJustification(J, position.X, position.Y, this.Splash.getWidth(), this.Splash.getHeight()));
		
		//Checks for message -----//
		if(msg == null)
		{System.out.println("[WARNING]: Confirmation message is null"); this.Message = "Null!";}
		else
			this.Message = msg;
		
		//Creates Text Box -------//
		TEXT = new TextBox(this.Splash.getWidth() - (HorizontalPadding * 2), this.Splash.getHeight()/2 - (VerticlePadding * 2), this.position.X + HorizontalPadding, this.position.Y + Splash.getHeight() - VerticlePadding);
		TEXT.setMessage(TESTMESSAGE);
		//Calculates the size of the buttons
		int Button_Width = (this.Splash.getWidth() - (HorizontalPadding * 4))/2;
		int Button_Height = (this.Splash.getHeight() - (VerticlePadding * 3) - TEXT.getHeight());
		
		//Checks for AffButton ---//
		if(AffButton != null)
			this.Button_Affirmation = AffButton;
		else
			this.Button_Affirmation = new Button("OK!", position.X + HorizontalPadding, position.Y + VerticlePadding, Justify.LEFT_BOTTOM, Button_Width, Button_Height, false);
		
		//Checks for DenButton ---//
		if(DenyButton != null)
			this.Button_Denial = DenyButton;
		else
			this.Button_Denial = new Button("Cancel!", position.X + this.Splash.getWidth() - HorizontalPadding, position.Y + VerticlePadding, Justify.RIGHT_BOTTOM, Button_Width, Button_Height, false);
	}
	
	public void render(SpriteBatch batch)
	{
		if(visable){
			if(shadeScreen)
				Gdx.gl.glClearColor(shadeColor.r, shadeColor.g, shadeColor.b, (float) 0.4);
		batch.draw(Splash, position.X, position.Y);
		Button_Affirmation.render(batch);
		Button_Denial.render(batch);
		TEXT.render(batch);
		}
	}
	
	public void show()
	{
		visable = true;
	}
	
	public void hide()
	{
		visable = false;
		Button_Affirmation.manualClickReset();
		Button_Denial.manualClickReset();
	}
	
	public boolean isVisable()
	{
		return visable;
	}
	
	public int decision()
	{
		if(Button_Affirmation.wasClicked())
			return 0;
		else if(Button_Denial.wasClicked())
			return 1;
		else return 2;
	}
	public void dispose()
	{
		Button_Affirmation.dispose();
		Button_Denial.dispose();
		Splash.dispose();		
	}

}
