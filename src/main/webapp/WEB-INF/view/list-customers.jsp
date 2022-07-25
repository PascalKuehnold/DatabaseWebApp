<%--
  Created by IntelliJ IDEA.
  User: Pascal Kühnold
  Date: 7/22/2022
  Time: 12:15 AM
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="de.pascalkuehnold.databasewebapp.util.SortUtils" %>
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

        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />
        <br>

        <!-- add a search form -->
        <form:form action="search" method="get">
            Search customer: <input type="text" name="customerNameToSearch">

            <input type="submit" value="Search" class="add-button">
        </form:form>


        <!-- construct sort links for header types -->
        <c:url var ="sortLinkFirstName" value="/customer/list">
            <c:param name="sort" value="<%=Integer.toString(SortUtils.FIRST_NAME)%>" />
        </c:url>

        <c:url var ="sortLinkLastName" value="/customer/list">
            <c:param name="sort" value="<%=Integer.toString(SortUtils.LAST_NAME)%>" />
        </c:url>

        <c:url var ="sortLinkEmail" value="/customer/list">
            <c:param name="sort" value="<%=Integer.toString(SortUtils.EMAIL)%>" />
        </c:url>



        <table>
            <tr>
                <th><a href="${sortLinkFirstName}">First Name</a></th>
                <th><a href="${sortLinkLastName}">Last Name</a></th>
                <th><a href="${sortLinkEmail}">Email</a></th>
                <th>Action</th>
            </tr>

            <!-- loop over and print the customers -->
            <c:forEach var="tempCustomer" items="${customers}">

                <!-- construct an "update" link with customer id -->
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <!-- construct a "delete" link with customer id -->
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>


                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td>
                        <!-- display the update link -->
                        <a href="${updateLink}">Update</a>
                        <span>|</span>
                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"
                        >Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </div>
</div>

</body>
</html>
