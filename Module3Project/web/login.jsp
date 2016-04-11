<%-- 
    Document   : login
    Created on : Apr 4, 2016, 9:23:51 PM
    Author     : Takahashi
--%>
<%@page import="takahm.User"%>
<%@page import="edu.lcc.citp.inventory.Product"%>
<%@page import="takahm.DataAccessObject"%>
<%@page import="takahm.DataAccessObjectFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username" />
            </div>
            <div>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" />
            </div>
            <div>
                <input type="submit" value="Login" name="button" />
            </div>
        </form>
        <c:if test="${param.failed == 'true'}"><p>The username or password provided are not valid.</p></c:if>
        <c:if test="${param.logout == 'true'}"><p>Logout successful.</p></c:if>
        <c:if test="${param.denied == 'true'}"><p>Access denied.</p></c:if>
    </body>
</html>