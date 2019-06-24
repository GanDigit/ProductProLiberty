<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Books List</title>
    </head>
    <body>
        <table border=1>
            <thead>
                <tr>
                    <th>id</th>
                    <th>isbn</th>
                    <th>name</th>
                    <th>author</th>
                    <th>pages</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td><c:out value="${book.id}"/></td>
                        <td><c:out value="${book.isbn}"/></td>
                        <td><c:out value="${book.name}"/></td>
                        <td><c:out value="${book.author}"/></td>
                        <td><c:out value="${$book.pages}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
                 
          <a href="index.jsp">Home</a>
    </body>    
</html>