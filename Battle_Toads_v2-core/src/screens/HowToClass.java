package screens;

import utils.data.Justify;
import utils.msg.ConfirmationMsg;
import utils.selection.Button;
import applicationFiles.BattleToads;
import applicationFiles.DebuggableScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HowToClass implements DebuggableScreen{
	
	BattleToads GAME;
	Button back;
	SpriteBatch batch;
	
	ConfirmationMsg testMsg;
	
	public HowToClass(BattleToads GAME)
	{
		this.GAME = GAME;
		back = new Button("Back!", 700, 50, Justify.CENTER_CENTER, 100, 50, false);
		batch = new SpriteBatch();
		
		testMsg = new ConfirmationMsg("This is an error!", null, null, null, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, Justify.CENTER_CENTER, 20, 20, true, Color.GRAY);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		if(!testMsg.isVisable())
			back.render(batch);
		testMsg.render(batch);
		batch.end();
		if(back.wasClicked())
		{
			if(!testMsg.isVisable())
				testMsg.show();
			else
			{
				if(testMsg.Button_Affirmation.wasClicked())
					this.GAME.setScreen(GAME.menu);
				else if(testMsg.Button_Denial.wasClicked())
					{this.testMsg.hide(); back.manualClickReset();}
			}
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		//System.out.println("This is the How To Screen!");
	}

	@Override
	public void hide() {
		back.manualClickReset();
		testMsg.hide();
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
