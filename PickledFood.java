import java.text.SimpleDateFormat;
import java.util.Date;

public class PickledFood extends Food {
    public PickledFood(String foodID, String expirationDate) {
        super(foodID, "Pickled", expirationDate);
    }

    @Override
    public String getExpirationStatus() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        try {
            Date currentMonthYear = sdf.parse(sdf.format(new Date()));
            Date expMonthYear = sdf.parse(sdf.format(expirationDate));
            return expMonthYear.before(currentMonthYear) ? "Expired" : "Not Expired";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unknown";
    }
}
