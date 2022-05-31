package entity.tile;
import main.KeyHandler;

import main.GamePanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOError;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class tile {
    public BufferedImage image;  
    public boolean collision = false;
    public boolean coin_touch = false;
}
