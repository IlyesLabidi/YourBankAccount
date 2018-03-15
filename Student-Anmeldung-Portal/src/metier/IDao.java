package metier;

import java.util.List;

import model.Fach;
import model.Professor;
import model.Student;
import web.StudentModel;

public interface IDao {
	public void addStudent(Student st);
	public List<Fach> listfacher (int id);
	public int Login(String login,String pass);
	public int LoginAdmin(String login,String pass);
	public List<Student> listStudenten(int id);
	public int GenerateTeam(int id, int nbr);
	public Student GetStudent(int id,int fach);
	public List<StudentModel> ListTeam(int fach);
	public void addProf(Professor p);
	public void addFach(Fach f);
	
	public List<Professor> ListProf();

}
