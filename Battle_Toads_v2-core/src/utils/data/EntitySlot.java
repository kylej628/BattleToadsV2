package utils.data;

public class EntitySlot
{
	private String TAG;
	private String objectId;
	
	public enum SlotType{
		ARMOR, WEAPON
	}
	
	/**
	 * non-visible data value holding a slot 'tag' and corresponding objectId
	 */
	public EntitySlot(SlotType type, String tag, String id)
	{
		TAG = tag;
		objectId = id;
	}
	
	public EntitySlot(SlotType type, String tag)
	{
		TAG = tag;
		objectId = "#0001";
	}
	
	public void setObjectId(String id)
	{
		this.objectId = id;
	}
	
	public String getObjectId()
	{
		return this.objectId;
	}
	
	public String getTag()
	{
		return this.TAG;
	}
}
