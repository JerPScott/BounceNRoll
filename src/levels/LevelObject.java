package levels;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;

public class LevelObject {
	/**
	 * This is an object that serves as a form of node in the levels linked list
	 * 
	 **/
	
	GoalCoin GC;
	Coin Cn[];
	Platform Plat[];
	LevelObject NextLvl;
	LevelObject ThisLvl = this;
	
	public LevelObject(GoalCoin GoalC, Coin Coins[], Platform Platforms[], LevelObject NLvl){
		GC = GoalC;
		Cn = Coins;
		Plat = Platforms;
		NextLvl = NLvl;
	}
	
	public Platform[] getPlat(){
		return Plat;
	}
	
	public Coin[] getCoin(){
		return Cn;
	}
	
	public GoalCoin getGC(){
		return GC;
	}
	
	public LevelObject getNextLevel(){
		return NextLvl;
	}

}
