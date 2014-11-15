/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import enums.GameState;
import gfx.Renderer;
import input.MouseInput;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import screens.Menu;
import utils.ResourceLoader;

/**
 *
 * @author Kelle
 */
public class Game extends Canvas implements Runnable
{
    private static JFrame frame = new JFrame();
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 4 * 3;
    public static final String TITLE = "Project Azure";
    private static Game game = new Game();
    public static GameState state = GameState.MENU;
    
    private boolean running = false;
    private Thread thread;
    private Renderer gfx;
    public Menu menu;
    
    public static Game getInstance()
    {
        return game;
    }
    
    public void init()
    {
        ResourceLoader.loadImages();
        menu = new Menu();
        gfx = new Renderer();
        MouseInput mouse = new MouseInput();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }
    
    public void tick()
    {
        
    }
    
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);
        
        ////////////////////////////////////////////
        
        gfx.renderBackground(g);
        gfx.renderForeground(g);
        
        g.dispose();
        bs.show();
    }
    
    @Override
    public void run()
    {
        init();
        long lastTime = System.nanoTime();
        final double numTicks = 60.0;
        double n = 1000000000 / numTicks;
        double delta = 0;
        int frames = 0;
        int ticks = 0;
        long timer = System.currentTimeMillis();
        
        while(running)
        {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / n;
            lastTime = currentTime;
            
            if(delta >= 1)
            {
                tick();
                ticks++;
                delta--;
            }
            
            render();
            frames++;
            
            if(System.currentTimeMillis()- timer > 1000)
            {
                timer += 1000;
                System.out.println(ticks + " Ticks, FPS: " + frames);
                frame.setTitle(TITLE + "      FPS: " + ticks);
                ticks = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    public static void main(String args[])
    {
        frame.setTitle(TITLE);
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
        game.start();
    }
    
        private synchronized void start()
    {
        if(running)
            return;
        else
            running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop()
    {
        if(!running)
            return;
        else
            running = false;
        try 
        {
            thread.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        
        System.exit(0);
    }
    
}
