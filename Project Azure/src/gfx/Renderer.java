/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import java.awt.Color;
import java.awt.Graphics;
import main.Game;
import screens.Menu;
//import main.Game;

/**
 *
 * @author Kelle
 */
public class Renderer 
{
    //private static Game game = Game.getInstance();
    
    public void renderBackground(Graphics g)
    {
        switch(Game.state)
        {
            case GAME:
                break;
            case MENU:
                Game.getInstance().menu.render(g);
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                g.setColor(Color.red);
                g.drawString("UNKOWN GAMESTATE", 150, 150);
                break;
        }
    }
    
    public void renderForeground(Graphics g)
    {
        
    }
}
