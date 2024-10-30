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





	}
}
