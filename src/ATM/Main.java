package ATM;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int pass, balancedb = 0, withdrawAmount, ch, passdb = 0, depositAmount;
        String nameJ;
        boolean flag = true;


        Connection con = Jdbc.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your name :");
        nameJ = sc.nextLine();
        System.out.println("welcome " + nameJ);

        while (flag) {
            System.out.println("press 0 to enter pass");
            System.out.println("press 1 to withdraw");
            System.out.println("press 2 to deposit");
            System.out.println("press 3 to see balance ");
            System.out.println("press 4 to exit");

            System.out.println("enter your choice to continue ");
            ch = sc.nextInt();

            switch (ch) {
                case 0 -> {
                    System.out.println("enter your pass");
                    pass = sc.nextInt();

                    String query = "select password from bank where name=?";
                    PreparedStatement pt = con.prepareStatement(query);
                    pt.setString(1, nameJ);
                    ResultSet rs = pt.executeQuery();

                    while (rs.next()) {
                        passdb = rs.getInt(1);
                        if (pass == passdb) {
                            System.out.println(".......you may proceed further.........");
                        } else
                            System.out.println("wrong password.......try again");
                    }

                }
                case 1 -> {
                    System.out.println("enter Amount to withdraw ");
                    withdrawAmount = sc.nextInt();

                    String query1 = "select balanceAmount from bank where name=?";
                    String query5 = "update bank set  balanceAmount=balanceAmount-?  where name=?";

                    PreparedStatement pt1 = con.prepareStatement(query1);
                    pt1.setString(1, nameJ);
                    ResultSet rs1 = pt1.executeQuery();


                    while (rs1.next()) {
                        balancedb = rs1.getInt(1);
                        if (withdrawAmount > balancedb) {
                            System.out.println("low balance :" + balancedb);
                        } else
                            System.out.println("withdrawn " + withdrawAmount + " your balance Amount is " + (balancedb - withdrawAmount));
                        PreparedStatement pt5 = con.prepareStatement(query5);
                        pt5.setInt(1, withdrawAmount);
                        pt5.setString(2, nameJ);
                        pt5.executeUpdate();
                    }

                }
                case 2 -> {
                    System.out.println("enter Amount to deposit");
                    depositAmount = sc.nextInt();

                    String query2 = "update bank set balanceAmount = balanceAmount + ? where name=?";
                    PreparedStatement pt2 = con.prepareStatement(query2);
                    pt2.setInt(1, depositAmount);
                    pt2.setString(2, nameJ);
                    pt2.executeUpdate();
                    System.out.println("successfully deposited ");
                }
                case 3 -> {
                    String query3 = "select balanceAmount from bank where name=?";
                    PreparedStatement pt3 = con.prepareStatement(query3);
                    pt3.setString(1, nameJ);
                    ResultSet rs3 = pt3.executeQuery();

                    while (rs3.next()) {
                        balancedb = rs3.getInt(1);
                    }
                    System.out.println("your balance Amount available in your account is " + balancedb);
                }
                case 4 -> {
                    System.out.println("thank you visit again");
                    flag = false;
                }
            }
        }

    }
}
