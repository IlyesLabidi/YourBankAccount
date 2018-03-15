<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Startseite</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<script language="javascript" type="text/javascript" src="js/control.js" ></script>

</head>
<body>

<div class="navbar navbar-inverse">
<ul class="nav navbar-nav" >
   <li> <a href="Admin.php"  >Admin </a></li>
   

     <li> <a href="Prof.php"> Prof  </a> </li>
    
      <li><a href="Student.php">Student  </a></li>
      
</ul>
</div>

 <c:if test="${m=='/Student.php'}">
  <p></p>
<div class="container col-md-10 col-md-offset-1 col-xs-12 ">
<div class="panel panel-primary">
<div class="panel-heading">Anmeldung als Student :</div>
<div class="panel-body">
 
 
 <form action="controleur.php" method="post" name="studentAnm">

 <div class="form-group">


<label class="control-label">Name :</label>
<input type="text"  name="name" class="form-control" >
<span></span>
</div>

<div class="form-group">


 <label class="control-label">Vorname :</label>
 <input type="text"  name="vorname" class="form-control" >
 <span></span>
</div>

<div class="form-group">

<label class="control-label">Fach :</label>
<input type="text"  name="fach" class="form-control" >
<span></span>
</div>
<div>
<input type="submit" value="bestatigen" name="action" onclick=" return studentAnmeldung();" class="btn btn-primary"/>
</div>


 </form>
 </div>
  </div>
  </div>
  </c:if>
  
  
 <c:if test="${m=='/Prof.php'}">
  <p></p>
<div class="container col-md-10 col-md-offset-1">
<div class="panel panel-primary">
<div class="panel-heading">Anmeldung als Professor :</div>
<div class="panel-body">
 
<form action="controlleur.php" method="post" name="profAnm">

 
<div class="form-group">



<c:if test="${t=='no'}"> 
<label class="control-label">Falsch Login oder Passwort</label>
  </c:if> 
<label class="control-label">Login :</label>
<input type="text"  name="login" class="form-control" >

</div>
<div class="form-group">
<label class="control-label"> passwort :</label>
<input type="password"  name="passwort" class="form-control" >
<span></span>
</div>


<div><input type="submit" value="anmelden" name="action" onclick=" return profAnmeldung();" class="btn btn-primary"></div>

 </form>
 </div>
  </div>
  </div>
 </c:if>
 
 <c:if test="${m=='/Admin.php'}">
 <p></p>
 
 <div class="container col-md-10 col-md-offset-1">
<div class="panel panel-primary">
<div class="panel-heading">Anmeldung als Admin :</div>
<div class="panel-body">
 
<form action="controlleur.php" method="post" name="adminAnm">

 

<div class="form-group">
<c:if test="${t=='no'}"> 
<label class="control-label">Falsch Login oder Passwort</label>
  </c:if> 
<label class="control-label">Login :</label>
<input type="text"  name="login" class="form-control" >
</div>

<div class="form-group"> 
<label class="control-label">passwort :</label>
<input type="password"  name="passwort" class="form-control"  >
</div>


<div><input type="submit" value="Loggen" name="action" onclick=" return adminAnmeldung();" class="btn btn-primary"></div>

 </form>

 </div>
  </div>
  </div>
   </c:if>
 











</body>
</html>



