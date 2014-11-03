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

public class Game extends Applet implements Runnable, KeyListener{
	
	// have an array of levels and encase the entire game loop in a for loop that cycles through the level array
	// the loop will move to the next level once GoalCoin is gotten
    
    private Image i;
    private Graphics doubleG;
    UserBall Ball;
    Platform plat[];
    GoalCoin GC;
    Coin Cn[]; // try out coin array
    
    
    @Override
    public void init() {
        setSize(800, 600);
        addKeyListener(this); // this is the key listener we are implementing
        
    }

    @Override
    public void start() {
    	Ball = new UserBall();
    	GC = new GoalCoin(300,200);
    	plat = new Platform[2];
    	plat[0] = new Platform();
    	plat[1] = new Platform(450, 250, 50, 200);
    	Cn = new Coin[3];
    	Cn[0] = new Coin(100,400);
    	Cn[1] = new Coin(50,400);
    	Cn[2] = new Coin(150,400);
        // thread takes a run method which in this case is specified by this 
        // (the run method implemented in the class)
        Thread thread = new Thread(this); 
        thread.start(); // starts thread
    }

    public void run() {
    	// thread info
        while(true){
        	Ball.update(this);
        	for (Platform P : plat){
        		P.update(Ball);
        	}
        	GC.update(Ball);
        	for (Coin coin : Cn){
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
    	for (Platform P : plat){
    		P.paint(g);
    	}
    	GC.paint(g);
    	for (Coin coin : Cn){
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
