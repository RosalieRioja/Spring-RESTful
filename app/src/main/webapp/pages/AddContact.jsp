<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<script>

function validateAddContact() {
    $('.form-add-contact-error').hide();
    var valid = true;

    if($('#type').val() == "") {
        $('#typeError').show();
        valid = false;
    }

    if(valid) {
        return (confirm('Are you sure to submit this contact?'));
    }
    else {
        return valid;
    }
}

</script>
<!-- ADD / EDIT CONTACT JSP -->
<html>

    <head>
        <title>Mini Registration System</title>
    </head>

    <body>
     
    <div align="center">
        <c:choose>
            <c:when test="${empty contact.id}">
                Add Contact
            </c:when>
            <c:otherwise>
                Update Contact
            </c:otherwise>
        </c:choose>
    </div>

    <div align="center" style="margin-top: 50px;" class="form-add-contact" >
        <form action="/Contact/submit" method="post" onsubmit="return validateAddContact();">
            <input type="hidden" name="personId" id="personId" value="${personId}">
            <input type="hidden" name="contactId" id="contactId" value="${contact.id}">

            Contact Type:   <select name="type" id="type" value="${contact.type}">
                                <option></option>
                                <option value="LANDLINE">Landline</option>
                                <option value="MOBILE">Mobile</option>
                                <option value="EMAIL">Email</option>
                            </select>
                <label style="display:none; color:red;" id="typeError" class="form-add-contact-error">Please select Contact Type.</label> <br>
            Value:   <input     type="text"     id="value"  name="value"    size="20px" required value="${contact.value}"> <br>
            <input type="submit" value="Submit">
            <input type="button" value="cancel" onclick="window.location.assign('/Contact/list');">
        </form>
    </div>

    </body>
</html>