package vttp.batch5.sdf.task02;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//CODE TO MAKE IT TAKE ARGUMENT IN COMMAND PROMPT:
		File boardFile;
		if(args.length > 0){
			boardFile = new File("task02\\TTT\\" + args[0]);
		}else{
			//Could use system.err.println to show an error message to stop the program. Allowed for default value of board0 when no argument given.
			System.out.println("\nERROR! Restart the program and specify the file name! e.g board1.txt");
			System.out.println("Since nothing was specified, for demo, using board0.txt");
			boardFile = new File("task02\\TTT\\board4.txt");//NOT HARDCODING, Arguments are accepted, but if no argument given, run a defaut.
		}

		//Accessing the board.txt files
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
		System.out.println("\nHere is the TTT Board:\n");
		for(char[] row: board){
			for(char element : row){
				System.out.print(element);
			}
			System.out.println();
		}

		//formatting to make it neater
		System.out.println("");
		
		//Getting the empty spaces where a next move can be played (legal positions to place X)
		String emptySpotCoords = "";
		ArrayList<String> listOfEmptyCoords = new ArrayList<>();
		for(int i = 0; i <3; i ++){
			for(int k = 0; k<3; k++){
				if(board[i][k] == '.'){
					//System.out.println("Available position at: (x=" + k +" , y=" +i +")");
					emptySpotCoords = String.valueOf(k) + i;

					//adds the empty coordinate XY e.g 02 into a list of coordinates of empty spaces.
					listOfEmptyCoords.add(emptySpotCoords);
				}
			}
		}

		//System.out.println(listOfEmptyCoords);


	/* 	positions of each coordinate
		00,10,20
		01,11,21
		02,12,22

		positions of index
		0,1,2
		3,4,5
		6,7,8
		for reference */

		//map to show coordinate for each position
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

		HashMap<String, Integer> boardIndextoCoords = new HashMap<>();
		// 00 refers to x=0,y=0 and 22 refers to x=2,y=2
		boardIndextoCoords.put("00", 0);
		boardIndextoCoords.put("01", 3);
		boardIndextoCoords.put("02", 6);
		boardIndextoCoords.put("10", 1);
		boardIndextoCoords.put("11", 4);
		boardIndextoCoords.put("12", 7);
		boardIndextoCoords.put("20", 2);
		boardIndextoCoords.put("21", 5);
		boardIndextoCoords.put("22", 8);
		/* 	positions of each coordinate
		00,10,20
		01,11,21
		02,12,22

		positions of index
		0,1,2
		3,4,5
		6,7,8
		for reference */


		//iterating through the list of coordinates for empty spaces
		for(String coordinate : listOfEmptyCoords){
			String UtilityValue = " 0";
			//System.out.println(boardIndextoCoords.get(coordinate));
			char[][] newboard = board;
			String[] XYasString = coordinate.split(""); 

			//Getting the x and y coordinates of the specific empty spot
			int xCoord = Integer.valueOf(XYasString[0]);
			int yCoord = Integer.valueOf(XYasString[1]);
			//System.out.println("X coord is:" + xCoord + ",  Y coord is:" + yCoord);

			//creating a new board with the empty spot becoming X;
			newboard[yCoord][xCoord] = 'X';
			
			for(char[] row: newboard){
				for(char element : row){
					//System.out.print(element);
				}
				//System.out.println();
			}
			//System.out.println("\n");

			//CHECK NEW BOARD FOR WIN OR LOSE

			//checking rows for wins for X
			for(int yRow =0; yRow<3; yRow++){
				if(newboard[yRow][0] == newboard[yRow][1] && newboard[yRow][1] == newboard[yRow][2]){
					if(newboard[yRow][0] == 'X'){
						UtilityValue = "+1";

					}
				}
			}
			
			//checking columns for wins for X
			for(int xCol =0; xCol <3; xCol++){
				if(newboard[0][xCol] == newboard[1][xCol] && newboard[1][xCol] == newboard[2][xCol]){
					if(newboard[0][xCol] == 'X'){
						UtilityValue = "+1";
					}
				}
			}

			//checking the diagonal \
			if(newboard[0][0] == newboard[1][1] && newboard[1][1] == newboard[2][2]){
				if(newboard[0][0] == 'X'){
					UtilityValue = "+1";
				}
			}

			// checking the diagonal /
			if(newboard[0][2] == newboard[1][1] && newboard[1][1] == newboard[2][0]){
				if(newboard[0][2] == 'X'){
					UtilityValue = "+1";
				}
			}


			
			//Checking O Values for a O Winning:
			if(!UtilityValue.equals("+1")){
				String OemptySpotCoords = "";
			ArrayList<String> OlistOfEmptyCoords = new ArrayList<>();
			for(int i = 0; i <3; i ++){
			for(int k = 0; k<3; k++){
				if(newboard[i][k] == '.'){
					//System.out.println("Available position for O at: (x=" + k +" , y=" +i +")");
					OemptySpotCoords = String.valueOf(k) + i;

					//adds the empty coordinate XY e.g 02 into a list of coordinates of empty spaces.
					OlistOfEmptyCoords.add(OemptySpotCoords);
				}
			}
		}

		for(String Ocoordinate : OlistOfEmptyCoords){

			//System.out.println(boardIndextoCoords.get(coordinate));
			char[][] Onewboard = newboard;
			String[] OXYasString = Ocoordinate.split(""); 

			//Getting the x and y coordinates of the specific empty spot
			int OxCoord = Integer.valueOf(OXYasString[0]);
			int OyCoord = Integer.valueOf(OXYasString[1]);
			Onewboard[OyCoord][OxCoord] = 'O';
			//System.out.println("OX coord is:" + OxCoord + ",  OY coord is:" + OyCoord);

			for(int OyRow =0; OyRow<3; OyRow++){
				if(Onewboard[OyRow][0] == Onewboard[OyRow][1] && Onewboard[OyRow][1] == Onewboard[OyRow][2]){
					if(Onewboard[OyRow][0] == 'O'){
						UtilityValue = "-1";

					}
				}
			}
			
			//checking columns for wins for O
			for(int OxCol =0; OxCol <3; OxCol++){
				if(Onewboard[0][OxCol] == Onewboard[1][OxCol] && Onewboard[1][OxCol] == Onewboard[2][OxCol]){
					if(Onewboard[0][OxCol] == 'O'){
						UtilityValue = "-1";
					}
				}
			}

			//checking the diagonal \
			if(newboard[0][0] == newboard[1][1] && newboard[1][1] == newboard[2][2]){
				if(newboard[0][0] == 'O'){
					UtilityValue = "-1";
				}
			}

			// checking the diagonal /
			if(newboard[0][2] == newboard[1][1] && newboard[1][1] == newboard[2][0]){
				if(newboard[0][2] == 'O'){
					UtilityValue = "-1";
				}
			}

			Onewboard[OyCoord][OxCoord] = '.';
		}

			}
			
		//END OF O SECTION

			//PRINT OUT THE UTILITY VALUE FOR THE MOVES
			System.out.println("For empty space at:(y =" + yCoord + ", x = " + xCoord+  "),  Utility value is:" + UtilityValue);
			//resets the new board back to normal
			newboard[yCoord][xCoord] = '.';
			
		}
	}
}
