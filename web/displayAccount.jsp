<!-- 
Student: Barbara Sullivan
CIST 2373 - Java Programming III - Fall 2019
Lab#6 - Simple JSPs - Part V (Display Account)
-->

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
        <h1 style="font-weight: bold; background-color: lightseagreen; color: white; text-align: center">ChattBank - Account List</h1>

        <%
            System.out.println("DisplayAccount.jsp");
            Account a1;
            a1 = (Account) session.getAttribute("a1");
            a1.Display();
        %>
        Account Number: <input type="text" name="Accttb" value='<%= a1.getAcctNo()%>'/><br><br> 
        Customer ID: <input type="text" name="Cidtb" value='<%= a1.getCustId()%>'/><br><br>

        Account Type: <input type="text" name="typetb" value="<%= a1.getType()%> "/><br><br>

        Balance: <input type="text" name="baltb" value="<%= a1.getBalance()%>"/><br>
        <br><br>
        <h4><a href="accountLookup.jsp"> Go Back to Account Lookup</a></h4>
    </body>
</html>
