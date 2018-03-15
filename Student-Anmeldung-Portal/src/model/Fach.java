package model;

public class Fach {
String Name ;
String Semester ;
int idProfessor;
int idFach ;

public int getIdFach() {
	return idFach;
}

public void setIdFach(int idFach) {
	this.idFach = idFach;
}

public int getIdProfessor() {
	return idProfessor;
}

public void setIdProfessor(int idProfessor) {
	this.idProfessor = idProfessor;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getSemester() {
	return Semester;
}

public void setSemester(String semester) {
	Semester = semester;
}



}
