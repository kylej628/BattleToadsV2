package utils.map;

import utils.data.Property;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Matrix4;

public class MapGrid{
	
	//Variables
	MapGridSquare[][] squares;
	private int WIDTH, HEIGHT, TILE_SIZE;
	TiledMapTileLayer mapLayer;
	
	public MapGrid()
	{
		System.out.println("MapGrid has been created");
		
	}
	
	public void load(MapWrapper map)
	{
		WIDTH = Integer.parseInt(map.getProperty(Property.WIDTH));
		HEIGHT = Integer.parseInt(map.getProperty(Property.HEIGHT));
		TILE_SIZE = Integer.parseInt(map.getProperty(Property.TILE_SIZE));
		mapLayer = (TiledMapTileLayer) map.tiledMap.getLayers().get(0);
		squares = new MapGridSquare[WIDTH][HEIGHT];
		for(int i = 0; i < WIDTH; i++)
		{
			for(int j = 0; j < HEIGHT; j++)
			{
				squares[i][j] = new MapGridSquare(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, mapLayer.getCell(i, j));
			}
		}
		
	}
	
	public void render(Matrix4 matrix)
	{
		for(int i = 0; i < WIDTH; i++)
		{
			for(int j = 0; j < HEIGHT; j++)
			{
				squares[i][j].render(matrix);
			}
		}
	}
}