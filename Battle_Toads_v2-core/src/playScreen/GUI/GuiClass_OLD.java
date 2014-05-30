package playScreen.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utils.SystemLogger;
import utils.data.Justify;
import utils.map.TacoClass;

public class GuiClass_OLD implements TacoClass{
	
	SpriteBatch batch;
	private OrthographicCamera Guicam;
	BitmapFont font;
	Texture GUIBacking;
	
	Justify just;
	
	private int GUI_WIDTH = 0;
	
	public GuiClass_OLD(int GUIWidth, Justify j)
	{
		GUI_WIDTH = GUIWidth;
		just = j;
		init();
	}

	@Override
	public void init()
	{
		batch = new SpriteBatch();
		batch.enableBlending();
		Guicam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());	
		Guicam.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		Guicam.update();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		batch.setProjectionMatrix(Guicam.combined);
		Guicam.update();
		GUIBacking = new Texture(Gdx.files.internal("assets/play/GUI Resources/Sample.png"));
	}

	@Override
	public void update()
	{
		
	}

	@Override
	public void render()
	{
		batch.begin();
		
		switch(just)
		{
		case BOTTOM:batch.draw(GUIBacking, 0, 0);
			break;
		case CENTER:batch.draw(GUIBacking, Gdx.graphics.getWidth()/2-GUIBacking.getWidth()/2, Gdx.graphics.getHeight()/2-GUIBacking.getHeight()/2);
			break;
		case CENTER_BOTTOM:
			break;
		case CENTER_CENTER:
			break;
		case CENTER_TOP:
			break;
		case LEFT:
			break;
		case LEFT_BOTTOM:
			break;
		case LEFT_CENTER:
			break;
		case LEFT_TOP:
			break;
		case RIGHT:
			break;
		case RIGHT_BOTTOM:
			break;
		case RIGHT_CENTER:
			break;
		case RIGHT_TOP:
			break;
		case TOP:batch.draw(GUIBacking, 0, Gdx.graphics.getHeight() - GUI_WIDTH);
			break;
		default:SystemLogger.Log("Unable to justify!");
			break;
		}
		
		//batch.draw(GUIBacking, 0, 0);
		//font.draw(batch, "This is a test", 20, 20);
		batch.end();
	}

	@Override
	public void dispose()
	{
		font.dispose();
		batch.dispose();
	}
	
	public int getWidth()
	{
		return GUI_WIDTH;
	}

	
}
