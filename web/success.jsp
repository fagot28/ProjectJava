<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page language="java"contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
<title>Sample Jsp-Servlet Example</title>
</head>
<body>
    <H1><font color="green">Login Successful</font></H1>
    
    <sql:query var="db" dataSource="jdbc/DepPlast">
                    select field from FIELDS;
            </sql:query>
    <h2>Месторождения</h2>  
            <c:forEach var="FIELDS" items="${db.rows}">   
                    <p><c:out value="${FIELDS.field}" /></p>
            </c:forEach>
    
</body>
</html>
