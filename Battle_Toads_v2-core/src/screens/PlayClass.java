package screens;

import handlers.HandlerWrapper;
import playScreen.GUI.GuiClass;
import utils.data.Justify;
import utils.selection.Pointer;
import applicationFiles.BattleToads;
import applicationFiles.DebuggableScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayClass implements DebuggableScreen{
	
	//Main game -----//
	public BattleToads GAME;
	
	//Camera --------//
	private OrthographicCamera cam;
	
	float xCorOffset, yCorOffset;
	float xTrueCam, yTrueCam;
	int mapEdgeX = 0, mapEdgeY=0;
	
	
	//Sprite Batch --//
	private SpriteBatch batch;
	private SpriteBatch debug;
	
	//GUI -----------//
	private GuiClass GUI;
	
	//Mouse position //
	private int MouseX=0, MouseY=0;
	
	//Handlers
	HandlerWrapper handlers;
	
	public PlayClass(BattleToads GAME)
	{
		
		//Links the game to the main game --//
		this.GAME = GAME;
		
		//Initializes camera ---------------//
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.translate(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		cam.update();
		xCorOffset = Gdx.graphics.getWidth()/2;
		yCorOffset = Gdx.graphics.getHeight()/2;
		xTrueCam = cam.position.x - xCorOffset;
		yTrueCam = cam.position.y - yCorOffset;
		
		//Assigns a map --------------------//
		//MapLoad();
		
		
		//Initializes spriteBatch ----------//
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		batch.enableBlending();
		
		debug = new SpriteBatch();
		debug.enableBlending();
		
		//Initializes the GUI --------------//
		GUI = new GuiClass(new Texture(Gdx.files.internal("play/GUI Resources/GUI_Main_Back.png")), 0, 0, Justify.LEFT_TOP);
		
		handlers = new HandlerWrapper(cam);
		
		//Loads information for map movement
	}

	double tempX = 0;
	double tempY = 0;
	
	@Override
	public void render(float delta) {
		//Mouse update ---------//
		//--Pulls the position to temp doubles
		tempX = (Gdx.input.getX() + cam.position.x - Gdx.graphics.getWidth()/2) / 32;
		tempY = (Gdx.graphics.getHeight() - Gdx.input.getY() + cam.position.y - Gdx.graphics.getHeight()/2)/32;
		//--If temps are bigger than 0, assign
		if(tempX < 0 || tempY < 0)
		{MouseX = -1; MouseY = -1;}
		else
		{MouseX = (int) tempX; MouseY = (int) tempY;}
		
		//Render section -------//
		handlers.render(batch);
		GUI.render();
		batch.begin();
		cam.update();
		
		if(Pointer.isDragging)
		{
			dragMap(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
		}
		else if(Pointer.isClicky)
			System.out.println("Clicky!");
		
		batch.end();
		debug.begin();
		GAME.font.setColor(Color.WHITE);
		//GAME.font.draw(debug, "Nother test", 10, -10);
		GAME.font.draw(debug, "Cam Position: " + cam.position.x + ", " + cam.position.y + ":", 10, 20);
		GAME.font.draw(debug, "Mouse: " + Gdx.input.getX() + ", " + Gdx.input.getY() + "/n" + "Grid Position: (" + MouseX + ", " + MouseY + ")", 0, 0);
		debug.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		//Unlimit the rendering ------------//
		this.GAME.limitFPS(false);
	}
	
	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
	
	public void dragMap(float deltaX, float deltaY) {
		mapEdgeX = (int) ((int) handlers.maps.getCurrent().tiledMap.getProperties().get("width") * 32 - xCorOffset);
		mapEdgeY = (int) ((int) handlers.maps.getCurrent().tiledMap.getProperties().get("height") * 32 - yCorOffset);
		
		cam.translate(deltaX, deltaY);
		
		if(cam.position.x <= xCorOffset)
			cam.position.set(xCorOffset, cam.position.y, 0f);
		if(cam.position.x >= mapEdgeX)
			cam.position.set(mapEdgeX, cam.position.y, 0f);
		if(cam.position.y <= yCorOffset)
			cam.position.set(cam.position.x, yCorOffset, 0f);
		if(cam.position.y >= mapEdgeY + GUI.getHeight())
			cam.position.set(cam.position.x, mapEdgeY + GUI.getHeight(), 0f);
	}

	@Override
	public void debug() {
		// TODO Auto-generated method stub
		
	}

}
