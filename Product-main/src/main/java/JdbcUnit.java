import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUnit {
    public static void main(String[] args) {
        Connection con=null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");//Register Driver
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InsuranceMangementSystem",
                    "root","Bex987174@");//Create Connection
            if(con!=null)
            {
                System.out.println("Connection Establish");
            }
            else {
                System.out.println("Connection not stablish");
            }
               }catch (ClassNotFoundException e){
                   e.printStackTrace();
                     } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
