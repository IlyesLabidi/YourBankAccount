package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import model.Fach;
import model.Professor;
import model.Student;
import sun.invoke.empty.Empty;
import web.StudentModel;

public class Dao implements IDao {
	@Override
	public void addStudent(Student st){
		
	
	
		Connection connection= SingletonConnection.getConnection();
		try {
		PreparedStatement preparedstatement= connection.prepareStatement("INSERT INTO student(StudentName,StudentVorname,StudentFachId) VALUES (?,?,?)");
		preparedstatement.setString(1,st.getName());
		preparedstatement.setString(2,st.getVorname());
		preparedstatement.setInt(3,st.getFach());

		preparedstatement.executeUpdate();
		preparedstatement.close();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Fach> listfacher (int id) {
		List<Fach> Facher = new ArrayList<Fach>();
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from fach where idProfessor=? ");
			preparedstatement.setInt(1, id);
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()){
				Fach f = new Fach();
				f.setName(rs.getString("FachName"));
				f.setSemester(rs.getString("Semester"));
				f.setIdProfessor(id);
				f.setIdFach(rs.getInt("idFach"));
				Facher.add(f);
				
			}
		preparedstatement.close();
		
		}catch (SQLException e) {
			// TODO Auto-generat ed catch block
			e.printStackTrace();
		}
		
		return Facher;
		
	}

	@Override
	public int Login(String login , String pass) {
		int id=0;
		
		Connection connection= SingletonConnection.getConnection();
		try  {
		
		//String query= "select * from professor where ProfessorLogin=? and ProfessorPasswort=?";
		PreparedStatement pst = connection.prepareStatement("select * from professor where ProfessorLogin=? and ProfessorPasswort=?");
		pst.setString(1, login);
		pst.setString(2, pass);
		ResultSet rst= pst.executeQuery();
	   if  (rst.next()) { 
		   id=rst.getInt("idProfessor");
		   }
		  
		  pst.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Student> listStudenten(int id) {
		List <Student> Studenten = new ArrayList<Student>();
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from student where studentFachId=? ");
			preparedstatement.setInt(1, id);
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()){
				Student st = new Student();
				st.setName(rs.getString("StudentName"));
				st.setVorname(rs.getString("StudentVorname"));
				st.setIdStudent(rs.getInt("idStudent"));
				st.setFach(id);
				Studenten.add(st);
			}
			preparedstatement.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return Studenten;
	}

	@Override
	public int GenerateTeam(int id,int nbr) {
		
		List <Student> Studenten= listStudenten(id);
		//ListIterator li = Studenten.listIterator();
		int d=0;
		int nbrTeam=(Studenten.size())/nbr;
		int nbrRest=(Studenten.size())%nbr;
		if(nbrTeam==0) nbrTeam=1;
		if (nbrRest!=0) nbrTeam++;
		
		Connection connection= SingletonConnection.getConnection();
		
			for (int i = 1;  i<= nbrTeam; i++) {
			for(int j = d; j < (d+nbr); j++)
			{ 
				if(j>=Studenten.size()) break;
				Student st = new Student();
				st=(Student) Studenten.get(j);	
		   try {
			PreparedStatement preparedstatement= connection.prepareStatement("INSERT INTO team(idTeam,idStudent,idFach) VALUES (?,?,?)");
			preparedstatement.setInt(1,i);
			preparedstatement.setInt(2,st.getIdStudent());
			preparedstatement.setInt(3,st.getFach());
			preparedstatement.executeUpdate();
			preparedstatement.close();
		}catch (SQLException e) {
				e.printStackTrace();
			}
		   }
			d=d+nbr;
			
	}
		return nbrTeam ;
		
		}

	@Override
	public Student GetStudent(int id, int fach) {
		Student st = new Student();
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from student where idStudent=? and studentFachId=? ");
			preparedstatement.setInt(1, id);
			preparedstatement.setInt(2, fach);
			ResultSet rs = preparedstatement.executeQuery();
			
			while (rs.next()){
				
				st.setName(rs.getString("StudentName"));
				st.setVorname(rs.getString("StudentVorname"));
				st.setIdStudent(id);
				st.setFach(fach);
				
			}
			System.out.println(st.getName()+"Getstudent");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return st;
	}

	@Override
	public List<StudentModel> ListTeam(int fach) {
		
		List <StudentModel> Studenten = new ArrayList<StudentModel>();
		
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from team where idFach=? ");
			preparedstatement.setInt(1, fach);
			ResultSet rs = preparedstatement.executeQuery();
			
			while (rs.next()){
				StudentModel stm = new StudentModel();
				stm.setIdStudent(rs.getInt("idStudent"));
				stm.setIdTeam(rs.getInt("idTeam"));
				stm.setFach(fach);
				Student st =new Student();
				int i=stm.getIdStudent();
				
				int j=stm.getFach();
				
			 st = GetStudent(i, j);
			
				stm.setName(st.getName());
				stm.setVorname(st.getVorname());
				//System.out.println(stm.getVorname()+stm.getIdTeam()+"Listteam");
				Studenten.add(stm);
				
				
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Studenten;
	}

	@Override
	public int LoginAdmin(String login, String pass) {
       int id=0;
		
		Connection connection= SingletonConnection.getConnection();
		try  {
		
		//String query= "select * from professor where ProfessorLogin=? and ProfessorPasswort=?";
		PreparedStatement pst = connection.prepareStatement("select * from admin where Login=? and Passwort=?");
		pst.setString(1, login);
		pst.setString(2, pass);
		ResultSet rst= pst.executeQuery();
	   if  (rst.next()) { 
		   id=rst.getInt("idAdmin");
		   }
		  
		  pst.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}



	@Override
	public List<Professor> ListProf() {
	
		List<Professor> Professoren = new ArrayList<Professor>();
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement preparedstatement =connection.prepareStatement("select * from professor  ");
			
			ResultSet rs = preparedstatement.executeQuery();
			while (rs.next()){
				System.out.println(rs.getString("ProfessorLogin")+" rs");
				Professor p = new Professor();
				p.setLogin(rs.getString("ProfessorLogin"));
				p.setId(rs.getInt("idProfessor"));
				System.out.println(p.getLogin()+" object");
			Professoren.add(p);
			}
		preparedstatement.close();
		
		}catch (SQLException e) {
			// TODO Auto-generat ed catch block
			e.printStackTrace();
		}
		
		return Professoren;

	}

	@Override
	public void addProf(Professor p) {
		
		Connection connection= SingletonConnection.getConnection();
		try {
		PreparedStatement preparedstatement= connection.prepareStatement("INSERT INTO professor(ProfessorLogin, ProfessorPasswort) VALUES (?,?)");
		preparedstatement.setString(1,p.getLogin());
		preparedstatement.setInt(2,p.getPasswort());
		
		preparedstatement.executeUpdate();
		preparedstatement.close();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addFach(Fach f) {
		Connection connection= SingletonConnection.getConnection();
		try {
		PreparedStatement preparedstatement= connection.prepareStatement("INSERT INTO fach(FachName, Semester, idProfessor) VALUES (?,?,?)");
		preparedstatement.setString(1,f.getName());
		preparedstatement.setString(2,f.getSemester());
		preparedstatement.setInt(3,f.getIdProfessor());
		
		
		preparedstatement.executeUpdate();
		preparedstatement.close();
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

