package playScreen.componentEntity.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import playScreen.componentEntity.Entity;
import playScreen.entities.Component;

public class Control implements Component {
	
	//Variables ===========//
	Entity entity;
	int speed;
	
	public Control(Entity passedEntity, int passedSpeed){
		entity = passedEntity;
		speed = passedSpeed;
	}

	@Override
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.A)){
			entity.position.X -= (speed * delta);
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			entity.position.X += (speed * delta);
		}
		if(Gdx.input.isKeyPressed(Keys.W)){
			entity.position.Y += (speed * delta);
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			entity.position.Y -= (speed * delta);
		}
	}
}
