import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validation {

// Validate email format using regex
public static boolean isValidEmail(String email) {
String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
Pattern pattern = Pattern.compile(emailRegex);
Matcher matcher = pattern.matcher(email);
return matcher.matches();
}

// Validate phone number (must be 10 digits)
public static boolean isValidPhoneNumber(String phone) {
String phoneRegex = "^\\d{10}$";
Pattern pattern = Pattern.compile(phoneRegex);
Matcher matcher = pattern.matcher(phone);
return matcher.matches();
}

// Validate if the field is empty
public static boolean isFieldEmpty(String field) {
return field == null || field.trim().isEmpty();
}

// Validate date of birth (YYYY-MM-DD format)
public static boolean isValidDob(String dob) {
String dobRegex = "^\\d{4}-\\d{2}-\\d{2}$";
return dob.matches(dobRegex);
}
}