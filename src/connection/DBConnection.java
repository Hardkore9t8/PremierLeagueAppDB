package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    //database connection
    public static java.sql.Connection connection;
    public static DBConnection getConnection(){
        String dbName ="PLeagueDB";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }
}
