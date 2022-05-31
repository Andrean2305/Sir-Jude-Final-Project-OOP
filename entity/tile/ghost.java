package entity.tile;

import main.KeyHandler;

import main.GamePanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;

import javax.imageio.ImageIO;

import entity.entity;
import entity.music;
import entity.player;

import java.awt.Color;
import java.awt.image.BufferedImage;

import java.awt.Rectangle;
import java.util.Random;

public class ghost extends entity {
    GamePanel gp;

    public tile[] tiles;
    public int ghost_x;
    public int ghost_y;

    public static int ghost_param = 0;

    public String arah = "right";
    public static int total_x ;
    public static int total_y ;

    public int penambahanX;
    public int penambahanY;

    public int animasi_hantu = 0;
    public int spritenum_hantu = 0;

    public int ghost_para = 1;

    public static int ghost_touch = 0;
    Random rand = new Random();

    public static String[] random_path = new String[] {"up","down","left","right"}; 

    public boolean sudahdigambar = false;

    public ghost(GamePanel gp){
        this.gp = gp;
        tiles = new tile[20];
        getghostimage();
    }
    
    public void getghostimage(){
        try { 
            tiles[0] = new tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("tiles/Hantu1s.png"));
          
            tiles[1] = new tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("tiles/Hantu2s.png"));
            
            tiles[2] = new tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("tiles/Hantu3s.png"));
            
            tiles[3] = new tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("tiles/Hantu4s.png"));

            tiles[4] = new tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("tiles/hantu1lefts.png"));
        
            tiles[5] = new tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("tiles/hantu2lefts.png"));
            
            tiles[6] = new tile();
            tiles[6].image = ImageIO.read(getClass().getResourceAsStream("tiles/hantu3lefts.png"));
            
            tiles[7] = new tile();
            tiles[7].image = ImageIO.read(getClass().getResourceAsStream("tiles/hantu4lefts.png"));


        }catch(IOException e){
            e.printStackTrace();
        }
    }



    public void pathfinding(){
        switch(arah) {
            case "up" :
                penambahanY = -2;
                penambahanX = 0;
            break;
            case "down":
                penambahanY = 2;
                penambahanX = 0;
            break;
            case "left":
                penambahanX = -2;
                penambahanY = 0;
                
                break;
            case "right":
                penambahanX = 2;
                penambahanY = 0;
                break;
            
        }   
    
    }

    public void draw(Graphics2D g2){
        total_x = ghost_x - tilemanager.tileXincreament;
        total_y = ghost_y - tilemanager.tileYincreament;

        for (int i = 0; i < tilemanager.map.length; ++i){
            for(int j = 0; j < tilemanager.map[i].length; ++j){
                if(tilemanager.map[i][j] == 0  && ghost_para == rand.nextInt(10000) && ghost_param == 0){
                    ghost_param = 1;
                    
                    ghost_x = gp.tileSize * (j) - tilemanager.main_map_X;
                    ghost_y = gp.tileSize * (i) - tilemanager.main_map_Y;

                    sudahdigambar = true;
                }
            }
        }
        if ( sudahdigambar = true){
            // System.out.println("TEMPAT HANTU_x = " + (total_x ) );
            // System.out.println("TEMPAT PLAYER_x = " + (player.screenX + 8));
            // System.out.println("OBJEKTIF_x= " + (player.screenX + 8 - total_x ));
            // System.out.println("TEMPAT HANTU_Y = "  + (total_y ));
            // System.out.println("TEMPAT PLAYER_Y = "  + (player.screenY + 8));
            // System.out.println("OBJEKTIF_Y = "  + (player.screenY - total_y + 8));

            animasi_hantu++;
            if(animasi_hantu > 20){
                spritenum_hantu += 1;
                if (spritenum_hantu == 4){
                    spritenum_hantu = 1;
                }
                animasi_hantu= 0;
            }

            if(arah.equals("right")){
                if(spritenum_hantu == 1){
                    g2.drawImage(tiles[0].image, 
                    total_x, 
                    total_y, 
                    gp.tileSize,
                    gp.tileSize,
                    null);
                }if(spritenum_hantu == 2){
                    g2.drawImage(tiles[1].image, 
                    total_x, 
                    total_y, 
                    gp.tileSize,
                    gp.tileSize,
                    null);
                }if(spritenum_hantu == 3){
                    g2.drawImage(tiles[2].image, 
                    total_x, 
                    total_y, 
                    gp.tileSize,
                    gp.tileSize,
                    null);
                }if(spritenum_hantu == 4){
                    g2.drawImage(tiles[3].image, 
                    total_x, 
                    total_y, 
                    gp.tileSize,
                    gp.tileSize,
                    null);
                }}else if (arah.equals("left")){
                    if(spritenum_hantu == 1){
                        g2.drawImage(tiles[4].image, 
                        total_x, 
                        total_y, 
                        gp.tileSize,
                        gp.tileSize,
                        null);
                    }if(spritenum_hantu == 2){
                        g2.drawImage(tiles[5].image, 
                        total_x, 
                        total_y, 
                        gp.tileSize,
                        gp.tileSize,
                        null);
                    }if(spritenum_hantu == 3){
                        g2.drawImage(tiles[6].image, 
                        total_x, 
                        total_y, 
                        gp.tileSize,
                        gp.tileSize,
                        null);
                    }if(spritenum_hantu == 4){
                        g2.drawImage(tiles[7].image, 
                        total_x, 
                        total_y, 
                        gp.tileSize,
                        gp.tileSize,
                        null);
                    }
                }

            
            if(((player.screenX + 8 - total_x ) <= 176 ) && (player.screenX + 8 - total_x) >= 20 && ((player.screenY + 8 - total_y <= 132)) && ((player.screenY + 8 - total_y) >= -132)){
                ghost_x += 1;
                arah = "right";
            }
            if((-(player.screenX + 8 - total_x ) >= 20) && (-(player.screenX + 8 - total_x ) <= 176) && ((player.screenY + 8 - total_y <= 132)) && ((player.screenY + 8 - total_y) >= -132)){
                ghost_x -= 1;
                arah = "left";
            }if(((player.screenY + 8 - total_y ) <= 150 ) && (player.screenY + 8 - total_y) >= 20 && ((player.screenX + 8 - total_x <= 132)) && ((player.screenX + 8 - total_x) >= -132)){
                ghost_y += 1;

            }if((-(player.screenY + 8 - total_y ) >= 20 )  &&  (-(player.screenY + 8 - total_y ) <= 176 )  && ((player.screenX + 8 - total_x <= 132)) && ((player.screenX + 8 - total_x) >= -132)){
                ghost_y -= 1;

            }if (((player.screenX + 8 - total_x <= 32)) && ((player.screenX + 8 - total_x) >= -32) && ((player.screenY + 8 - total_y <= 32)) && ((player.screenY + 8 - total_y) >= -32) && ghost_touch == 0){
                player.dead = 1;
                ghost_touch = 1;
                gp.playmusiconce(1,0.0f);
            }
    }
    }


}
