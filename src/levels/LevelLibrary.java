package levels;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;

public class LevelLibrary {
	/**
	 * This class defines the properties of the different levels
	 * 
	 **/
	LevelObject Level_1, Level_2;
	
	GoalCoin GC_1;
	Platform Plat_1[] = new Platform[3];
	Coin Cn_1[] = new Coin[10];
	GoalCoin GC_2;
	Platform Plat_2[] = new Platform[4];
	Coin Cn_2[] = new Coin[8];
			
	public LevelLibrary(){
		// Level one game objects
		GC_1 = new GoalCoin(700, 50);
		Plat_1[0] = new Platform(360, 520, 80, 160);
		Plat_1[1] = new Platform(400, 360, 80, 160);
		Plat_1[2] = new Platform(440, 200, 80, 160);
		Cn_1[0] = new Coin(120, 520);
		Cn_1[1] = new Coin(160, 520);
		Cn_1[2] = new Coin(200, 520);
		Cn_1[3] = new Coin(240, 520);
		Cn_1[4] = new Coin(120, 450);
		Cn_1[5] = new Coin(160, 450);
		Cn_1[6] = new Coin(200, 450);
		Cn_1[7] = new Coin(240, 450);
		Cn_1[8] = new Coin(280, 120);
		Cn_1[9] = new Coin(320, 120);
		
		//Level two games objects
		GC_2 = new GoalCoin(400, 50);
		Plat_2[0] = new Platform(160, 360, 80, 160);
		Plat_2[1] = new Platform(320, 240, 80, 160);
		Plat_2[2] = new Platform(480, 360, 80, 160);
		Plat_2[3] = new Platform(320, 480, 80, 160);
		Cn_2[0] = new Coin(320, 360);
		Cn_2[1] = new Coin(360, 360);
		Cn_2[2] = new Coin(400, 360);
		Cn_2[3] = new Coin(440, 360);
		Cn_2[4] = new Coin(320, 400);
		Cn_2[5] = new Coin(360, 400);
		Cn_2[6] = new Coin(400, 400);
		Cn_2[7] = new Coin(440, 400);
		
		// pulling together levels
		Level_2 = new LevelObject(GC_2, Cn_2, Plat_2, null);
		Level_1 = new LevelObject(GC_1, Cn_1, Plat_1, Level_2);
	}
	
	public LevelObject getLevel_1(){
		return Level_1;
	}
	
	public LevelObject getLevel_2(){
		return Level_2;
	}
	
}
