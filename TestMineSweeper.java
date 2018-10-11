/**
 * This file contains testing methods for the MineSweeper project.
 * These methods are intended to serve several objectives:
 * 1) provide an example of a way to incrementally test your code
 * 2) provide example method calls for the MineSweeper methods
 * 3) provide examples of creating, accessing and modifying arrays
 *    
 * Toward these objectives, the expectation is that part of the 
 * grade for the MineSweeper project is to write some tests and
 * write header comments summarizing the tests that have been written. 
 * Specific places are noted with FIXME but add any other comments 
 * you feel would be useful.
 * 
 * Some of the provided comments within this file explain
 * Java code as they are intended to help you learn Java.  However,
 * your comments and comments in professional code, should
 * summarize the purpose of the code, not explain the meaning
 * of the specific Java constructs.
 *    
 */

import java.util.Random;
import java.util.Scanner;


/**
 * This class contains a few methods for testing methods in the MineSweeper
 * class as they are developed. These methods are all private as they are only
 * intended for use within this class.
 * 
 * @author Jim Williams
 * @author FIXME add your name here when you add tests and comment the tests
 *
 */
public class TestMineSweeper {

    /**
     * This is the main method that runs the various tests. Uncomment the tests
     * when you are ready for them to run.
     * 
     * @param args  (unused)
     */
    public static void main(String [] args) {

        // Milestone 1
        //testing the main loop, promptUser and simplePrintMap, since they have
        //a variety of output, is probably easiest using a tool such as diffchecker.com
        //and comparing to the examples provided.
        //testEraseMap();
        
        // Milestone 2
        //testPlaceMines();
        //testNumNearbyMines();
        //testShowMines();
        //testAllSafeLocationsSwept();
        
        // Milestone 3
        testSweepLocation();
        //testSweepAllNeighbors();
        //testing printMap, due to printed output is probably easiest using a 
        //tool such as diffchecker.com and comparing to the examples provided.
    }
    
    /**
     * This is intended to run some tests on the eraseMap method. 
     * 1. FIXME describe each test in your own words. 
     * 2.
     */
    private static void testEraseMap() {
    	boolean error = false;
    	char [][] map = new char[][] {
    		{'1','1',Config.UNSWEPT,'1','1'},
    		{'1','1','1','1','1'},
    		{'1',Config.UNSWEPT,'1',Config.UNSWEPT,Config.UNSWEPT},
    		{'1',Config.UNSWEPT,'1','1','1'},
    		{'1','1',Config.UNSWEPT,'1','1'}};
    		MineSweeper.eraseMap(map);
    		 for (int i= 0 ; i < map.length ; i++  ) {
    			    for (int j=0 ; j < map[i].length ; j++) {
    			    if (!(map[i][j] == Config.UNSWEPT)) {
    			    	error = true;
    			    }
    			    }
    			    }
    	char [][] map1 = new char[][] {
    	    		{'1',Config.UNSWEPT},
    	    		{'2','3'}};
    	   MineSweeper.eraseMap(map1);
    	    		 for (int i= 0 ; i < map1.length ; i++  ) {
    	    			    for (int j=0 ; j < map1[i].length ; j++) {
    	    			    if (!(map1[i][j] == Config.UNSWEPT)) {
    	    			    	error = true;
    	    			    }
    	    			    }
    	    			    }
    			   
    		 if (error) {
    			System.out.println("Test failed. Expected a blank array containing only Config.Unswept characters, but a non Config.Unswept character was found.");
    		}
    		
    }      
    
    /*
     * Calculate the number of elements in array1 with different values from 
     * those in array2
     */
    private static int getDiffCells(boolean[][] array1, boolean[][] array2) {
        int counter = 0;
        for(int i = 0 ; i < array1.length; i++){
            for(int j = 0 ; j < array1[i].length; j++){
                if(array1[i][j] != array2[i][j]) 
                    counter++;
            }
        }
        return counter;
    }    
    
    /**
     * This runs some tests on the placeMines method. 
     * 1. FIXME describe each test in your own words. 
     * 2.
     */
    private static void testPlaceMines() {
        
    		boolean error = false;
        
        //These expected values were generated with a Random instance set with
        //seed of 123 and MINE_PROBABILITY is 0.2.
        boolean [][] expectedMap = new boolean[][]{
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,false,true,true},
            {false,false,false,false,false},
            {false,false,true,false,false}};
        int expectedNumMines = 3;
            
        Random studentRandGen = new Random( 123);
        boolean [][] studentMap = new boolean[5][5];
        int studentNumMines = MineSweeper.placeMines( studentMap, studentRandGen);
        
        if ( studentNumMines != expectedNumMines) {
            error = true;
            System.out.println("testPlaceMines 1: expectedNumMines=" + expectedNumMines + " studentNumMines=" + studentNumMines);
        }
        int diffCells = getDiffCells( expectedMap, studentMap);
        if ( diffCells != 0) {
            error = true;
            System.out.println("testPlaceMines 2: mine map differs.");
        }

