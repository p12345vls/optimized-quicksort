
project folder:
/pavlosp1967-project09


/pavlosp1967-project09/src/DataSet.java
	- Creates data sets of random generated numbers that will be sorted.
      The sorted time is recorded and displayed on a chart.
 	  The numbers are stored in a text file as raw data.
  	  A table is created as a text file and the table is also printed on the console.

/pavlosp1967-project09/src/FHsort.java
	- Contains optimized quicksort with insertion and setsetRecursionLimit methods.
	
/pavlosp1967-project09/src/RecordData.java
	- Records the data to text files and prints the results on the screen.
	
/pavlosp1967-project09/src/TimeConverter.java
	- Converts duration into a string representation.
	
/pavlosp1967-project09/src/TestClass.java
	- Testing arraysizes, contains main().			

/pavlosp1967-project09/resourses/(_20000_numbers.text up to _1000000_numbers.text) 
	- 22 text files contain the average of three running times of each arraysize.
	
/pavlosp1967-project09/resourses/_Table_20000_numbers.text up to _Table_1000000_numbers.text)
	- 22 text files contain tables of each array testing.

/pavlosp1967-project09/resourses/all_sizes_20000_1000000 .png
	- Graph image generated in excel of all the array sizes tested. With all the array sizes overlaid in this graph we conclude
	  that the running time of each graph follows the same pattern.When the number of recursions is set 
	  up to 10 it takes longer to sort an array regardless the amount of numbers it holds.
	  In the range of 150 to 300 the running time appears more stable.


/pavlosp1967-project09/resourses/four_arraysizes.png
	- Graph image generated in excel showing the running times of arrays with 70,170,270 and 370 thousand
	  elements.From the graph we conclude: When the number of recursions is set up to 10, the time needed
	  to sort an array is the longest. Also we see that the optimal recursion limit lies on the interval that
	  represents limit of 150 to 300 recursions.

/pavlosp1967-project09/resourses/(graph_20000.txt.png,graph_70000.txt.png,graph_220000.txt.png,graph_850000.txt.png)
	- Samples of java generated graphs of various sizes.  

/pavlosp1967-project09/resourses/optimal_limit_interval.png
	- Filtered graph of the four_arraysizes showing the range where the optimal recursion limit lies.
	
RUN.txt
    - console output of TestClass.java 	 
    
README.txt
    - description of submitted files  	

