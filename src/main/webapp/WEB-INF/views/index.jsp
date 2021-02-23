<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<style>
  .error {
    color: green; font-weight: bold;
  }
</style>
</head>
<body>
<center>
    <h1>User Registration Form</h1>
    <form:form  modelAttribute="user" method="post" action="register">
        <table>
        <input type="hidden" id="id" name="id"
          <tr>
            <td>
              <form:label path="name">Name</form:label>
            </td>
            <td>
              <form:input path="name" id="name" />
            </td>
            <td><form:errors path="name" cssClass="error"/></td>
          </tr>
          <tr>
          <td>
            <form:label path="surname">Surname</form:label>
          </td>
          <td>
            <form:input path="surname" id="surname" />
          </td>
            <td><form:errors path="surname" cssClass="error"/></td>
            </tr>
             <tr>
              <td>
               <form:label path="phone">Phone</form:label>
               </td>
               <td>
                <form:input path="phone" id="phone" />
                 </td>
                 <td><form:errors path="phone" cssClass="error"/></td>
                 </tr>
                 <tr>
                  <td>
                  <form:label path="email">Email</form:label>
                    </td>
                    <td>
                     <form:input path="email" id="email" />
                     </td>
                     <td><form:errors path="email" cssClass="error"/></td>
                     </tr>
                     <tr>
                   <td><input type="submit" value="Submit"></td>
                    </tr>
                    </table>
                 </form:form>

</center>
</body>
</html>