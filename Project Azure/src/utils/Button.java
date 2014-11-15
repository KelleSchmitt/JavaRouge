/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import input.MouseInput;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Kelle
 */
public class Button extends Rectangle
{
    private String text;
    
    public Button()
    {
        super();
    }
    
    public Button(Rectangle r)
    {
        super(r);
    }
    
    public Button(Point p)
    {
        super(p);
    }
    
    public Button(Dimension d)
    {
        super(d);
    }
    
    public Button(int width, int height)
    {
        super(width, height);
    }
    
    public Button(Point p, Dimension d)
    {
        super(p, d);
    }
    
    public Button(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }
    
    public Button setText(String text)
    {
        this.text = text;
        return this;
    }
    
    public void drawButton(Graphics g, int offset)
    {
        int xx = x + offset;
        int yy = y + 38;
        if(MouseInput.MOUSE.intersects(this))
        {
            g.setColor(Color.yellow);
        }
        else
        {
            g.setColor(Color.white);
        }
        g.drawRect(x, y, width, height);
        g.drawString(text, xx, yy);
    }
}
