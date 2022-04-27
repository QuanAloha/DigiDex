package app;

import java.io.BufferedReader;
import java.util.Scanner;

public class AppState {
    // FIELDS
    private List<Phone> phoneBook;

    // CONSTRUCTOR
    public AppState() {
        this.phoneBook = new ArrayList<Phone>();

        // Set Up BufferedReader, FileWriter, Scanner
        BufferedReader fileReader = new BufferedReader(new FileReader(fileToScan));
        FileWriter writer = new FileWriter("/Users/nathanielatwood/Downloads/newDigiDex.vcf");
        Scanner userInput = new Scanner(System.in);

        gatherFileName(userInput);
        this.phoneBook = addContacts(fileReader);
        writeContacts(writer, this.phoneBook);


        // Close BufferedReader, FileWriter, Scanner
        fileReader.close();
        writer.close();
        userInput.close();
    

    }

    // MUTATOR METHODS
    public String gatherFileName(Scanner userInput) {
        System.out.println("What file will DigiDex be converting today? ");

        
        String fileToScan = userInput.next();

        System.out.println("DigiDex will scan the data from " + fileToScan);

        return fileToScan;

    }


    public ArrayList addContacts(BufferedReader reader) {
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

    }


    public writeContacts(FileWriter writer, ArrayList phoneList) {

        for (int i = 0; i < phoneArray.length; i++) {           
            writer.write( "BEGIN:VCARD \n" +
                        "VERSION:3.0  \n" +
                        "N:" + phoneArray[i].getEmployeeLastName() + ";" + phoneArray[i].getEmployeeFirstName() + ";;;  \n" +
                        "FN:" + phoneArray[i].getEmployeeName() + "\n" +
                        "ORG:" + phoneArray[i].getRouteNumber() + "\n" +
                        "TEL;TYPE=WORK,MSG: +1" + phoneArray[i].getPhoneNumber() + "\n" +
                        "END:VCARD \n");
        }

    }

    // ACCESSOR METHODS


}
