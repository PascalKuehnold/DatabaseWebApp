<%--
  Created by IntelliJ IDEA.
  User: Pascal Kühnold
  Date: 7/22/2022
  Time: 12:15 AM
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer List</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

  </head>
  <body>
      <div id="wrapper">
        <div id="header">
          <h2>CRM - Customer Relationship Manager</h2>
        </div>
      </div>

      <div id="container">
        <div id="content">
            <!-- add out html table here -->

            <table>
              <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
              </tr>

              <!-- loop over and print the customers -->
              <c:forEach var="tempCustomer" items="${customers}">
                  <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                  </tr>
              </c:forEach>

            </table>

        </div>
      </div>

  </body>
</html>
