package levels;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;

public class LevelTemplate {
	Coin Cn[];
	Platform Plat[];
	GoalCoin GC;
	
	public LevelTemplate(){
		GC = new GoalCoin(300,200);
    	Plat = new Platform[2];
    	Plat[0] = new Platform();
    	Plat[1] = new Platform(450, 250, 50, 200);
    	Cn = new Coin[3];
    	Cn[0] = new Coin(100,400);
    	Cn[1] = new Coin(50,400);
    	Cn[2] = new Coin(150,400);
	}
	
	public GoalCoin getGC(){
		return GC;
	}
	
	public Coin[] getCoin(){
		return Cn;
	}
	
	public Platform[] getPlat(){
		return Plat;
	}
}

