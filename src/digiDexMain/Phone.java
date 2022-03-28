package digiDexMain;

public class Phone {
    
    // FIELDS
    private String employeeFirstName;
    private String employeeLastName; 
    private long phoneNumber;
    private int phoneAssetCode;
    private int routeNumber;

    // CONSTRUCTOR
    public Phone (String employeeFirstName, String employeeLastName, int phoneAssetCode, int routeNumber) {

        this.employeeFirstName = employeeFirstName;

        this.employeeLastName = employeeLastName;

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

    // ACCESSOR METHODS
    public String getEmployeeName() { return employeeFirstName + " " + employeeLastName; }
    public String getEmployeeFirstName() { return employeeFirstName; }
    public String getEmployeeLastName() { return employeeLastName; }
    public int getRouteNumber() { return routeNumber; }
    public int getPhoneAssetCode() { return phoneAssetCode; }
    public long getPhoneNumber() { return phoneNumber; }

    // TO STRING METHOD
    public String toString() {
        return employeeFirstName + " " + employeeLastName + " on route " + routeNumber + " has phone " + phoneAssetCode + " with the " + phoneNumber + " phone number.";
    }

}
