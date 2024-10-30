package vttp.batch5.sdf.task02;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//CODE TO MAKE IT TAKE ARGUMENT:
		File boardFile;
		if(args.length > 0){
			boardFile = new File("task02\\TTT\\" + args[0]);
		}else{
			System.out.println("Restart the program and specify the file name! e.g board1.txt");
			System.out.println("Since nothing was specified, for demo, using board0.txt");
			boardFile = new File("task02\\TTT\\board0.txt");
		}

		//File boardFile = new File("task02\\TTT\\board0.txt");
		FileReader fileReader = new FileReader(boardFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String lineRead;
/* 		while ((lineRead = bufferedReader.readLine()) != null) {
			System.out.println(bufferedReader.readLine());
		} */

		System.out.println(bufferedReader.readLine());
		System.out.println(bufferedReader.readLine());
		System.out.println(bufferedReader.readLine());
		

		//REPLACE THIS WITH THE CODE THAT TAKES IN ARGUMENT!




	}
}
