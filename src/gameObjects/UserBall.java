package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import core.Game;

public class UserBall {
	private int radius = 15;
	private double dt = 0.2; // changing time
	private double Px = 0; // x position
	private double Py = 0; // y position
	private double Vx = 20; // x velocity
	private double Vy; // y velocity
	private double gravity = 10;
	private double energyLoss = 0.6; // the ratio of velocity retained when bouncing
	private double friction = 0.9;
	
	public UserBall(){
		
	}
	
	UserBall(double xPos, double yPos, double g, double EL, double F, double T){
		// initialize the specific physics for the calling level
		dt = T;
		Px = xPos;
		Py = yPos;
		gravity = g;
		energyLoss = EL;
		friction = F;
	}
	
	public void moveRight(){
		// arrow key response
		Vx = 3;
	}
	
	public void moveLeft(){
		// arrow key response
		Vx = -3;
	}
	
	public void slow(){
		// down arrow key response
		Vx *= 0.3;
	}
	
	public void jump(Game G){
		// space bar response
		// ball will jump if it is touching the ground, not on platforms
		if ((Math.abs(Vy) < 10) && (Py > G.getHeight()-2*radius)){
		Vy = 115;
		}
	}
	
	public void update(Game G){
		// updates the balls position in the level
		if (Px + Vx > G.getWidth()-radius-1){
			// if the ball is hitting the right side of the screen, make it bounce off
			Px = G.getWidth()-radius-1;
			Vx = -Vx*energyLoss;
		}else if (Px+Vx < radius){
			Px = radius;
			Vx = -Vx*energyLoss;
		}else{
			Px += Vx;
		}
		
		if (Py == G.getHeight()-radius-1){
			// if the ball is on the ground slow the ball
			Vx *= friction;
			if (Math.abs(Vx) < 0.2){
				// if the ball is moving slow enough stop the ball
				Vx = 0;
			} 
		}
		
		if(Py > G.getHeight()-radius-1){
            Py = G.getHeight()-radius-1;
            Vy *= energyLoss;
            Vy = -Vy;
        }else{
            // velocity formula
            Vy += gravity*dt;
            // position formula
            Py += Vy*dt + 0.5*gravity*dt*dt;
        }
		
	}
	
	public void paint(Graphics g){
        g.setColor(Color.GREEN);
        // Paint a circle. Shifted so that paints with center at [x,y] instead 
        // of corner at that point.
        int x = (int) Math.round(Px);
        int y = (int) Math.round(Py);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
    }
	
	public Rectangle getBounds() {
		return new Rectangle((int)Px, (int)Py, radius*2, radius*2);
	}
	
	public int getRadius(){
		return radius;
	}
	
	public double getPy(){
		return Py;
	}
	
	public double getPx(){
		return Px;
	}
	
	public void setPy(double newPy){
		Py = newPy;
	}
	
	public void setPx(double newPx){
		Px = newPx;
	}
	
	public double getVy(){
		return Vy;
	}
	
	public double getVx(){
		return Vx;
	}
	
	public void setVy(double newVy){
		Vy = newVy;
	}
	
	public void setVx(double newVx){
		Vx = newVx;
	}

}
