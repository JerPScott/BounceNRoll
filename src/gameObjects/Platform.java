package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
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
	
	private int height = 50;
	private int width = 200;
	private int Px = 400;
	private int Py = 500;
	
	public void Platform(){
		
	}
	
	public void update(UserBall b){
		if (b.getBounds().intersects(getBounds())){
			if (b.getPy() < Py){
				// ball is on top of platform
				System.out.println("top");
				b.setPy(Py-b.getRadius());
				b.setVy(-b.getVy());
			}else if (b.getPy() > Py+height){
				// ball is under platform
				System.out.println("bot");
				b.setPy(Py+b.getRadius());
				b.setVy(-b.getVy());
			}else if (b.getPx() < Px){
				// ball is to the left of the platform
				System.out.println("left");
				b.setPx(Px-b.getRadius());
				b.setVx(-b.getVx());
			}else if (b.getPx() > Px+width){
				//ball is to the right of the platform
				System.out.println("right");
				b.setPx(Px+b.getRadius());
				b.setVx(-b.getVx());
			}
		}
	}
	
	public void paint(Graphics g){
        g.setColor(Color.BLUE);
        // Paint a circle. Shifted so that paints with center at [x,y] instead 
        // of corner at that point.
        g.fillRect(Px, Py, width, height);
    }
	
	public Rectangle getBounds() {
		return new Rectangle((int)Px, (int)Py, width, height);
	}
	
}
