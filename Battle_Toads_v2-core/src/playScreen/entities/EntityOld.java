package playScreen.entities;

import utils.data.Coord;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
@Deprecated
public class EntityOld {

	public enum Script{
		ONE_DIRECTION, 	//Back and forth movement
		RANDOM, 		//Various directions and lengths
		PATROL, 		//Back and forth along a set distance
		GUARD			//Doesn't move but rotates
	}
	
	//Variables ---------//
	String interactionId;
	Texture sprite;
	Coord position;
	float xPos, yPos;
	int direction = 0;
	boolean walking = false;
	
	Script script;
	
	public EntityOld(String passedID, Texture passedSprite, Coord passedPosition, Script passedScript)
	{
		this.interactionId = passedID;
		this.sprite = passedSprite;
		this.position = passedPosition;
		xPos = passedPosition.X;
		yPos = passedPosition.Y;
		this.script = passedScript;
	}
	
	public void update(float delta)
	{
		if(!walking)
		{
			//Rounds the player to the nearest position,
			//this works for every situation.
			position.X = (int) Math.round(xPos / 32);
			position.Y = (int) Math.round(yPos / 32);
			
			xPos = position.X * 32;
			yPos = position.Y * 32;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN) && !walking)
			{moveDown(delta); direction = 0;}
		if(Gdx.input.isKeyPressed(Keys.RIGHT) && !walking)
			{moveRight(delta); direction = 1;}
		if(Gdx.input.isKeyPressed(Keys.UP) && !walking)
			{moveUp(delta); direction = 2;}
		if(Gdx.input.isKeyPressed(Keys.LEFT) && !walking)
			{moveLeft(delta); direction = 3;}	
		if(walking)
		{
			switch(direction)
			{
				case 0 : moveDown(delta);
				break;
				case 1 : moveRight(delta);
				break;
				case 2 : moveUp(delta);
				break;
				case 3 : moveLeft(delta);
				break;
			}
		}
	}
	float distance = 32;
	
	public void render(SpriteBatch batch)
	{
		batch.draw(sprite, xPos, yPos);
	}
	
	public void moveUp(float delta)
	{
		if(!walking)
		{
			distance = 32;
			walking = true;
		}
		float temp = 64.0f * delta*2;
		if(distance > 0 && walking)
		{
			yPos += temp;
			distance -= temp;
			System.out.println("[Data] " + distance + ", " + xPos);
		}
		else
		{
			walking = false;
		}
		
	}
	
	public void moveDown(float delta)
	{
		if(!walking)
		{
			distance = 32;
			walking = true;
		}
		float temp = 64.0f * delta*2;
		if(distance > 0 && walking)
		{
			yPos -= temp;
			distance -= temp;
			System.out.println("[Data] " + distance + ", " + xPos);
		}
		else
		{
			walking = false;
		}
		
	}
	
	public void moveLeft(float delta)
	{
		if(!walking)
		{
			distance = 32;
			walking = true;
		}
		float temp = 64.0f * delta*2;
		if(distance > 0 && walking)
		{
			xPos -= temp;
			distance -= temp;
			System.out.println("[Data] " + distance + ", " + xPos);
		}
		else
		{
			walking = false;
		}
		
	}
	
	
	public void moveRight(float delta)
	{
		if(!walking)
		{
			distance = 32;
			walking = true;
		}
		float temp = 64.0f * delta*2;
		if(distance > 0 && walking)
		{
			xPos += temp;
			distance -= temp;
			System.out.println("[Data] " + distance + ", " + xPos);
		}
		else
		{
			walking = false;
		}
			
	}

}
