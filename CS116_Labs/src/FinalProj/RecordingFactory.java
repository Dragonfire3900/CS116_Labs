package FinalProj;


public class RecordingFactory {

	private static final int MIN_NUM_DETAILS = 4; //The minimum number of details needed to construct a record
	protected static final String DEF_DELIM = " ";
	
	public static Recording build(String stringRecord, String delim) throws MalformedRecording {
		if (stringRecord == null) { throw new NullPointerException("The string version of the record was null"); }
		
		String[] infoList = stringRecord.split(delim);
		
		if (infoList.length < RecordingFactory.MIN_NUM_DETAILS) { throw new MalformedRecording("The string recording didn't have enough info"); }
		
		switch(infoList.length) {
			case 5: switch (infoList[0]) {
						case "V": return new VideoRecording(infoList[2], infoList[1], Integer.parseInt(infoList[3]), Double.parseDouble(infoList[4]));
						case "A": return new AudioRecording(infoList[2], infoList[1], Integer.parseInt(infoList[3]), Double.parseDouble(infoList[4]));
						default: throw new IllegalArgumentException("Unknown string record format");
					}
			default: throw new MalformedRecording("Unknown string record format");
		}
	}
	
	public static Recording build(String stringRecord) {
		return RecordingFactory.build(stringRecord, RecordingFactory.DEF_DELIM);
	}
}
