<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 1/20/20
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

    <head>
        <title>List Customers</title>

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>

    <body>

        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
        </div>

        <br>

        <div id="content">

            <!-- put new button: Add customer -->
            <input type="button" value="Add Customer"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"
            />

            <%-- add our html table --%>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <!-- loop over and print our customers -->
                <c:forEach var="customer" items="${customers}">

                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>

                    <!-- construct an "delete" link with customer id -->
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${customer.id}"/>
                    </c:url>

                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!confirm('Are you sure you want to delete this customer?')) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>

</html>
