package playScreen.entities;

import playScreen.componentEntity.Entity;

import com.badlogic.gdx.utils.Array;

public class EntityWrapper {
	
	//Public variables
	public Array<Entity> stationaries;
	public Array<Entity> moveables;
	
	private String mapName = "Null";
	
	public EntityWrapper(String mapName)
	{
		this.mapName = mapName;
		stationaries = new Array<Entity>();
		moveables = new Array<Entity>();
	}
	
	public String getName()
	{
		return mapName;
	}
	
}
