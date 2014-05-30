package utils.selection.lists;

import utils.xml.XMLReader;
import utils.data.Justify;

public class ScrollList {
	
	//Variables ------//
	ListItem[] items;
	String[] Agents;
	
	//Low level variables --//
	int CURRENT_ITEM = 0;
	
	public ScrollList(XMLReader parser, String XMLPath, String[] agents, Justify[] j)
	{
		for(int temp = 0; temp < agents.length; temp++)
			Agents[temp] = new String(agents[temp]);
	}
	
	public ListItem getCurrentItem()
	{
		return items[CURRENT_ITEM];
	}
}
