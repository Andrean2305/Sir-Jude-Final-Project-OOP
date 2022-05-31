package entity;

import main.KeyHandler;

import main.GamePanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;

import javax.imageio.ImageIO;

import entity.tile.floor;
import entity.tile.floormanager;
import entity.tile.ghost;
import entity.tile.tile;
import entity.tile.tilemanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public class player extends entity {
    GamePanel gp;
    Graphics2D g2;
    KeyHandler keyH;

    public static int light = 0;

    public static int onhome = 1;
    public int x_home = 0;
    public int home_x = 0;

    public static int onschool = 0;

    public static int screenX;
    public static int screenY;

    public static int walkingIncreamentX;
    public static int walkingIncreamentY;

    public static int dead = 0;

    public static int chat = 0;

    public boolean chat_press = true;

    public static int coin_upgrade = 0;
    public double coin_upgrade_cost = 1;

    public static int speed_upgrade = 7;
    public int speed_upgrade_cost = 125;

    public boolean speed_confirmation_tab = false;
    public boolean coin_confirmation_tab = false;

    public boolean no_money_now = false; 

    public boolean max_money = false;

    public static tile[] rain;

    public player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (5*gp.tileSize);
        screenY = gp.screenHeight/2 - 48;

        solidArea = new Rectangle();
        solidArea.x = screenX + 21;
        solidArea.y = screenY + 28;
        solidArea.width = gp.tileSize - 28;
        solidArea.height = gp.tileSize - 25;
        
        walkingIncreamentX = 0;
        walkingIncreamentY = 0;

        setDefaultValues();
        getplayeranimationinhome();
    }

    public void upgradingspeed(){
        speed_upgrade += 1;
        speed += 1;
        coin_money -= speed_upgrade_cost;
        speed_upgrade_cost = speed_upgrade_cost * 25 + 1580;
    }

    public void upgradingcoin(){
        coin_money -= coin_upgrade_cost;
        coin_upgrade_cost = coin_upgrade_cost - (coin_upgrade)*10;
        coin_upgrade += 1;
        coin_upgrade_cost = coin_upgrade_cost*1.1 + coin_upgrade * 10;
    }

    public void setDefaultValues() {
        worldX = 16*16*2 + 4;
        worldY = 12*16*3;
        speed = 2;
        direction = "left";
    }

    public void getplayeranimationinhome(){
        try{    

            right1 = ImageIO.read(getClass().getResourceAsStream("player1/right_1.png")); //I AM SO SORRY FOR THIS
            right2 = ImageIO.read(getClass().getResourceAsStream("player1/right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("player1/right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("player1/right_4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("player1/right_5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("player1/right_6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("player1/right_7.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("player1/right_8.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("player1/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("player1/left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("player1/left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("player1/left_4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("player1/left_5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("player1/left_6.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("player1/left_7.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("player1/left_8.png"));

            up1 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg6.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg7.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_blkg8.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan6.png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan7.png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("player1/karakter_depan8.png"));

            idle1 = ImageIO.read(getClass().getResourceAsStream("player1/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("player1/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("player1/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("player1/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("player1/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("player1/idle_6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("player1/idle_7.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("player1/idle_8.png"));

            
            idles1 = ImageIO.read(getClass().getResourceAsStream("player1/idles_1.png"));
            idles2 = ImageIO.read(getClass().getResourceAsStream("player1/idles_2.png"));
            idles3 = ImageIO.read(getClass().getResourceAsStream("player1/idles_3.png"));
            idles4 = ImageIO.read(getClass().getResourceAsStream("player1/idles_4.png"));
            idles5 = ImageIO.read(getClass().getResourceAsStream("player1/idles_5.png"));
            idles6 = ImageIO.read(getClass().getResourceAsStream("player1/idles_6.png"));
            idles7 = ImageIO.read(getClass().getResourceAsStream("player1/idles_7.png"));
            idles8 = ImageIO.read(getClass().getResourceAsStream("player1/idles_8.png"));

            die1 = ImageIO.read(getClass().getResourceAsStream("player1/DIE.png"));
            die2 = ImageIO.read(getClass().getResourceAsStream("player1/DIE_HOVER_RESPAWN.png"));

            homescreen = ImageIO.read(getClass().getResourceAsStream("player1/homemenu2.png"));

            shadow = ImageIO.read(getClass().getResourceAsStream("player1/shadow.png"));

            upgradecoin1 = ImageIO.read(getClass().getResourceAsStream("player1/coin_upgrade.png"));
            upgradecoin2 = ImageIO.read(getClass().getResourceAsStream("player1/coin_upgrade_hover.png"));
            
            upgradespeed1 = ImageIO.read(getClass().getResourceAsStream("player1/speed_upgrade.png"));
            upgradespeed2= ImageIO.read(getClass().getResourceAsStream("player1/speed_upgrade_hover.png"));

            confirmCoin1 = ImageIO.read(getClass().getResourceAsStream("player1/confirmation_gold.png"));
            confirmCoin2 = ImageIO.read(getClass().getResourceAsStream("player1/confirmation_gold_x.png"));
            confirmCoin3 = ImageIO.read(getClass().getResourceAsStream("player1/confirmation_gold_yes.png"));

            confirmSpeed1 = ImageIO.read(getClass().getResourceAsStream("player1/confirmation_speed.png"));
            confirmSpeed2 = ImageIO.read(getClass().getResourceAsStream("player1/confirmation_speed_x.png"));
            confirmSpeed3 = ImageIO.read(getClass().getResourceAsStream("player1/confirmation_speed_y.png"));

            no_money = ImageIO.read(getClass().getResourceAsStream("player1/no_money.png"));

            max_speed = ImageIO.read(getClass().getResourceAsStream("player1/max_speed.png"));

            rain1 = ImageIO.read(getClass().getResourceAsStream("player1/rain1.png"));
            rain2 = ImageIO.read(getClass().getResourceAsStream("player1/rain2.png"));
            rain3 = ImageIO.read(getClass().getResourceAsStream("player1/rain3.png"));
            rain4 = ImageIO.read(getClass().getResourceAsStream("player1/rain4.png"));
            rain = new tile[4];
            rain[0] = new tile();rain[0].image = rain1;
            rain[1] = new tile();rain[1].image = rain2;
            rain[2] = new tile();rain[2].image = rain3;
            rain[3] = new tile();rain[3].image = rain4;

            door1 = tilemanager.tile[34].image;



        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.GoUp == true && keyH.GoDown == false && onschool == 1){ //Movement update
            direction = "up";
            
        }else if(keyH.GoDown == true && keyH.GoUp == false && onschool == 1) {
            direction = "down";
            
        }else if(keyH.GoLeft == true ){//&& keyH.GoRight == false){
            direction = "left";
            x_home = -2;
            
        }else if(keyH.GoRight == true ){//&& keyH.GoLeft == false){
            direction = "right";
            x_home = 2;
            
        }else if(keyH.GoDown == false && keyH.GoUp == false && keyH.GoLeft == false && keyH.GoRight == false && (direction.equals("right"))){
            direction = "idle";
        }else if (keyH.GoDown == false && keyH.GoUp == false && keyH.GoLeft == false && keyH.GoRight == false && (direction.equals("left"))){
            direction = "idles";  
        }else if (keyH.GoDown == false && keyH.GoUp == false && keyH.GoLeft == false && keyH.GoRight == false && (direction.equals("up"))){
            direction = "idle";  
        }else if (keyH.GoDown == false && keyH.GoUp == false && keyH.GoLeft == false && keyH.GoRight == false && (direction.equals("down"))){
            direction = "idle";  
        }else if (keyH.GoLeft == false && keyH.GoRight == false){
            x_home = 0;
        }

        spriteCounter ++; 
        spriteCounter_rain ++; 
            if(spriteCounter > 7){
                spriteNum += 1;
                if (spriteNum == 8){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

            if(spriteCounter_rain > 5){
                spriteNum_rain += 1;
                if (spriteNum_rain == 4){
                    spriteNum_rain = 1;
                }
                spriteCounter_rain = 0;
            }

        if (onschool == 1){
            if (keyH.pointerPosition_x > 509 && keyH.pointerPosition_x < 805 && keyH.pointerPosition_y > 417 && keyH.pointerPosition_y < 513 && keyH.mouseClicked && dead == 1){
                home_x = 0;
                dead = 0;

                tilemanager.tileXincreament = 0;
                tilemanager.tileYincreament = 0;
                tilemanager.belumngocok = 0;
                tilemanager.map[tilemanager.coin_y][tilemanager.coin_x] = 0;

                floormanager.tileYyincreament = 0;
                floormanager.tileXxincreament = 0 ;
                
                ghost.total_x = 0;
                ghost.total_y = 0;
                ghost.ghost_touch = 0;
                ghost.ghost_param = 0;

                onschool = 0;
                onhome = 1;
                coin_money += (int)tilemanager.coin/2;
                tilemanager.coin = 0;
                System.out.println(coin_money);
                gp.playmusiconce(5, -5.0f);
                gp.song = false;
                gp.stopMusic(gp.music);
                gp.stopMusic(gp.music1);
            }

            if(tilemanager.get_out == 1 && keyH.mouseClicked == true && keyH.pointerPosition_x > 426 && keyH.pointerPosition_x < 491 && keyH.pointerPosition_y > 140 && keyH.pointerPosition_y < 201){
                gp.playmusiconce(5, -5.0f);
                tilemanager.tileYincreament -= 100;
                floormanager.tileYyincreament -= 100;

            }

            if (tilemanager.tileXincreament >= -68 && tilemanager.tileXincreament <= 56 && tilemanager.tileYincreament >= 160 && tilemanager.tileYincreament <= 308 && keyH.pointerPosition_x > 560 && keyH.pointerPosition_x < 743 && keyH.pointerPosition_y > 355 && keyH.pointerPosition_y < 415 && keyH.mouseClicked){
                home_x = 0;
                dead = 0;
                tilemanager.get_out = 0;

                tilemanager.tileXincreament = 0;
                tilemanager.tileYincreament = 0;
                tilemanager.belumngocok = 0;
                tilemanager.map[tilemanager.coin_y][tilemanager.coin_x] = 0;

                floormanager.tileYyincreament = 0;
                floormanager.tileXxincreament = 0 ;

                ghost.total_x = 0;
                ghost.total_y = 0;
                ghost.ghost_touch = 0;
                ghost.ghost_param = 0;

                onschool = 0;
                onhome = 1;
                coin_money += tilemanager.coin;
                tilemanager.coin = 0;
                System.out.println(coin_money);
                gp.playmusiconce(5, -5.0f);
                gp.song = false;
                gp.stopMusic(gp.music);
                gp.stopMusic(gp.music1);
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            if(collisionOn == false){
                switch(direction) {
                    case "up":
                        walkingIncreamentY = -speed_upgrade + 5;
                        walkingIncreamentX = 0;
                        break;
                    case "down":
                        walkingIncreamentY = speed_upgrade - 5;
                        walkingIncreamentX = 0;
                    
                        break;
                    case "left":
                        walkingIncreamentX = -speed_upgrade + 5;
                        walkingIncreamentY = 0;
                        
                        break;
                    case "right":
                        walkingIncreamentX = speed_upgrade - 5;
                        walkingIncreamentY = 0;
                        break;
                    case "idle":
                        walkingIncreamentX = 0;
                        walkingIncreamentY = 0;
                    case "idles":
                        walkingIncreamentX = 0;
                        walkingIncreamentY = 0;
                    
                }   
            }

            if(collisionOn == true){
                switch(direction) {
                    case "up":
                        walkingIncreamentY = 0;
                        break;
                    case "down":
                        walkingIncreamentY = 0;
                    
                        break;
                    case "left":
                        walkingIncreamentX = 0;
                        
                        break;
                    case "right":
                        walkingIncreamentX = 0;
                        
                        break;
                    
                }   
            }

            if (direction.equals("left") || direction.equals("right")){
                walkingIncreamentY = 0;
            }
            if (direction.equals("up" )|| direction.equals("down")){
                walkingIncreamentX = 0;
            }

        }

        
    }

    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        

        switch(direction){
            case "right":
                if (spriteNum == 1){ //I AM SO SORRY FOR THIS// DONT GIVE ME LOW POINT PLS
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                if (spriteNum == 4){
                    image = right4;
                }
                if (spriteNum == 5){
                    image = right5;
                }
                if (spriteNum == 6){
                    image = right6;
                }
                if (spriteNum == 7){
                    image = right7;
                }
                if (spriteNum == 8){
                    image = right8;
                }

                break;
            case "left":
            if (spriteNum == 1){ //I AM SO SORRY FOR THIS// DONT GIVE ME LOW POINT PLS
                image = left1;
            }
            if (spriteNum == 2){
                image = left2;
            }
            if (spriteNum == 3){
                image = left3;
            }
            if (spriteNum == 4){
                image = left4;
            }
            if (spriteNum == 5){
                image = left5;
            }
            if (spriteNum == 6){
                image = left6;
            }
            if (spriteNum == 7){
                image = left7;
            }
            if (spriteNum == 8){
                image = left8;
            }
                break;
            case "idle":
            if (spriteNum == 1){ //I AM SO SORRY FOR THIS// DONT GIVE ME LOW POINT PLS
                image = idle1;
            }
            if (spriteNum == 2){
                image = idle2;
            }
            if (spriteNum == 3){
                image = idle3;
            }
            if (spriteNum == 4){
                image = idle4;
            }
            if (spriteNum == 5){
                image = idle5;
            }
            if (spriteNum == 6){
                image = idle6;
            }
            if (spriteNum == 7){
                image = idle7;
            }
            if (spriteNum == 8){
                image = idle8;
            }
            break;
            case "idles":
            if (spriteNum == 1){ //I AM SO SORRY FOR THIS// DONT GIVE ME LOW POINT PLS
                image = idles1;
            }
            if (spriteNum == 2){
                image = idles2;
            }
            if (spriteNum == 3){
                image = idles3;
            }
            if (spriteNum == 4){
                image = idles4;
            }
            if (spriteNum == 5){
                image = idles5;
            }
            if (spriteNum == 6){
                image = idles6;
            }
            if (spriteNum == 7){
                image = idles7;
            }
            if (spriteNum == 8){
                image = idles8;
            }
                break;
            case "up":
            if (spriteNum == 1 && onschool == 1){ //I AM SO SORRY FOR THIS// DONT GIVE ME LOW POINT PLS
                image = up1;
            }
            if (spriteNum == 2 && onschool == 1){
                image = up2;
            }
            if (spriteNum == 3 && onschool == 1){
                image = up3;
            }
            if (spriteNum == 4 && onschool == 1){
                image = up4;
            }
            if (spriteNum == 5 && onschool == 1){
                image = up5;
            }
            if (spriteNum == 6 && onschool == 1){
                image = up6;
            }
            if (spriteNum == 7 && onschool == 1){
                image = up7;
            }
            if (spriteNum == 8 && onschool == 1){
                image = up8;
            }
                break;
            case "down":
            if (spriteNum == 1 && onschool == 1){ //I AM SO SORRY FOR THIS// DONT GIVE ME LOW POINT PLS
                image = down1;
            }
            if (spriteNum == 2 && onschool == 1){
                image = down2;
            }
            if (spriteNum == 3 && onschool == 1){
                image = down3;
            }
            if (spriteNum == 4 && onschool == 1){
                image = down4;
            }
            if (spriteNum == 5 && onschool == 1){
                image = down5;
            }
            if (spriteNum == 6 && onschool == 1){
                image = down6;
            }
            if (spriteNum == 7 && onschool == 1){
                image = down7;
            }
            if (spriteNum == 8 && onschool == 1){
                image = down8;
            }
                break;
        }
            if(onschool == 1){
            // System.out.println(dead);
                g2.drawImage(image, screenX , screenY, gp.tileSize + 8, gp.tileSize + 8, null);
                g2.draw(solidArea);
                g2.drawImage(door1,384 - tilemanager.tileXincreament - tilemanager.main_map_X, 1248 - tilemanager.tileYincreament - tilemanager.main_map_Y, gp.tileSize, gp.tileSize, null);

                if(tilemanager.tileYincreament >= -436 && tilemanager.tileYincreament < -316){
                g2.drawImage
                (tilemanager.tile[29].image, //image of the block
                601 - tilemanager.tileXincreament, //index x 
                -100 - tilemanager.tileYincreament,  //index y
                gp.tileSize + 47, gp.tileSize + 47, null);
                }

                // System.out.println("YINCRE = " + tilemanager.tileYincreament);
                // System.out.println("XINCRE = " + tilemanager.tileXincreament);

                if (keyH.light == false){
                g2.drawImage(shadow, -10, 0, 1728,672,null);
                }
                if (dead == 1 && keyH.pointerPosition_x > 509 && keyH.pointerPosition_x < 805 && keyH.pointerPosition_y > 417 && keyH.pointerPosition_y < 513 && keyH.mousePressed){
                    g2.drawImage(die1, 400,50, 500, 500,null);
                }
                else if (dead == 1 && keyH.pointerPosition_x > 509 && keyH.pointerPosition_x < 805 && keyH.pointerPosition_y > 417 && keyH.pointerPosition_y < 513 ){
                    g2.drawImage(die2, 400,50, 500, 500,null);
                }
                else if (dead == 1){
                    g2.drawImage(die1, 400,50, 500, 500,null);
                    
                }

                if (tilemanager.tileXincreament >= -68 && tilemanager.tileXincreament <= 56 && tilemanager.tileYincreament >= 160 && tilemanager.tileYincreament <= 208 && keyH.pointerPosition_x > 426 && keyH.pointerPosition_x < 491 && keyH.pointerPosition_y > 140 && keyH.pointerPosition_y < 201 && keyH.mousePressed){
                    g2.drawImage(tilemanager.tile[127].image, 400,50, 500, 500,null);
                }
                else if (tilemanager.tileXincreament >= -68 && tilemanager.tileXincreament <= 56 && tilemanager.tileYincreament >= 160 && tilemanager.tileYincreament <= 308 && keyH.pointerPosition_x > 560 && keyH.pointerPosition_x < 743 && keyH.pointerPosition_y > 355 && keyH.pointerPosition_y < 415 && keyH.mousePressed){
                    g2.drawImage(tilemanager.tile[129].image, 400,50, 500, 500,null);
                }
                else if (tilemanager.tileXincreament >= -68 && tilemanager.tileXincreament <= 56 && tilemanager.tileYincreament >= 160 && tilemanager.tileYincreament <= 308 && keyH.pointerPosition_x > 560 && keyH.pointerPosition_x < 743 && keyH.pointerPosition_y > 355 && keyH.pointerPosition_y < 415){
                    g2.drawImage(tilemanager.tile[128].image, 400,50, 500, 500,null);
                }
                else if (tilemanager.tileXincreament >= -68 && tilemanager.tileXincreament <= 56 && tilemanager.tileYincreament >= 160 ){
                    tilemanager.get_out = 1;
                    g2.drawImage(tilemanager.tile[129].image, 400,50, 500, 500,null);
                }else if (tilemanager.tileYincreament <= 160 ){
                    tilemanager.get_out = 0;
                }

                if(keyH.chat == true && chat == 0 && chat_press == true && tilemanager.tileXincreament >= -40 && tilemanager.tileXincreament <= 28 && tilemanager.tileYincreament >= -404 && tilemanager.tileYincreament <= -308){
                   chat = 1;
                }else if (keyH.chat == true && chat == 1 && chat_press == true && tilemanager.tileXincreament >= -40 && tilemanager.tileXincreament <= 28 && tilemanager.tileYincreament >= -404 && tilemanager.tileYincreament <= -308){
                    chat = 2;
                }else if (keyH.chat == true && chat == 2 && chat_press == true && tilemanager.tileXincreament >= -40 && tilemanager.tileXincreament <= 28 && tilemanager.tileYincreament >= -404 && tilemanager.tileYincreament <= -308){
                    chat = 0;
                }  

                if (keyH.chat == false){
                    chat_press = true;
                }else if (keyH.chat == true){
                    chat_press = false;
                }
                
                if (chat == 1){
                    g2.drawImage(tilemanager.tile[30].image,290,0,720,280,null);
                }else if (chat == 2){
                    g2.drawImage(tilemanager.tile[31].image,290,0,720,280,null);
                }
                
                g2.setFont(new Font("VT323",Font.BOLD,50));
                g2.setColor(Color.white);
                g2.drawString(String.valueOf(coin),80, 57);
                g2.drawImage(tilemanager.tile[0].image,20,20,48,48,null);
    
            }

        else if(onhome == 1){
            if(keyH.mouseClicked == true){
                System.out.println(keyH.pointerPosition_x);
                System.out.println(keyH.pointerPosition_y);
            }

            if(speed_confirmation_tab == true || coin_confirmation_tab == true){
                x_home = 0;
            }

            home_x += x_home;
            if (home_x > 36 || home_x < -768){
                home_x -= x_home;
            }

            g2.drawImage(homescreen, 65, 0, 1152, 648, null);
            g2.drawImage(image, 900 + home_x, 475, 100,100,null);

            g2.setFont(new Font("VT323",Font.BOLD,50));
            g2.setColor(Color.white);
            g2.drawString(String.valueOf(coin_money),130, 57);
            g2.drawImage(tilemanager.tile[0].image,70,20,48,48,null);

            g2.drawImage(rain[spriteNum_rain].image,0,0,gp.screenWidth,gp.screenHeight,null);

            if (keyH.mouseClicked == true && keyH.pointerPosition_x >= 1008 && keyH.pointerPosition_x <= 1205 && keyH.pointerPosition_y >= 209 && keyH.pointerPosition_y <= 279 && speed_confirmation_tab == false && coin_confirmation_tab == false){
                coin_confirmation_tab = true;
                gp.playmusiconce(5, -5.0f);
            }
            else if (keyH.mousePressed == true && keyH.pointerPosition_x >= 1008 && keyH.pointerPosition_x <= 1205 && keyH.pointerPosition_y >= 209 && keyH.pointerPosition_y <= 279 && speed_confirmation_tab == false && coin_confirmation_tab == false){
                g2.drawImage(upgradecoin2, 1000, 213, 210,72, null);
            }else if (true){
                g2.drawImage(upgradecoin1, 1000, 210, 210,75, null);
            }
            
            if (keyH.mouseClicked == true && keyH.pointerPosition_x >= 1008 && keyH.pointerPosition_x <= 1205 && keyH.pointerPosition_y >= 298 && keyH.pointerPosition_y <= 371 && speed_confirmation_tab == false && coin_confirmation_tab == false && speed_upgrade > 9 && max_money == false){
                max_money = true;
                gp.playmusiconce(6, 6.0f);
            }else if (keyH.mouseClicked == true && keyH.pointerPosition_x >= 1008 && keyH.pointerPosition_x <= 1205 && keyH.pointerPosition_y >= 298 && keyH.pointerPosition_y <= 371 && speed_confirmation_tab == false && coin_confirmation_tab == false){
                speed_confirmation_tab = true;
                gp.playmusiconce(5, -5.0f);
            }else if (keyH.mousePressed == true && keyH.pointerPosition_x >= 1008 && keyH.pointerPosition_x <= 1205 && keyH.pointerPosition_y >= 298 && keyH.pointerPosition_y <= 371 && speed_confirmation_tab == false && coin_confirmation_tab == false){
                g2.drawImage(upgradespeed2, 995, 313, 210,72, null);
            }else if (true){
                g2.drawImage(upgradespeed1, 995, 310, 210,75, null);
            }

            if (coin_confirmation_tab == true && keyH.mouseClicked && keyH.pointerPosition_x >= 765 && keyH.pointerPosition_x <= 851 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                if(coin_money > coin_upgrade_cost){
                    gp.playmusiconce(5, -5.0f);
                    upgradingcoin();
                }else if (coin_money < coin_upgrade_cost){
                    no_money_now = true;
                    gp.playmusiconce(6, 6.0f);
                }
                coin_confirmation_tab = false;
            }
            else if (coin_confirmation_tab == true && keyH.mouseClicked && keyH.pointerPosition_x >= 447 && keyH.pointerPosition_x <= 531 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                coin_confirmation_tab = false;
                gp.playmusiconce(5, -5.0f);
            }
            else if (coin_confirmation_tab == true && keyH.mousePressed && keyH.pointerPosition_x >= 447 && keyH.pointerPosition_x <= 531 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                g2.drawImage(confirmCoin2, 350, 70, 600,600, null);
                g2.drawString(String.valueOf((int)coin_upgrade_cost + " Coins"),730, 298);
                g2.setFont(new Font("VT323",Font.BOLD,38));
                g2.drawString(String.valueOf(coin_upgrade + 2),660, 378);
            }
            else if (coin_confirmation_tab == true && keyH.mousePressed && keyH.pointerPosition_x >= 765 && keyH.pointerPosition_x <= 851 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                g2.drawImage(confirmCoin3, 350, 70, 600,600, null);
                g2.drawString(String.valueOf((int)coin_upgrade_cost + " Coins"),730, 298);
                g2.setFont(new Font("VT323",Font.BOLD,38));
                g2.drawString(String.valueOf(coin_upgrade + 2),660, 378);
            }
            else if (coin_confirmation_tab == true){
                g2.drawImage(confirmCoin1, 350, 70, 600,600, null);
                g2.drawString(String.valueOf((int)coin_upgrade_cost + " Coins"),730, 298);
                g2.setFont(new Font("VT323",Font.BOLD,38));
                g2.drawString(String.valueOf(coin_upgrade + 2),660, 378);
            }

            if (speed_confirmation_tab == true && keyH.mouseClicked && keyH.pointerPosition_x >= 765 && keyH.pointerPosition_x <= 851 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                if(coin_money >= speed_upgrade_cost){ 
                 upgradingspeed();
                 gp.playmusiconce(5, -5.0f);
                }else if(coin_money < speed_upgrade_cost){
                    no_money_now = true;
                    gp.playmusiconce(6, 6.0f);
                }
                speed_confirmation_tab = false;
            }
            else if (speed_confirmation_tab == true && keyH.mouseClicked && keyH.pointerPosition_x >= 447 && keyH.pointerPosition_x <= 531 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                speed_confirmation_tab = false;
                gp.playmusiconce(5, -5.0f);
            }
            else if (speed_confirmation_tab == true && keyH.mousePressed && keyH.pointerPosition_x >= 447 && keyH.pointerPosition_x <= 531 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                g2.drawImage(confirmSpeed2, 350, 70, 600,600, null);
                g2.drawString(String.valueOf(speed_upgrade_cost + " Coins"),730, 298);
                g2.setFont(new Font("VT323",Font.BOLD,38));
                g2.drawString(String.valueOf(speed_upgrade - 5),580, 378);
            }
            else if (speed_confirmation_tab == true && keyH.mousePressed && keyH.pointerPosition_x >= 765 && keyH.pointerPosition_x <= 851 && keyH.pointerPosition_y >= 402 && keyH.pointerPosition_y <= 477){
                g2.drawImage(confirmSpeed3, 350, 70, 600,600, null);
                g2.drawString(String.valueOf(speed_upgrade_cost + " Coins"),730, 298);
                g2.setFont(new Font("VT323",Font.BOLD,38));
                g2.drawString(String.valueOf(speed_upgrade - 5),580, 378);
            }
            else if (speed_confirmation_tab == true){
                g2.drawImage(confirmSpeed1, 350, 70, 600,600, null);
                g2.drawString(String.valueOf(speed_upgrade_cost + " Coins"),730, 298);
                g2.setFont(new Font("VT323",Font.BOLD,38));
                g2.drawString(String.valueOf(speed_upgrade - 5),580, 378);
            }

            if(no_money_now == true && keyH.enter == true){
                no_money_now = false;
                gp.playmusiconce(5, -5.0f);
            }
            else if(no_money_now){
                g2.drawImage(no_money, 350, 70, 600,600, null);
            }
            
            if(max_money == true && keyH.enter){
                max_money = false;
                gp.playmusiconce(5, -5.0f);
            }
            else if(max_money == true){
                g2.drawImage(max_speed, 350, 70, 600,600, null);
            }

            if(home_x > -508 && home_x < -324 && keyH.go_inside == true ){
                onhome = 0;
                gp.song = false;  
                onschool = 1;       
            }

            keyH.go_inside = false;
        }
    }
}

