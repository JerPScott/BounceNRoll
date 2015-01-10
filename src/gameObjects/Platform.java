package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform {
	
	/**
	 * This is the first type of platform. It will shoot the ball up if the ball comes from underneath.
	 * Also this platform will cause the ball to bounce off of it if approached from above.
	 * 
	 **/
	
	private int height = 50;
	private int width = 200;
	private int Px = 400;
	private int Py = 400;
	private int BRad;
	private double BVy;
	private double BVx;
	private double BPx;
	private double BPy;
	
	public Platform(){
		
	}
	
	public Platform(int platXPos, int platYPos, int platHeight, int platWidth){
		height = platHeight;
		width = platWidth;
		Px = platXPos;
		Py = platYPos;
	}
	
	public void update(UserBall b){
		BPx = b.getPx();
		BPy = b.getPy();
		BVx = b.getVx();
		BVy = b.getVy();
		BRad = b.getRadius();
			if  ((BPy+BRad > Py) && (BPy+BRad < Py+BRad) && (BPx+(0.5)*BRad > Px) && (BPx-(0.5)*BRad < Px+width)){
				// ball is on top of platform
				BPy = Py-BRad;
				BVy = -60;
			}
		b.setPx(BPx);
		b.setPy(BPy);
		b.setVx(BVx);
		b.setVy(BVy);
	}
	
	public void paint(Graphics g){
        g.setColor(Color.BLUE);
        // Paint a circle. Shifted so that paints with center at [x,y] instead 
        // of corner at that point.
        g.fillRect(Px, Py, width, height);
    }
	
	public Rectangle getBounds() {
		return new Rectangle((int)Px, (int)Py, width-1, height-1);
	}
	
}
