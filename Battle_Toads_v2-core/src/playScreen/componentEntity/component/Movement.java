package playScreen.componentEntity.component;

import playScreen.componentEntity.Entity;
import playScreen.entities.Component;
import utils.data.Script;

public class Movement implements Component
{
	//Variables -------//
	Script script;
	int x, y, speed, currentStep = 0, stepProgress = 0;
	Entity entity;
	
	/**
	 * Adds the ability for the entity to move.
	 * @param passedScript - give a certain form of movement to the entity
	 * @param xBound - restrict the script to a certain length in the x grid
	 * @param yBound - restrict the script to a certain length in the y grid
	 */
	public Movement(Entity passedEntity, Script passedScript, int speed, int xBound, int yBound)
	{
		this.entity = passedEntity;
		this.script = passedScript;
		this.x = xBound;
		this.y = yBound;
		this.speed = speed;
	}
	
	private void rectifyGrid()
	{
		entity.position.X = Math.round(entity.position.X/32) * 32;
		entity.position.Y = Math.round(entity.position.Y/32) * 32;
	}

	float updatetemp1 = 0;
	int updatetemp2 = 0; //used to determine direction
	int updatetemp3 = 0; //used to determine range
	@Override
	public void update(float delta)
	{
		if(entity.isInteracting()){
			switch(script)
			{
			case PATROL:{/*=====================================PATROL====================*/
				if(currentStep < 8)
				{
					switch(currentStep)
					{
					case 0:{ //Move right!
						if(entity.direction != 3)
							entity.direction = 3;
						if(stepProgress < x*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.X += updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 1:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					case 2:{ //Move up!
						if(entity.direction != 1)
							entity.direction = 1;
						if(stepProgress < y*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.Y += updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 3:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					case 4:{ //Move Left!
						if(entity.direction != 7)
							entity.direction = 7;
						if(stepProgress < x*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.X -= updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 5:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					case 6:{ //Move Down!
						if(entity.direction != 5)
							entity.direction = 5;
						if(stepProgress < y*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.Y -= updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 7:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					}
				}
				else
					currentStep = 0;
				break;
			}
			case CIRCLES:{/*=====================================CIRCLES===================*/
				if(currentStep < 4)
				{
					switch(currentStep)
					{
					case 0:{ //Move right!
						if(entity.direction != 3)
							entity.direction = 3;
						if(stepProgress < x*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.X += updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 1:{ //Move up!
						if(entity.direction != 1)
							entity.direction = 1;
						if(stepProgress < y*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.Y += updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 2:{ //Move Left!
						if(entity.direction != 7)
							entity.direction = 7;
						if(stepProgress < x*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.X -= updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 3:{ //Move Down!
						if(entity.direction != 5)
							entity.direction = 5;
						if(stepProgress < y*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.Y -= updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					}
				}
				else
					currentStep = 0;
			}
				break;
			case GUARD:{/*=======================================GUARD=====================*/
				if(currentStep < 2)
				{
					switch(currentStep)
					{
					case 0:{//Look Around!
						entity.direction = (int) Math.round(Math.random() * 7);
						currentStep++;
					}
					case 1:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					}
				}
				else
					currentStep = 0;
			}
				break;
			case HORIZONTAL:{/*=================================HORIZONTAL=================*/
				if(currentStep < 4)
				{
					switch(currentStep)
					{
					case 0:{ //Move right!
						if(entity.direction != 3)
							entity.direction = 3;
						if(stepProgress < x*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.X += updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 1:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					case 2:{ //Move Left!
						if(entity.direction != 7)
							entity.direction = 7;
						if(stepProgress < x*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.X -= updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 3:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					}
				}
				else
					currentStep = 0;
			}
				break;
			case RANDOM:{/*=====================================RANDOM=====================*/
				if(currentStep < 2)
				{
					switch(currentStep)
					{
					case 0:{
						updatetemp2 = (int) Math.round(Math.random() * 3); //0:Right, 1:Up, 2:Left, 3:Down
						switch(updatetemp2)
						{
						case 0:
						case 2: updatetemp3 = (int) Math.round(Math.random() * x);
						break;
						case 1:
						case 3: updatetemp3 = (int) Math.round(Math.random() * y);
						break;
						}
					}
					case 1:{
						switch(updatetemp2)
						{
						case 0:{ //Move right!
							if(entity.direction != 3)
								entity.direction = 3;
							if(stepProgress < updatetemp3*32)
							{
								updatetemp1 = speed * delta;
								stepProgress += updatetemp1;
								entity.position.X += updatetemp1;
							}
							else
							{
								currentStep++;
								stepProgress = 0;
								rectifyGrid();
							}
							break;
						}
						case 1:{ //Move up!
							if(entity.direction != 1)
								entity.direction = 1;
							if(stepProgress < updatetemp3*32)
							{
								updatetemp1 = speed * delta;
								stepProgress += updatetemp1;
								entity.position.Y += updatetemp1;
							}
							else
							{
								currentStep++;
								stepProgress = 0;
								rectifyGrid();
							}
							break;
						}
						case 2:{ //Move Left!
							if(entity.direction != 7)
								entity.direction = 7;
							if(stepProgress < updatetemp3*32)
							{
								updatetemp1 = speed * delta;
								stepProgress += updatetemp1;
								entity.position.X -= updatetemp1;
							}
							else
							{
								currentStep++;
								stepProgress = 0;
								rectifyGrid();
							}
							break;
						}
						case 3:{ //Move Down!
							if(entity.direction != 5)
								entity.direction = 5;
							if(stepProgress < updatetemp3*32)
							{
								updatetemp1 = speed * delta;
								stepProgress += updatetemp1;
								entity.position.Y -= updatetemp1;
							}
							else
							{
								currentStep++;
								stepProgress = 0;
								rectifyGrid();
							}
							break;
						}
						}
					}
					case 2:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					}
				}
				else
					currentStep = 0;
			}
				break;
			case VERTICAL:{/*====================================VERTICAL==================*/
				if(currentStep < 4)
				{
					switch(currentStep)
					{
					case 0:{ //Move up!
						if(entity.direction != 1)
							entity.direction = 1;
						if(stepProgress < y*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.Y += updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 1:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					case 2:{ //Move Down!
						if(entity.direction != 5)
							entity.direction = 5;
						if(stepProgress < y*32)
						{
							updatetemp1 = speed * delta;
							stepProgress += updatetemp1;
							entity.position.Y -= updatetemp1;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
							rectifyGrid();
						}
						break;
					}
					case 3:{ //Pause!
						if(stepProgress < 10*speed)
						{
							updatetemp1 += delta;
						}
						else
						{
							currentStep++;
							stepProgress = 0;
						}
						break;
					}
					}
				}
				else
					currentStep = 0;
			}
				break;
			default:
				break;
			}
		}
	}
}
