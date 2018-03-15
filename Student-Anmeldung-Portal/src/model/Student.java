package model;

public class Student {
	String Name ;
	String Vorname;
	int Fach ;
	int IdStudent;
  	
	
	public int getIdStudent() {
		return IdStudent;
	}
	public void setIdStudent(int idStudent) {
		IdStudent = idStudent;
	}
	public int getFach() {
		return Fach;
	}
	public void setFach(int fach) {
		Fach = fach;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getVorname() {
		return Vorname;
	}
	public void setVorname(String vorname) {
		Vorname = vorname;
	}

}
