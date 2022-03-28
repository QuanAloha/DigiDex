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
import java.util.Scanner;

public class theMain {

    public static void main(String[] args) throws IOException {
        // Read the csvFile and store it into objects. 
            
            // Ask the user what file the program will be reading 
                System.out.println("What file will DigiDex be converting today? ");

                Scanner userInput = new Scanner(System.in);
                String fileToScan = userInput.next();

                System.out.println("DigiDex will scan the data from " + fileToScan);

            // Read through the file and load contact information into an array
                // Set Up BufferedReader
                    BufferedReader fileReader = new BufferedReader(new FileReader(fileToScan));

                // Gather how many contacts the file needs to make.
                    String firstLine = fileReader.readLine();
                    String[] splitFirstLine = firstLine.split(",");
                    int loopTime = Integer.parseInt(splitFirstLine[0]);
                    System.out.println("The program will scan " + loopTime + " lines.");

            

            // Create an array with that many phones, then loop through the array to store data into each object.
                // Create Phone Array
                Phone phoneArray[] = new Phone[loopTime];

                for (int index = 0; index < phoneArray.length; index++) {
                    // Read in one line and deconstruct it among contact variables
                    String contactLine = fileReader.readLine();
                    String[] contactArray = contactLine.split(",");
                    String employeeFirstName = contactArray[0];
                    String employeeLastName = contactArray[1];
                    int phoneAssetCode = Integer.parseInt(contactArray[2]);
                    int routeNumber = Integer.parseInt(contactArray[3]);

                    // Store this information into a phone object
                    phoneArray[index] = new Phone(employeeFirstName, employeeLastName, phoneAssetCode, routeNumber);
                }
            // System.out.println(Arrays.toString(phoneArray));  // TESTING LINE TO MAKE SURE THE FILE READ CORRECTLY

            // Close active objects.
            fileReader.close();
            userInput.close();

        // Reconstruct the contacts and print the vcf file for the phones.
            // Set up FileWriter
            FileWriter writer = new FileWriter("newDigiDex.vcf");

            // Reconstruct and write contacts to a contact file.
            for (int i = 0; i < phoneArray.length; i++) {           
                writer.write( "BEGIN: VCARD \n" +
                            "VERSION:3.0  \n" +
                            "N:" + phoneArray[i].getEmployeeLastName() + ";" + phoneArray[i].getEmployeeFirstName() + ";;;  \n" +
                            "FN:" + phoneArray[i].getEmployeeName() + "\n" +
                            "ORG:" + phoneArray[i].getRouteNumber() + "\n" +
                            "TEL; TYPE=WORK,MSG: +1" + phoneArray[i].getPhoneNumber() + "\n" +
                            "END: VCARD \n");
            }

            // Close FileWriter
            writer.close();

    }

}