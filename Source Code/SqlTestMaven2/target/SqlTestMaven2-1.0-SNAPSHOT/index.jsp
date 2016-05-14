<%-- 
    Document   : index
    Created on : May 13, 2016, 5:03:18 AM
    Author     : Shirin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="HibernateSessionFactoryListener" method="get">
    Name: <input type="text" name="name">
    Email: <input type="text" name="email">
    Password: <input type="password" name="password">
    Country:

    <select name="userCountry">
        <option>India</option>
        <option>Pakistan</option>
        <option>Other</option>
    </select><br><br>

    <input type="submit" value="register">
</form>
    </body>
</html>
