import java.sql.*;
public class ReadRecords {
    public static void main(String[] args) {
        try
        {
            //reading the records
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lk","root","KANI#23mySql24");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee2");

            while (rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