        // Can you think of other tests that would make sure your method works correctly?
        // if so, add them.

        if (error) {
            System.out.println("testPlaceMines: failed");
        } else {
            System.out.println("testPlaceMines: passed");
        }        
        
    }
    
    /**
     * This runs some tests on the numNearbyMines method. 
     * 1. FIXME describe each test in your own words. 
     * 2.
     */
    private static void testNumNearbyMines() {
        boolean error = false;

        boolean [][] mines = new boolean[][]{
            {false,false,true,false,false},
            {false,false,false,false,false},
            {false,true,false,true,true},
            {false,false,false,false,false},
            {false,false,true,false,false}};
        int numNearbyMines = MineSweeper.numNearbyMines( mines, 1, 1);
        
        if ( numNearbyMines != 2) {
            error = true;
            System.out.println("testNumNearbyMines 1: numNearbyMines=" + numNearbyMines + " expected mines=2");
        }
        
       numNearbyMines = MineSweeper.numNearbyMines( mines, 2, 1);
        
        if ( numNearbyMines != 0) {
            error = true;
            System.out.println("testNumNearbyMines 2: numNearbyMines=" + numNearbyMines + " expected mines=0");
        }        
        
        // Can you think of other tests that would make sure your method works correctly?
        // if so, add them.

        if (error) {
            System.out.println("testNumNearbyMines: failed");
        } else {
            System.out.println("testNumNearbyMines: passed");
        }
    }
    
    /**
     * This runs some tests on the showMines method. 
     * 1. FIXME describe each test in your own words. 
     * 2.
     */
    private static void testShowMines() {
        boolean error = false;
        

        boolean [][] mines = new boolean[][]{
            {false,false,true,false,false},
            {false,false,false,false,false},
            {false,true,false,false,false},
            {false,false,false,false,false},
            {false,false,true,false,false}};
            
        char [][] map = new char[mines.length][mines[0].length];
        map[0][2] = Config.UNSWEPT;
        map[2][1] = Config.UNSWEPT;
        map[4][2] = Config.UNSWEPT;
        
        MineSweeper.showMines( map, mines);
        if ( !(map[0][2] == Config.HIDDEN_MINE && map[2][1] == Config.HIDDEN_MINE && map[4][2] == Config.HIDDEN_MINE)) {
            error = true;
            System.out.println("testShowMines 1: a mine not mapped");
        }
        if ( map[0][0] == Config.HIDDEN_MINE || map[0][4] == Config.HIDDEN_MINE || map[4][4] == Config.HIDDEN_MINE) {
            error = true;
            System.out.println("testShowMines 2: unexpected showing of mine.");
        }
        
        // Can you think of other tests that would make sure your method works correctly?
        // if so, add them.

        if (error) {
            System.out.println("testShowMines: failed");
        } else {
            System.out.println("testShowMines: passed");
        }        
    }    
    
    /**
     * This is intended to run some tests on the allSafeLocationsSwept method.
     * 1. Creates a  5x5 mines array containing mines
     * 2. Creates a 5x5 map array, one containing a true case to test(map), and one containing a false case (map1)
     * 3. Tests AllSafeLocationsSwept(), passing the map and mines array as arguments.
     * 4. Test 1, using mines and map arrays, should return true if the method is working.
     * 5. Test 2, using mines and map1 arrays, should return false if the method is working, as there is a Config.UNSWEPT 
     * character located in a position without a mine.
     */
    
    private static void testAllSafeLocationsSwept() {
    	 boolean [][] mines = new boolean[][]{
             {false,false,true,false,false},
             {false,false,false,false,false},
             {false,true,false,true,true},
             {false,false,false,false,false},
             {false,false,true,false,false}};
       
    char [][] map = new char[][] {
    			{'1','1',Config.UNSWEPT,'1','1'},
    			{'1','1','1','1','1'},
    			{'1',Config.UNSWEPT,'1',Config.UNSWEPT,Config.UNSWEPT},
    			{'1','1','1','1','1'},
    			{'1','1',Config.UNSWEPT,'1','1'}}; 
    			//true case. If method works, this should return true, that all safe locations have been swept.
    	
    char [][] map1 = new char[][] {
        		{'1','1',Config.UNSWEPT,'1','1'},
        		{'1','1','1','1','1'},
        		{'1',Config.UNSWEPT,'1',Config.UNSWEPT,Config.UNSWEPT},
        		{'1',Config.UNSWEPT,'1','1','1'},
        		{'1','1',Config.UNSWEPT,'1','1'}}; 
        		//false case. If method works, this should return false, because there is still a spot without a mine that hasnt been swept.
    
    
    int testsPassed = 0;
    if (MineSweeper.allSafeLocationsSwept(map,mines) == true) {
    		testsPassed += 1;
    }
    if (MineSweeper.allSafeLocationsSwept(map,mines) == false) {
    	 System.out.println("Test failed. Expected allSafe = true, method incorrectly returned false.");
    }
    if (MineSweeper.allSafeLocationsSwept(map1,mines) == false) {
		testsPassed += 1;
    }
    if (MineSweeper.allSafeLocationsSwept(map1,mines) == true) {
	 System.out.println("Test failed. Expected allSafe = false, method incorrectly returned true.");
    }
    if (testsPassed == 2) {
    	System.out.println("All tests passed.");
    }
    	
    
    }

    
    /**
     * This is intended to run some tests on the sweepLocation method. 
     * 1. Test 1 checks spot 2,2 on the array. which should return 2 if the method is working.
     * 2. Test 2 checks spot 3,3 on the array, which should return 3 if the method is working.
     * 3. Test 3 checks the spot of a previously swept location, which should return 0 if the method is working.
     * 4. Test 4 checks the out of array bounds case, which should return -3 if the method is working.
     */
    
    private static void testSweepLocation() {
    	boolean [][] mines = new boolean[][]{
            {false,false,true,false,false},
            {false,false,false,false,false},
            {false,true,false,true,true},
            {false,false,false,false,false},
            {false,false,true,false,false}}; 
   
    char [][] map = new char[][] {
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT}}; 
    int testPasses = 0;
    MineSweeper.sweepLocation(map, mines,2,2);
    if (map[2][2] == '2') {
    	testPasses += 1;
    	}
    if (!(map[2][2] == '2')) {
    	System.out.println("Test 1 failed. Expected 1 nearby mine(s) at row 2 column 2, but method did not return 1");
    	}
    
    
    
    MineSweeper.sweepLocation(map, mines,3,3);
    if (map[3][3] == '3') {
    	testPasses += 1;
    	}
    if (!(map[3][3] == '3')) {
    
    	System.out.println("Test 2 failed. Expected 2 nearby mine(s) at row 3 column 3, but method did not return 2");
    	}
  
   
    
    
    if (MineSweeper.sweepLocation(map, mines,2,2) == -2) {
    	testPasses += 1;
    	}
    if (!(MineSweeper.sweepLocation(map, mines,2,2) == -2)) {
    	System.out.println("Test 3 failed. Expected a return value of -2 when given a previously swept location.");
    	}
    
    
    
    
    
