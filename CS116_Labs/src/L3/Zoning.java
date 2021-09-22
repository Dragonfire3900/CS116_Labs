package L3;

public class Zoning {
		/**
		 * The width of the zone
		 */
		private int width;
	
		/**
		 * The length of the zone
		 */
		private int length;
		
		/**
		 * The zone type of the particular zone
		 */
		private ZonesEnum zone;
		
	Zoning() {
		this.width = 0;
		this.length = 0;
		this.calcZoneType();
	}
	
	Zoning(int W, int L) {
		this.width = 0;
		this.length = 0;
		this.setArea(W, L);
	}
	
	/*  -------------------------
	 *  |        Getters        |
	 *  ------------------------- 
	 */
	
	public int getWidth() { return this.width; }
	public int getLength() { return this.length; }
	public ZonesEnum getZoneType() { return this.zone; }
	
	public double heightLimit() { return this.zone.calcMaxHeight(this.getArea()); }
	public int unitCountLimit() { return this.zone.getUnitLimit(); }
	
	/** Calculates the area of the lot
	 * @return The area of the lot
	 */
	public int getArea() { return this.width * this.length; }
	
	/*  -------------------------
	 *  |       Mutators        |
	 *  ------------------------- 
	 */
	
	/**
	 * Sets the width of the lot
	 * @param nW The new width of the lot
	 * @return If the set was successful returns true, false otherwise
	 */
	private boolean setWidth(int nW) {
		if (nW < 0) {
			this.width = 0;
			return false; 
			}
		
		this.width = nW;
		return true;
	}
	
	/**
	 * Sets the length of the lot
	 * @param nL The new length of the lot
	 * @return If the set was successful returns true, false otherwise
	 */
	private boolean setLength(int nL) {
		if (nL < 0) {
			this.length = 0;
			return false;
		}
		
		this.length = nL;
		return true;
	}
	
	/**
	 * Sets the lot's area by setting the width and length and resets the zone type for the lot
	 * @param nW The new width of the lot
	 * @param nL The new length of the lot
	 * @return returns true if the setting process was successful
	 */
	public boolean setArea(int nW, int nL) {
		boolean set1 = this.setWidth(nW);
		boolean set2 = this.setLength(nL);
		boolean set3 = this.calcZoneType();
		
		return set1 && set2 && set3;
	}
	
	/** Figures out what type of zone the created zone is. Should only be used after changing the lot area
	 *  Exclusive on the bottom and inclusive on the top
	 *  @return True if the zone was found. False if the zone wasn't found
	 */
	private boolean calcZoneType() {
		for (ZonesEnum test : ZonesEnum.values()) {
			if (test == ZonesEnum.DEFAULT) continue;
			
			if (this.getArea() > test.getLowerLotArea() && this.getArea() <= test.getUpperLotArea()) {
				this.zone = test;
				return true;
			}
		}
		
		this.zone = ZonesEnum.DEFAULT;
		return false;
	}

	@Override
	public String toString() {
		return String.format("Zone (%d, %d), Area: %d, Type: %s, Max Height: %f, Unit num: %d", this.getWidth(), this.getLength(), this.getArea(), this.getZoneType(), this.heightLimit(), this.unitCountLimit());
	}
}
