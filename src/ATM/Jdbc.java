package ATM;

import java.sql.DriverManager;
import java.sql.*;

public class Jdbc  {
    static String url="jdbc:mysql://localhost:3306/atm";
    static String user="root";
    static String password="";

    public  static  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

}

