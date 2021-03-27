

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class gives a method for reading a Maze file and returning it as a Maze object.
 * You should not edit this file.
 *
 */
public class MazeReader {

	public static Maze readMazeFromFile(String filename) {

		Maze outputMaze = null;
		boolean fileFound = false;
		try {
			Scanner in = new Scanner(new FileReader(filename));
			int N = in.nextInt();
			int startX = in.nextInt();
			int startY = in.nextInt();
			int endX = in.nextInt();
			int endY = in.nextInt();
			in.nextLine(); // reads the end-of-line after the last int parameter to consume it from the input stream
			
			char[][] m = new char[N][N];
			for (int i=0; i<N; i++) 
				m[i] = in.nextLine().trim().toCharArray();
			
			outputMaze = new Maze(N, startX, startY, endX, endY, m);
			fileFound = true;
			in.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("File " + filename + " not found. Ensure that it is in the correct folder/directory.");
			e.printStackTrace();
		}
		
		if (fileFound && outputMaze == null) System.err.println(filename + " was found but no maze found in file.");
		return outputMaze;			
		
	}
	
}
