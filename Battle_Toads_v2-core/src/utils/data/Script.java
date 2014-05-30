package utils.data;

/**
 * <p>Script for the movement of the entity.</p>
 * Patrol - rectangle - stops at corners</br>
 * Guard - stationary but 'looks' around</br>
 * Circles - rectangle - continuous</br>
 * Random - what it sounds like</br>
 * Horizontal - Straight line horizontal</br>
 * Vertical - Straight line vertical</br>
 * @author Kyle
 */
public enum Script{
	PATROL, GUARD, CIRCLES, RANDOM,
	HORIZONTAL, VERTICAL
}
