package playScreen.componentEntity;

import playScreen.entities.Component;
import utils.data.Coord;
import utils.data.EntitySlot;
import utils.data.EntitySlot.SlotType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Entity
{
	public enum comp{
		MOVEMENT, CONTROL
	}
	//Variables
	//*\Identifiers/*\\
	String ID, DisplayName;
	
	//*\Data/*\\
	public Coord position;
	Texture sprite;
	Texture animatedSprite;
	public int direction, originDirection;
	Array<EntitySlot> slots;
	public Array<Component> components;
	boolean isInteractable = true;
	boolean isInteracting = false;
	
	public Entity(String passedID, String passedName, Coord passedPosition, Texture passedSprite, Texture passedAnimation, int passedDirection)
	{
		ID = passedID;
		DisplayName = passedName;
		this.position.set(passedPosition);
		sprite = passedSprite;
		animatedSprite = passedAnimation;
		direction = passedDirection;
		originDirection = direction;
		slots = new Array<EntitySlot>();
		/*Since no slotTags were passed, defaults assumed*/
		slots.add(new EntitySlot(SlotType.ARMOR, "Head"));		//Head slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Chest"));		//Chest slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Arms"));		//Arms slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Legs"));		//Legs slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Feet"));		//Feet slot (armor)
		slots.add(new EntitySlot(SlotType.WEAPON, "Right"));	//Right hand slot (weapon)
		slots.add(new EntitySlot(SlotType.WEAPON, "Left:"));	//Left hand slot (weapon)
	}
	
	public Entity(String passedID, String passedName, Coord position, Texture passedSprite, Texture passedAnimation, int passedDirection, Array<EntitySlot> passedSlots)
	{
		ID = passedID;
		DisplayName = passedName;
		this.position.set(position);
		sprite = passedSprite;
		animatedSprite = passedAnimation;
		direction = passedDirection;
		slots = new Array<EntitySlot>(passedSlots);
	}
	
	public void update(float deltaTime)
	{
		for(int i = 0; i < components.size; i++)
		{
			components.get(i).update(deltaTime);
		}
	}
	
	public void render(SpriteBatch batch)
	{
		if(isInteracting)
			batch.draw(sprite, position.getX(), position.getY());
		else if(animatedSprite != null);
			//batch.draw(animatedSprite.getKeyFrame(Gdx.graphics.getDeltaTime()), position.getX(), position.getY());
	}
	
	public String getDisplayName()
	{
		return DisplayName;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void interact(int direction)
	{
		if(isInteractable){
			this.direction = direction;
			isInteracting = true;}
	}
	
	public void stopInteract()
	{
		if(isInteractable){
			this.direction = originDirection;
			this.isInteracting = false;}
	}
	
	public boolean isInteracting()
	{
		return isInteracting;
	}
	
}
