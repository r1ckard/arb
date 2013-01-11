package util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader {

	public String readFile() {
		String fileContent = "";
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("BetFair.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				fileContent += strLine;
				// Print the content on the console
				System.out.println(strLine);
			}

			// Close the input stream
			in.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {
			// in.close();
		}
		return fileContent;
	}
}
