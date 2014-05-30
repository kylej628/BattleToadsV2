package playScreen.GUI;

import utils.xml.XMLReader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ItemSlot
{
	//Object information
	String SlotTag;
	String objectId = "#0001";
	
	int xPos, yPos, backingPadding, padding;
	Texture SlotBacking, ObjectTile;
	
	public ItemSlot(String tag, FileHandle SlotBacking, XMLReader xml)
	{
		//Assigns the slot a tag, can be used as an identifier
		SlotTag = tag;
		
		//Assigns a texture for the back of the slot. Most visible without an item
		this.SlotBacking = new Texture(SlotBacking);
	}
	
	public void setObject(String id)
	{
		this.objectId = id;
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(this.SlotBacking, xPos, yPos);
		batch.draw(this.ObjectTile, xPos + padding, yPos + padding);
	}
}
