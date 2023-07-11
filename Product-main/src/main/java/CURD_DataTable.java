import java.sql.*;

public class CURD_DataTable {
    public static void main(String[] args) {
        // Database connection parameters
        final String url = "jdbc:mysql://localhost:3306/InsuranceMangementSystem";
        final String username = "root";
        final String password = "Bex987174@";
        Connection connection = null;//(I)
        Statement statement=null;
        ResultSet resultSet=null;

        try {// 1: Establish the connection//DriverManager(C)
            //Implicitly scan the available Jdbc driver implementation and load by DM
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database Successfully");

            // Step 2: Create a statement
            statement = connection.createStatement();// Statement(I)/cS=abstract method
            //Create Table
            statement.execute("CREATE TABLE IF NOT EXISTS Users (" +
                    "iD INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50)," +
                    "address VARCHAR(100)," +
                    "phone BIGINT NOT NULL," +
                    "login VARCHAR(100)," +
                    "password VARCHAR(50)" +
                    ")");
            System.out.println("Table created successfully.");

            // Step 3: Perform CRUD operations

            // Create operation
            String createQuery = "INSERT INTO Users (name,address,phone,login,password) VALUES ('Mick Doe','NYC',1236667890,'axbcd@1234','xlzvv')";
            //final String createQuery = "INSERT INTO Users  VALUES (27,'Miccck Doe','NYC',1236667890,'axbcyd@1234','xlkzvv')";
            statement.executeUpdate(createQuery);
            System.out.println("Record created!");

            // Read operation/Execute queries
            String readQuery = "SELECT * FROM Users";
            resultSet = statement.executeQuery(readQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("iD");
                String name = resultSet.getString("name");
                String adds = resultSet.getString("address");
                System.out.println("ID: " + id + ", Name: " + name + ", Address: " + adds);
            }

            // Update operation
            final String updateQuery = "UPDATE Users SET address = 'DC' WHERE id = 20";
            int count=statement.executeUpdate(updateQuery);
            if(count!=0)
            {System.out.println("Record updated!");}
            else
            {System.out.println("Data not Inserted");}

            // Delete operation
            String deleteQuery = "DELETE FROM Users WHERE id = 18";
            statement.executeUpdate(deleteQuery);
            System.out.println("Record deleted!");
            statement.close();
            connection.close();



         } catch (SQLException e) {
        e.printStackTrace();
        }}}