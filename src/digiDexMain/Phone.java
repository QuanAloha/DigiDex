package digiDexMain;

public class Phone {
    
    private String employeeName;
    
    private long phoneNumber;

    private int phoneAssetCode;

    private int routeNumber;

    public Phone (String employeeName, int phoneAssetCode, int routeNumber) {

        this.employeeName = employeeName;

        this.routeNumber = routeNumber;

        this.phoneAssetCode = phoneAssetCode;

        // Set a phone number for the object based on what phone asset code is provided. 

        if (phoneAssetCode == 123) {

            this.phoneNumber = 1234567890L;

        } else if (phoneAssetCode == 321) {

            this.phoneNumber = 9376543421L;

        } else if (phoneAssetCode == 123) {

            this.phoneNumber = 6549874321L;

        } 

        
    }

    public String toString() {

        return employeeName + " on route " + routeNumber + " has phone " + phoneAssetCode + " with the " + phoneNumber + " phone number.";

    }


}
