package points;

import gameObjects.UserBall;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerStatus {
	/**
	 * For now this class is not used. I plan on using it to implement a scoring system.
	 * The scoring system may also be put into the coins class.
	 * 
	 **/
	int Score;
	int timer;
	
	public PlayerStatus(){
		Score = 0;
		timer = 0;
	}
	
	public void GotCoin(){
		Score += 10;
	}
	
	public void GotGCoin(){
		Score += 100;
	}
	
	public void timePenalty(){
		Score -= 1;
	}
	
	public void update(){
		timer += 1;
		if (timer == 30){
			timePenalty();
			timer -= 30;
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.drawString("Score: " + Integer.toString(Score), 5, 20);
    }

}
