package playScreen.entities;

import utils.data.Coord;
import utils.data.EntitySlot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;

public class Player extends Entity{
	
	public Player(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection)
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection);
	}

	public Player(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots) 
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection, passedSlots);
	}

}
