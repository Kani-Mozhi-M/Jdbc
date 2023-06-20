import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecord {
    public static void main(String[] args) {
        try
        {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Lk","root"," ");
            Statement st=connection.createStatement();
            int  rs=st.executeUpdate("insert into employee2 values(5,'Meena','HR',2000000)");
            System.out.println("no of rows affected "+rs);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
