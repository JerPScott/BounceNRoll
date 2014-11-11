package levels;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;

public class LevelObject {
	
	GoalCoin GC;
	Coin Cn[];
	Platform Plat[];
	LevelObject NextLvl;
	LevelObject ThisLvl = this;
	
	public LevelObject(GoalCoin GoalC, Coin Coins[], Platform Platforms[]){
		GC = GoalC;
		Cn = Coins;
		Plat = Platforms;
	}

}
