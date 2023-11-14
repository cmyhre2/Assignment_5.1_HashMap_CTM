/**
 * This class reads the words & dictionary files and pairs the first line of each in a dictionary
 * and the next line and so on until all lines have been paired up. Then a Hash Table stores all
 * the words and their dictionaries for easy access. The whole dictionary is printed, then 5 words
 * will be searched then the key/value pairs + hashkey of each word is printed.
 * 
 * @author Chris Myhre
 * @version 1.0 (CS-215 Module 5 Lab 1)
 * Fall 2023 (11/15/2023)
 */
import java.io.File;//for opening files
import java.io.FileNotFoundException;//for when files aren't found
import java.util.Scanner;//for the reading of each line in the files
import java.util.HashMap;//for pairing each line of thte words file with the corresponding line on the definitions file
public class Application {
		
	public static void main(String[]args) {
		File words = new File("Dictionary Words.txt");//opens the words file
		File definitions = new File("Dictionary Definitions.txt");//opens the definitions file
		HashMap<String, String> dictionary = new HashMap<String, String>();
		/*
		 * try block to attempt to run the following code incase a FileNotFound Exception is detected
		 */
		try {
			Scanner scanWords = new Scanner(words);//reader for the words file
			Scanner scanDefinitions = new Scanner(definitions);//reader for the definitions file
			/*
			 * while loop to load each word with its definition into the HashMap while there are lines to put into the HashMap
			 */
			while (scanWords.hasNextLine() && scanDefinitions.hasNextLine()) {
				dictionary.put(scanWords.nextLine(), scanDefinitions.nextLine());
			}//end while loop
			scanWords.close();//closes the words file
			scanDefinitions.close();//closes the definitions file
		}//end try block
		/*
		 * catch block to tell the user if the files attempting to be used weren't found
		 */
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}//end catch block
		
		/*
		 * Description of the 6 lines of code below
		 * Line 1: Prints the entire dictionary
		 * Lines 2-6: Prints Each of the selected words (aka their keys), their definitions (aka their values) and their hashkeys.
		 */
		System.out.println(dictionary);
		System.out.println("Word 1 Dictionary key/value pair: fare / " + dictionary.get("fare") + ", Word hashkey: " + dictionary.get("fare").hashCode());
		System.out.println("Word 2 Dictionary key/value pair: sables / " + dictionary.get("sables") + ", Word hashkey: " + dictionary.get("sables").hashCode());
		System.out.println("Word 3 Dictionary key/value pair: forsooth / " + dictionary.get("forsooth") + ", Word hashkey: " + dictionary.get("forsooth").hashCode());
		System.out.println("Word 4 Dictionary key/value pair: glim / " + dictionary.get("glim") + ", Word hashkey: " + dictionary.get("glim").hashCode());
		System.out.println("Word 5 Dictionary key/value pair: chapman / " + dictionary.get("chapman") + ", Word hashkey: " + dictionary.get("chapman").hashCode());
	}//end main()
}//end Application class
