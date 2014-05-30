package utils.selection;

import utils.data.Justify;
import utils.selection.lists.ScrollList;

import com.badlogic.gdx.graphics.Texture;

public class PreviewPane {
	
	Texture currentPreview;
	protected int XPOS, YPOS, WIDTH, HEIGHT;
	
	//Compatibility variables --------//
	private ScrollList SCROLL_LIST;
	
	public PreviewPane(ScrollList connectedList, int xPos, int yPos, int width, int height, Justify justification)
	{
		//Links the list to the preview --//
		this.SCROLL_LIST = connectedList;
		
		//Sets the justification 
		setJustification(justification, xPos, yPos);
		
		//Sets the width and height ------//
		this.WIDTH = width;
		this.HEIGHT = height;
	}
	
	public PreviewPane(ScrollList connectedList, int xPos, int yPos, int width, int height)
	{
		//Links the list to the preview --//
		this.SCROLL_LIST = connectedList;
		
		//Sets the width and height ------//
		this.WIDTH = width;
		this.HEIGHT = height;
	}
	
	/*
	 * Will add the compatibility to other types of lists
	 */
	
	public void update()
	{
		if(this.SCROLL_LIST != null)
			currentPreview = SCROLL_LIST.getCurrentItem().getPreview();
	}
	
	public void render()
	{
		
	}
	
	/**
	 * Justifies the pane depending on an input.
	 * @param j : Convention <X>_<Y> ie: Center-Top = centered X, top Y
	 * @param positionX
	 * @param positionY
	 */
	private void setJustification(Justify j, int positionX, int positionY)
	{
		switch(j)
		{
		case LEFT_TOP: JustifyX_Left(positionX); JustifyY_Top(positionY);
			break;
		case LEFT_CENTER: JustifyX_Left(positionX); JustifyY_Center(positionY);
			break;
		case LEFT_BOTTOM: JustifyX_Left(positionX); JustifyY_Bottom(positionY);
			break;
		case CENTER_TOP: JustifyX_Center(positionX); JustifyY_Top(positionY);
			break;
		case CENTER_CENTER: JustifyX_Center(positionX); JustifyY_Center(positionY);
			break;
		case CENTER_BOTTOM: JustifyX_Center(positionX); JustifyY_Bottom(positionY);
			break;
		case RIGHT_TOP: JustifyX_Right(positionX); JustifyY_Top(positionY);
			break;
		case RIGHT_CENTER: JustifyX_Right(positionX); JustifyY_Center(positionY);
			break;
		case RIGHT_BOTTOM: JustifyX_Right(positionX); JustifyY_Bottom(positionY);
			break;
		default : System.out.println("ERROR: Unable to justify, check code!");
		}
	}
	
	private void JustifyX_Left(int positionX)  {this.XPOS = positionX;				 }
	private void JustifyX_Center(int positionX){this.XPOS = positionX - (WIDTH / 2); }
	private void JustifyX_Right(int positionX) {this.XPOS = positionX - WIDTH;		 }
	private void JustifyY_Top(int positionY)   {this.YPOS = positionY - HEIGHT;		 }
	private void JustifyY_Center(int positionY){this.YPOS = positionY - (HEIGHT / 2);}
	private void JustifyY_Bottom(int positionY){this.YPOS = positionY;				 }
}
