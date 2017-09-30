import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

/**
 * Creates data sets of random generated numbers that will be sorted.
 * The sorted time is recorded and displayed on a chart.
 * The numbers are stored in a text file as raw data.
 * A table is created as a text file and the table is also printed on the console.  
 */
@SuppressWarnings("serial")
public class DataSet extends ApplicationFrame {

	/**
	 * Instantiates a new data set.
	 *
	 * @param title the size of the array
	 * @param testSize the test size of the array
	 */
	public DataSet(final String title, int testSize) {

		super(title);

		final XYDataset dataset = createDataset(testSize);
		final JFreeChart chart = createChart(dataset, testSize);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1000, 500));
		setContentPane(chartPanel);

	}

	/**
	 * Gets the numbers.
	 *
	 * @param testSize the test size
	 * @return the random numbers
	 */
	private Integer[] getNumbers(int testSize) {

		Integer[] arrayOfInts = new Integer[testSize];
		int k, randomInt;
		for (k = 0; k < testSize; k++) {

			randomInt = (int) (Math.random() * testSize);
			arrayOfInts[k] = randomInt;

		}
		return arrayOfInts;
	}

	/**
	 * Gets random numbers and creates a 2d array of three
	 * running times to calculate the average of them
	 * Adds the average to the XYSeriesCollection to 
	 * create a graph on the screen. 
	 *
	 * @param testSize the test size
	 * @return the XY dataset
	 */
	private XYDataset createDataset(int testSize) {

		long startTime, estimatedTime;
		final XYSeries series = new XYSeries("Size:" + testSize);
		Integer[] arrayOfInts = getNumbers(testSize);

		int tests = 3;
		int numOfRecursions = 300;

		int col = 150;// since it counts every 2 recursions
		// three same capacity arrays with random generated numbers
		long[][] threeTests = new long[col][tests];

		for (int i = 0; i < tests; i++) {
			int index = 0;
			for (int newLim = 2; newLim <= numOfRecursions; newLim += 2) {

				FHsort.setRecursionLimit(newLim);
				startTime = System.nanoTime(); // ------------------ start
				FHsort.quickSort(arrayOfInts);
				estimatedTime = System.nanoTime() - startTime;// --------stop
				threeTests[index][i] = estimatedTime;

				index++;
			}
		}

		System.out.println(RecordData.printHeader(testSize));
		RecordData.writeFileTitle(testSize);

		for (int row = 0; row < threeTests.length; row++) {
			long sumOfEachRow = 0;
			for (int column = 0; column < threeTests[row].length; column++) {
				sumOfEachRow += threeTests[row][column];

			}
			long avg = sumOfEachRow / tests;

			RecordData.writeAvgToFile(testSize, avg);

			// printing table
			System.out.println(RecordData.printResults((row * 2) + 2, avg));

			RecordData.writeTable(testSize,
					RecordData.printResults((row * 2) + 2, avg));

			// adding data to the graph
			series.add(row * 2, avg);
		}

		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		return dataset;

	}

	/**
	 * Creates the chart.
	 *
	 * @param dataset the dataset
	 * @param testSize the test size
	 * @return the chart
	 */
	private JFreeChart createChart(final XYDataset dataset, int testSize) {

		// create the chart...
		final JFreeChart chart = ChartFactory.createXYLineChart(
				"Testing Array of Size: " + testSize, // chart title
				"number of recursions", // x axis label
				"nanoseconds", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
				);

		chart.setBackgroundPaint(Color.WHITE);

		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.black);
		plot.setRangeGridlinePaint(Color.black);

		final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(1, true);
		renderer.setSeriesShapesVisible(0, false);
		plot.setRenderer(renderer);

		// change the auto tick unit selection to integer units only
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;

	}

}
