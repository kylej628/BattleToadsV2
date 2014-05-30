package handlers;

import java.io.IOException;

import utils.SystemLogger;
import utils.map.MapWrapper;
import utils.xml.XMLReader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;

public class MapHandler
{
	//Variables
	Array<MapWrapper> maps;
	
	int CURRENT_MAP;
	
	XMLReader mapXml;
	Element mapElement;
	
	OrthogonalTiledMapRenderer renderer;
	
	public MapHandler(String currentMap)
	{
		maps = new Array<MapWrapper>();
		mapXml = new XMLReader("core/maps.xml", "maps");
		mapElement = mapXml.getElement("maps");
		if(mapElement.getChildCount() == 0)
		{
			SystemLogger.Log("maps.xml is empty");
		}
		else
		{
			for(int i = 0; i < mapElement.getChildCount(); i++)
			{
				maps.add(new MapWrapper(mapElement.getChild(i)));
			}
		}
		
		//Find the map to set as current
		boolean found = false;
		for(int j = 0; j < maps.size; j++)
		{
			if(maps.get(j).getName().equalsIgnoreCase(currentMap))
			{
				CURRENT_MAP = j;
				found = true;
				break;
			}
		}
		if(!found)
		{
			CURRENT_MAP = 0;
			SystemLogger.Log("Cannot find currentMap");
		}
		
		renderer = new OrthogonalTiledMapRenderer(maps.get(CURRENT_MAP).tiledMap);
	}
	
	public void update(float delta)
	{
		maps.get(CURRENT_MAP).update(delta);
	}
	
	public void render(SpriteBatch batch, OrthographicCamera cam)
	{
		renderer.setView(cam);
		renderer.render();
		maps.get(CURRENT_MAP).render(batch);
//		for(int i = 0; i < renderer.getMap().getLayers().getCount(); i++)
//		{
//			if(!renderer.getMap().getLayers().get(i).getName().equalsIgnoreCase("data"))
//			renderer.renderTileLayer((TiledMapTileLayer) renderer.getMap().getLayers().get(i));
//		}
	}

	public MapWrapper getCurrent()
	{
		return maps.get(CURRENT_MAP);
	}
	
	public void switchMaps(String mapName)
	{
		for(int i = 0; i < maps.size; i++)
		{
			if(maps.get(i).getName().equalsIgnoreCase(mapName))
			{
				CURRENT_MAP = i;
				renderer.setMap(maps.get(i).tiledMap);
			}
		}
	}

}
