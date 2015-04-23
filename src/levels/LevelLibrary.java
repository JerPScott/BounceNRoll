package levels;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;

public class LevelLibrary {
	/**
	 * This class defines the properties of the different levels
	 * 
	 **/
	LevelObject Level_1, Level_2, Level_3;
	
	// Level 1 objects
	GoalCoin GC_1;
	Platform Plat_1[] = new Platform[3];
	Coin Cn_1[] = new Coin[10];
	// Level 2 objects
	GoalCoin GC_2;
	Platform Plat_2[] = new Platform[4];
	Coin Cn_2[] = new Coin[8];
	// Level 3 objects
	GoalCoin GC_3;
	Platform Plat_3[] = new Platform[6];
	Coin Cn_3[] = new Coin[8];
			
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
		
		// Level three game objects
		GC_3 = new GoalCoin(700, 50);
		Plat_3[0] = new Platform(360, 520, 80, 160);
		Plat_3[1] = new Platform(260, 420, 80, 160);
		Plat_3[2] = new Platform(160, 320, 80, 160);
		Plat_3[3] = new Platform(260, 220, 80, 160);
		Plat_3[4] = new Platform(360, 120, 80, 160);
		Plat_3[5] = new Platform(460, 120, 80, 160);
		Cn_3[0] = new Coin(650, 100);
		Cn_3[1] = new Coin(520, 220);
		Cn_3[2] = new Coin(520, 320);
		Cn_3[3] = new Coin(520, 420);
		Cn_3[4] = new Coin(520, 520);
		Cn_3[5] = new Coin(520, 620);
		Cn_3[6] = new Coin(80, 100);
		Cn_3[7] = new Coin(110, 100);
		
		// pulling together levels
		Level_3 = new LevelObject(GC_3, Cn_3, Plat_3, null);
		Level_2 = new LevelObject(GC_2, Cn_2, Plat_2, Level_3);
		Level_1 = new LevelObject(GC_1, Cn_1, Plat_1, Level_2);
	}
	
	public LevelObject getLevel_1(){
		return Level_1;
	}
	
	public LevelObject getLevel_2(){
		return Level_2;
	}
	
	public LevelObject getLevel_3(){
		return Level_3;
	}
	
}
