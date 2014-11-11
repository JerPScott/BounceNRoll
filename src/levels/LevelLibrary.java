package levels;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;

public class LevelLibrary {

	LevelObject Level_1, Level_2;
	
	GoalCoin GC_1;
	Platform Plat_1[] = new Platform[3];
	Coin Cn_1[] = new Coin[10];
	GoalCoin GC_2;
	Platform Plat_2[] = new Platform[3];
	Coin Cn_2[] = new Coin[5];
			
	public LevelLibrary(){
		// Level one
		GC_1 = new GoalCoin(700, 50);
		Plat_1[0] = new Platform(0, 0, 0, 0);
		Plat_1[1] = new Platform(0, 0, 0, 0);
		Plat_1[2] = new Platform(0, 0, 0, 0);
		Cn_1[0] = new Coin(0, 0);
		Cn_1[1] = new Coin(0, 0);
		Cn_1[2] = new Coin(0, 0);
		Cn_1[3] = new Coin(0, 0);
		Cn_1[4] = new Coin(0, 0);
		Cn_1[5] = new Coin(0, 0);
		Cn_1[6] = new Coin(0, 0);
		Cn_1[7] = new Coin(0, 0);
		Cn_1[8] = new Coin(0, 0);
		Cn_1[9] = new Coin(0, 0);
		
		//Level two
		GC_2 = new GoalCoin(700, 50);
		Plat_2[0] = new Platform(0, 0, 0, 0);
		Plat_2[1] = new Platform(0, 0, 0, 0);
		Plat_2[2] = new Platform(0, 0, 0, 0);
		Cn_2[0] = new Coin(0, 0);
		Cn_2[1] = new Coin(0, 0);
		Cn_2[2] = new Coin(0, 0);
		Cn_2[3] = new Coin(0, 0);
		Cn_2[4] = new Coin(0, 0);
	}
}
