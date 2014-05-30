package playScreen.entities;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;

import utils.data.Coord;
import utils.xml.XMLReader;

enum Move{
	LEFT, RIGHT, UP, DOWN, PAUSE, LOOK_RANDOM, MOVE_RANDOM
}

public class ScriptRunner {
	
	private String SCRIPT;
	private int speed, xBound, yBound;
	private Entity entity;
	private Array<Move> script;
	
	public ScriptRunner(String script, int scriptSpeed, int xBound, int yBound, Entity scriptedEntity)
	{
		this.SCRIPT = script;
		this.speed = scriptSpeed;
		this.entity = scriptedEntity;
		this.xBound = xBound;
		this.yBound = yBound;
		this.loadScript(SCRIPT);
	}
	
	public ScriptRunner(String script, int scriptSpeed, Coord bounds, Entity scriptedEntity)
	{
		this.SCRIPT = script;
		this.speed = scriptSpeed;
		this.entity = scriptedEntity;
		this.xBound = bounds.X;
		this.yBound = bounds.Y;
		this.loadScript(SCRIPT);
	}
	
	//Update variables
	int currentStep = 0, stepProgress = 0;
	float updatetemp1 = 0; //Used for delta movements
	int updatetemp2 = 0; //Used to determine direction
	int updatetemp3 = 0; //Used to determine range
	public void update(float delta)
	{
		if(currentStep > script.size)
			currentStep = 0;
		switch(script.get(currentStep))
		{
		case LEFT: moveLeft(delta);
		case RIGHT: moveRight(delta);
		case UP: moveUp(delta);
		case DOWN: moveDown(delta);
		case PAUSE: pause(delta);
		case LOOK_RANDOM: lookRandom(delta);
		case MOVE_RANDOM: moveRandom(delta);
		}
		
	}
	
	private void moveLeft(float delta)
	{
		
	}
	
	private void moveRight(float delta)
	{
		if(entity.direction != 3)
			entity.direction = 3;
		if(stepProgress < xBound*32)
		{
			updatetemp1 = speed * delta;
		}
	}
	
	private void moveUp(float delta)
	{
		
	}
	
	private void moveDown(float delta)
	{
		
	}
	
	private void pause(float delta)
	{
		
	}
	
	private void lookRandom(float delta)
	{
		
	}

	private void moveRandom(float delta)
	{
		
	}
	private void loadScript(String passedScript)
	{
		XMLReader xml = new XMLReader("assets/core/Scripts.xml", "Scripts");
		Element element = xml.getElement(passedScript);
		for(int i = 0; i < element.getChildCount(); i++)
		{
			switch(element.getChild(i).getText().toLowerCase())
			{
			case "left": script.add(Move.LEFT);
			case "right" : script.add(Move.RIGHT);
			case "up" : script.add(Move.UP);
			case "down" : script.add(Move.DOWN);
			case "pause" : script.add(Move.PAUSE);
			case "look_random" : script.add(Move.LOOK_RANDOM);
			case "move_random" : script.add(Move.MOVE_RANDOM);
			}
		}
	}
	
	public void changeScript(String passedScript)
	{
		this.script.clear();
		this.loadScript(passedScript);
	}

}
