package L1;

public class Runner {
	  private String name;
	  
	  private int marathonTimeSeconds;
	  
	  //Current world record: 2h 3min 59 seconds
	  private static final int WORLD_RECORD_TIME_SECONDS = 2 * 3600 + 3 * 60 + 59;// add expression to convert the record hours and minutes and seconds to seconds; [1 pt]
	  
	  public Runner (String n, int h, int m, int s){
	    name = n;
	    setTime(h, m, s);
	  }
	  
	  public void setTime (int h, int m, int s){
	    if (h>=0 && m>=0 && s>=0) 
	      this.marathonTimeSeconds =  3600 * h + 60 * m + s;// add expression to convert the h and m and s to seconds  [1 pt]
	  }
	  
	  public String getName() { return name; }
	  
	  public int getSeconds() { return marathonTimeSeconds; }
	  
	  public double percentageSlower() {
	  // ADD CODE HERE TO CALCULATE THE PERCENTAGE SLOWER THAN THE WORLD RECORD [2 pt]
		  return ((double) this.marathonTimeSeconds / Runner.WORLD_RECORD_TIME_SECONDS) - 1.0D;
	  }

	  public Runner (String n, String data){
	     // ADD CODE HERE TO INITIALIZE the object attributes by using the first String argument as the player name,
	  // and by parsing the second colon-delimited String argument (hh:mm:ss) into 3 integers hours, minutes, seconds [3 pt]
	  }
	}
