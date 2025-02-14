import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class test {

    public static boolean isInteger(Object obj) {
        if (obj instanceof Integer) {
            return true;
        } else if (obj instanceof String) {
            try {
                Integer.parseInt((String) obj);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
    public static boolean isFloat(Object x) {
        return x instanceof Float || x instanceof Double;
    }
     public static boolean isValidDateFormat(String inputDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Disable lenient mode to enforce strict parsing

        try {
            dateFormat.parse(inputDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
