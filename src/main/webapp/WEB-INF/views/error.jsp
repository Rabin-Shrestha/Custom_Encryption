<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Error Page</title>
</head>
<body>
<% if (response.getStatus() == 500) { %>
<h3> Please Check your encryption key!! </h3>
<h4> Retry again: <a href="/">Main Page</a></h4>

<font color="red">
    Cause: <%=exception.getCause()  %><br>
    Class: <%=exception.getClass()  %>
</font><br>

<%} %>
</body>
</html>