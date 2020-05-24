package zodic;

import java.util.Scanner;

public class Zodiacs {

	private static Scanner scannermonth;
	private static Scanner scannerday;

	public static void main(String[] args) {
		
		scannerday = new Scanner(System.in);
	    System.out.println("Enter day:");
        int day = scannerday.nextInt(); 
         
 		scannermonth = new Scanner(System.in);
	    System.out.println("Enter month:");
         String month = scannermonth.next(); 
         
	      String sign="";
	      if (month == "January") {
	         if (day < 20)
	            sign = "Capricorn";
	         else
	            sign = "Aquarius";
	      } else if (month == "February") {
	         if (day < 19)
	            sign = "Aquarius";
	         else
	            sign = "Pisces";
	      } else if(month == "March") {
	         if (day < 21)
	            sign = "Pisces";
	         else
	            sign = "Aries";
	      } else if (month == "April") {
	         if (day < 20)
	            sign = "Aries";
	         else
	            sign = "Taurus";
	      } else if (month == "May") {
	         if (day < 21)
	            sign = "Taurus";
	         else
	            sign = "Gemini";
	      } else if( month == "June") {
	         if (day < 21)
	            sign = "Gemini";
	         else
	            sign = "Cancer";
	      } else if (month == "July") {
	         if (day < 23)
	            sign = "Cancer";
	         else
	            sign = "Leo";
	      } else if( month == "August") {
	         if (day < 23) 
	            sign = "Leo"; 
	         else
	            sign = "Virgo";
	      } else if (month == "September") {
	         if (day < 23)
	            sign = "Virgo";
	         else
	            sign = "Libra";
	      } else if (month == "October") {
	         if (day < 23)
	            sign = "Libra";
	         else
	            sign = "Scorpio";
	      } else if (month == "November") {
	         if (day < 22)
	            sign = "scorpio";
	         else
	            sign = "Sagittarius";
	      } else if (month == "Decemmber") {  
	         if (day < 22)
	            sign = "Sagittarius"; 
	         else
	            sign ="Capricorn";
	      }
	      System.out.println("The astrological sign for " + day + " " + month + " is " + sign );
	   }
}

