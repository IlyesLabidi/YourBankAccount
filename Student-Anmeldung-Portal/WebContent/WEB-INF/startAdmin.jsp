
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<script language="javascript" type="text/javascript" src="js/control.js">
</script>
</head>
<body>
<p></p>
<div class="container col-md-10 col-md-offset-1 col-xs-12">
<div class="panel panel-primary">
<div class="panel-heading">Professor Liste:</div>
<div class="panel-body">
 
 <form action="controlleur.php" method="post">

<div class="form-group">


<label class="control-label">List Professoren</label>



 <select name="Prof" size="4" class="form-control " id="select"  >
 <c:forEach items="${professoren}" var="p">
          <option value="${p.id}" class="form-control"> ${p.login }  </option>
         </c:forEach>
     </select>
     </div>
     
     
     <div>
<input type="submit" value="AddProfessor" name="action" class="btn btn-primary"  >
<input type="submit" value="EditProfessor" name="action" onclick="return editProf();" class="btn btn-primary">
</div>

     </form>
     
     
  <c:if test="${m=='AddProfessor'}">   

   <form action="controlleur.php" method="post"  name="addProf">
      <div class="form-group">
     <label class="control-label">Proffesor formular</label>
       <label class="control-label">Login :</label>
         <input type="text"  name="login" class="form-control" >
           </div>
           
            <div class="form-group">
     <label class="control-label"> passwort :</label>
     <input type="password"  name="pass" class="form-control">
     </div>
     <div>
           <input type="submit" value="Add" name="action"  onclick="return addProfValidation();" class="btn btn-primary">
           </div>
	 
  </form>

</c:if>
 
 <c:if test="${(m=='EditProfessor')|| (m=='AddFach')|| (m=='addFach')}">   

 <form action="controlleur.php" method="post">

<table class="table">
<tr> <td> <input type="hidden"  value="${id }" name="profId" /></td></tr>
<tr> <td><h1>Facher Liste </h1></td></tr>
<tr><th>FachName</th><th>Semeseter</th></tr>
<c:forEach items="${facher}" var="f">
<tr>
<td>${f.name }</td>

<c:if test="${f.semester=='w' }">
<td>WinterSemester</td>
</c:if>

<c:if test="${f.semester=='s' }">
<td>SommerSemester</td>
</c:if>
</tr>
</c:forEach>





     <tr><td><input type="submit" value="AddFach" name="action" class="btn btn-primary" ></td></tr>
 </table>
     </form>
        </c:if>
        
     <c:if test="${m=='AddFach'}">   

   <form action="controlleur.php" method="post" name="addFacher">
       <div class="form-group">
     <label class="control-label"> <input type="hidden"  value="${id }" name="profId" /></label>
        <label class="control-label">Fach Formular</label>
         <label class="control-label"> Name : </label>
         <input type="text"  name="name"  class="form-control" >
         </div>
           
           <div class="form-group">
<label class="control-label">Winter Semester</label>
<input type="radio" name="semester" value="w" checked="checked" class="form-control"> 
          
<input type="radio" name="semester" value="s" class="form-control"> <label >Sommer Semester</label>
          </div>
	      
	     <div><input type="submit" value="addFach" name="action" onclick="return addFach(); " class="btn btn-primary" ></div>
	 
  </form>

</c:if>
</div>
</div>
</div>


</body>
</html>