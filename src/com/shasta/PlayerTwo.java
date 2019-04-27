/*
 * Purpose: Populates player two's (AI) fleet into the UI
 * Author: Jacob Turner
 * Date: 4/27/2019
 */
package my.altercationcraft;

import java.util.ArrayList;
import java.util.Random;

public class PlayerTwo 
{       
    int fleet[][];      //declare array for player two's fleet
    int attack[][];     //declare an array for player two's attacks
    
    //constructor
    public PlayerTwo()
    {
        //declare new 2d array for the game board
        fleet = new int[][]{
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
    
    //getFleet returns the fleet to the UI
    public int[][] getFleet()
    {
        return fleet;
    }
    public void fillFleet()
    {        
        //fill the standard boats onto the board
        fillPatrol();
        fillSub();
        fillCruiser();
        fillBattle();
        fillCarrier();         
    }
    
    //gets x-coordinate of initial boat point
    private int getX()
    {
        int x = 0;
        
        Random rand1 = new Random();
        x = rand1.nextInt(10) + 0;
        
        return x;
    }
    
    //gets y-coordinate of initial boat point
    private int getY()
    {
        int y = 0;
        
        Random rand2 = new Random();
        y = rand2.nextInt(10) + 0;
        
        return y;
    }
    
    //gets the direction in which boat will finish filling
    private int getD()
    {
        int d = 0;
        
        Random rand3 = new Random();
        d = rand3.nextInt(4) + 1;
        
        return d;
    }
    
    private void fillPatrol()
    {
        boolean placed = false;
        int boatPatrol = 1;
        int x = 0;
        int y = 0;
        int d = 0;
        
        x = getX();
        y = getY();
        
        //check if another boat is filling that space
        while(fleet[x][y] > 0)
        {
            //get  new x/y values and check again
            x = getX();
            y = getY();
        }
        
        //boat starting point is now in empty space
        fleet[x][y] = boatPatrol;
        
        System.out.println("Patrol Boat ----->");
        System.out.println("Start: (" + x +", " + y + ")");
        
        int count = 0;
        do
        {
            count++;
            d = getD();
            
            //1 = UP, 2 = RIGHT, 3 = DOWN, 4 = LEFT
            if(d == 1)
            {
                if((x-1) < 0)
                {
                    placed = false;
                }
                else if(fleet[x-1][y] > 0)
                {
                    placed = false;
                }
                else
                {
                    fleet[x-1][y] = boatPatrol;
                    placed = true;
                }
            }
            else if(d == 2)
            {
                if((y+1) > 9)
                {
                    placed = false;
                }
                else if(fleet[x][y+1] > 0)
                {
                    placed = false;
                }
                else
                {
                    fleet[x][y+1] = boatPatrol;
                    placed = true;
                }
            }
            else if(d == 3)
            {
                if((x+1) > 9)
                {
                    placed = false;
                }
                else if(fleet[x+1][y] > 0)
                {
                    placed = false;
                }
                else
                {
                    fleet[x+1][y] = boatPatrol;
                    placed = true;
                }
            }
            else if(d == 4)
            {
                if((y-1) < 0)
                {
                    placed = false;
                }
                else if(fleet[x][y-1] > 0)
                {
                    placed = false;
                }
                else
                {
                    fleet[x][y-1] = boatPatrol;
                    placed = true;
                }
            }
        }while(placed == false);
        
        System.out.println("Direction: " + d);
        System.out.println("Count: " + count);
    }
    
    private void fillSub()
    {
        boolean placed = false;
        int boatSub = 2;
        int x = 0;
        int y = 0;
        int d = 0;
        
        x = getX();
        y = getY();
        
        //check if another boat is filling that space
        while(fleet[x][y] > 0)
        {
            //get  new x/y values and check again
            x = getX();
            y = getY();
        }
        
        //boat starting point is now in empty space
        fleet[x][y] = boatSub;
        
        System.out.println("Submarine ----->");
        System.out.println("Start: (" + x +", " + y + ")");
        
        int count = 0;
        do
        {
            count++;
            d = getD();
            
            //1 = UP, 2 = RIGHT, 3 = DOWN, 4 = LEFT
            if(d == 1)
            {
                if((x-2) < 0)
                {
                    placed = false;
                }
                else if(fleet[x-2][y] > 0 || fleet[x-1][y] > 0)
                {
                        placed = false;                    
                }
                else
                {
                    fleet[x-1][y] = boatSub;
                    fleet[x-2][y] = boatSub;
                    placed = true;
                }
            }
            else if(d == 2)
            {
                if((y+2) > 9)
                {
                    placed = false;
                }
                else if(fleet[x][y+2] > 0 || fleet[x][y+1] > 0)
                {
                        placed = false;
                }
                else
                {
                    fleet[x][y+1] = boatSub;
                    fleet[x][y+2] = boatSub;
                    placed = true;
                }
            }
            else if(d == 3)
            {
                if((x+2) > 9)
                {
                    placed = false;
                }
                else if(fleet[x+2][y] > 0 || fleet[x+1][y] > 0)
                {
                        placed = false;
                }
                else
                {
                    fleet[x+1][y] = boatSub;
                    fleet[x+2][y] = boatSub;
                    placed = true;
                }
            }
            else if(d == 4)
            {
                if((y-2) < 0)
                {
                    placed = false;
                }
                else if(fleet[x][y-2] > 0 || fleet[x][y-1] > 0)
                {
                        placed = false;
                }
                else
                {
                    fleet[x][y-1] = boatSub;
                    fleet[x][y-2] = boatSub;
                    placed = true;
                }
            }
        }while(placed == false);
        
        System.out.println("Direction: " + d);
        System.out.println("Count: " + count);
    }
    
    private void fillCruiser()
    {
        boolean placed = false;
        int boatCruiser = 3;
        int x = 0;
        int y = 0;
        int d = 0;
        
        x = getX();
        y = getY();
        
        //check if another boat is filling that space
        while(fleet[x][y] > 0)
        {
            //get  new x/y values and check again
            x = getX();
            y = getY();
        }
        
        //boat starting point is now in empty space
        fleet[x][y] = boatCruiser;
        
        System.out.println("Cruiser ----->");
        System.out.println("Start: (" + x +", " + y + ")");
        
        int count = 0;
        do
        {
            count++;
            d = getD();
            
            //1 = UP, 2 = RIGHT, 3 = DOWN, 4 = LEFT
            if(d == 1)
            {
                if((x-2) < 0)
                {
                    placed = false;
                }
                else if(fleet[x-2][y] > 0 || fleet[x-1][y] > 0)
                {
                        placed = false;
                }
                else
                {
                    fleet[x-1][y] = boatCruiser;
                    fleet[x-2][y] = boatCruiser;
                    placed = true;
                }
            }
            else if(d == 2)
            {
                if((y+2) > 9)
                {
                    placed = false;
                }
                else if(fleet[x][y+2] > 0 || fleet[x][y+1] > 0)
                {
                        placed = false;
                }
                else
                {
                    fleet[x][y+1] = boatCruiser;
                    fleet[x][y+2] = boatCruiser;
                    placed = true;
                }
            }
            else if(d == 3)
            {
                if((x+2) > 9)
                {
                    placed = false;
                }
                else if(fleet[x+2][y] > 0 || fleet[x+1][y] > 0)
                {
                        placed = false;
                }
                else
                {
                    fleet[x+1][y] = boatCruiser;
                    fleet[x+2][y] = boatCruiser;
                    placed = true;
                }
            }
            else if(d == 4)
            {
                if((y-2) < 0)
                {
                    placed = false;
                }
                else if(fleet[x][y-2] > 0 || fleet[x][y-1] > 0)
                {
                        placed = false;
                }
                else
                {
                    fleet[x][y-1] = boatCruiser;
                    fleet[x][y-2] = boatCruiser;
                    placed = true;
                }
            }
        }while(placed == false);
        
        System.out.println("Direction: " + d);
        System.out.println("Count: " + count);
    }
    
    private void fillBattle()
    {
        boolean placed = false;
        int boatBattle = 4;
        int x = 0;
        int y = 0;
        int d = 0;
        
        x = getX();
        y = getY();
        
        //check if another boat is filling that space
        while(fleet[x][y] > 0)
        {
            //get  new x/y values and check again
            x = getX();
            y = getY();
        }
        
        //boat starting point is now in empty space
        fleet[x][y] = boatBattle;
        
        System.out.println("Battle Ship ----->");
        System.out.println("Start: (" + x +", " + y + ")");
        
        int count = 0;
        do
        {
            count++;
            d = getD();
            
            //1 = UP, 2 = RIGHT, 3 = DOWN, 4 = LEFT
            if(d == 1)
            {
                if((x-3) < 0)
                {
                    placed = false;
                }
                else if(fleet[x-3][y] > 0 || fleet[x-2][y] > 0 || fleet[x-1][y] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x-1][y] = boatBattle;
                    fleet[x-2][y] = boatBattle;
                    fleet[x-3][y] = boatBattle;
                    placed = true;
                }
            }
            else if(d == 2)
            {
                if((y+3) > 9)
                {
                    placed = false;
                }
                else if(fleet[x][y+3] > 0 || fleet[x][y+2] > 0 || fleet[x][y+1] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x][y+1] = boatBattle;
                    fleet[x][y+2] = boatBattle;
                    fleet[x][y+3] = boatBattle;
                    placed = true;
                }
            }
            else if(d == 3)
            {
                if((x+3) > 9)
                {
                    placed = false;
                }
                else if(fleet[x+3][y] > 0 || fleet[x+2][y] > 0 || fleet[x+1][y] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x+1][y] = boatBattle;
                    fleet[x+2][y] = boatBattle;
                    fleet[x+3][y] = boatBattle;
                    placed = true;
                }
            }
            else if(d == 4)
            {
                if((y-3) < 0)
                {
                    placed = false;
                }
                else if(fleet[x][y-3] > 0 || fleet[x][y-2] > 0 || fleet[x][y-1] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x][y-1] = boatBattle;
                    fleet[x][y-2] = boatBattle;
                    fleet[x][y-3] = boatBattle;
                    placed = true;
                }
            }
        }while(placed == false);
        
        System.out.println("Direction: " + d);
        System.out.println("Count: " + count);
    }
    
     private void fillCarrier()
    {
        boolean placed = false;
        int boatCarrier = 5;
        int x = 0;
        int y = 0;
        int d = 0;
        
        x = getX();
        y = getY();
        
        //check if another boat is filling that space
        while(fleet[x][y] > 0)
        {
            //get  new x/y values and check again
            x = getX();
            y = getY();
        }
        
        //boat starting point is now in empty space
        fleet[x][y] = boatCarrier;
        
        System.out.println("Carrier ----->");
        System.out.println("Start: (" + x +", " + y + ")");
        
        int count = 0;
        do
        {
            count++;
            d = getD();
            
            //1 = UP, 2 = RIGHT, 3 = DOWN, 4 = LEFT
            if(d == 1)
            {
                if((x-4) < 0)
                {
                    placed = false;
                }
                else if(fleet[x-3][y] > 0 || fleet[x-3][y] > 0 || fleet[x-2][y] > 0 || fleet[x-1][y] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x-1][y] = boatCarrier;
                    fleet[x-2][y] = boatCarrier;
                    fleet[x-3][y] = boatCarrier;
                    fleet[x-4][y] = boatCarrier;
                    placed = true;
                }
            }
            else if(d == 2)
            {
                if((y+4) > 9)
                {
                    placed = false;
                }
                else if(fleet[x][y+4] > 0 || fleet[x][y+3] > 0 || fleet[x][y+2] > 0 || fleet[x][y+1] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x][y+1] = boatCarrier;
                    fleet[x][y+2] = boatCarrier;
                    fleet[x][y+3] = boatCarrier;
                    fleet[x][y+4] = boatCarrier;
                    placed = true;
                }
            }
            else if(d == 3)
            {
                if((x+4) > 9)
                {
                    placed = false;
                }
                else if(fleet[x+4][y] > 0 || fleet[x+3][y] > 0 || fleet[x+2][y] > 0 || fleet[x+1][y] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x+1][y] = boatCarrier;
                    fleet[x+2][y] = boatCarrier;
                    fleet[x+3][y] = boatCarrier;
                    fleet[x+4][y] = boatCarrier;
                    placed = true;
                }
            }
            else if(d == 4)
            {
                if((y-4) < 0)
                {
                    placed = false;
                }
                else if(fleet[x][y-4] > 0 || fleet[x][y-3] > 0 || fleet[x][y-2] > 0 || fleet[x][y-1] > 0)
                {
                            placed = false;
                }
                else
                {
                    fleet[x][y-1] = boatCarrier;
                    fleet[x][y-2] = boatCarrier;
                    fleet[x][y-3] = boatCarrier;
                    fleet[x][y-4] = boatCarrier;
                    placed = true;
                }
            }
        }while(placed == false);
        
        System.out.println("Direction: " + d);
        System.out.println("Count: " + count);
    }
     
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
        
        return c;
    } 
}
