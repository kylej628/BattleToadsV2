package utils.selection.lists;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utils.xml.XMLReader;
public class List
{
	//Variables --------//
	int selectedIndex = 0;
	ListItem[] items;
	ItemAgent[] agents;
	
	/**
	 * Creates a list based off of a XML file with a flexible agent list
	 * @param parser - XMLReader
	 * @param Agents - ItemAgent[]
	 * @param Dimensions - int[5] {XPos, YPos, ListWidth, ListHeight, ListItemHeight}
	 * @param RootKey - String
	 */
	public List(XMLReader passedParser, ItemAgent[] passedAgents, int[] dimensions, String RootKey)
	{
		//Links the local agent array
		this.agents = passedAgents;
		
		//Creates a new String array with the size of the list and the number of agents
		String[][] ListItems = new String[passedParser.getList(RootKey).size][passedAgents.length];
		
		//Populates the String array
		for(int i = 0; i < passedParser.getList(RootKey).size; i++)//FOR:ITEMLIST
		{
			for(int j = 0; j < passedAgents.length; j++)//FOR:AGENTS
			{
				ListItems[i][j] = new String(passedParser.getData(passedAgents[j].getXMLTag()));
			}
		}
		
		//Creates a new ListItem array
		items = new ListItem[ListItems.length];
		
		//Populates the ListItem array
		for(int i = 0; i < items.length; i++)//FOR:ITEMS
		{
			items[i] = new ListItem(ListItems[i]);
		}
	}
	
	/**
	 * returns the list item that is currently selected
	 * @return ListItem
	 */
	public ListItem getSelected()
	{
		return items[selectedIndex];
	}
	
	public void update()
	{
		
	}
	
	public void render(SpriteBatch batch)
	{
		//batch.draw();
		for(int i = 0; i < items.length; i++)//FOR:ITEMS
		{
			for(int j = 0; j < agents.length; j++)//FOR:AGENTS
			{
				drawAgent(items[i].getData(j), agents[j]);
			}
		}
	}
	
	private void drawAgent(String data, ItemAgent agent)
	{
		
	}
}
