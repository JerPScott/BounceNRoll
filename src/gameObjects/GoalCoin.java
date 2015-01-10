package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GoalCoin {
	/**
	 * This object serves as the win condition of the level and is similar to coins.
	 * 
	 **/
	private int Px;
	private int Py;
	private int radius = 10;
	private boolean gotten = false;
	
	public GoalCoin(int xPos, int yPos){
		Px = xPos;
		Py = yPos;
	}
	
	public void update(UserBall b){
		if (b.getBounds().intersects(getBounds())){
			gotten = true;
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		if (!gotten){
        	// Paint a circle. Shifted so that paints with center at [x,y] instead 
	        // of corner at that point.
	        g.fillOval(Px, Py, radius*2, radius*2);
        }else{
        	// level completed output to user
        	g.drawString("Level Complete!", 370, 200);
        }
    }
	
	public Rectangle getBounds() {
		return new Rectangle((int)Px, (int)Py, radius*2-1, radius*2-1);
	}
	
	public boolean getGotten(){
		return gotten;
	}
	
}
