import org.jfree.ui.RefineryUtilities;

/**
 * Testing arraysizes, contains main().
 * 
 * @author pavlosp1967
 */
public class TestClass {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {

		int[] testSize = { 170000 };
		for (int i = 0; i < testSize.length; i++) {
			RecordData.writeTableTitle(testSize[i]);

			final DataSet demo = new DataSet("", testSize[i]);
			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
		}
	}

}
