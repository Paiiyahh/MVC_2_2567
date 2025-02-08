import java.text.SimpleDateFormat;
import java.util.Date;
// PickledFood class extends the Food class and represents pickled food items
public class PickledFood extends Food {
    public PickledFood(String foodID, String expirationDate) {
        super(foodID, "Pickled", expirationDate);
    }
    // Override method to check expiration status for pickled food
    @Override
    public String getExpirationStatus() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        try {
            Date currentMonthYear = sdf.parse(sdf.format(new Date()));
            Date expMonthYear = sdf.parse(sdf.format(expirationDate));
            // Return "Expired" if the expiration date is before the current date, otherwise return "Not Expired"
            return expMonthYear.before(currentMonthYear) ? "Expired" : "Not Expired";
        } catch (Exception e) {
            e.printStackTrace();// Print error if date parsing fails
        }
        return "Unknown";
    }
}
