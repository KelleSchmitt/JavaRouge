/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;


import input.MouseInput;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import libs.Images;
import libs.Reference;
import main.Game;
import utils.Button;

/**
 *
 * @author Kelle
 */
public class Menu 
{
    public static Rectangle play, options, quit;
    //private static int centerX = Game.WIDTH / 2;
    //private static int centerY = Game.HEIGHT / 2;
  
    public Menu()
    {
        int fillerY = 150;
        play = new Button(Reference.CENTER_X - 100, fillerY, 200, 50).setText("Play");
        options = new Button(Reference.CENTER_X - 100, fillerY+=60, 200, 50).setText("Options");
        quit = new Button(Reference.CENTER_X - 100, fillerY+=60, 200, 50).setText("Quit");
    }
    
    public void drawButton(Graphics g, Rectangle rect, String text, int offsetX)
    {
        Font tempFont = new Font("Arial", Font.BOLD, 45);
        g.setFont(tempFont);
        if(MouseInput.MOUSE.intersects(rect) && MouseInput.MOUSE != null)
        {
            g.setColor(Color.yellow);
        }
        else
        {
            g.setColor(Color.white);
        }
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.drawString(text, rect.x + offsetX, rect.y + 38);
    }
    
    public void render(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(Images.title, 128, 10, null);
        
        Font tempFont = new Font("Arial", Font.BOLD, 45);
        g.setFont(tempFont);
        
        //play.drawButton(g, 55); //restart episode 8
        //options.drawButton(g, 15);
        //quit.drawButton(g, 55);
        
        drawButton(g, play, "Play", 45);
        drawButton(g, options, "Options", 15);
        drawButton(g, quit, "Quit", 45);
    }
}
