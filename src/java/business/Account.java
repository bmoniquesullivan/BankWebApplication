/*******************************************************
 * Student: Barbara Sullivan                           *
 * CIST 2373 - Java Programming III - Fall 2019        *
 * Lab#3 - Business Objects - Part II                  *
 *******************************************************/
package business;

import java.sql.*;

public class Account {

    int acctNo;
    int custId;
    String type;
    double balance;

    //Empty args Constructor to initialize all properties
    public Account() {
        acctNo = 0;
        custId = 0;
        type = "";
        balance = 0;
    }

    //Constructor to take all arguments and set appropriate properties
    public Account(int acct, int id, String typ, double bal) {
        this.acctNo = acct;
        this.custId = id;
        this.type = typ;
        this.balance = bal;
    }

    //Include Getters and Setters
    public int getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(int acctNo) {
        this.acctNo = acctNo;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Display Method
    public void Display() {
        System.out.println("Account Number: " + getAcctNo());
        System.out.println("Customer ID: " + getCustId());
        System.out.println("Account Type: " + getType());
        System.out.println("Account Balance: " + getBalance());
    }
    //*********************************************************************************//
    //SelectDB Method

    public void SelectDB(int acctNum) {
        acctNo = acctNum;

        try {
            System.out.println("Loading DataBase...");

            //Step 1 - Load Driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            //Step 2 - Get a connection
            Connection con;
            con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Monique//Desktop//CIST 2373 - Java III//ChattBankMDB.mdb");

            System.out.println("Connected to DataBase...");

            //Step 3 - Create SQL Statement
            Statement stmt = con.createStatement();

            //Step 4 - Execute SQL Statement
            String sql = "select * from Accounts Where AcctNo ='" + getAcctNo() + "'";
            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Statement Executed");

            //Step 5 - Process Result
            while (rs.next()) {

                acctNo = rs.getInt(1);
                custId = rs.getInt(2);
                type = rs.getString(3);
                balance = rs.getDouble(4);

            }

            //Step 6 - Close connection
            con.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    //*********************************************************************************//
    //InsertDB Method
    public void insertDB(int acct, int id, String typ, double bal) {
        acctNo = acct;
        custId = id;
        type = typ;
        balance = bal;

        try {

            //Step 1 - Load Driver
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Step 2 - Get a connection
            Connection con;
            con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Monique//Desktop//CIST 2373 - Java III//ChattBankMDB.mdb");

            System.out.println("Connected to DataBase...");

            //Step 3 - Create SQL Statement
            Statement stmt = con.createStatement();

            //Step 4 - Execute SQL Statement
            String sql = "Insert into Accounts values(" + getAcctNo() + "," + getCustId() + "," + "'" + getType() + "'," + getBalance() + ")";
            //Check the single quotes on the sql code "'"
            System.out.println(sql);
            int execute = stmt.executeUpdate(sql);

            //Step 5 - Process Result
            if (execute == 1) {
                System.out.println("INSERT Done successfully");
            } else {
                System.out.println("INSERT Not successfully");
            }

            //Step 6 - Close Connection
            con.close();
            System.out.println("Connection for INSERT Closed");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //*********************************************************************************//
    //UpdateDB Method
    public void updateDB() {

        try {

            //Step 1 - Load Driver
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Step 2 - Get a connection
            Connection con;
            con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Monique//Desktop//CIST 2373 - Java III//ChattBankMDB.mdb");

            System.out.println("Connected to DataBase...");

            //Step 3 - Create SQL Statement
            Statement stmt = con.createStatement();

            //Step 4 - Execute SQL Statement
            String sql = "Update Accounts set Cid = '" + custId + "', "
                    + "Type = '" + type + "', Balance = '" + balance + "' Where AcctNo = '" + acctNo + "'";
            //Check the single quotes on the sql code "'"
            System.out.println(sql);
            int execute = stmt.executeUpdate(sql);

            //Step 5 - Process Result
            if (execute == 1) {
                System.out.println("UPDATE Done successfully");
            } else {
                System.out.println("UPDATE Not successfully");
            }

            //Step 6 - Close Connection
            con.close();
            System.out.println("Connection for UPDATE Closed");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //*********************************************************************************//
    //DeleteDB Method
    public void deleteDB() {
        try {

            //Step 1 - Load Driver
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Step 2 - Get a connection
            Connection con;
            con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Monique//Desktop//CIST 2373 - Java III//ChattBankMDB.mdb");

            System.out.println("Connected to DataBase...");

            //Step 3 - Create SQL Statement
            Statement stmt = con.createStatement();

            //Step 4 - Execute SQL Statement
            String sql = "Delete from Accounts where AcctNo ='" + getAcctNo() + "'";
            System.out.println(sql);
            int execute = stmt.executeUpdate(sql);

            //Step 5 - Process Result
            if (execute == 1) {
                System.out.println("DELETE Done successfully");
            } else {
                System.out.println("DELETE Not successfully");
            }

            //Step 6 - Close Connection
            con.close();
            System.out.println("Connection for DELETE Closed");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        Account a1 = new Account();
        //a1.SelectDB(90005);
        //a1.insertDB(90012, 3008, "SAV", 15130.30);

        //a1.SelectDB(90012);
        //a1.setCustId(3007);
        //a1.updateDB();
        //a1.SelectDB(90012);
        //a1.deleteDB();
        //Customer c1 = new Customer();
        //c1.SelectDB(3001);
        //c1.Display();
        //for(int x=0;x<c1.aList.count;x++){
        //a1=c1.aList.aArr[x];
}
    //a1.Display();    
    }

