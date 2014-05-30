package utils.selection.lists;

public class AgentData
{
	
	private String XMLTag;
	private String Data;
	
	public AgentData(String xmlTag, String data)
	{
		this.XMLTag = xmlTag;
		this.Data = data;
	}
	
	public AgentData(String xmlTag)
	{
		this.XMLTag = xmlTag;
		this.Data = "null";
	}
	
	public String getTag()
	{
		return XMLTag;
	}
	
	public void setTag(String tag)
	{
		this.XMLTag = tag;
	}
	
	public String getData()
	{
		return this.Data;
	}
	
	public void setData(String data)
	{
		this.Data = data;
	}

}
