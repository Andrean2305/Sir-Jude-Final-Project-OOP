package main;

// import javax.swing.text.html.parser.Entity;

import entity.entity;
import entity.player;
import entity.tile.tile;
import entity.tile.tilemanager;
// import entity.player;
import entity.tile.tilemanager;

import java.awt.Rectangle;
import java.awt.Graphics2D;

public class colissionchecker extends entity{
    GamePanel gp; 
    Graphics2D g2;
    player player;

    public colissionchecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(entity entity){
        int entityLeftWorldX = tilemanager.main_map_X + tilemanager.tileXincreament + entity.solidArea.x ;
        int entityRightWorldX = tilemanager.main_map_X + tilemanager.tileXincreament + entity.solidArea.x + entity.solidArea.width -3;
        int entityTopWorldY = tilemanager.main_map_Y + tilemanager.tileYincreament + entity.solidArea.y;
        int entityBottomWorldY = tilemanager.tileYincreament + entity.solidArea.y + entity.solidArea.height + tilemanager.main_map_Y;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize ;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int entityLeftColl = entityLeftWorldX/gp.originalTileSize;
        int entityRightColl = entityRightWorldX/gp.originalTileSize ;   
        int entityTopRoww = entityTopWorldY/gp.originalTileSize;
        int entityBottomRoww = entityBottomWorldY/gp.originalTileSize;


        int tileNum1, tileNum2;

        // System.out.println(gp.tileM.map_wall[entityTopRoww][entityLeftColl]);
        // System.out.println(entityLeftColl);

        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - player.speed_upgrade)/gp.tileSize;
                tileNum1 = gp.tileM.map[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileM.map[entityTopRow][entityRightCol];
                // System.out.println(tileNum1);

                // if(gp.tileM.tile[tileNum1].collisionWallTop == true || gp.tileM.tile[tileNum2].collisionWallTop == true){
                //     tileNum1 = gp.tileM.map[entityTopRoww][entityLeftColl];
                //     tileNum2 = gp.tileM.map[entityTopRoww][entityRightColl];
                //     System.out.println("OOPS");
                // }
                
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }

                if(gp.tileM.tile[tileNum1].coin_touch == true || gp.tileM.tile[tileNum2].coin_touch == true){
                    entity.coinColissiOn = true;
                    // System.out.println("Touch coin");
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + player.speed_upgrade)/gp.tileSize;
                tileNum1 = gp.tileM.map[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileM.map[entityBottomRow][entityRightCol];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }

                if(gp.tileM.tile[tileNum1].coin_touch == true || gp.tileM.tile[tileNum2].coin_touch == true){
                    entity.coinColissiOn = true;
                }

                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - player.speed_upgrade)/gp.tileSize;
                tileNum1 = gp.tileM.map[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileM.map[entityBottomRow][entityLeftCol];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }

                if(gp.tileM.tile[tileNum1].coin_touch == true || gp.tileM.tile[tileNum2].coin_touch == true){
                    entity.coinColissiOn = true;
                }

                break;
            case "right":
                entityRightCol = (entityRightWorldX + player.speed_upgrade)/gp.tileSize;
                tileNum1 = gp.tileM.map[entityTopRow][entityRightCol];
                tileNum2 = gp.tileM.map[entityBottomRow][entityRightCol];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }

                if(gp.tileM.tile[tileNum1].coin_touch == true || gp.tileM.tile[tileNum2].coin_touch == true){
                    entity.coinColissiOn = true;
                }

                break;

        }
        switch(entity.direction){
            case "up":
                entityTopRoww = (entityTopWorldY - player.speed_upgrade)/gp.originalTileSize;
                tileNum1 = gp.tileM.map_wall[entityTopRoww][entityLeftColl];
                tileNum2 = gp.tileM.map_wall[entityTopRoww][entityRightColl];
                // System.out.println(tileNum1);
                // System.out.println(gp.tileM.map_wall[entityTopRoww][entityLeftColl]);
                // System.out.println(entityLeftColl);
                
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRoww = (entityBottomWorldY + player.speed_upgrade)/gp.originalTileSize;
                tileNum1 = gp.tileM.map_wall[entityBottomRoww][entityLeftColl];
                tileNum2 = gp.tileM.map_wall[entityBottomRoww][entityRightColl];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }

                break;
            case "left":
                entityLeftColl = (entityLeftWorldX - player.speed_upgrade)/gp.originalTileSize;
                tileNum1 = gp.tileM.map_wall[entityTopRoww][entityLeftColl];
                tileNum2 = gp.tileM.map_wall[entityBottomRoww][entityLeftColl];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightColl = (entityRightWorldX + player.speed_upgrade)/gp.originalTileSize;
                tileNum1 = gp.tileM.map_wall[entityTopRoww][entityRightColl];
                tileNum2 = gp.tileM.map_wall[entityBottomRoww][entityRightColl];

                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;

        }
        
    }
    
}
