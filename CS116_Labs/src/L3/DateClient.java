package L3;

public class DateClient
{
  public static void main( String [] args )
  {
     // add code to construct Data objects
	 // and test and output if they are a
	 // leap year or not
	 
	 // not leap year (not divisible by 4)
	  Date one = new Date( 1 , 1 , 2001);
	  if(one.leapYear()) {
		  System.out.println( one.getYear() + "is a leap year." );
	  }
	  else {
		  System.out.println( one.getYear() + "is not a leap year." );
	  }
	 // leap year (divisible by 4, but not by 100)
	  Date two = new Date( 1 , 1 , 2004);
	  if(two.leapYear()) {
		  System.out.println( two.getYear() + "is a leap year." );
		  }
	  else {
		  System.out.println( two.getYear() + "is not a leap year." );
	  }
	 // not leap year (divisible by 4 and by 100)
	  Date three = new Date( 1 , 1 , 2200);
	  if(three.leapYear()) {
		  System.out.println( three.getYear() + "is a leap year." );
		  }
	  else {
			  System.out.println( three.getYear() + "is not a leap year." );
	  }
	 // leap year (divisible by 4 and by 100 and by 400)
	  Date four = new Date( 1 , 1 , 2400);
	  if(four.leapYear()) {
		  System.out.println( four.getYear() + "is a leap year." );
		  }
	  else {
			  System.out.println( four.getYear() + "is not a leap year." );
	  }

	 // your birth year
	  Date five = new Date( 1 , 1 , 2000);
	  if(five.leapYear()) {
		  System.out.println( five.getYear() + "is a leap year." );
		  }
	  else {
			  System.out.println( five.getYear() + "is not a leap year." );
	  }
	  
	  Date tests[] = {
			  new Date(2, 1, -100),
			  new Date(2, 29, 2006),
			  new Date(2, 29, 2000),
			  new Date(2, 29, 2004),
			  new Date(2, 29, 1900),
			  new Date(2, 29, 1600)
	  };
	  
	  for (Date value : tests) {
		  System.out.print(value.toString() + "\n");
	  }

  }
}

