package L1;

public class Vehicle {
    private int uniqueID;
    private int arrivalTime;
    private int tollBoothTime;
    private int leavingTime;

    static private int numVehicles = 0;

    public Vehicle() {
        numVehicles++;
        uniqueID = numVehicles;
        arrivalTime = 0;
        tollBoothTime = 0;
        leavingTime = 0;
    }

    public Vehicle(int aT) {
        numVehicles++;
        uniqueID = numVehicles;
        setArrivalTime(aT);
        tollBoothTime = 0;
        leavingTime = 0;
    }

    /*--------------------------------------
      |          Accessor Methods          |
      --------------------------------------*/
    
    //TODO: Make and document Accessors
    
	/**
	 * @return the uniqueID
	 */
	private int getUniqueID() {
		return uniqueID;
	}

	/**
	 * @return the arrivalTime
	 */
	private int getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @return the tollBoothTime
	 */
	private int getTollBoothTime() {
		return tollBoothTime;
	}

	/**
	 * @return the leavingTime
	 */
	private int getLeavingTime() {
		return leavingTime;
	}

	//--------------------------------------
    //|          Mutator Methods           |
    //--------------------------------------
	
	//TODO: Make the Mutator logical relationships make sense
	
	/**
	 * @param uniqueID the uniqueID to set
	 */
	private void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	private boolean setArrivalTime(int aT) {
		if(aT <= leavingTime) {
          this.arrivalTime = aT;
          return true;
      }
      else return false;
	}

	/**
	 * @param tollBoothTime the tollBoothTime to set
	 */
	private void setTollBoothTime(int tollBoothTime) {
		this.tollBoothTime = tollBoothTime;
	}

	/**
	 * @param leavingTime the leavingTime to set
	 */
	private void setLeavingTime(int leavingTime) {
		this.leavingTime = leavingTime;
	}

	//TODO: Format the toString method better
	
	@Override
	public String toString() {
		return "Vehicle [uniqueID=" + uniqueID + ", arrivalTime=" + arrivalTime + ", tollBoothTime=" + tollBoothTime
				+ ", leavingTime=" + leavingTime + "]";
	}
}