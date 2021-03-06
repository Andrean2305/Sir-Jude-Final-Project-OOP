package entity.tile;
import main.KeyHandler;

import main.GamePanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOError;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.entity;
import entity.player;

import java.awt.Color;
import java.awt.image.BufferedImage;

import java.util.Random;
public class floormanager extends entity {
    GamePanel gp;
    public floor[] floor;

    public static int tileXxincreament;
    public static int tileYyincreament;
    
    public static int[][] map = new int[][] {
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 5, 4, 4, 4, 5, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //26
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //25
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //24
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //23
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //22
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //21
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //20
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //19
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //18
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //17
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //16
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //15
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //14
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //13
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //12
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //11
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //10
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //9
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //8
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //7
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //6 
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 3, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //5 
        {5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, //4
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
        {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, //2
        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //3
        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //4
        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //5
        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //6
        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //7
        {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //8
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 0, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //9
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 0, 0, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //10
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 0, 0, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //11
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //12
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //13
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, //14
    }; //1//1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6
       //1                          9                         18                         27                         36            
       public static int main_map_Y = (map.length - 14) * 48;
       public static int main_map_X = (1) * 48; // 1 itu dari tempat yg ditambahken ke kiri


    public floormanager(GamePanel gp){
        this.gp = gp;

        floor = new floor[10];

        getfloorimage();
    }      
    public void getfloorimage(){
        
        try {
            floor[0] = new floor();
            floor[0].image = ImageIO.read(getClass().getResourceAsStream("tiles/wooden_Floor.png"));

            }catch(IOException e){
            e.printStackTrace();
        }   
    }

    public void draw(Graphics2D g2){

        if (player.dead == 1){
            player.walkingIncreamentX = 0;
            player.walkingIncreamentY = 0;
            
        }

        if (tilemanager.get_out == 1){
            player.walkingIncreamentX = 0;
            player.walkingIncreamentY = 0;
            player.direction = "idle";
            
        }

        if (player.chat == 1 || player.chat == 2){
            player.walkingIncreamentX = 0;
            player.walkingIncreamentY = 0;
            player.direction = "idle";
        }

        tileXxincreament += player.walkingIncreamentX;
        tileYyincreament += player.walkingIncreamentY;
        
        for (int i = 0; i < map.length; ++i){
            for(int j = 0; j < map[i].length; ++j){
                if (map[i][j] == 0){
                    g2.drawImage
                    (floor[0].image, //image of the block
                    gp.tileSize * (j) - tileXxincreament - main_map_X, //index x 
                    gp.tileSize* (i) - tileYyincreament - main_map_Y,  //index y
                    gp.tileSize, gp.tileSize, null);
                
            }
        }

    }
}
}
