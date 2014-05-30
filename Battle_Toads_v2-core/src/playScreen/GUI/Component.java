package playScreen.GUI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utils.SystemLogger;
import utils.data.Justify;

public class Component {
	
	//Component information
	private String tag;
	private int width;
	private int height;
	private int x, y;
	private int padding=0;
	
	//Component graphics
	Texture icon, backing;
	
	//Component values
	private int maxValue;
	private int currentValue;
	private int minValue;
	private int iconPadding;
	
	//Super class information
	GuiClass gui;
	Justify just;
	
	public Component(GuiClass gui, String tag, int width, int height, int minValue, int currentValue, int maxValue, Justify just,
			Texture componentIcon, Texture componentBacking)
	{
		this.tag = tag;
		this.width = width;
		this.height = height;
		this.maxValue = maxValue;
		this.currentValue = currentValue;
		this.minValue = minValue;
		
		this.icon = componentIcon;
		this.backing = componentBacking;
		
		this.iconPadding = (this.height - icon.getHeight())/2;
		
		this.gui = gui;
		this.just = just;
		
		setPosition(gui, just);
	}
	
	public void setComponentPadding(int amount)
	{
		this.padding = amount;
		setPosition(gui, just);
	}
	
	private void setPosition(GuiClass gui, Justify just)
	{
		//Pull width and height information from the GUI class;
		int guiWidth = gui.width, guiHeight = gui.height;
		//Pull location information out of GUI class;
		int guiX = gui.x, guiY = gui.y;
		
		switch(just)
		{
		case BOTTOM:SystemLogger.Log("Unable to justify to " + just);
			break;
		case CENTER:SystemLogger.Log("Unable to justify to " + just);
			break;
		case CENTER_BOTTOM:{ x = guiX+guiWidth/2-width/2; y = guiY+padding;};
			break;
		case CENTER_CENTER:{ x = guiX+guiWidth/2-width/2; y = guiY+guiHeight/2-height/2;};
			break;
		case CENTER_TOP:{ x = guiX+guiWidth/2-width/2; y = guiY+guiHeight-height-padding;};
			break;
		case LEFT:SystemLogger.Log("Unable to justify to " + just);
			break;
		case LEFT_BOTTOM:{ x = guiX+padding; y = guiY+padding;};
			break;
		case LEFT_CENTER:{ x = guiX+padding; y = guiY+guiHeight/2-height/2;};
			break;
		case LEFT_TOP:{ x = guiX+padding; y = guiY+guiHeight-height-padding;};
			break;
		case RIGHT:SystemLogger.Log("Unable to justify to " + just);
			break;
		case RIGHT_BOTTOM:{ x = guiX+guiWidth-width-padding; y = guiY+padding;};
			break;
		case RIGHT_CENTER:{ x = guiX+guiWidth-width-padding; y = guiY+guiHeight/2-height/2;};
			break;
		case RIGHT_TOP:{ x = guiX+guiWidth-width-padding; y = guiY+guiHeight-height-padding;};
			break;
		case TOP:SystemLogger.Log("Unable to justify to " + just);
			break;
		default:SystemLogger.Log("Unable to justify to " + just);
			break;
		}
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(backing, x, y, width, height);
		batch.draw(icon, x+iconPadding, y+iconPadding);
	}
	
	public String getTag()
	{
		return tag;
	}
	
	public int getCurrent()
	{
		return currentValue;
	}
	
	public void adjustValue(int amount)
	{
		if(currentValue+amount < minValue || currentValue+amount > maxValue)
			SystemLogger.Log("invalid value!: " + (currentValue+amount) + " :Max|" + maxValue + ":Min|" + minValue);
		else
			currentValue =+ amount;
	}

}