if (MineSweeper.sweepLocation(map,mines,6,6) == -3) {
testPasses += 1;
}
if (!(MineSweeper.sweepLocation(map, mines,6,6) == -3)) {
	System.out.println("Test 4 failed. Expected a return value of -3 when given a out of bounds location to sweep.");
	}
  
    
    
    
    if ( testPasses == 4) {
    	System.out.println("All tests passed.");
    }
    
    }      
    
    /**
     * This is intended to run some tests on the sweepAllNeighbors method. 
     * 1. FIXME describe each test in your own words. 
     * 2.
     */
    private static void testSweepAllNeighbors() {
     	boolean [][] mines = new boolean[][]{
            {false,false,true,false,false},
            {false,false,false,false,false},
            {false,true,false,true,true},
            {false,false,false,false,false},
            {false,false,true,false,false}}; 
       char [][] map = new char[][] {
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT},
    			{Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT,Config.UNSWEPT}};
    	   boolean [][] mines1 = new boolean[][]{
    	        {false,false,true,false,false},
    	        {false,false,false,false,false},
    	        {true,false,false,false,true},
    	        {false,false,false,false,false},
    	        {false,false,true,false,false}}; 
    	   int testPasses = 0;
    			
    			
    			
   
     MineSweeper.sweepAllNeighbors(map, mines, 0, 0);       
    if (map[0][1] == '1' && map[1][0] == '1' && map[1][1] == '2' ) {
    	testPasses += 1;
    	}
    else {
    	System.out.println("Test 1 failed. Expected the 4 surrounding locations at 0,0 to contain 1,1, and 2, but the map did not have those.");
    }
    MineSweeper.eraseMap(map);
    MineSweeper.sweepAllNeighbors(map, mines1,2,2);
    if (map[1][1] == '2' && map[1][2]  == '1' && map[1][3] == '2' && map[2][1] == '1' 
    		&& map[2][3] == '1' && map[3][1] == '2' && map[3][2] == '1' && map[3][3] == '2') {
    	 
    	testPasses += 1;
    }
    else {

    
    	System.out.println("Test 2 failed. Expected the 8 surrounding locations of map[2][2] to contain 0, and [2][2] to contain the no nearby mine character, but it doesnt.");
    }
    if (testPasses == 2) {
    	System.out.println("All tests passed.");
    }
  
    }      
}