import java.util.Calendar;
import java.util.Date;

public class CannedFood extends Food {
    public CannedFood(String foodID, String expirationDate) {
        super(foodID, "Canned", expirationDate);
    }

    @Override
    public String getExpirationStatus() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(expirationDate);
        cal.add(Calendar.MONTH, 9); // เพิ่ม 9 เดือนหลังวันหมดอายุ
        return new Date().after(cal.getTime()) ? "Expired" : "Not Expired";
    }
}
