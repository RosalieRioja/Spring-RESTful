<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<script>

function validateAddPerson() {
    $('.form-add-person-error').hide();
    var valid = true;

    var rdEmployed = $('input:radio[name="employed"]:checked');
    if(rdEmployed.length == 0)//no buttons selected
    {
        $('#employedError').show();
        valid = false;
    }

    var rdGender = $('input:radio[name="gender"]:checked');
    if(rdGender.length == 0)//no buttons selected
    {
        $('#genderError').show();
        valid = false;
    }

    if(valid) {
        return (confirm('Are you sure to submit this record?'));
    }
    else {
        return valid;
    }
}

</script>
<!-- ADD / EDIT PERSON JSP -->
<html>

    <head>
        <title>Mini Registration System</title>
    </head>

    <body>
     
    <div align="center">
        <c:choose>
            <c:when test="${empty person.id}">
                Register Person
            </c:when>
            <c:otherwise>
                Update Person
            </c:otherwise>
        </c:choose>
    </div>

    <div align="center" style="margin-top: 50px;" class="form-add-person" >
        <form action="/Person/submit" method="post" onsubmit="return validateAddPerson();">
            <input type="hidden" name="id" id="id" value="${person.id}">
            Name: <br>
            First name: <input      type="text" id="firstname"  name="firstname"    size="20px" required value="${person.name.firstName}"/> <br>
            Middle name:    <input  type="text" id="middlename" name="middlename"   size="20px" required value="${person.name.middleName}"/> <br>
            Last name:  <input      type="text" id="lastname"   name="lastname"     size="20px" required value="${person.name.lastName}"/> <br>
            Suffix: <input          type="text" id="suffix"     name="suffix"       size="20px" required value="${person.name.suffix}"/> <br>
            Title:  <input          type="text" id="title"      name="title"        size="20px" required value="${person.name.title}"/> <br>
            Birthday:   <input      type="date" id="birthday"   name="birthday"     size="20px" required value="${person.birthday}"/> <br>
            Grade Weighted Average: <input type="number" step="0.01" id="gwa" name="gwa"        size="20px" required value="${person.GWA}"/> <br>
            Date Hired: <input      type="date" id="datehired"  name="datehired"    size="20px" required value="${person.dateHired}"/> <br>
            Employed:   <input type="radio" name="employed" value="true"/> True <input type="radio" name="employed" value="false"/> False
                <label style="display:none; color:red;" id="employedError" class="form-add-person-error">Please select an employment status.</label> <br>
            Gender: <input type="radio" name="gender" value="FEMALE"/> Female <input type="radio" name="gender" value="MALE"/> Male
                <label style="display:none; color:red;" id="genderError" class="form-add-person-error">Please select gender.</label> <br>
            Address: <br>
            Street number:  <input  type="number"   id="streetnumber"   name="streetnumber" size="20px" required value="${person.address.streetNumber}"> <br>
            Barangay:   <input      type="text"     id="barangay"       name="barangay"     size="20px" required value="${person.address.barangay}"> <br>
            City:   <input          type="text"     id="city"           name="city"         size="20px" required value="${person.address.city}"> <br>
            Zip code:   <input      type="number"   id="zipcode"        name="zipcode"      size="20px" required value="${person.address.zipCode}"> <br>
            <input type="submit" value="Submit">
            <input type="button" value="cancel" onclick="window.location.assign('/Person/list');">
        </form>
    </div>

    </body>
</html>