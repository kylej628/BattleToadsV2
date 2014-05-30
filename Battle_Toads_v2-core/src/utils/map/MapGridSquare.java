package utils.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Matrix4;

/**
 * Square to be used with MapGrid.java
 * contains information about the TMX square
 * below. Will need the TMX map linked to it
 * in order to grab the information from it.
 * @author Kyle
 *
 */
public class MapGridSquare {
	
	private Cell TILE;
	private int xPos, yPos, size, ID;
	//Debugging - Will be removed
	ShapeRenderer renderer;
	
	
	public MapGridSquare(int xPos, int yPos, int size, Cell cell)
	{
		this.TILE = cell;
		if(cell != null)
			this.ID = TILE.getTile().getId();
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		//this.sb = batch;
		
		//Debugging - Will be removed
		renderer = new ShapeRenderer();
		renderer.setColor(0, 0, 1.0f, 1);
	}
	
	public void render(Matrix4 matrix)
	{
		//debugging rectangle
		renderer.setProjectionMatrix(matrix);
		renderer.begin(ShapeType.Line);
		renderer.rect(xPos, yPos, size, size);
		renderer.end();
	}
	
	public void dispose()
	{
		renderer.dispose();
	}

}
