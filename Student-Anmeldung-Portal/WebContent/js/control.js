/**
 * 
 */

function addProfValidation() {
	var log=document.addProf.login.value;
	var rec= /[^a-zA-Z]/;
	var res=rec.test(log);
	if(log=="" || document.addProf.pass.value=="" ){ 
		alert("Bitte Füllen sie den Formular ein");
	    return false ;}
	else if(res==true){ alert("falsche Login  ");
	return false;}
	else { return true ;}
	
}

function addFach() {
	var fach=document.addFacher.name.value;
	var rec= /[^a-zA-Z]/;
	var res=rec.test(fach);
	if(fach==""  ){ 
		alert("Bitte Füllen sie den Formular ein");
	    return false ;}
	else if(res==true){ alert("falsche Fach ");
	return false;}
	
	else { return true ;}
	
}

function profAnmeldung() {
	var log=document.profAnm.login.value;
	var rec= /[^a-zA-Z]/;
	var res=rec.test(log);
	if(document.profAnm.login.value=="" || document.profAnm.passwort.value==" "  ){ 
		alert("Bitte geben sie Ihre Name und Passwort");
	    return false ;}
	
	else if(res==true){alert("falsche login oder passwort "); 
    return false;    }
	
	else { return true ;}
	
}

function studentAnmeldung() {
	var name=document.studentAnm.name.value;
	var vorname=document.studentAnm.vorname.value;
	var rec= /[^a-zA-Z]/;
	var resN=rec.test(name);
	var resV=rec.test(vorname);
	if(name=="" || vorname==" "  ){ 
		alert("Bitte geben sie Ihre Name und Vorname");
	    return false ;}
	
	else if(resN==true || resV==true){alert("falsche login oder passwort "); 
    return false;    }
	
	else { return true ;}
	
}

function adminAnmeldung() {
	var log=document.adminAnm.login.value;
	var rec= /[^a-zA-Z]/;
	var res=rec.test(log);
	if(document.adminAnm.login.value=="" || document.adminAnm.passwort.value==" "  ){ 
		alert("Bitte geben sie Ihre Name und Passwort");
	    return false ;}
	
	
	else if(res==true){alert("falsche login oder passwort "); 
	                   return false;    }
	
	
	else { return true ;}
	
}


function editProf() {
	select = document.getElementById('select');
	if(select.value){ 
		return true ;
	}
		
	else {
		alert("Bitte wählen sie ein  Professor");
	    return false ;}
		
	}

function fachAuswahl() {
	select = document.getElementById('fachList');
	if(select.value){ 
		return true ;
	}
		
	else {
		alert("Bitte wählen sie ein  Fach");
	    return false ;}
		
	}
	
