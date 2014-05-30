package screens;

import utils.data.Justify;
import utils.selection.Button;
import utils.selection.lists.ItemAgent;
import utils.selection.lists.List;
import applicationFiles.BattleToads;
import applicationFiles.DebuggableScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameConfigureClass implements DebuggableScreen
{
	Button back, Map1, Map2;
	BattleToads GAME;
	SpriteBatch batch;
	
	List testList;
	ItemAgent[] agents;
	
	public GameConfigureClass(BattleToads game)
	{
		this.GAME = game;
		this.batch = new SpriteBatch();
		back = new Button("Back!", Gdx.graphics.getWidth() - 20, 20, Justify.RIGHT_BOTTOM, 100, 50, true);
		Map1 = new Button("Map #1!", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()/2 + 40, Justify.CENTER_BOTTOM, 200, 50, true);
		Map2 = new Button("Map #2!", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight()/2 - 40, Justify.CENTER_BOTTOM, 200, 50, true);
		
		agents = new ItemAgent[]{
				new ItemAgent("Name", "Map", false, Justify.LEFT_TOP), new ItemAgent("PlayerCount", "Players", true, Justify.RIGHT_BOTTOM)
		};
		//testList = new List(null, agents, new int[]{10, 10, 100, 400, 50}, "Maps");
	}

	@Override
	public void render(float delta)
	{
		batch.begin();
		back.render(batch);
		Map1.render(batch);
		Map2.render(batch);
		batch.end();
		if(back.isClicked())
			GAME.setScreen(GAME.menu);
		if(Map1.isClicked()){
			GAME.setScreen(GAME.play);}
		if(Map2.isClicked()){
			GAME.setScreen(GAME.play);}
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void show()
	{
		
	}

	@Override
	public void hide()
	{
		back.manualClickReset();
		Map1.manualClickReset();
		Map2.manualClickReset();
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}

	@Override
	public void dispose()
	{
		back.dispose();
		Map1.dispose();
		Map2.dispose();
		batch.dispose();
	}

	@Override
	public void debug() {
		// TODO Auto-generated method stub
		
	}

}
