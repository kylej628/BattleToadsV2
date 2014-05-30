package utils.selection.lists;

import com.badlogic.gdx.graphics.Texture;

public class ListItem
{
	//Variables --//
	String[] data;
	Texture PREVIEW;
	public ListItem(String[] DATA)
	{
		this.data = DATA;
	}
	
	public String getData(int index)
	{
		return data[index];
	}
	
	public Texture getPreview()
	{
		return PREVIEW;
	}
	
	

}
