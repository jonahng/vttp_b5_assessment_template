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

		//iterating over the whole csv file
		while((lineRead = bufferedReader.readLine()) != null){
			String[] splitLineRead = lineRead.split(",");
			BikeEntry currentBikeEntry = BikeEntry.toBikeEntry(splitLineRead);
			System.out.println(currentBikeEntry.getMonth());

		}





	}
}
