/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Omkar
 */
public class Database {
    
    public void data() throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
                // 1. Get a connection to database
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "student" , "student");

                myStmt = myConn.createStatement();

                System.out.println("Inserting a new user to database\n");

                myStmt.executeUpdate("insert into user(Acc_no, First_name, Last_name, Email, Phone, Address) values (9876543211, 'Adeeba', 'Ansari', 'adeeba@gmail.com', 8446904813, 'Bhiwandi')");
                System.out.println("Test");
                // 4. Verify this by getting a list of employees
                myRs = myStmt.executeQuery("select * from user");
                System.out.println("Test");
                // 5. Process the result set
                while (myRs.next()) {
                        System.out.println(myRs.getString("First_name") + ", " + myRs.getString("Last_name"));
                }
        }
        catch (SQLException exc) {
        }
        finally {
                if (myRs != null) {
                        myRs.close();
                }

                if (myStmt != null) {
                        myStmt.close();
                }

                if (myConn != null) {
                        myConn.close();
                }
        }
    }
    
    
}
