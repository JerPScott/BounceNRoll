package gameObjects;

import core.Game;

public class UserBall {
	private int radius = 15;
	private int mass = 5;
	private double Px = radius; // x position
	private double Py = radius; // y position
	private double Vx; // x velocity
	private double Vy; // y velocity
	private double Ax; // x acceleration
	private double Ay = -9.8; // y acceleration
	private double energyLoss = 0.8; // the ratio of velocity retained when bouncing
	
	public UserBall(){
		
	}
	
	UserBall(double xPos, double yPos, double g, double EL){
		Px = xPos;
		Py = yPos;
		Ay = g;
		energyLoss = EL;
	}
	
	public void moveRight(){
		if (Vx+1 < 10){
			Vx += 1;
		}
	}
	
	public void moveLeft(){
		if (Vx-1 > -10){
			Vx -= 1;
		}
	}
	
	public void update(Game G){
		if (Px + Vx > G.getWidth()-radius-1){
			// if the ball is hitting the right side of the screen, make it bounce off
			Px = G.getWidth()-radius-1;
			Vx = -Vx*energyLoss;
		}else if (Px+Vx < radius){
			Px = 0;
			Vx = -Vx;
		}else{
			if (Vx < 0.2){Vx = 0;}
			Px += Vx;
		}
	}

}
