package playScreen.entities;

import utils.data.Coord;
import utils.data.EntitySlot;
import utils.data.Script;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MovingEntity extends Entity{
	
	Script script = Script.RANDOM;

	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection) 
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection);
	}
	
	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Script script) 
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection);
		this.script = script;
	}
	
	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots)
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection, passedSlots);
	}
	
	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots, Script script)
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection, passedSlots);
		this.script = script;
	}

	public void update()
	{
		
	}
	
	public void render(SpriteBatch batch)
	{
		//Updates internally --//
		this.update();
		//Renders -------------//
		super.render(batch);
		
	}
}
