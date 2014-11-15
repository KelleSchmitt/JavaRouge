/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import libs.Reference;

/**
 *
 * @author Kelle
 */
public class BufferedImageLoader 
{
    private BufferedImage image;
    
    public BufferedImage loadImage(String imagePath) throws IOException
    {
        image = ImageIO.read(new File(Reference.SPRITE_LOCATION + imagePath));
        return image;
    }
}
