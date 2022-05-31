package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.text.Position;

public class KeyHandler implements KeyListener, MouseListener, MouseMotionListener {
    public boolean GoUp, GoDown, GoLeft, GoRight; //JUST BASIC MECHANIC OF WASD. WE PLAY WITH BOOLEAN SO WE CAN SET IT TO BE TRUE/FALSE IF WE PRESS IT AND GO SEBALIKNYA IF WE RELEASE
    
    public static double pointerPosition_x;
    public static double pointerPosition_y;


    public boolean mouseClicked;
    public static boolean mousePressed;

    public boolean go_inside = false;

    public boolean light;

    public boolean chat;

    public boolean enter;

    public void clearMouseClick(){
        mouseClicked = false;
    }

    @Override
    public void keyTyped(KeyEvent e) { // Just like pygame(IMOpinion), this 2 function (key press and release) is the main function for the keyboard input. With this you can make double click, etc.
        // TODO Auto-generated method stub  //Keytype kinda so.. so..
        
    }

    @Override
    public void keyPressed(KeyEvent e) { 
        // TODO Auto-generated method stub
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            GoUp = true;
            go_inside = true;
        }

        
        if (code == KeyEvent.VK_S){
            GoDown = true;
        }
        
        if (code == KeyEvent.VK_A){
            GoLeft = true;
        }
        
        
        if (code == KeyEvent.VK_D){
            GoRight = true;
        }

        if (code == KeyEvent.VK_SPACE){
            go_inside = true;
            chat = true;
        }

        if (code == KeyEvent.VK_M){
            light = true;
        }

        if (code == KeyEvent.VK_ENTER){
            enter = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            GoUp = false;
        }

        
        if (code == KeyEvent.VK_S){
            GoDown = false;
        }
        
        if (code == KeyEvent.VK_A){
            GoLeft = false;
        }
        
        
        if (code == KeyEvent.VK_D){
            GoRight = false;
        }

        if (code == KeyEvent.VK_M){
            light = false;
        }

        if (code == KeyEvent.VK_SPACE){
            go_inside = false;
            chat = false;
        }

        if (code == KeyEvent.VK_ENTER){
            enter = false;
        }
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        pointerPosition_x = e.getPoint().getX();
        pointerPosition_y = e.getPoint().getY();
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        pointerPosition_x = e.getPoint().getX();
        pointerPosition_y = e.getPoint().getY();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub\
        mouseClicked = true;
        mousePressed = false;
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
