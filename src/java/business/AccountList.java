/******************************************************
 * Student: Barbara Sullivan                          *
 * CIST 2373 - Java Programming III - Fall 2019       *
 * Lab#4 - More Business Objects - Part I             *
 ******************************************************/
package business;

import java.util.ArrayList;


public class AccountList {

    public ArrayList<Account> accountList = new ArrayList<>();
    public int count = 0;
    
    public void addAccount(Account a){
        accountList.add(a);
        count++;
    }//end accountList
    
    public void Display(){
        for(int i=0;i<count;i++){
            accountList.get(i).Display();
            System.out.println("-------------------------");
        }
    }
   

    public static void main(String[] args) {
        AccountList aList = new AccountList();
        Account a1 = new Account();

        aList.addAccount(a1);
        aList.addAccount(new Account(90012, 3007, "SAV", 19500.00));
        aList.addAccount(new Account(90013, 3007, "MMA", 5000.00));

        aList.Display();
    }
}
