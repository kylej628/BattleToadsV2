package screens;

import utils.data.Justify;
import utils.selection.Button;
import applicationFiles.BattleToads;
import applicationFiles.DebuggableScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OptionsClass implements DebuggableScreen{
	
	BattleToads GAME;
	
	Button back;
	SpriteBatch batch;

	public OptionsClass(BattleToads GAME)
	{
		this.GAME = GAME;
		batch = new SpriteBatch();
		back = new Button("Back!", Gdx.graphics.getWidth()-20, 20, Justify.RIGHT_BOTTOM, 100, 50, true);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		back.render(batch);
		batch.end();
		update();
	}
	
	private void update()
	{
		if(back.isClicked())
			GAME.setScreen(GAME.menu);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		//System.out.println("This is the options Screen!");
	}

	@Override
	public void hide() {
		back.manualClickReset();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void debug() {
		// TODO Auto-generated method stub
		
	}

}
