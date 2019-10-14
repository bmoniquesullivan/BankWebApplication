/******************************************************
 * Student: Barbara Sullivan                          *
 * CIST 2373 - Java Programming III - Fall 2019       *
 * Lab#4 - More Business Objects - Part II            *
 ******************************************************/
package business;

import java.sql.*;

public class Customer {

    //Properties
    int custId;
    public String custPassword;
    public String custFirstName;
    public String custLastName;
    public String custAddress;
    public String custEmail;
    public AccountList aList = new AccountList();

    //Empty args Constructor to initialize all properties
    public Customer() {
        custId = 0;
        custPassword = "";
        custFirstName = "";
        custLastName = "";
        custAddress = "";
        custEmail = "";
    }

    //Constructor to take all arguments and set appropriate properties
    public Customer(int id, String password, String fname, String lname, String address, String email) {
        this.custId = id;
        this.custPassword = password;
        this.custFirstName = fname;
        this.custLastName = lname;
        this.custAddress = address;
        this.custEmail = email;
    }

    //Include Getters and Setters
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    //Display Method
    public void Display() {
        System.out.println("Customer ID: " + getCustId());
        System.out.println("Customer Password: " + getCustPassword());
        System.out.println("First Name: " + getCustFirstName());
        System.out.println("Last Name: " + getCustLastName());
        System.out.println("Customer Address: " + getCustAddress());
        System.out.println("E-mail: " + getCustEmail());
        aList.Display();
    }

    //*********************************************************************************//
    //SelectDB Method
    public void SelectDB(int custID) {
        custId = custID;

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
            String sql = "select * from Customers Where CustID ='" + getCustId() + "'";
            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Statement Executed");

            //Step 5 - Process Result
            while (rs.next()) {

                custId = rs.getInt(1);
                custPassword = rs.getString(2);
                custFirstName = rs.getString(3);
                custLastName = rs.getString(4);
                custAddress = rs.getString(5);
                custEmail = rs.getString(6);

            }

            //Step 6 - Close connection
            con.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        CreateAccountList();
    }

    //*********************************************************************************//
    //InsertDB Method
        public void insertDB(int ID, String PASS, String FN, String LN, String ADR, String EM) {
        custId = ID;
        custPassword = PASS;
        custFirstName = FN;
        custLastName = LN;
        custAddress = ADR;
        custEmail = EM;

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
            String sql = "Insert into Customers values(" + getCustId() + "," + getCustPassword() + "," + "'" + getCustFirstName() + "'," + "'" + getCustLastName() + "'," + "'" + getCustAddress() + "'," + "'" + getCustEmail() + "')";
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
            String sql = "Update Customers set CustPassword = '" + custPassword + "', "
                    + "CustFirstName = '" + custFirstName + "', CustLastName = '" + custLastName + "', CustAddress = '" + custAddress + "', CustEmail = '" + custEmail + "' Where CustID = '" + custId + "'";
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
            String sql = "Delete from Customers where CustID ='" + getCustId() + "'";
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
    
    //*********************************************************************************//
    //Add Account List Property
    public void CreateAccountList() {
        
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
            String sql = "select AcctNo from Accounts Where Cid ='" + getCustId() + "'";
            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Statement Executed");

            //Step 5 - Process Result
         
            while (rs.next()) {
                
                Account a1;
                int accountNum;
                
                accountNum = rs.getInt(1);
                a1 = new Account();
                a1.SelectDB(accountNum);
                aList.addAccount(a1);

            }

            //Step 6 - Close connection
            con.close();
            System.out.println("Connection Closed");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        Customer c1 = new Customer();
        /*Code goes on Servlet*/
        c1.SelectDB(3001);
        //c1.insertDB(3007, 2323, "Monique", "Sullivan", "Villa Rica", "bmona@gmail.com");
        //c1.SelectDB(3007);
        //c1.setCustFirstName("Barbara");
        //c1.updateDB();
        //c1.SelectDB(3006);
        //c1.deleteDB();
        c1.Display();

        /* Customer c1 = new Customer(); //Creates an empty object
        c1.SelectDB(3006); // DB Lookup to find Customer
        int pwdb = c1.getCustPassword();
        if (passwordFromTextBox.equals(pwdb)) {
            //login correct
        } else {
            //login incorrect
        }*/
    }
}
