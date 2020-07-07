import java.lang.Math;
public class Scores { 
	private double[][] arrStudent;
	private int students;
	private int tests;
	private double classSum;
	private double studentSum;
	private String formatTest; // so our output looks nicer
	private double studentLowest;
	private double testSum;
	private double deviation;
	private double[] testAverages;
	// Initializing 
	public Scores(int numberOfStudents, int numberOfTests) {
		students = numberOfStudents;
		tests = numberOfTests;
		arrStudent = new double[students][tests];
		classSum = 0;
		studentSum = 0;
		formatTest = "Test";
		// We'll compare this value to all of the scores 
		// that the student received.
		studentLowest = 100; 
		testSum = 0;
		deviation = 0;
		testAverages = new double[tests];
		
	}
	
	public void printScores() {
		for (int x = 0; x < arrStudent.length; x++) { // For each student
			// Add 1 to current student so we can start at 1 rather than 0
			System.out.println("\nStudent " + (x + 1) + " scores"); 
			for (int i = 0; i < arrStudent[0].length; i++) { // For each test
				// Same thing here, except for student tests
				System.out.printf("%10s #" + (i + 1) + ": %.2f", formatTest, arrStudent[x][i]);
				
			}
			System.out.println(); // Separate previous student from current student
		}
	}
	
	public void printClassAvg() {
		System.out.printf("\nClass avg is: %.2f \n", (classSum/(students*tests))); // Divides sum by total # of tests for avg
	}
	
	public void printStudentsAvg() {
		for (int i = 0; i < arrStudent.length; i++) {
			studentSum = 0; // Reset sum so current student starts at 0
			for (int x = 0; x < arrStudent[0].length; x++) {
				studentSum += arrStudent[i][x];
			}
			System.out.printf("Student " + (i + 1) + " avg score: %.2f\n", studentSum/tests);
		}
	}
	
	public void printStudentsAvgWithoutLowest() {
		// Make a new line to separate this chunk of data
		// from the previous chunk
		System.out.println(); 
		for (int i = 0; i < arrStudent.length; i++) {
			studentLowest = 100;  // Reset lowest score for current student
			studentSum = 0; // Reset sum for current student
			for (int x = 0; x < arrStudent[0].length; x++) { // Compare the max possible score, 100, to the 
				// current score of the student. If the current score is < than the largest possible, set
				// lowest score to the current score.
				if (arrStudent[i][x] < studentLowest) {
					studentLowest = arrStudent[i][x];
				}
			}
			// Take the lowest score of the current student 
			// and subtract it from the sum
			for (int z = 0; z < arrStudent[0].length; z++) { 
				studentSum += arrStudent[i][z];
			}
			studentSum -= studentLowest; // Remove lowest score from sum
			// Divide the current student sum by the new test amount, 4, to get the new avg
			System.out.printf("Student " + (i + 1) + " avg w/out lowest: %.2f\n", studentSum/4);
		}
			
	}

	public void printTestsStats() {
		System.out.println();
		for (int i = 0; i < arrStudent[0].length; i++) {
			testSum = 0; // Reset sum to 0 for current test
			for (int x = 0; x < arrStudent.length; x++) {
				testSum += arrStudent[x][i]; // Store sum of scores for current test 
			}
			testAverages[i] = ((testSum)/(arrStudent.length)); // Store average of current test in an array
		}
		for (int x = 0; x < arrStudent[0].length; x++) {
			deviation = 0; // Reset deviation to 0 for current test's deviation
			for (int i = 0; i < arrStudent.length; i++) {
				deviation += (arrStudent[i][x] - testAverages[x])*(arrStudent[i][x] - testAverages[x]); // deviation formula
			}
			deviation = (deviation/arrStudent.length);
			deviation = Math.sqrt(deviation);
			System.out.printf("Test #" + (x + 1) + " avg: %.2f with std Deviation: %.2f\n", testAverages[x], deviation);
		}
		
	}
	
	public void enterScore(int idxStudent, int idxTest, double fScore) { 
		// Self-explanatory setting of scores for the corresponding student and test
		int Student = idxStudent;
		int Test = idxTest;
		double Score = fScore;
		arrStudent[Student][Test] = Score;
		classSum += Score; // Sum of all scores for calculating class avg later
	}
}
