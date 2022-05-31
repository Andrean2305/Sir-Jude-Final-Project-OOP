package entity;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.swing.JOptionPane;

import java.awt.Rectangle;

public class entity {
    public BufferedImage image;
    public int worldX;
    public int worldY;
    public int speed;
    public static int coin = 0;

    public BufferedImage right1,right2,right3,right4,right5,right6,right7,right8, //ORANG NGADEP KANAN
                         left1,left2,left3,left4,left5,left6,left7,left8, //ORANG NGADEP KIRI
                         up1,up2,up3,up4,up5,up6,up7,up8,
                         down1,down2,down3,down4,down5,down6,down7,down8,
                         idle1,idle2,idle3,idle4,idle5,idle6,idle7,idle8, //ORANG DIEM NGADEP KANAN
                         idles1,idles2,idles3,idles4,idles5,idles6,idles7,idles8, //ORANG DIEM NGADEP KIRI
                         die1,die2,
                         getout1,getout2,getout3,
                         homescreen,
                         shadow,
                         upgradecoin1,upgradecoin2,
                         upgradespeed1,upgradespeed2,
                         confirmCoin1, confirmCoin2, confirmCoin3,
                         confirmSpeed1, confirmSpeed2, confirmSpeed3,
                         no_money,
                         max_speed,
                         rain1,rain2,rain3,rain4,
                         door1,door2;

                         
    public static String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int spriteCounter_rain = 0;
    public int spriteNum_rain = 1;
    
    public Rectangle solidArea;

    public boolean collisionOn = false;
    public static boolean coinColissiOn = false;

    public int coin_money = 50;

    



}
