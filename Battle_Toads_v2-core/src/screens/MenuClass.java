package screens;

import utils.data.Justify;
import utils.selection.Button;
import applicationFiles.BattleToads;
import applicationFiles.DebuggableScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuClass implements DebuggableScreen{
	
	//VARIABLES//
	BattleToads GAME;
	SpriteBatch sb;
	Button Button_Play;
	Button Button_Options;
	Button Button_Howtoplay;
	
	public MenuClass(BattleToads game)
	{
		this.GAME = game;
		this.LoadAssets();
	}

	@Override
	public void render(float delta) {
		//System.out.println("THis is a test");
		sb.begin();
		GAME.font.setColor(Color.RED);
		Button_Play.render(sb);
		Button_Options.render(sb);
		Button_Howtoplay.render(sb);
		sb.end();
		if(Button_Play.isClicked())
		{
			GAME.setScreen(GAME.play);
		}
		if(Button_Options.isClicked())
		{
			GAME.setScreen(GAME.options);
		}
		if(Button_Howtoplay.isClicked())
		{
			GAME.setScreen(GAME.howto);
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		GAME.limitFPS(30f);
		Button_Howtoplay.manualDisregard();
	}

	private void LoadAssets() 
	{
		sb  = new SpriteBatch();
		Button_Play = new Button("Play!", Gdx.graphics.getWidth()/2, 100, Justify.CENTER_CENTER, 400, 50, false);
		Button_Play.setCustomArt("menu/button_up.png", "menu/button_down.png", "menu/button_hover.png");
		Button_Play.setCustomFont(GAME.font);
		Button_Play.setHoverText("Lets Go!");
		Button_Options = new Button("Options!", Gdx.graphics.getWidth()/2, 160, Justify.CENTER_CENTER, 400, 50, false);
		Button_Options.setHoverText("Set this stuff up!");
		Button_Howtoplay = new Button("How to Play!", Gdx.graphics.getWidth()/2, 220, Justify.CENTER_CENTER, 400, 50, false);
		Button_Howtoplay.setHoverText("Learn young padawon!");
	}

	@Override
	public void hide() {
		Button_Play.manualClickReset();
		Button_Options.manualClickReset();
		Button_Howtoplay.manualClickReset();
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
		sb.begin();
		Button_Play.debug(sb);
		Button_Options.debug(sb);
		Button_Howtoplay.debug(sb);
		sb.end();
	}

}
