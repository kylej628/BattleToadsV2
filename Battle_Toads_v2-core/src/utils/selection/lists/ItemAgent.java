package utils.selection.lists;

import utils.data.Justify;

public class ItemAgent {
	
	String XMLTag;
	String Label;
	Justify justification;
	boolean DisplayLabel;
	
	/**
	 * 
	 * @param XMLTag
	 * @param Label
	 * @param displayLabel
	 * @param Justification
	 */
	public ItemAgent(String passedTag, String passedLabel, boolean displayLabel, Justify passedJustification)
	{
		this.XMLTag = passedTag;
		this.Label = passedLabel;
		this.DisplayLabel = displayLabel;
		this.justification = passedJustification;
	}

	public String getXMLTag()
	{
		return XMLTag;
	}
	
	public void setXMLTag(String xMLTag)
	{
		XMLTag = xMLTag;
	}
	
	public String getLabel()
	{
		return Label;
	}
	
	public void setLabel(String label)
	{
		Label = label;
	}
	
	public Justify getJustification()
	{
		return justification;
	}
	
	public void setJustification(Justify justification)
	{
		this.justification = justification;
	}
	
	public boolean isDisplayLabel()
	{
		return DisplayLabel;
	}
	
	public void setDisplayLabel(boolean displayLabel)
	{
		DisplayLabel = displayLabel;
	}
}
