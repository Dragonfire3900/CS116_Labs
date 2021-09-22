package L3;

public enum ZonesEnum {
	
	DEFAULT(new double[] {0.0f, 0.0f}, 0.0f, 0.0f, 0),
	T1(new double[] {Double.MIN_VALUE, 2000.0f}, 25.0f, 0.0f, 1),
	T2(new double[] {2000.0f, 2500.0f}, 25.0f, 2.0f, 2),
	T3(new double[] {2500.0f, 3500.0f}, 35.0f, 1.0f, 2),
	T4(new double[] {3500.0f, 5000.0f}, 45.0f, 0.5f, 3),
	T5(new double[] {5000.0f, Double.MAX_VALUE}, 52.5f, 0.25f, 4);
	
	/**
	 * The lot area limits for this enum type in square feet
	 * 	The first index is the lower limit
	 * 	The second index is the upper limit
	 */
	private final double lotArea[];
	
	/**
	 * The height offset for calculating the height limit in feet
	 */
	private final double heightOffset;
	
	/**
	 * The percentage scale for calculating the height limit
	 */
	private final double heightScale;
	
	/**
	 * The maximum number of units on this particular zone
	 */
	private final int unitLimit;
	
	ZonesEnum(double[] lA, double hO, double hS, int uL) {
		//Verifying stupid things
		//Verifying lot area
		if (lA.length != 2) {
			System.out.print("The lot area needs to be an array of length 2");
			lA = new double[] {0.0f, 0.0f};
		}
		
		if (lA[0] < 0.0f) {
			System.out.print("The lower limit in a zones enum was negative");
			lA[0] = 0.0f;
		}
		
		if (lA[1] < 0.0f) {
			System.out.print("The upper limit in a zones enum was negative");
			lA[1] = 0.0f;
		}
		this.lotArea = lA;
		
		//Verifying height offset
		if (hO < 0.0f) {
			System.out.print("The height offset in a zones enum was negative");
			hO = 0.0f;
		}
		this.heightOffset = hO;
		
		//Verifying height Scale
		if (hS < 0.0f) {
			System.out.print("The height scale in a zones enum was negative");
			hS = 0.0f;
		}
		this.heightScale = hS;
		
		//Verifying unit limit
		if (uL < 0) {
			System.out.print("Negative unit limits are not possible");
			uL = 0;
		}
		
		this.unitLimit = uL;
	}
	
	protected double getLowerLotArea() { return this.lotArea[0]; }
	protected double getUpperLotArea() { return this.lotArea[1]; }
	protected int getUnitLimit() { return this.unitLimit; }
	
	//Just a bit extra for further use
	private double getHeightOffset() { return this.heightOffset; }
	private double getHeightScale() { return this.heightScale; }
	
	protected double calcMaxHeight(double lotArea) {
		if (lotArea < this.getLowerLotArea()) {
			System.out.print("The incorrect zone type was used please redetermine the zone type");
			return 0.0f;
		}
		
		return this.heightOffset + (this.heightScale / 100.0f) * Math.abs(lotArea - this.getLowerLotArea());
	}
}
