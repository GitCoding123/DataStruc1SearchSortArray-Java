import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * COP 3530: Project - Array Searches and Sorts
 * 
 * Project1 class includes methods to read in a csv file,
 * creating state objects using the data in the file to set and get attributes
 *  for an object, and creating an array of State objects in which we can sort and search based on category
 * 
 * @author Brian Gerkens
 * @version 9/17/21
 */

public class Project1 {

	/**
	 * The main method includes while loops to prompt user for the file name
	 * input until the correct file name is entered. It also prints a number
	 * menu that will keep re-printing until option '7' is entered, which
	 * exits the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int nElems = 50;
		int index = 0;
		String line = "";
		boolean running = true;
		State[] stateArray = new State[50];
		Scanner scan = new Scanner(System.in);
		
		
		printHeader();
		System.out.println("Enter the file name: ");
		
		while(running) {
			String fileName = scan.next();
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				System.out.println("\nThere were 50 records found.\n");
				
								
				 
				String headLine = br.readLine();						//This line will get rid of the first row(headers) of the file.
				while((line = br.readLine()) != null) {
					//set 
					String[] attributes = line.split(",");
					//parse data from file
					String name = attributes[0];
					String capitol = attributes[1];
					String region = attributes[2];
					int usHouseSeats = Integer.parseInt(attributes[3]);
					int population = Integer.parseInt(attributes[4]);
					double covidCases = Double.parseDouble(attributes[5]);
					double covidDeaths = Double.parseDouble(attributes[6]);
					int income = Integer.parseInt(attributes[7]);
					double crimeRate = Double.parseDouble(attributes[8]);
					double CFR = covidCases / covidDeaths;
					double caseRate = covidCases / population * 100000;
					double deathRate = covidDeaths / population * 100000;
					//create state objects from parsed attributes.
					State state = new State(name, capitol, region, usHouseSeats, population, covidCases, 
											covidDeaths, income, crimeRate, CFR, caseRate, deathRate);
					// set states into state array.
					stateArray[index] = state;
					index += 1;
				}
				running = false;	
			}
			catch (FileNotFoundException e) {
				System.out.println("YIKES!!! Incorrect file name. Please try again.\nEnter the file name: ");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}

		running = true;
		int menuNumber = 0;
		int j;
		while(running) {
			printMenu();
			try {
				menuNumber = scan.nextInt();
			}
			catch(InputMismatchException e) {
				scan.next();
			}
			if(menuNumber == 1) {
				//States report contains custom data
				printStatesReport(stateArray);
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 2) {
				//name bubble sort contains custom data	
				nameBubbleSort(stateArray);
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 3) {
				// selection sort for cfr contains custom data
				cfrSelectionSort(stateArray);
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 4) {
				//insertion sort for income contains custom data
				mhiInsertionSort(stateArray);
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 5) {
				
				
				String name = scan.next();
				int searchKey = 0;
				
				for(j = 0; j < nElems; j++) {
					if (stateArray[j].getName() == name) {
						findAndPrintState(stateArray, searchKey);
					}
				}
				if (j == nElems) {
					System.out.println("Cannot find " + searchKey + " in array.");
					continue;
				}
			
				
				
//				boolean run = true;
//				try {	
//					while(run) {
//						System.out.println("Enter state name: ");
//						String findState = scan.next();
//						if(findState == stateArray[0].getName()) {		//if we have a correct state name,
//																		//then search for that state object by calling the findAndPrintState().
//							findAndPrintState(stateArray);
//							run = false;
//						}
//					}
//				} 
//				catch(Exception e) {
//					System.out.println("YIKES!!! Not a valid entry!!\nPlease try again: ");
//				}
				
				// this method is not created yet
				
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 6) {
				//this method is not created yet
				printSpearmans();
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 7) {
				System.out.println("File closed.\nProgram terminated.");
				scan.close();
				running = false;
			}
			else {
				System.out.println("\nYIKES!!!\nInvalid entry. Please try again: \n");
			}	
		}	
	}
	/**
	 * 
	 */
	public static void printHeader() {
		System.out.println("COP3530 Project 1\nInstructor: Xudong Liu\n");
		System.out.println("Array Searches and Sorts");
	}
	/**
	 * 
	 */
	public static void printMenu() {
		System.out.println("1. Print a States report\n2. Sort by name\n3. Sort by Case Fatality Rate");
		System.out.println("4. Sort by Median Household Income\n5. Find and print a given State");
		System.out.println("6. Find Spearman's Rho Matrix\n7. Quit\n\nPlease enter your choice: ");
	}
	/**
	 * printStatesReport() is a method for printing out a a full report 
	 * of all 50 states. 
	 * 
	 */
	public static void printStatesReport(State[] stateArray) {
//		System.out.println("Name   MHI   VCR   CFR   Case Rate   Death Rate");
//		for (int i = 0; i < 50; i++) {
//			System.out.print("-");
//		}
//		
//		System.out.println();
		System.out.printf("%-15s%-15s%-18s%-17s%-15s%-15s%-15s%-15s%-15s%-20s%-20s%-20s%n",
						"Name", "Capitol", "Region", "US House Seats", "Population", "Covid Cases",
						"Covid Deaths", "Income", "Crime Rate", "CFR", "Case Rate", "Death Rate");
		for (int i = 0; i < stateArray.length; i++) { 
			System.out.print("-"); 
			System.out.printf("%-15s%-15s%-18s%-17s%-15s%-15s%-15s%-15s%-15s%-20s%-20s%-20s%n", stateArray[i].getName(),
					stateArray[i].getCapitol(), stateArray[i].getRegion(), stateArray[i].getUsHouseSeats(), 
					stateArray[i].getPopulation(), stateArray[i].getCovidCases(), stateArray[i].getCovidDeaths(),
					stateArray[i].getIncome(), stateArray[i].getCrimeRate(), String.format("%.6f", stateArray[i].getCFR()),
					String.format("%.2f", stateArray[i].getCaseRate()), String.format("%.2f", stateArray[i].getDeathRate()));
		}		  
	}
	/**
	 * nameBubbleSort() is a method that will alphabetically sort
	 * an array of objects by their state name. 
	 * 
	 * @param State[] stateArray
	 */
	public static void nameBubbleSort(State[] stateArray) {
	
		State temp;
		int j;
		int i = 0;
	
		for(j = 0; j < stateArray.length; j++) {
			for(i = j + 1; i < stateArray.length; i++) {
				if(stateArray[i].compareTo(stateArray[j]) < 0) {
					temp = stateArray[j];
					stateArray[j] = stateArray[i];
					stateArray[i] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("States sorted by name.");	
	}
	/**
	 * cfrSelectionSort() is a method that sorts the covid fatality rate
	 * ascendingly by state. 
	 * 
	 * @param State[] cfr
	 */
	public static void cfrSelectionSort(State[] cfr) {
		
		int size = 50;
		int i;
		int lowest;
	
		for(int j = 0; j < size - 1; j++) {
			lowest = j;
			for(i = j + 1; i < cfr.length; i++) {
				if(cfr[i].getCFR() < cfr[lowest].getCFR()) {
					lowest = i;
				}
			}
			if (lowest != j) {
				State temp = cfr[lowest];
				cfr[lowest] = cfr[j];
				cfr[j] = temp;		
			}
		}
		System.out.println();
		System.out.println("States sorted by Covid Fatality Rate.");
	}
	/**
	 * mhiInsertionSort() is a method to sort the median household income
	 * ascendingly.
	 * 
	 * @param State[] mhi
	 */
	public static void mhiInsertionSort(State[] mhi) {
		
		int size = 50;
		int i;
		int j;
		State temp;
		
		for(j = 1; j < size; j++) {
			temp = mhi[j];
			i = j - 1;
			while(i >= 0 && mhi[i].getIncome() > temp.getIncome()) {
				mhi[i + 1] = mhi[i];
				i--;
				mhi[i + 1]= temp;
			}
		}
		System.out.println();
		System.out.println("States sorted by Median Household Income.");
	}	/**
	 * findAndPrintState() is supposed to be a method which includes both
	 * a binary search and sequential search. Binary if data is sorted by name,
	 * sequential otherwise.
	 * 
	 * @param
	 */
	public static int findAndPrintState(State[] stateObj, int searchKey) {
		int nElems = 50;
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		
		
			while (true) {
				curIn = (lowerBound + upperBound) / 2;
				if(stateObj[curIn]. == searchKey) {
					return curIn;
				}
				else if (lowerBound > upperBound) {
					return nElems;
					}
				else {
					if (stateObj[curIn] < searchKey) {
						lowerBound = curIn + 1;
					}
					else {
						upperBound = curIn - 1;
					}
				}
			}
		
	}
	/**
	 * printSpearmans() is supposed to be a method that prints spearman's 
	 * rho matrix which compares income, crime rate, case rate, and death rate.
	 * 
	 */
	public static void printSpearmans() {
		
	}
	
	
}
