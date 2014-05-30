package playScreen.entities;

import utils.data.Coord;
import utils.xml.XMLReader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;

public class EntityHandler {
	
	//Multidimensional arrays for entities <map><entity>
	Array<EntityWrapper> entities;
	
	XMLReader EntityXml;
	XMLReader xml;
	
	//Current map
	int current = 0;
	
	public EntityHandler(XMLReader XML)
	{
		//Links the xml readers
		EntityXml = new XMLReader("assets/core/entities.xml", "entities");
		xml = XML;
		entities = new Array<EntityWrapper>();
	}
	
	public void loadMap(String mapName)
	{
		//1.) Creates a new entity wrapper for the map
		entities.add(new EntityWrapper(mapName));
		
		//2.) Pulls the node for the map from 'internal.xml'
		Element Entity_Element = xml.getElement("mapName").getChildByName("entities");
		for(int i = 0; i < Entity_Element.getChildCount(); i++)
		{
			//Load the entity into the arrays
			String type = Entity_Element.getChild(i).getAttribute("type");
			
			//If it of the moving variety
			if(type.equalsIgnoreCase("moving"))
			{
				//Pull the element into the temp slot
				Element temp = Entity_Element.getChild(i);
				//Prepare information for loading
				//String passedID, String passedName, Coord passedPosition, Texture passedSprite, Texture passedAnimation, int passedDirection
				String ID, NAME, Default;
				Coord position;
				Texture sprite, animation;
				int x, y, direction, walkingFrames, attackingFrames;
				boolean isDefaultAvailable = false;
				
				if(temp.getChildByName("Default") != null && !temp.getChildByName("Default").getText().equalsIgnoreCase("none"))
					isDefaultAvailable = true;
				else
				{
					isDefaultAvailable = false;
					Default = temp.getChildByName("Default").getText();
					Element tempDefault = EntityXml.getElement(Default);
				}
				
				
				/*ID*/
				ID = temp.getName();
				/*Name*/
				if(temp.getAttribute("name") != null)
					NAME = temp.getAttribute("name");
				else if(isDefaultAvailable)
					//NAME = Default;
				/*X Position*/
				if(temp.getAttribute("x") != null)
					x = Integer.parseInt(temp.getAttribute("x"));
				else if(isDefaultAvailable)
					{x = 0; System.out.println("ID: " + ID + " has no X value");}
				/*Y Position*/
				if(temp.getAttribute("y") != null)
					y = Integer.parseInt(temp.getAttribute("x"));
				else if(isDefaultAvailable)
					{y = 0; System.out.println("ID: " + ID + " has no Y value");}
				/*Texture*/
				if(temp.getChildByName("Texture").getAttribute("path") != null)
					sprite = new Texture(temp.getChildByName("Texture").getAttribute("path"));
				else if(isDefaultAvailable)
					//sprite = tempDefault.getChildByName("Texture").getAttribute("path") 
				/*Animation*/
				if(temp.getChildByName("Animation").getAttribute("path") != null)
					animation = new Texture(temp.getChildByName("Animation").getAttribute("path"));
				else if(isDefaultAvailable)
					
				/*Walking Frames*/
				if(temp.getChildByName("Animation").getChildByName("walking").getAttribute("frames") != null)
					walkingFrames = Integer.parseInt(temp.getChildByName("Animation").getChildByName("walking").getAttribute("frames"));
				else if(isDefaultAvailable)
					
				/*Attacking Frames*/
				if(temp.getChildByName("Animation").getChildByName("attacking").getAttribute("frames") != null)
					attackingFrames = Integer.parseInt(temp.getChildByName("Animation").getChildByName("attacking").getAttribute("frames"));
				else if(isDefaultAvailable);
			}
			
			//If it of the stationary variety - DEFAULT
			if(type.equalsIgnoreCase("stationary") || type == null)
			{
				
			}
		}
	}
	
	public void update(float delta, SpriteBatch batch)
	{	
		//Update and render the stationary entities
		for(int h = 0; h < entities.get(current).stationaries.size; h++)
		{
			entities.get(current).stationaries.get(h).update(delta);
		}
		for(int i = 0; i < entities.get(current).stationaries.size; i++)
		{
			entities.get(current).stationaries.get(i).render(batch);
		}
		
		//Update and render the moving entities
		for(int j = 0; j < entities.get(current).moveables.size; j++)
		{
			entities.get(current).moveables.get(j).update(delta);
		}
		for(int k = 0; k < entities.get(current).moveables.size; k++)
		{
			entities.get(current).moveables.get(k).render(batch);
		}
		
	}

}
