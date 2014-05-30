package handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utils.map.MapGrid;

public class HandlerWrapper
{

	MapGrid grid;
	
	//Handlers
	public MapHandler maps;
	EntityHandler entities;
	ItemHandler items;
	OrthographicCamera cam;
	
	public HandlerWrapper(OrthographicCamera cam)
	{
		this.grid = new MapGrid();
		
		maps = new MapHandler("New_Spawn");
		entities = new EntityHandler();
		items = new ItemHandler();
		
		this.cam = cam;
		
		this.grid.load(maps.getCurrent());
	}
	
	public void render(SpriteBatch batch)
	{
		maps.render(batch, cam);
		if(Gdx.input.isKeyPressed(Keys.F11))
			grid.render(cam.combined);
		
	}
}
