/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import libs.Images;
import libs.Reference;

/**
 *
 * @author Kelle
 */
public class ResourceLoader 
{
    private static BufferedImageLoader imageLoader = new BufferedImageLoader();
    
    public static void loadImages()
    {
        try
        {
            Images.title = imageLoader.loadImage("title.png");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
