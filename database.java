import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;
public class database {
private static final String DB_URL = "jdbc:mysql://localhost:3306/UserRegistration";
private static final String DB_USER = "root"; // MySQL username
private static final String DB_PASSWORD = "yourpassword"; // MySQL password

public static boolean insertUser(User user) {
try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
// SQL query to insert user data
String query = "INSERT INTO Users (name, email, phone, password, dob) VALUES (?, ?, ?, ?, ?)";
PreparedStatement preparedStatement = connection.prepareStatement(query);
preparedStatement.setString(1, user.getName());
preparedStatement.setString(2, user.getEmail());
preparedStatement.setString(3, user.getPhone());
preparedStatement.setString(4, user.getPassword());

Date sqlDob = Date.valueOf(user.getDob());
preparedStatement.setDate(5, sqlDob);
int result = preparedStatement.executeUpdate();
return result > 0; // Return true if insertion is successful
} catch (Exception e) {
e.printStackTrace();
return false; // Return false if there's an error
}
}
}