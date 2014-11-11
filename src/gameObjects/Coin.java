package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coin {
	/**
	 * Coins are for now just for show. They will disappear when the userball goes over them. Eventually
	 * they will be worth points.
	 * 
	 **/
	private int Px;
	private int Py;
	private int radius = 10;
	private boolean gotten = false;
	
	public Coin(int xPos, int yPos){
		Px = xPos;
		Py = yPos;
	}
	
	public void update(UserBall b){
		if (b.getBounds().intersects(getBounds())){
			gotten = true;
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		if (!gotten){
        	// Paint a circle. Shifted so that paints with center at [x,y] instead 
	        // of corner at that point.
	        g.fillOval(Px, Py, radius*2, radius*2);
        }
    }
	
	public Rectangle getBounds() {
		return new Rectangle((int)Px, (int)Py, radius*2, radius*2);
	}

}
