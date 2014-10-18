package gameObjects;

import java.awt.Rectangle;

public class Platform {
	
	/* Consider implementing the Platforms as an iterable linkedlist 
	 * because then the ball can iterate through the list and 
	 * detect which if any platform it has collided with. It could
	 * then take the appropriate action.
	 * 
	 * For now I will only make one platform to get the collision
	 * and physics feeling correct.
	 */
	
	private int height;
	private int width;
	private double Px;
	private double Py;
	
	public Rectangle getBounds() {
		return new Rectangle((int)Px, (int)Py, width, height);
	}
	
}
