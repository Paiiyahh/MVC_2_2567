//import important lib
import java.util.Calendar;
import java.util.Date;

// CannedFood class extends Food class
public class CannedFood extends Food {

    // Constructor to initialize foodID and expirationDate for CannedFood
    public CannedFood(String foodID, String expirationDate) {
        super(foodID, "Canned", expirationDate); // Calling parent class constructor
    }

    // Override method to check expiration status
    @Override
    public String getExpirationStatus() {
        Calendar cal = Calendar.getInstance(); // Create a calendar instance
        cal.setTime(expirationDate); // Set the expiration date
        cal.add(Calendar.MONTH, 9); // Add 9 months to the expiration date

        // Return expiration status based on current date
        return new Date().after(cal.getTime()) ? "Expired" : "Not Expired";
    }
}
