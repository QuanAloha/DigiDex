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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class theMain {

public static void main(String[] args) throws IOException {
    // Read the csvFile and store it into objects. 
        
        // Ask the user what file the program will be reading 
        // System.out.println("What file will I be converting today? ");

        // Scanner userInput = new Scanner(System.in);

        // String fileToScan = userInput.next();

        // System.out.println("I will scan the data from " + fileToScan);

        BufferedReader fileReader = new BufferedReader(new FileReader("src/digiDexMain/Sheet2.csv"));

        String firstLine = fileReader.readLine();

        String[] splitFirstLine = firstLine.split(",");

        System.out.println(Arrays.toString(splitFirstLine));

        int loopTime = Integer.parseInt(splitFirstLine[0]);
        
        System.out.println("The program will scan " + loopTime + " lines.");

        

        // Create an array with that many phones, then loop through the array to store data into each object.
        
        Phone phoneArray[] = new Phone[loopTime];

        for (int index = 0; index < phoneArray.length; index++) {

            String contactLine = fileReader.readLine();

            String[] contactArray = contactLine.split(",");

            String employeeName = contactArray[0];

            int phoneAssetCode = Integer.parseInt(contactArray[1]);

            int routeNumber = Integer.parseInt(contactArray[2]);

            phoneArray[index] = new Phone(employeeName, phoneAssetCode, routeNumber);

        }

        System.out.println(Arrays.toString(phoneArray));  // TESTING LINE TO MAKE SURE THE FILE READ CORRECTLY

        fileReader.close();

    // Print the vcf file for the phones.

        // Loop through the same array to print out the object values

        FileWriter writer = new FileWriter("newDigiDex");

        
        for (int i = 0; i < phoneArray.length; i++) {
            
            writer.write("{ \n" +
                        phoneArray[i].getEmployeeName() + "\n" +
                        phoneArray[i].getRouteNumber() + "\n" +
                        phoneArray[i].getPhoneAssetCode() + "\n" +
                        phoneArray[i].getPhoneNumber() + "\n" +
                        "} \n");
        }

        writer.close();


    // userInput.close();
 }

}