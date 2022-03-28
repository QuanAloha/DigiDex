/**
 * This code takes a csv file and turns it into a file for contacts. 
 * 
 * Each phone has it's own object. 
 * 
 * @author Nathaniel Atwood
 * @version 27MAR2022
 * 
 */


package digiDexMain;

import java.util.Scanner;

public class theMain {

public static void main(String[] args) {
    // Read the csvFile and store it into objects. 
        
        // Ask the user what file the program will be reading 
        System.out.println("What file will I be converting today? ");

        Scanner userInput = new Scanner(System.in);

        String fileToScan = userInput.next();

        System.out.println("I will scan the data from " + fileToScan);

        // Scanner fileReader = new Scanner(new File(fileToScan));



        // ask the user how many contacts they will be creating 
        
        // Create an array with that many phones, then loop through the array to store data into each object. 

    // Print the vcf file for the phones.

        // Loop through the same array to pring out the 

    Phone aPhone = new Phone("Nathaniel Atwood", 123, 555);

    System.out.println(aPhone.toString());
 }

}