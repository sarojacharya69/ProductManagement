import java.sql.*;

public class Product {
////jhjhjhj

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
                String createTableQuery = "CREATE TABLE IF NOT EXISTS Product (" +
                        "ID INT PRIMARY KEY AUTO_INCREMENT," +
                        "name VARCHAR(50)," +
                        "Quantity INT NOT NULL," +
                        "Price INT NOT NULL" +
                        ")";
                statement.execute(createTableQuery);

                System.out.println("Table created successfully.");

                // Step 3: Perform CRUD operations

                // Create operation
                String createQuery = "INSERT INTO Product (name,Quantity,Price) VALUES ('Mac',90,1200)";
                statement.executeUpdate(createQuery);
                System.out.println("Record created!");

                // Read operation/Execute queries
                String readQuery = "SELECT * FROM Product";
                resultSet = statement.executeQuery(readQuery);
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("Price");
                    int qty = resultSet.getInt("Quantity");
                    System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + qty);
                }

                // Update operation
                final String updateQuery = "UPDATE Product SET name = 'ProMax' WHERE id = 2";
                int count=statement.executeUpdate(updateQuery);
                if(count!=0)
                {System.out.println("Record updated!");}
                else
                {System.out.println("Data not Inserted");}

                // Delete operation
                String deleteQuery = "DELETE FROM Product WHERE ID =3";
                statement.executeUpdate(deleteQuery);
                System.out.println("Record deleted!");
                statement.close();
                connection.close();



            } catch (SQLException e) {
                e.printStackTrace();
            }}}

