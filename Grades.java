//=============================================== 
// AUTHOR: Ian Utnehmer  
// COURSE: CS 112 Intro to CS II - Java  
// SECTION: 6/14 
// ASSIGNMENT: Assignment #1  
//=============================================== 

//===============================================  
// Scoring Program
// Program will take in scores of a class and print
// out various results of those scores such as 
// avg, lowest, highest scores
//==============================================

//=============================================== 
// IMPORTS 
//=============================================== 
import java.util.Scanner;
import java.io.File;

public class Grades {
	public static void main(String[] args) throws Exception {
		
		//======================================== 
		// INITIALIZATION AND DECLARATION SECTION 
		//======================================== 
		
		int studentAmount = 1000;
		int testAmount = 1;
		File inputData = new File("input.txt");
		Scanner input = new Scanner(inputData);
		
		//======================================== 
		// INPUT SECTION 
		//========================================
		
		Scores scoreModule = new Scores(studentAmount, testAmount);
		for (int i = 0; i < studentAmount; i++) { 
			for (int x = 0; x < testAmount; x++) { 
				double score = input.nextDouble(); 
				scoreModule.enterScore(i, x, score); // Entering scores
			}
		}
		
		//======================================== 
		// PROCESSING AND OUTPUT SECTION 
		// (Scores that were input into the 
		// scoreModule are now being processed
		// and output using the Score methods)
		//======================================== 
		
		scoreModule.printScores();
		scoreModule.printClassAvg();
		scoreModule.printStudentsAvg();
		scoreModule.printStudentsAvgWithoutLowest();
		scoreModule.printTestsStats();
	}
}
