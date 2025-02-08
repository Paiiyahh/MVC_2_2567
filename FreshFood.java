import java.util.Date;

// FreshFood class extends the Food class and represents fresh food items
public class FreshFood extends Food {
    
    public FreshFood(String foodID, String expirationDate) {
        super(foodID, "Fresh", expirationDate);
    }
    // Override method to check expiration status for fresh food
    @Override
    public String getExpirationStatus() {
        System.out.println(new Date());
        System.out.println(expirationDate);
        // Return "Expired" if the current date is after the expiration date, otherwise return "Not Expired"
        return new Date().after(expirationDate) ? "Expired" : "Not Expired";
    }
}
