<%-- 
Student: Barbara Sullivan
CIST 2373 - Java Programming III - Fall 2019
Lab#7 - More JSPs - Part I & II (DisplayAccounts.jsp)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.Account" %>
<%@page import="business.Customer" %>
<%@page import="business.AccountList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Accounts</title>
    </head>
    <body style="max-width: 600px; margin: auto; background-image:url('cash.jpg');">
        <h1 style="font-weight: bold; background-color: lightseagreen; color: white; text-align: center">ChattBank - Accounts List</h1>

        <%
            System.out.println("DisplayAccount.jsp");
            Customer c1;
            c1 = (Customer)session.getAttribute("c1");
            c1.Display();
            Account a1 = null;
           
            for (int i=0; i<c1.aList.count; i++) {
                a1 = c1.aList.accountList.get(i);
            
        %>
        
        <form action="AccountLookupServlet" method="post">
        Customer: <input type="text" name="Nametb" value="<%= c1.getCustFirstName() %> <%= c1.getCustLastName() %>" /><br><br>
            
        Account Number: <input type="text" name="Accttb" value='<%= a1.getAcctNo()%>'/><br><br> 
        
        Customer ID: <input type="text" name="Cidtb" value='<%= a1.getCustId()%>'/><br><br>

        Account Type: <input type="text" name="typetb" value="<%= a1.getType()%> "/><br><br>

        Balance: <input type="text" name="baltb" value="<%= a1.getBalance()%>"/><br>
        <br><br>
        
        <%
            }
            %>
            <h4><a href="login.jsp"> Go Back to Login Page</a>   |    <a href="accountLookup.jsp"> Go to Account Lookup</a></h4>
            
        </form>
    </body>
</html>
