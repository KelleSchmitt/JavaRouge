/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.util.Random;

/**
 *
 * @author falco_000
 */
public class Item {
    private int damage;
    private int weaponSpeed;
    private int 
    Random rand = new Random();
    public Item()
    {
                
    }
    public Item createItem()
    {
        String type;
        int typeOfWeapon = rand.nextInt(5);
        switch (typeOfWeapon)
        {
            case 1 :
                type = "axe";
                
        }
    }
}
