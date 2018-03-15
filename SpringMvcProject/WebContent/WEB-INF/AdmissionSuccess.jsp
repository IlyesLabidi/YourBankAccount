<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${headermsg}</h3>

<h1>Congratulation ! your application form has been successfully processed</h1>

<h2>Details submitted by you</h2>

<table>
<tr>
<td>Student name : </td>
<td>${student1.studentName }</td>
</tr>

<tr>
<td>Student Hobbys : </td>
<td>${student1.studentHobbys }</td>
</tr>

<tr>
<td>Student Mobile : </td>
<td>${student1.studentMobile }</td>
</tr>

<tr>
<td>Student DOB : </td>
<td>${student1.studentDOB }</td>
</tr>

<tr>
<td>Student Skills : </td>
<td>${student1.studentSkills }</td>
</tr>

<tr>
<td>Student Adress : </td>
<td>Country : ${student1.studentAdress.country }
    City : ${student1.studentAdress.city }
    Street : ${student1.studentAdress.street }
    Pincode: ${student1.studentAdress.pincode }
</td>
</tr>


</table>

</body>
</html>