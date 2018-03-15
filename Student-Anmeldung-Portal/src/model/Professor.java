package model;

public class Professor {
	String Login;
	int Passwort;
	int id ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public int getPasswort() {
		return Passwort;
	}
	public void setPasswort(int passwort) {
		Passwort = passwort;
	}

}
