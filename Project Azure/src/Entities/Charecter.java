/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author falco_000
 */
public class Charecter {
    private int health;
    private int agility;
    private int strength;
    private int intelligence;
    private int level;
    private int experience;
    Random rand = new Random();
    private ArrayList inventory = new ArrayList(8);
    public Charecter()
    {
        health = 100;
        level = 1;
        experience = 0;
        strength = rand.nextInt(10);
        agility = rand.nextInt(10);
        intelligence = rand.nextInt(10);
    }
    public void addExperience(int experienceToAdd)
    {
        experience = experience + experienceToAdd;
    }
    public void dropItem(int indexInInvertory)
    {
        inventory.remove(indexInInvertory);
    }
    public void addItem(Item item)//Need to create item class
    {//Need to check if inventory is full before calling this
        for(int i = 0; i > inventory.size(); i++)
        {
            if(inventory.get(i) == null)
            {
                inventory.add(i, item);
            }
        }
    }
}
