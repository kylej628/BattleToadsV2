package playScreen.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utils.data.Coord;

public class AnimatedEntity {
	
	//Variables----------//
	String interactionId;
	Animation animation;
	Coord position;
	
	public AnimatedEntity(String passedID, Animation passedAnimation, Coord passedPosition)
	{
		this.interactionId = passedID;
		this.animation = passedAnimation;
		this.position = passedPosition;
	}
	
	public void update()
	{
		
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(animation.getKeyFrame(Gdx.graphics.getDeltaTime()), position.X, position.Y);
	}

}
