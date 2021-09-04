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

    public boolean setArrivalTime(int aT) {
        if(aT <= leavingTime) {
            arrivalTime = aT;
            return true;
        }
        else return false;
    }

}