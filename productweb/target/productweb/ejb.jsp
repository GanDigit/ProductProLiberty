<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Calculator EJB results</title>
    </head>
    <body>
        <table>

            <tbody>
                     <tr>
                        <td>Add</td>
                        <td><c:out value="${add}"/></td>
                    </tr>
                    <tr>
                        <td>Sub</td>
                        <td><c:out value="${sub}"/></td>
                    </tr>
            </tbody>
        </table>
        
                
          <a href="index.jsp">Home</a>
    </body>    
</html>