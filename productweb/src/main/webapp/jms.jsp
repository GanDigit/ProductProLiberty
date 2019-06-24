<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Messages List </title>
    </head>
    <body>
    	<h1>Messages sent</h1>
        <table border=1>
            <tbody>
                <c:forEach var="msg" items="${messagesSent}">
                    <tr>
                        <td><c:out value="${msg}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <h1>Messages received</h1>
        <table border=1>
            <tbody>
                <c:forEach var="msg" items="${messagesReceived}">
                    <tr>
                        <td><c:out value="${msg}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                 
          <a href="index.jsp">Home</a>
    </body>    
</html>