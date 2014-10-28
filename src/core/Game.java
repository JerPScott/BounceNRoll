package core;

import gameObjects.GoalCoin;
import gameObjects.Platform;
import gameObjects.UserBall;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Applet implements Runnable, KeyListener{
    
    private Image i;
    private Graphics doubleG;
    UserBall Ball;
    Platform plat;
    GoalCoin GC;
    
    
    @Override
    public void init() {
        setSize(800, 600);
        addKeyListener(this); // this is the key listener we are implementing
        
    }

    @Override
    public void start() {
    	Ball = new UserBall();
    	plat = new Platform();
    	GC = new GoalCoin();
        // thread takes a run method which in this case is specified by this 
        // (the run method implemented in the class)
        Thread thread = new Thread(this); 
        thread.start(); // starts thread
    }

    public void run() {
    	// thread info
        while(true){
        	Ball.update(this);
        	plat.update(Ball);
        	GC.update(Ball);
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
    	plat.paint(g);
    	GC.paint(g);
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
