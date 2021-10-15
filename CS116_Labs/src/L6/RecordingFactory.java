package L6;

import L5.Recording;

public class RecordingFactory {
	private static final int MIN_NUM_DETAILS = 4; //The minimum number of details needed to construct a record
	
	/**
	 * Builds a type of recording based on a deliminated string with all of the associated information
	 * @param stringRecord A deliminated string assumed to be in the order TYPE, NAME, ARTIST, DURATION, ADDITIONAL INFO
	 * @param delim The deliminator string used in the string version of the record
	 * @return The constructed record from the string. Returns a default record if the data couldn't be parsed
	 */
	public static Recording getRecording(String stringRecord, String delim) throws NumberFormatException, NullPointerException, IllegalArgumentException {
		if (stringRecord == null) { throw new NullPointerException("The string version of the record was null"); }
		
		String[] infoList = stringRecord.split(delim);
		
		if (infoList.length < RecordingFactory.MIN_NUM_DETAILS) { throw new IllegalArgumentException("The string record was too short"); }
		
		switch(infoList.length) {
			case 4: return new Recording(infoList[2], infoList[1], Integer.parseInt(infoList[3]));
			case 5: switch (infoList[0]) {
						case "V": return new VideoRecording(infoList[2], infoList[1], Integer.parseInt(infoList[3]), Double.parseDouble(infoList[4]));
						case "A": return new AudioRecording(infoList[2], infoList[1], Integer.parseInt(infoList[3]), Double.parseDouble(infoList[4]));
						default: throw new IllegalArgumentException("Unknown string record format");
					}
			default: throw new IllegalArgumentException("Unknown string record format");
		}
	}
	
	/**
	 * @see getRecording(String stringRecord, String delim)
	 */
	public static Recording getRecording(String stringRecord) throws NumberFormatException {
		return RecordingFactory.getRecording(stringRecord, ",");
	}
}
