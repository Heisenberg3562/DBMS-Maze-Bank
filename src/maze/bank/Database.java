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
    static String user_id = "";
    
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
                Database.user_id = myRs.getString("user_id");
            }
            if(Database.name.equals("")){
                flag = false;
            }else{
                flag = true;
            }
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
                Database.balance = myRs.getString("balance");
            }
            System.out.println(acc);
            user.executeUpdate("INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `email`, `phone`, `address`, `dob`, `pan`, `pin`, `account_no`) VALUES (NULL, '"+Fname+"', '"+Lname+"', '"+Email+"', '"+Phone+"', '"+Address+"', '"+Date+"', '"+PAN+"', '"+pin+"','"+acc+"' )");
            Rs = st.executeQuery("SELECT * from user where account_no='"+acc+"'");
            while (Rs.next()) {
                Database.name = Rs.getString("first_name")+" "+Rs.getString("last_name");
                
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
    
    public Boolean deposit(String balance, String pin) throws SQLException{
        //String email, String pin
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        Boolean flag = false;
        String id = "";

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM `user` WHERE `pin`="+pin+" AND `user_id`="+Database.user_id+"");
            while (myRs.next()) {
                id = myRs.getString("user_id");
            }
            if(id == ""){
                flag = false;
            }else{
                myStmt.executeUpdate("INSERT INTO `transaction` (`tr_id`, `user_id`, `account_no`, `type`, `created_at`, `transfer_acc_no`, `amount`, `current_balance`) VALUES (NULL, '"+Database.user_id+"', '"+Database.account_no+"', 'Deposit', current_timestamp(), NULL, '"+balance+"', '"+Integer.toString(Integer.parseInt(balance)+Integer.parseInt(Database.balance))+"')");
                myStmt.executeUpdate("UPDATE `account` SET `balance` = '"+Integer.toString(Integer.parseInt(balance)+Integer.parseInt(Database.balance))+"' WHERE `account`.`account_no` = "+Database.account_no+"");
                Database.balance = Integer.toString(Integer.parseInt(balance)+Integer.parseInt(Database.balance));
                flag = true;
            }
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
    
    public Boolean withdraw(String balance, String pin) throws SQLException{
        //String email, String pin
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        Boolean flag = false;
        String id = "";

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM `user` WHERE `pin`="+pin+" AND `user_id`="+Database.user_id+"");
            while (myRs.next()) {
                id = myRs.getString("user_id");
            }
            if(id == ""){
                flag = false;
            }else{
                myStmt.executeUpdate("INSERT INTO `transaction` (`tr_id`, `user_id`, `account_no`, `type`, `created_at`, `transfer_acc_no`, `amount`, `current_balance`) VALUES (NULL, '"+Database.user_id+"', '"+Database.account_no+"', 'Withdraw', current_timestamp(), NULL, '"+balance+"', '"+Integer.toString(-Integer.parseInt(balance)+Integer.parseInt(Database.balance))+"')");
                myStmt.executeUpdate("UPDATE `account` SET `balance` = '"+Integer.toString(-Integer.parseInt(balance)+Integer.parseInt(Database.balance))+"' WHERE `account`.`account_no` = "+Database.account_no+"");
                Database.balance = Integer.toString(-Integer.parseInt(balance)+Integer.parseInt(Database.balance));
                flag = true;
            }
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
    
    public Boolean transfer(String account_no,String balance, String pin) throws SQLException{
        //String email, String pin
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        Boolean flag = false;
        String id = "";
        String tid = "";
        String bal = "";

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM `user` WHERE `pin`="+pin+" AND `user_id`="+Database.user_id+"");
            while (myRs.next()) {
                id = myRs.getString("user_id");
            }
            if("".equals(id)){
                flag = false;
            }else{
                myRs = myStmt.executeQuery("SELECT * FROM `account`,`user` WHERE account.account_no = user.account_no AND account.account_no = "+account_no+"");
                while (myRs.next()){
                    tid = myRs.getString("user_id");
                    bal = myRs.getString("balance");
                }
                Database db = new Database();
                myStmt.executeUpdate("INSERT INTO `transaction` (`tr_id`, `user_id`, `account_no`, `type`, `created_at`, `transfer_acc_no`, `amount`, `current_balance`) VALUES (NULL, '"+tid+"', '"+account_no+"', 'Deposit', current_timestamp(), NULL, '"+balance+"', '"+Integer.toString(Integer.parseInt(balance)+Integer.parseInt(bal))+"')");
                myStmt.executeUpdate("UPDATE `account` SET `balance` = '"+Integer.toString(Integer.parseInt(balance)+Integer.parseInt(bal))+"' WHERE `account`.`account_no` = "+account_no+"");
                flag = db.withdraw(balance, pin);
                flag = true;
            }
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
    
    public void fetchData() throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");

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
