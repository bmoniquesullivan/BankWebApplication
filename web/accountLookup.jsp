<!-- 
Student: Barbara Sullivan
CIST 2373 - Java Programming III - Fall 2019
Lab#1 - Simple HTML Forms (AccountLookup)
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChattBank Account Lookup</title>
    </head>
    <body style="max-width: 600px; margin: auto; background-image:url('cash.jpg');">
        <h1 style="font-weight: bold; background-color: lightseagreen; color: white; text-align: center">ChattBank Account Information</h1>
        <h2>Enter your Account Information:</h2>
        <form action="http://localhost:8080/ChattBank/AccountLookupServlet" method="POST">
            Account Number: <input type="text" name="Accttb"/><br><br>
            Customer ID: <input type="text" name="Cidtb"/><br><br>

            Account Type: <select name="Account Type">
                <option>Checking</option>
                <option>Savings</option>
                <option>Money Market</option>
            </select>
            <br><br>
            Balance: <input type="text" name="baltb" /><br>
            <br><br>
            <input type="submit" name="lookbtn" value="Lookup" />
            <input type="reset" value="Clear" />

        </form>
    </body>
</html>
