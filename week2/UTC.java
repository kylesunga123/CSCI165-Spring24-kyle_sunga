// Import the correct Calendar class here
import java.util.Calendar;



public class UTC{

	// constants for raw time conversion
	// these must be static because they will be called from a "static context" => main
	static final int MILLISECONDS	= 1;
	static final int MIL_PER_SEC	= MILLISECONDS * 1000;
	static final int MIL_PER_MIN	= MIL_PER_SEC  * 60;
	static final int MIL_PER_HOUR	= MIL_PER_MIN  * 60;
	static final int MIL_PER_DAY	= MIL_PER_HOUR * 24;

	public static void main(String[] args) {
		
		// write Calendar code here. Research API for details
		long millis = System.currentTimeMillis();	      							  			// Get the current Unix timestamp in milliseconds
		System.out.println(millis);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

		//Used chat gpt for this section of the problem.
		// get the command line argument, convert to an integer
		int timeZoneOffset = Integer.parseInt(args[0]); 										// Parse the time zone offset from the command line argument
		millis += timeZoneOffset * MIL_PER_HOUR;
		System.out.println("Current Local Time: " + getTimeString(millis));				        // Display the current local time
		// Adjust the timestamp based on the time zone offset
		System.out.println("Current GMT Time: " + getTimeString(System.currentTimeMillis()));					    // Display the current GMT time
	}
		private static String getTimeString(long millis) {									    // Helper method to format time in HH:mm:ss format
		Calendar calendar = Calendar.getInstance();											    // Create a Calendar instance and set its time using the provided timestamp
		calendar.setTimeInMillis(millis);
		return String.format("%02d:%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY),	    // Format the time in HH:mm:ss format
		calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));



	
	}
}

