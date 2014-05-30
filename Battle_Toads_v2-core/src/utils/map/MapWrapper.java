package utils.map;

import playScreen.componentEntity.Entity;
import utils.SystemLogger;
import utils.data.Property;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;

public class MapWrapper {

	//Actual TmxMap
	public TiledMap tiledMap;
	
	
	//Variables
	private String MAP_NAME;
	
	//XMLReader
	Element mapElement;
	
	//Arrays - Portals and Entities
	Array<Entity> entities;
	Array<Portal> portals;
	
	public MapWrapper(Element mapElement)
	{
		//Loads the tiled map
		System.out.println(mapElement.getName());
		tiledMap = new TmxMapLoader().load(mapElement.getAttribute("IFP"));
		
		//Sets the name via the map
		MAP_NAME = tiledMap.getProperties().get("Map_Name").toString();
		
		//XMLReader
		this.mapElement = mapElement;
		
		
		//Initializes the portal array
	}
	
	public void update(float delta)
	{
		
	}
	
	public void render(SpriteBatch batch)
	{
		
	}
	
	public String getName()
	{
		return MAP_NAME;
	}
	
	public String getProperty(Property prop)
	{
		switch(prop)
		{
		case WIDTH: return String.valueOf(tiledMap.getProperties().get("width"));
		case HEIGHT: return String.valueOf(tiledMap.getProperties().get("height"));
		case NAME: return MAP_NAME;
		case TILE_SIZE: return String.valueOf(tiledMap.getProperties().get("tilewidth"));
		
		default: SystemLogger.Log("Unable to find property:" + prop);
		}
		return null;
	}
	
}
