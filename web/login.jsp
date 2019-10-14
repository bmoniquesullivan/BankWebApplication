<!-- 
Student: Barbara Sullivan
CIST 2373 - Java Programming III - Fall 2019
Lab#1 - Simple HTML Forms (Login)
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChattBank Login Page</title>
        <script type="text/javascript">

            function validatefunctions() {

                if (document.getElementById('idtb').value === '') {
                    alert('You need to enter a Customer ID');
                    return false;
                }
                
                if (document.getElementById('pwtb').value === '') {
                    alert('Please enter your password');
                    return false;
                }
               /* var custID;
                custID = document.getElementsByName("idtb").value;

                if (isNan(custID)) {
                    alert("Customer ID needs to be numeric");
                    return false;
                }
                if (custID < 3000) {
                    alert("ID must be above 3000");
                    return false;
                }
                if (custID > 3999) {
                    alert("ID must be below 3999");
                    return false;
                } */
            }

        </script>


    </head>
    <body style="max-width: 600px; margin: auto; background-image:url('cash.jpg');">
        <h1 style="font-weight: bold; background-color: lightseagreen; color: white; text-align: center">ChattBank Login Information</h1>
        <h2>Enter your login:</h2>
        <form action="http://localhost:8080/ChattBank/LoginServlet" method="POST" onsubmit="return validatefunctions()" >
            Customer ID: <input type="number" name="idtb" id="idtb" min="3000" max="3999"/><br><br>
            Password: <input type="password" name="pwtb" id="pwtb" /><br><br><br>
            <input type="submit" name="subbtn" value="Login" />
            <input type="reset" value="Clear" />


        </form>
    </body>
</html>
