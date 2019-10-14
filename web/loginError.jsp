<%-- 
Student: Barbara Sullivan
CIST 2373 - Java Programming III - Fall 2019
Lab#6 - Simple JSPs - Part III (LoginError.jsp)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.Customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChattBank - Login Error Page</title>
    </head>
    <body style="max-width: 600px; margin: auto; background-image:url('cash.jpg');">
        <%
            System.out.println("displayAccount.jsp");
            Customer c1;
            c1 = (Customer) session.getAttribute("c1");
            c1.Display();

        %>
        <h1 style="font-weight: bold; background-color: lightseagreen; color: white; text-align: center">Invalid Login</h1>
        <h3>Error Logging in for User with ID <%= c1.getCustId() %></h3>
        <br>
        <h3> User <u> <%= c1.getCustFirstName() %> <%= c1.getCustLastName() %> </u> with ID <%= c1.getCustId() %></h3>
        <h3>Please, check your User ID and Password and try again.</h3>
        <br>
        <h4><a href="login.jsp"> Go Back to Login</a></h4>
    </body>
</html>
