package Coin;

import java.util.Random;

public class coin2 {

	public static void main(String[] args)
	{
		while(true)
		{
		coin();
		}
	}
	 private static void coin()
	    {
	        String[] coin = new String[2];
	        Random radnom_coin = new Random();
	        int index = radnom_coin.nextInt(coin.length);
	        coin[0] = "Heads!";
	        coin[1] = "Tail";
	        System.out.println(coin[index]);
	    }

}
