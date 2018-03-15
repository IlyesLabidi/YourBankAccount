<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<p></p>
<div class="container col-md-10 col-md-offset-1">
<div class="panel panel-primary">
<div class="panel-heading">Studenten Liste :</div>

<div class="panel-body">
 <form action="controlleur.php" method="post">


<table class="table">
<tr><td><input type="hidden" name="Fach" value="${id}"/></td></tr>

<tr><th>Name</th> <th>Vorname</th></tr>
<c:forEach items="${st}" var="s">
<tr>
<td>${s.name } </td>
<td>${s.vorname } </td>
</tr>
</c:forEach>

</table>

<div class="form-group">


<label class="control-label">Zahl von Student per Group</label>
  <select name="TeamNbr" class="form-control">
  <c:forEach var="i" begin="2" end="10" step="1">
          <option value="${i }" class="form-control">${i }</option>
        
          </c:forEach>
     </select>
</div>
     


<div>
<input type="submit" value="generateGroupe" name="action" class="btn btn-primary" >
</div>
<c:if test="${act=='generateGroupe'}">
 <%-- <tr>
<td>
<c:forEach var="i" begin="1" end="${nbr }" step="1">
<c:forEach items="${stm}" var="s">
<c:set var="r" value="${i ==s.idTeam}"/>

 <h4> ${s.vorname } ${s.idTeam }</h4>
 </c:forEach>
 </c:forEach>
 </td>
 </tr> --%> 
 
 <div class="form-group">


<label class="control-label">List Team </label>
 
 <select name="studen" size="10" class="form-control">
         <c:forEach  var="i" begin="1" end="${nbr }" step="1">
         <%-- <fmt:parseNumber var="v" value="${i}"/> --%>
          <c:set var="v" value="${i}" /> 
         
       
  <optgroup label="team ${i}" class="form-control"> 
  <c:forEach items="${stm}" var="s">


    <c:if test="${s.idTeam==i} ">
          <option value="${s.idStudent}" class="form-control"> ${s.vorname } ${s.name } </option>
          </c:if>
          </c:forEach>
          
   </optgroup>
   </c:forEach>      
     </select>

</div>
</c:if>




</form>
</div>
</div>
</div>


</body>
</html>