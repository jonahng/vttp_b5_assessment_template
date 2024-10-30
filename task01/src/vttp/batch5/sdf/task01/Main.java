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
		//System.out.println(listOfKeys);

		//creating map for the words highest...fifth highest
		HashMap<Integer,String> PositionsToStringMap = new HashMap<>();
		PositionsToStringMap.put(0, "highest");
		PositionsToStringMap.put(1, "second highest");
		PositionsToStringMap.put(2, "third highest");
		PositionsToStringMap.put(3, "fourth highest");
		PositionsToStringMap.put(4, "fifth highest");

		//creating map for weather
		HashMap<Integer,String> Weather = new HashMap<>();
		Weather.put(1,"Clear, Few clouds, Partly cloudy, Partly cloudy.");
		Weather.put(2,"Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist.");
		Weather.put(3,"Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds.");
		Weather.put(4,"Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog.");

		//trying highest day:
		BikeEntry highestDay = MapOfBikeEntry.get(listOfKeys.get(0));

		//printing out:
/* 		System.out.println("For the highest day, the season was: " + 
		highestDay.getSeason() + "and the total number of cyclists was" +
		String.valueOf(highestDay.getCasual()+highestDay.getRegistered()) +
		"The day was:" + Utilities.toWeekday(highestDay.getWeekday())); */


		//iterating through the 5 highest entries
		for(int i = 0; i<5; i++){
			//getting the bikeEntry instance from the map, using the key of the totalCyclists
			BikeEntry highestEntries = MapOfBikeEntry.get(listOfKeys.get(i));
			int combinedCyclists = highestEntries.getCasual()+highestEntries.getRegistered();
			String holidayStatus = "";
			if(highestEntries.isHoliday()){
				holidayStatus = "a holiday!";
			}else{
				holidayStatus = "not a holiday";
			}


			//printing out the statements
			//THIS COULD BE DONE WITH System.out.printf and %s %d etc, however doing it with println feels easier to format.
			System.out.println("\nThe " + PositionsToStringMap.get(i) + "(position) recorded number of cyclists was in \n" +
			Utilities.toSeason(highestEntries.getSeason()) + "(season), on a " + Utilities.toWeekday(highestEntries.getWeekday()) +
			"(day) in the month of " + Utilities.toMonth(highestEntries.getMonth()) + "(month).\nThere were a total of " + combinedCyclists +
			"(total) cyclists. The weather \nwas " + Weather.get(highestEntries.getWeather()) + "(weather)\n" + Utilities.toWeekday(highestEntries.getWeekday()) + "(day) was " + holidayStatus  + "(holiday)\n");

		}
/* 		System.out.println(The <POSITION> recorded number of cyclists was in
		<SEASON>, on a <DAY> in the month of <MONTH>.
		There was a total of <TOTAL> Cyclists. The weater was <WEATHER>
		<Day> was <Holiday>. */

	}
}
