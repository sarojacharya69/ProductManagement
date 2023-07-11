import java.sql.*;

public class DataBaseConnetionDEmo {
     public static void main(String[] args) {
         try {
             Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             String query = "SELECT *from  Users";
             ResultSet resultSet = statement.executeQuery(query);

             while (resultSet.next()) {
                 // Retrieve data from the result set
                 int id = resultSet.getInt("iD");
                 String name = resultSet.getString("name");
                 System.out.println("ID: " + id + ", Name: " + name);
             }

             resultSet.close();
             statement.close();
             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }
 class DatabaseConnector {
     private static final String DB_URL = "jdbc:mysql://localhost:3306/InsuranceMangementSystem";
     private static final String DB_USER = "root";
     private static final String DB_PASSWORD = "Bex987174";

     public static Connection getConnection() throws SQLException {
         return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
     }
 }