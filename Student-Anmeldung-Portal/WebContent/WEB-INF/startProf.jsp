
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<script language="javascript" type="text/javascript" src="js/control.js" ></script>
</head>
<body>
<p></p>

<div class="container col-md-10 col-md-offset-1">
<div class="panel panel-primary">
<div class="panel-heading"> Facher Liste </div>
<div class="panel-body">
 <form action="controlleur.php" method="post">

<div class="form-group">

<label class="control-label">Facher Liste</label>
 
 
 <select id="fachList" name="fach" size="3" class="form-control">
 <c:forEach items="${facher}" var="f">
          <option value="${ f.idFach}" class="form-control">${f.name }</option>
         </c:forEach>
     </select>
    </div>
     

<div>
<input type="submit" value="auswahlen" onclick="return fachAuswahl();" name="action" class="btn btn-primary">
</div>


</form>
</div>
</div>
</div>

</body>
</html>