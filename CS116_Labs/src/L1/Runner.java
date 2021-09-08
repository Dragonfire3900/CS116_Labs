package L1;

public class Runner {
	  /**
	   * The name of the runner
	   */
	  private String name;
	  
	  /**
	   * The runner's marathon time in seconds
	   */
	  private int marathonTimeSeconds;
	  
	  //Current world record: 2h 3min 59 seconds
	  private static final int WORLD_RECORD_TIME_SECONDS = 2 * 3600 + 3 * 60 + 59;// add expression to convert the record hours and minutes and seconds to seconds; [1 pt]
	  
	  /**
	   * A runner constructor given their record as separate parameters
	   * 
	   * @param name The name of the runner
	   * @param h How many hours it took the runner to run their record 
	   * @param m How many minutes it took the runner to run their record
	   * @param s How many seconds it took the runner to run their record
	   */
	  public Runner (String name, int h, int m, int s){
	    this.name = name;
	    this.setTime(h, m, s);
	  }
	  
	  /**
	   * A runner constructor given a string version of their record
	   * 
	   * @param name The name of the runner
	   * @param data The string version of their record in hh:mm:ss format
	   */
	  public Runner (String name, String data) {
		     // ADD CODE HERE TO INITIALIZE the object attributes by using the first String argument as the player name,
		  // and by parsing the second colon-delimited String argument (hh:mm:ss) into 3 integers hours, minutes, seconds [3 pt]
		  
		  this.name = name;
		  
		  //First index is hours, second is minutes, third is seconds
		  String[] splitData = data.split(":");
		  
		  this.setTime(Integer.parseInt(splitData[0]), Integer.parseInt(splitData[1]), Integer.parseInt(splitData[2]));
	  }
	  
	  public void setTime (int h, int m, int s) {
	    if (h>=0 && m>=0 && s>=0) 
	      this.marathonTimeSeconds =  3600 * h + 60 * m + s;// add expression to convert the h and m and s to seconds  [1 pt]
	  }
	  
	  public String getName() { return name; }
	  
	  public int getSeconds() { return marathonTimeSeconds; }
	  
	  public double percentageSlower() {
	  // ADD CODE HERE TO CALCULATE THE PERCENTAGE SLOWER THAN THE WORLD RECORD [2 pt]
		  return 100 * (((double) this.marathonTimeSeconds / Runner.WORLD_RECORD_TIME_SECONDS) - 1.0D);
	  }
	}
