package main;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
// import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import entity.music;
import entity.player;
import entity.tile.floormanager;
import entity.tile.ghost;
import entity.tile.tile;
import entity.tile.tilemanager;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16; // The default tile size of every tile is 16
    final int scale = 3; //Scaling the pixel, so all of the character don't look really small

    public int tileSize = originalTileSize * scale; // it makes the origin of my game tile size is 48 ( 16 times 3)
    final int maxScreenCol = 36;
    final int maxScreenRow = 14;
    public int screenWidth = tileSize * maxScreenCol;
    public int screenHeight = tileSize * maxScreenRow;

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    public boolean song = false;

    public boolean music_one = false;


    int FPS = 60;

    floormanager floorM = new floormanager(this);

    tilemanager tileM = new tilemanager(this);

    ghost ghost = new ghost(this);
    
    KeyHandler keyH = new KeyHandler();

    public music music = new music();
    public music music1 = new music();
    public music once = new music();

    Thread gameThread; //to define the fps //it calls run method
    
    public player Player = new player(this, keyH);

    public colissionchecker cChecker = new colissionchecker(this);

    player player = new player(this, keyH);
    public Object tilemanager;
    public Object floormanager;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.addMouseListener(keyH);
        this.addMouseMotionListener(keyH);

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start(); //automaticcally call run method below |
//                                                                 v     
    }

    @Override
    // public void run() {
    //     double drawInterval = 1000000000/FPS;
    //     double nextDrawTime = System.nanoTime() + drawInterval;

    //     // TODO Auto-generated method stub

    //     // BTW TO DO THE RUN OVERRIDE YOU CAN SIMPLY JUST IMPORT UNIMPLEMENT METHOD// OR JUST SIMPLY TYPE IT EZPZ

    //     while (gameThread != null) { //To make a condition if the condition is not doing so it will keep looping
    //         // System.out.println("Testing Run");
            
    //         // long currentTime = System.nanoTime(); //1b nano = 1sec
    //         // long currentTime2 = System.currentTimeMillis(); //1k milli = 1sec

    //         update();
    //         repaint();

    //         try {
    //             double remainingTime = (nextDrawTime - System.nanoTime())/1000000;

    //             if(remainingTime < 0){
    //                 remainingTime = 0;
    //             }
    //             Thread.sleep((long)remainingTime);

    //             nextDrawTime += drawInterval;
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    //     }
    // }
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0; //declaring variable to display fps (for the potato pc owner)
        int drawCount = 0;

        while(gameThread != null){
            currentTime  = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;

            timer += (currentTime - lastTime);

            lastTime = currentTime; 
            
            if(delta >= 1){
                update();
                repaint();

                delta--;
                drawCount++;

            }
            
            if(timer >= 1000000000){
                // System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

           
        }
    }
 
    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        if (player.onschool == 1){
            if(song == false){
                song = true;
                music_one = true;
                stopMusic(music);
                playmusic(3,-15.0f,music);
                playmusic(4,-5.0f,music1);
            }

            floorM.draw(g2);

            ghost.draw(g2);

            tileM.draw(g2);
        }
        if(player.onhome == 1){
            if(song == false){
                song = true;
                playmusic(3,5.0f,music);
            }
            
        }
        player.draw(g2);
        keyH.clearMouseClick();

        g2.dispose();
    }

    public void playmusic(int i,float volume, music m){
        m.setFile(i);
        m.play(volume);
        m.loop();
    }

    public void playmusiconce(int i,float volume){
        once.setFile(i);
        once.play(volume);
    }

    public void stopMusic(music m){
        m.stop();
    }

}
