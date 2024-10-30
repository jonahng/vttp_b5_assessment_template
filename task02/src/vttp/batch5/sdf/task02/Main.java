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

		FileReader fileReader = new FileReader(boardFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String lineRead;

		//Turning the board into a 2d array
		char[][] board = {{0, 1, 2},{3, 4, 5},{6, 7, 8}};
		
		//adding each row from the board.txt file to the array
		char[] firstLine = bufferedReader.readLine().toCharArray();
		board[0] = firstLine;
		char[] secondLine = bufferedReader.readLine().toCharArray();
		board[1] = secondLine;
		char[] thirdLine = bufferedReader.readLine().toCharArray();
		board[2] = thirdLine;
		
		//printing out the 2d array to show the tic tac toe board
		for(char[] row: board){
			for(char element : row){
				System.out.print(element);
			}
			System.out.println();
		}
		
	
		

	/* 	positions of each coordinate
		00,10,20
		01,11,21
		02,12,22

		positions of index
		0,1,2
		3,4,5
		6,7,8
		for reference */

		HashMap<Integer, String> coordinateMap = new HashMap<>();
		coordinateMap.put(0, "(x=0, y=0)");
		coordinateMap.put(1, "(x=1, y=0)");
		coordinateMap.put(2, "(x=2, y=0)");
		coordinateMap.put(3, "(x=0, y=1)");
		coordinateMap.put(4, "(x=1, y=1)");
		coordinateMap.put(5, "(x=2, y=1)");
		coordinateMap.put(6, "(x=0, y=2)");
		coordinateMap.put(7, "(x=1, y=2)");
		coordinateMap.put(8, "(x=2, y=2)");


	}
}
