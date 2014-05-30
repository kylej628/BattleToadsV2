package playScreen.GUI;

import utils.SystemLogger;
import utils.data.Justify;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GuiClass {
	//Background texture
	Texture guiBack;
	//GUI information
	int x, y;
	int width, height;
	//information for rendering the GUI
	SpriteBatch batch;
	private OrthographicCamera Guicam;
	public BitmapFont font;
	
	//Component information
	Component health, coins;
	
	/**
	 * Creates a component driven GUI. pass 0, 0 for
	 * width and height if you want it to default to
	 * the width and height of the background image. 
	 * @param GUIBackground
	 * @param width
	 * @param height
	 */
	public GuiClass(Texture GUIBackground, int width, int height, Justify just)
	{
		this.guiBack = GUIBackground;
		if(width == 0)
			this.width = guiBack.getWidth();
		else
			this.width = width;
		if(height == 0)
			this.height = guiBack.getHeight();
		else
			this.height = height;
		
		setPosition(just);
		
		batch = new SpriteBatch();
		batch.enableBlending();
		
		health = new Component(this, "health", 150, 35, 0, 50, 100, Justify.RIGHT_TOP, new Texture(Gdx.files.internal("play/GUI Resources/heart.png")), new Texture(Gdx.files.internal("play/GUI Resources/alpha_105.png")));
		coins = new Component(this, "coins", 150, 35, 0, 0, 99999, Justify.RIGHT_BOTTOM, new Texture(Gdx.files.internal("play/GUI Resources/coin.png")), new Texture(Gdx.files.internal("play/GUI Resources/alpha_105.png")));
		health.setComponentPadding(20);
		coins.setComponentPadding(20);
		
		Guicam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());	
		Guicam.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		Guicam.update();
		
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		batch.setProjectionMatrix(Guicam.combined);
		Guicam.update();
	}
	
	private void setPosition(Justify just)
	{
		switch(just)
		{
		case BOTTOM:SystemLogger.Log("Unable to justify to " + just);
			break;
		case CENTER:SystemLogger.Log("Unable to justify to " + just);
			break;
		case CENTER_BOTTOM:{ x = Gdx.graphics.getWidth()/2-width/2; y = 0;};
			break;
		case CENTER_CENTER:{ x = Gdx.graphics.getWidth()/2-width/2; y = Gdx.graphics.getHeight()/2-height/2;};
			break;
		case CENTER_TOP:{ x = Gdx.graphics.getWidth()/2-width/2; y = Gdx.graphics.getHeight()-height;};
			break;
		case LEFT:SystemLogger.Log("Unable to justify to " + just);
			break;
		case LEFT_BOTTOM:{ x = 0; y = 0;};
			break;
		case LEFT_CENTER:{ x = 0; y = Gdx.graphics.getHeight()/2-height/2;};
			break;
		case LEFT_TOP:{ x = 0; y = Gdx.graphics.getHeight()-height;};
			break;
		case RIGHT:SystemLogger.Log("Unable to justify to " + just);
			break;
		case RIGHT_BOTTOM:{ x = Gdx.graphics.getWidth()-width; y = 0;};
			break;
		case RIGHT_CENTER:{ x = Gdx.graphics.getWidth()-width; y = Gdx.graphics.getHeight()/2-height/2;};
			break;
		case RIGHT_TOP:{ x = Gdx.graphics.getWidth()-width; y = Gdx.graphics.getHeight()-height;};
			break;
		case TOP:SystemLogger.Log("Unable to justify to " + just);
			break;
		default:SystemLogger.Log("Unable to justify to " + just);
			break;
		}
	}
	
	public void render()
	{
		batch.begin();
		batch.draw(guiBack, x, y);
		health.render(batch);
		coins.render(batch);
		batch.end();
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

}
