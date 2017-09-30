import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Records the data to text files and prints the results on the screen.
 * 
 */
public class RecordData {
	
	/** The Constant OUTPUT_SEPARATOR. */
	private static final String OUTPUT_SEPARATOR = "___________________________________________________________________________________";

	
	/**
	 * Writes file title.
	 *
	 * @param testSize the test size
	 */
	protected static void writeFileTitle(int testSize) {

		String outputFileName = "resources/_" + testSize + "_numbers.text";
		PrintWriter outputStream;

		try {

			outputStream = new PrintWriter(new FileOutputStream(outputFileName));
			outputStream.println("size " + testSize);
			outputStream.close();

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}

	}
	
	/**
	 * Writes table title.
	 *
	 * @param testSize the test size
	 */
	protected static void writeTableTitle(int testSize) {

		String outputFileName = "resources/_Table_" + testSize
				+ "_numbers.text";
		PrintWriter outputStream;

		try {
			outputStream = new PrintWriter(new FileOutputStream(outputFileName));
			outputStream.println(printHeader(testSize));
			outputStream.close();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}

	}
	
	/**
	 * Writes table.
	 *
	 * @param testSize the test size
	 * @param results the results
	 */
	protected static void writeTable(int testSize, String results) {

		String outputFileName = "resources/_Table_" + testSize
				+ "_numbers.text";
		PrintWriter outputStream;

		try {
			outputStream = new PrintWriter(new FileOutputStream(outputFileName,
					true));
			outputStream.println(results);
			outputStream.close();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}

	}
	
	/**
	 * Write average of three time tests to file.
	 *
	 * @param testSize the test size
	 * @param averageOfThree the average of three
	 */
	protected static void writeAvgToFile(int testSize, long averageOfThree) {

		String outputFileName = "resources/_" + testSize + "_numbers.text";
		PrintWriter outputStream;

		try {
			outputStream = new PrintWriter(new FileOutputStream(outputFileName,
					true));
			outputStream.println(averageOfThree);
			outputStream.close();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

	/**
	 * Prints the header of the table
	 *
	 * @param testSize the test size
	 * @return the header of the table
	 */
	protected static String printHeader(int testSize) {

		return ("\n\n\t\t\t\tSIZE: " + testSize + "\n"
				+ "Limit\t    hours    minutes  " + " "
				+ "seconds    millisec    " + " nanosec        total nanosec\n" + OUTPUT_SEPARATOR);

	}

	/**
	 * Prints the results.
	 *
	 * @param newLim the new lim
	 * @param estimatedTime the estimated time
	 * @return the results
	 */
	protected static String printResults(int newLim, long estimatedTime) {
		return String
				.format("  %-5s%s%17s ns\n", newLim,
						TimeConverter.convertTimeToString(estimatedTime),
						estimatedTime)
				+ "\n" + OUTPUT_SEPARATOR;
	}
}
