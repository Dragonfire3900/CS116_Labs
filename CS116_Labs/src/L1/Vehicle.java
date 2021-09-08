package L1;

public class Vehicle {
	
	/**
	 * The unique ID of the vehicle. Generated automatically
	 */
    final private int uniqueID;
    
    /**
     * The arrival time of the vehicle to the queue of the toll booth
     */
    private int arrivalTime;
    
    /**
     * The amount of time it takes the vehicle to get from the start of the line to the end
     */
    private int tollBoothTime;
    
    /**
     * The time at which the vehicle leaves the toll booth and line
     */
    private int leavingTime;

    
    /**
     * The total number of vehicles that have gone through the toll booths
     */
    static private int numVehicles = 0;

    /**
     * The default constructor which assumes everything is zero
     */
    public Vehicle() {
        Vehicle.numVehicles++;
        this.uniqueID = Vehicle.numVehicles;
        this.setArrivalTime(0);
        tollBoothTime = 0;
        leavingTime = 0;
    }

    public Vehicle(int aT) {
        Vehicle.numVehicles++;
        this.uniqueID = Vehicle.numVehicles;
        this.setArrivalTime(aT);
        tollBoothTime = 0;
        leavingTime = 0;
    }

    /*--------------------------------------
      |          Accessor Methods          |
      --------------------------------------*/
    
	/**
	 * @return the uniqueID
	 */
	public int getUniqueID() {
		return uniqueID;
	}

	/**
	 * @return the arrivalTime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @return the tollBoothTime
	 */
	public int getTollBoothTime() {
		return tollBoothTime;
	}

	/**
	 * @return the leavingTime
	 */
	public int getLeavingTime() {
		return leavingTime;
	}

	//--------------------------------------
    //|          Mutator Methods           |
    //--------------------------------------

	/**
	 * @param aT The new arrival time of the vehicle
	 * 
	 * @return returns true if the value was successfully set and false otherwise
	 */
	private boolean setArrivalTime(int aT) {
		//It's more maintainable to check for invalid time and return false than make a nested if statement
		
		//Case #1: Time is greater than zero
		if (aT <= 0) { return false; }
		
		this.arrivalTime = aT;
		return true;
	}

	/**
	 * @param tollBoothTime The new toll booth time for the vehicle
	 * 
	 * @return returns true if the value was successfully set and false otherwise
	 */
	private boolean setTollBoothTime(int tollBoothTime) {
		//It's more maintainable to check for invalid time and return false than make a nested if statement
		
		//Case #1: Time is greater than zero
		if (tollBoothTime <= 0) { return false; }
		
		//Case #2: Toll booth time is after the arrival time
		if (tollBoothTime > this.getArrivalTime()) { return false; }
		
		//Case #3: Assuming the car already left. tollBoothTime is before leaving time
		if (this.getLeavingTime() != 0 & this.getLeavingTime() < tollBoothTime) { return false; }
		
		this.tollBoothTime = tollBoothTime;
		return true;
	}

	/**
	 * @param leavingTime The new leaving time for the vehicle
	 * 
	 * @return returns true if the value was successfully set and false otherwise
	 */
	private boolean setLeavingTime(int leavingTime) {
		//It's more maintainable to check the negation of a valid time and return false than make a nested if statement
		
		//Case #1: Time is greater than zero
		if (leavingTime <= 0) { return false; }
		
		//Case #2: Leaving time is after toll booth time
		if (leavingTime <= this.getTollBoothTime()) { return false; }
		
		this.leavingTime = leavingTime;
		return true;
	}

	//TODO: Format the toString method better
	
	@Override
	public String toString() {
		return "Vehicle [uniqueID=" + uniqueID + ", arrivalTime=" + arrivalTime + ", tollBoothTime=" + tollBoothTime
				+ ", leavingTime=" + leavingTime + "]";
	}
}