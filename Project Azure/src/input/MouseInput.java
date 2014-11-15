/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import enums.GameState;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.Game;

/**
 *
 * @author Kelle
 */
public class MouseInput extends MouseAdapter
{
    public static int MOUSE_X, MOUSE_Y;
    public static Rectangle MOUSE = new Rectangle(1,1,1,1);
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int mouse = e.getButton();
        Rectangle rect = new Rectangle(e.getX(), e.getY(), 1, 1);
        
        if(mouse == MouseEvent.BUTTON1)
        {
            switch(Game.state)
            {
                case GAME:
                    break;
                case MENU:
                    if(rect.intersects(Game.getInstance().menu.play))
                    {
                        Game.state = GameState.GAME;
                        
                    }
                    break;
                case OPTIONS:
                    break;
                case PAUSE:
                    break;
                default:
                    break;
            }
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        MOUSE_X = e.getX();
        MOUSE_Y = e.getY();     
        MOUSE = new Rectangle(MOUSE_X, MOUSE_Y, 1, 1);
    }
}
