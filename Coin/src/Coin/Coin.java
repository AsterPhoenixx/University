package Coin;

import java.util.Random;

public class Coin
{
  public static void main(String args[])
  {
	  FLip_normal();
  }
 
  public static void FLip_normal()
  {
	 int br_Heads=0;
	 int br_Tails=0;
     for(;;)
      { 
    	  Random coin1 = new Random();
          int coins=coin1.nextInt(2);
		  if (coins==1)
		  {
			  System.out.println("Heads!");
			  br_Heads++;
			  br_Tails=0;
			  
		  }else
		  {
			  System.out.println("Tails!");
			  br_Tails++;
			  br_Heads=0;
		  }
		  if(br_Heads==3 || br_Tails==3)
		  {   
              break; 
		  }
      }
  }
	
}
