package vttp.batch5.sdf.task01;

import java.io.*;
import java.util.*;

import vttp.batch5.sdf.task01.models.BikeEntry;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) throws IOException {

		//Access the data in the day.csv file
		File csvFile = new File("task01\\day.csv");
		FileReader fileReader = new FileReader(csvFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String lineRead;

		//skipping over the first row of header
		System.out.println(bufferedReader.readLine());

		//creating Hashmap to store the totalCyclistsDaily and the respective BikeEntry
		HashMap<Integer, BikeEntry> MapOfBikeEntry = new HashMap<>();

		//iterating over the whole csv file
		while((lineRead = bufferedReader.readLine()) != null){
			String[] splitLineRead = lineRead.split(",");

			//creating instance of BikeEntry
			BikeEntry currentBikeEntry = BikeEntry.toBikeEntry(splitLineRead);
			//System.out.println(currentBikeEntry.getMonth());

			int currentDayTotalCyclists = currentBikeEntry.getCasual() + currentBikeEntry.getRegistered();
			//System.out.println("Total Cyclists for the current day is:" + currentDayTotalCyclists);
			MapOfBikeEntry.put(currentDayTotalCyclists, currentBikeEntry);
			

		}

		//Getting the list of currentDayTotalCyclists and sorting them in descending order. The number can the be referenced from the hashmap
		List<Integer> listOfKeys = new ArrayList<>(MapOfBikeEntry.keySet());
		Collections.sort(listOfKeys,Collections.reverseOrder());
		System.out.println(listOfKeys);

		HashMap<Integer,String> PositionsToStringMap = new HashMap<>();
		PositionsToStringMap.put(0, "highest");
		PositionsToStringMap.put(1, "second highest");
		PositionsToStringMap.put(2, "third highest");
		PositionsToStringMap.put(3, "fourth highest");
		PositionsToStringMap.put(4, "fifth highest");


		//trying highest day:
		BikeEntry highestDay = MapOfBikeEntry.get(listOfKeys.get(0));

		//printing out:
		System.out.println("For the highest day, the season was: " + 
		highestDay.getSeason() + "and the total number of cyclists was" +
		String.valueOf(highestDay.getCasual()+highestDay.getRegistered()) +
		"The day was:" + Utilities.toWeekday(highestDay.getWeekday()));


		//iterating through the 5 highest entries
		for(int i = 0; i<5; i++){
			//getting the bikeEntry instance from the map, using the key of the totalCyclists
			BikeEntry highestEntries = MapOfBikeEntry.get(listOfKeys.get(i));


			//printing out the statements
			System.out.println("The " + PositionsToStringMap.get(i) + " recorded number of cyclists was in \n" +
			Utilities.toSeason(highestEntries.getSeason()) + ", on a " + Utilities.toWeekday(highestEntries.getWeekday()) +
			" in the month of " + Utilities.toMonth(highestEntries.getMonth()) + ".\n There were a total of " + highestEntries.getCasual()+highestEntries.getRegistered() +
			" cyclists. The weather \n was " + highestEntries.getWeather() + "\n" + Utilities.toWeekday(highestEntries.getWeekday()) + " was a" + highestEntries.isHoliday()  + "\n");




		}
/* 		System.out.println(The <POSITION> recorded number of cyclists was in
		<SEASON>, on a <DAY> in the month of <MONTH>.
		There was a total of <TOTAL> Cyclists. The weater was <WEATHER>
		<Day> was <Holiday>. */

	}
}
