package levels;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;

public class LevelTemplate {
	Coin Cn[];
	Platform Plat[];
	GoalCoin GC;
	
	public GoalCoin getGC(){
		return this.GC;
	}
	
	public Coin[] getCoin(){
		return this.Cn;
	}
	
	public Platform[] getPlat(){
		return this.Plat;
	}
}

