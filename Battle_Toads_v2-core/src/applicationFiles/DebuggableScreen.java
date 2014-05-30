package applicationFiles;

import com.badlogic.gdx.Screen;

public interface DebuggableScreen extends Screen {
	
	/** Called when the game has debugging toggled */
	public void debug ();

}
