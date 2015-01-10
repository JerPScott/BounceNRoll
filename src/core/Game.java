package core;

import gameObjects.Coin;
import gameObjects.GoalCoin;
import gameObjects.Platform;
import gameObjects.UserBall;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import levels.LevelLibrary;
import levels.LevelObject;

public class Game extends Applet implements Runnable, KeyListener{
	/**
	 * This is the main frame of the game. It controls the updating of the game objects,
	 * and what level the player is on. 
	 **/
    
    private Image i;
    private Graphics doubleG;
    UserBall Ball;
    LevelObject CurrentLvl;
    GoalCoin CurrentGC;
    LevelLibrary LvlLibrary;
    Platform Plat[];
    Coin Cn[];
    GoalCoin GC;
    
    
    @Override
    public void init() {
        setSize(800, 600);
        addKeyListener(this); // this is the key listener we are implementing
        
    }

    @Override
    public void start() {
    	LvlLibrary = new LevelLibrary();
    	Ball = new UserBall();
    	CurrentLvl = LvlLibrary.getLevel_1();
        // thread takes a run method which in this case is specified by this 
        // (the run method implemented in the class)
        Thread thread = new Thread(this); 
        thread.start(); // starts thread
    }

    public void run() {
    	// thread info
        while(true){
        	CurrentGC = CurrentLvl.getGC();
        	if (CurrentGC.getGotten() && (CurrentLvl.getNextLevel() != null)){
        		CurrentLvl = CurrentLvl.getNextLevel();
        		try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
        		Ball = new UserBall();
        	}
        	Ball.update(this);
        	for (Platform P : CurrentLvl.getPlat()){
        		P.update(Ball);
        	}
        	CurrentLvl.getGC().update(Ball);
        	for (Coin coin : CurrentLvl.getCoin()){
        		coin.update(Ball);
        	}
            repaint(); // goes through update() then calls paint()
            try {
                Thread.sleep(17);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void update(Graphics g) {
        // this sets up double buffer
        if(i == null){
            i = createImage(this.getSize().width, this.getSize().height);
            doubleG = i.getGraphics();
        }
        // gets the background color of the last frames graphic
        doubleG.setColor(getBackground());
        doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
        // gets the foreground color for the last frames graphic
        doubleG.setColor(getForeground());
        paint(doubleG);
        
        g.drawImage(i, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
    	//paint the game objects on the screen by calling their individual paint methods
    	Ball.paint(g);
    	for (Platform P : CurrentLvl.getPlat()){
    		P.paint(g);
    	}
    	CurrentLvl.getGC().paint(g);
    	for (Coin coin : CurrentLvl.getCoin()){
    		coin.paint(g);
    	}
    }

    public void keyTyped(KeyEvent arg0) {
    	// TODO Auto-generated method stub
    	
    }

    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case KeyEvent.VK_SPACE:
            	// call object methods that happen when key is pressed
            	Ball.jump(this);
                break;
            case KeyEvent.VK_LEFT:
            	// call object methods that happen when key is pressed
            	Ball.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
            	// call object methods that happen when key is pressed
            	Ball.moveRight();
                break;
            case KeyEvent.VK_DOWN:
            	// call object methods that happen when key is pressed
            	Ball.slow();
                break;
        }
    }

    public void keyReleased(KeyEvent ke) {
    }
    
}
