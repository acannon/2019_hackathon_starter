/*
 * Purpose: A simple AI which uses random numbers to attack player one's fleet
 * Author: Jacob Turner
 * Date: 4/27/2019
 */
package my.altercationcraft;

import java.util.Random;

public class AIAttack 
{
    //declare array to hold player two's attacks
    int attack[][];
    
    //constructor
    public AIAttack()
    {
        //initialize attack grid
        attack = new int[][]{
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0}
                            };
    }
    
    //attack method gets random x/y coordinates, while that space has
    //not been attacked yet
    public int[] attack()
    {
        int c[] = new int[2];
        c[0] = getX();
        c[1] = getY();
        
        while(attack[c[0]][c[1]] != 0)
        {
            c[0] = getX();
            c[1] = getY();
        }
        attack[c[0]][c[1]] = 1;
        return c;
    } 
    
     //gets x-coordinate
    private int getX()
    {
        int x = 0;
        
        Random rand1 = new Random();
        x = rand1.nextInt(10) + 0;
        
        return x;
    }
    
    //gets y-coordinate
    private int getY()
    {
        int y = 0;
        
        Random rand2 = new Random();
        y = rand2.nextInt(10) + 0;
        
        return y;
    }
}
