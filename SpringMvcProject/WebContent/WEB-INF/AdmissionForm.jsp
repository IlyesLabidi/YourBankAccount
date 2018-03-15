<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>First Spring MVC Project</title>
</head>
<body>
<a href="/FirstSpringMvcProject/admissionForm.html?siteLanguage=en">Englisch</a> | 
<a href="/FirstSpringMvcProject/admissionForm.html?siteLanguage=de">Deutsch</a>
 


 <h3><spring:message code="label.hallo"/></h3> 
<h2><spring:message code="label.headermsg"/></h2>
 
<form:errors path="student1.*"/> 
<form action="/FirstSpringMvcProject/submitAdmissionForm.html" method="Post">
<p>
<spring:message code="label.studentName"/> <input type="text" name="studentName">
</p>

<p>
<spring:message code="label.studentHobbys"/>  <input type="text" name="studentHobbys">
</p>

<p>
<spring:message code="label.studentMobile"/>  <input type="text" name="studentMobile">
</p>

<p>
<spring:message code="label.studentDOB"/>  <input type="text" name="studentDOB">
</p>

<p>
<spring:message code="label.studentSkills"/>  <select name="studentSkills" multiple>

                   <option value="Java core">java core </option>
                   <option value="Spring core">Spring core </option>
                   <option value="Spring MVC">Spring MVC </option>
                   </select>
</p>
<h3><spring:message code="label.studentAdress"/></h3>
<p>
<spring:message code="label.country"/> <input type="text" name="studentAdress.country">
</p>
<p>
<spring:message code="label.city"/>  <input type="text" name="studentAdress.city">
</p>
<p>
<spring:message code="label.street"/>  <input type="text" name="studentAdress.street">
</p>
<p>
<spring:message code="label.pincode"/> <input type="text" name="studentAdress.pincode">
</p>

<input type="submit" value="<spring:message code="label.submit.admissionForm"/>"/>
</form>

</body>
</html>