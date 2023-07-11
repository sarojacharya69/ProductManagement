import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemoExample {



        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/InsuranceMangementSystem";
            String username = "root";
            String password = "Bex987174";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connection established successfully");
                // Perform database operations here
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


