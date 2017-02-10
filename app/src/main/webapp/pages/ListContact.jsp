<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>-->

<!-- LIST CONTACT JSP -->
<html>

    <head>
        <title>Mini Registration System</title>
    </head>

    <body>
     
    <div align="center">
        <a href="#" onclick="window.location.assign('/Person/list');">Back</a>
    </div>
    <br>
    <div align="center">
        <form action="/Contact/add" method="post">
            <input type="hidden" name="personId" id="personId" value="${person.id}">
            <input type="submit" value="Add Contact"/>
        </form>
    </div>
    <br>
    <div align="center">
        ${person.name.lastName}, ${person.name.firstName} ${person.name.middleName}'s List of Contact/s
    </div>
    <br>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td></td><td></td><td></td>
                    <td>Contact Type</td>
                    <td>Contact Value<td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${person.contacts}" var="contact">
                    <tr>
                        <td>
                            <form action="/Contact/edit" method="post">
                                <input type="hidden" name="personId" id="personId" value="${person.id}">
                                <input type="hidden" name="editId" id="editId" value="${contact.id}">
                                <input type="submit" value="Edit"/>
                            </form>
                        </td>
                        <td></td>
                        <td>
                            <form action="/Contact/delete" method="post" onsubmit="return confirm('Are you sure you want to delete this contact?');">
                                <input type="hidden" name="personId" id="personId" value="${person.id}">
                                <input type="hidden" name="deleteId" id="deleteId" value="${contact.id}">
                                <input type="submit" value="Delete"/>
                            </form>
                        </td>
                        <td>${contact.type}</td>
                        <td>${contact.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>