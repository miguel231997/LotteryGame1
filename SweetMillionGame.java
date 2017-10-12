/**
 * LAB 3 - 
 */
package edu.cuny.csi.csc330.lab3;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import edu.cuny.csi.csc330.lib.*;

public class SweetMillionGame {
	
	// constants  specific to current game - BUT NOT ALL GAMES 
	public final static int DEFAULT_GAME_COUNT = 1; 
	private final static String GAME_NAME = "Miguel's Powerball"; 
	private final static int SELECTION_POOL_SIZE = 40; 
	private final static int SELECTION_COUNT = 6; 
	private int game_array[][] = null;
	private int gameCount;
	private Randomizer randomizer; 
	


	public SweetMillionGame() {
		init(DEFAULT_GAME_COUNT); 
	}
	
	public SweetMillionGame(int games) {
		init(games); 
	}
  

	private void init(int games) {
		randomizer = new Randomizer(); 
		/**
		 * 
		 * Now what ... START FROM HERE 
		 * What additional methods do you need?
		 * What additional data properties/members do you need? 
		 */
		gameCount = games;
		
		game_array = new int[games][SELECTION_COUNT];

		for (int i = 0; i < games; i++) {
			for (int j = 0; j < SELECTION_COUNT; j++) {
				game_array[i][j] = randomizer.generateInt(1,SELECTION_POOL_SIZE);
		}

		Arrays.sort(game_array[i]);
		}
		
		
	}
	


	/**
	 * 
	 */
	public void displayTicket() {
		
		/**
		 * display heading 
		 * 
		 * for i in gameCount 
		 * 		generate selectionCount number of unique random selections in ascending order 
		 * 
		 * display footer 
		 */
		
		
		
		// display ticket heading 
		displayHeading(); 
		
		
		
		/**
		 * Display selected numbers 
		 */
      for (int i = 0; i < gameCount; i++) {
			System.out.printf("(%2d)\t", i + 1);
			for (int j = 0; j < SELECTION_COUNT; j++) {
			System.out.printf("%02d ", game_array[i][j]);
			}
			System.out.println("");
			}

			System.out.println("");
		
		// display ticket footer 
		displayFooter(); 
		
		return;
	}
	
	protected void displayHeading() {
	 
		System.out.println("---------------------------------");
		System.out.println("------ " + GAME_NAME + " ------");

		//System.out.println("");
		Format formatter = new SimpleDateFormat(" EEE MMM dd HH:mm:ss z yyyy");
		System.out.println(formatter.format(new Date()));
		System.out.println("");
	}
	
	protected void displayFooter() {
		System.out.println("-----------(c)My Deli-----------");
		System.out.println("---------------------------------");
	}
	
 
  

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be generated
		//  By default, generate 1  
		int numberOfGames  = 1; 
		if(args.length > 0) {
			numberOfGames = Integer.parseInt(args[0]);
		}
		
		SweetMillionGame game = new SweetMillionGame(numberOfGames);
		// now what 
		 
		game.displayTicket(); 
		
		//System.out.println("Leaving ...");

	}

}