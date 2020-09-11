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
    
    static String name = "";
    static String balance = "";
    static String account_no = "";
    
    public Boolean login(String email, String pin) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        Boolean flag = false;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM `user`,account WHERE user.account_no=account.account_no AND email='"+email+"' AND pin='"+pin+"'");
            while (myRs.next()) {
                Database.name = myRs.getString("first_name")+" "+myRs.getString("last_name");
                Database.balance = myRs.getString("balance");
                Database.account_no = myRs.getString("account_no");
            }
            flag = true;
        }
        catch (SQLException exc) {
            System.out.println("Exception");
            exc.printStackTrace();
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
        return flag;
    }
    
    public void signup(String Fname, String Lname, String Email, String Phone, String Address, String Date, String PAN, String pin, String Branch) throws SQLException{

        Connection myConn = null;
        Statement myStmt = null;
        Statement st = null;
        Statement user = null;
        ResultSet myRs = null;
        ResultSet Rs = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");
            myStmt = myConn.createStatement();
            st = myConn.createStatement();
            user = myConn.createStatement();
            System.out.println("Inserting a new user to database\n");
            myStmt.executeUpdate("INSERT INTO `account` (`account_no`, `balance`, `type`, `branch_id`) VALUES (NULL, '0', 'savings', '"+Branch+"')");
            myRs = myStmt.executeQuery("select * from account where account_no not in(select account_no from user)");
            String acc = "";
            while (myRs.next()) {
                acc = myRs.getString("account_no");
                Database.account_no = acc;
            }
            System.out.println(acc);
            user.executeUpdate("INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `email`, `phone`, `address`, `dob`, `pan`, `pin`, `account_no`) VALUES (NULL, '"+Fname+"', '"+Lname+"', '"+Email+"', '"+Phone+"', '"+Address+"', '"+Date+"', '"+PAN+"', '"+pin+"','"+acc+"' )");
            Rs = st.executeQuery("SELECT * from user where account_no='"+acc+"'");
            while (Rs.next()) {
                Database.name = Rs.getString("first_name")+" "+Rs.getString("last_name");
                Database.balance = Rs.getString("balance");
            }
        }
        catch (SQLException exc) {
            System.out.println("Exception Occured");
            exc.printStackTrace();
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
    
    public String findBranch(String bname) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        String no = "";
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");
            myStmt = myConn.createStatement();
            String sql = "select * from branch where name='"+bname+"'";
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                no = myRs.getString("branch_id");
            }
        }
        catch (SQLException exc) {
            System.out.println("Exception");
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
        return no;
    }
    
    public void fetchData() throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "student" , "student");

            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from user");

            // 4. Process the result set
            while (myRs.next()) {
                    System.out.println(myRs.getString("Last_name") + ", " + myRs.getString("First_name"));
            }
        }
        catch (SQLException exc) {
            System.out.println("Test");
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
