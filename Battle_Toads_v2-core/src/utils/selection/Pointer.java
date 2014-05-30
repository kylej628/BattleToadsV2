package utils.selection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pointer {
	
	//various pointers
	Texture Default_Pointer;
	Texture Grabbing_Pointer;
	private SpriteBatch batch;
	
	public static boolean isDragging = false;
	public static boolean isClicky = false;
	float x, y;
	
	public Pointer()
	{
		Default_Pointer = new Texture(Gdx.files.internal("pointers/default.png"));
		Grabbing_Pointer = new Texture(Gdx.files.internal("pointers/grabbed.png"));
		
		batch = new SpriteBatch();
	}
	
	public void render()
	{
		batch.begin();
		if(isDragging)
			batch.draw(Grabbing_Pointer, x-6, Gdx.graphics.getHeight()-(y+Grabbing_Pointer.getHeight()));
		else
			batch.draw(Default_Pointer, x, Gdx.graphics.getHeight()-(y+Default_Pointer.getHeight()));
		batch.end();
	}
	
	boolean ignore = false;
	public void update2()
	{
		this.x = Gdx.input.getX();
		this.y = Gdx.input.getY();
		if(Gdx.input.isButtonPressed(0) && (Gdx.input.getDeltaX() >= 0.1 || Gdx.input.getDeltaX() <= -0.1 || Gdx.input.getDeltaY() <= -0.1 || Gdx.input.getDeltaY() >= 0.1 || isDragging))
			isDragging = true;
		else
			isDragging = false;
		//Keeps track of clicking
		isClicky = false;
		if(!isDragging && !ignore && Gdx.input.isButtonPressed(0))
		{
			isClicky = true;
			ignore = true;
		}
		if(!Gdx.input.isButtonPressed(0))
			ignore = false;
	}
	
	boolean down = false;
	
	int code;
	public void update()
	{
		code = polePointer(); // 0 = down, 1 = up
		this.x = Gdx.input.getX();
		this.y = Gdx.input.getY();
		isClicky = false;
		if(code == 0)
			down = true;
		if(!isDragging && down && code == 1){
			if(!ignore)
				isClicky = true;
			down = false;
			ignore = false;
		}
		if(code == 0 && (Gdx.input.getDeltaX() >= 0.1 || Gdx.input.getDeltaX() <= -0.1 || Gdx.input.getDeltaY() <= -0.1 || Gdx.input.getDeltaY() >= 0.1 || isDragging))
			{isDragging = true; ignore = true;}
		else
			isDragging = false;
	}
	
	public int polePointer()
	{
		if(Gdx.input.isButtonPressed(0))
			return 0;
		else
			return 1;
	}

}
