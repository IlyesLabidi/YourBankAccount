package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Dao;
import model.Fach;
import model.Professor;
import model.Student;


/**
 * Servlet implementation class ControlleurServlet
 */
@WebServlet("/ControlleurServlet")
public class ControlleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Path= request.getServletPath();
		if (Path.equals("/Startseite")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/startseite.jsp").forward(request, response);
			
		}
		else if  ((Path.equals("/Admin.php")) || (Path.equals("/Prof.php"))|| (Path.equals("/Student.php"))){
			String m= Path;
			request.setAttribute("m", m);
				this.getServletContext().getRequestDispatcher("/WEB-INF/startseite.jsp").forward(request, response);
			
		}
		
		
		
		
		
	 //  this.getServletContext().getRequestDispatcher("/WEB-INF/startseite.jsp").forward(request, response);
		//doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//doPost(request, response);
		
		Dao d = new Dao();
		
		String action =request.getParameter("action");
		
		
		
		
		if(action!=null){
			
			if (action.equals("Admin")|| action.equals("Prof")|| action.equals("Student")) {
				System.out.println("++++++");
				String m= action;
				request.setAttribute("m", m);
					this.getServletContext().getRequestDispatcher("/WEB-INF/startseite.jsp").forward(request, response);
					
						}
				
			
			else if(action.equals("bestatigen")){
				System.out.println("-------");
				
				Student st = new Student();
				int f ;
				String f1;
				
				request.setAttribute("st", st);
				try{
					st.setName(request.getParameter("name"));
					st.setVorname(request.getParameter("vorname"));
					f1=request.getParameter("fach");
					try {
					f=Integer.parseInt(f1.substring(3));
					st.setFach(f);
					}catch (Exception e) { e.getMessage();
						// TODO: handle exception
					}
					
					d.addStudent(st);

					
					}catch(Exception e){e.printStackTrace();}
				this.getServletContext().getRequestDispatcher("/WEB-INF/ErfolgreichAnmeldung.jsp").forward(request, response);

			}
			else if(action.equals("anmelden")){
				int id=0;
				String t="yes";
				String m="Prof";
			
				
				
				
				try{
					String login=request.getParameter("login");
					String pass=request.getParameter("passwort");
					id =d.Login(login, pass);
					
					
					if (id>0){
						request.setAttribute("id", id);
						List<Fach> facher= d.listfacher(id);
						request.setAttribute("facher", facher);
						
						this.getServletContext().getRequestDispatcher("/WEB-INF/startProf.jsp").forward(request, response);
						}else if (id==0) {
							t="no";
							request.setAttribute("m", m);
							request.setAttribute("t", t);
							System.out.println(t+"******"+m);
							this.getServletContext().getRequestDispatcher("/WEB-INF/startseite.jsp").forward(request, response);	
						}
					
				}catch(Exception e){e.printStackTrace();}
			}
			
			else if(action.equals("auswahlen")){
				int id =Integer.parseInt(request.getParameter("fach"));
				System.out.println(id+"******");
				List <Student> Studenten = d.listStudenten(id);
				if (Studenten!=null){
					request.setAttribute("id", id);
					request.setAttribute("st", Studenten);
					System.out.println("yes");
					this.getServletContext().getRequestDispatcher("/WEB-INF/StudentenListe.jsp").forward(request, response);
				}
				
				System.out.println("noooooooooo");	

			}
			
			else if(action.equals("generateGroupe")){
				String act="generateGroupe";
				int id =Integer.parseInt(request.getParameter("Fach"));
				int nbr =Integer.parseInt(request.getParameter("TeamNbr"));
				List <Student> Studenten = d.listStudenten(id);
				if (Studenten!=null){
					request.setAttribute("id", id);
					request.setAttribute("st", Studenten);
				}
				int nbrTeam = d.GenerateTeam(id, nbr);
				List<StudentModel> stm =d.ListTeam(id);
				request.setAttribute("stm", stm);
				request.setAttribute("Fach", id);
				request.setAttribute("nbr", nbrTeam);
				request.setAttribute("act", act);
				for (int i = 0; i < stm.size(); i++) {
					StudentModel st = new StudentModel();
						st= (StudentModel)stm.get(i);
						System.out.println(st.Name+" *"+st.Vorname+"* "+st.IdTeam);
					
				}
				this.getServletContext().getRequestDispatcher("/WEB-INF/StudentenListe.jsp").forward(request, response);
			
				}
			else if(action.equals("Loggen")){
				int id=0;
				String t="yes";
				String m="Admin";
			
				
				
				
				try{
					String login=request.getParameter("login");
					String pass=request.getParameter("passwort");
					id =d.LoginAdmin(login, pass);
					
					
					if (id>0){
						
						List<Professor> professoren= d.ListProf();
						request.setAttribute("professoren", professoren);
						for (int i = 0; i < professoren.size(); i++) {
							Professor p = professoren.get(i);
							System.out.println(p.getLogin()+"*****");
						}
						this.getServletContext().getRequestDispatcher("/WEB-INF/startAdmin.jsp").forward(request, response);
						}else if (id==0) {
							t="no";
							request.setAttribute("m", m);
							request.setAttribute("t", t);
							System.out.println(t+"******"+m);
							this.getServletContext().getRequestDispatcher("/WEB-INF/startseite.jsp").forward(request, response);	
						}
					
				}catch(Exception e){e.printStackTrace();}
			
				
			}
			
			else if(action.equals("Add")){
				
				int pass =Integer.parseInt(request.getParameter("pass"));
				String login  =request.getParameter("login");
				Professor p= new Professor();
				p.setLogin(login);
				p.setPasswort(pass);
				d.addProf(p);
				List<Professor> professoren= d.ListProf();
				request.setAttribute("professoren", professoren);
				
				
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/startAdmin.jsp").forward(request, response);
				
			}
			
			else if(action.equals("AddProfessor")){
				String m = "AddProfessor";
				List<Professor> professoren= d.ListProf();
				request.setAttribute("professoren", professoren);
				request.setAttribute("m", m);
				this.getServletContext().getRequestDispatcher("/WEB-INF/startAdmin.jsp").forward(request, response);
			}
			else if(action.equals("EditProfessor")){
				String m = "EditProfessor";
				int id =Integer.parseInt(request.getParameter("Prof"));
				List<Professor> professoren= d.ListProf();
				request.setAttribute("professoren", professoren);
				List<Fach> facher=d.listfacher(id);
				request.setAttribute("facher", facher);
				request.setAttribute("m", m);
				request.setAttribute("id", id);
				this.getServletContext().getRequestDispatcher("/WEB-INF/startAdmin.jsp").forward(request, response);
				
				
			}
			else if(action.equals("AddFach")){
				String m = "AddFach";
				int id =Integer.parseInt(request.getParameter("profId"));
				List<Professor> professoren= d.ListProf();
				request.setAttribute("professoren", professoren);
				List<Fach> facher=d.listfacher(id);
				request.setAttribute("facher", facher);
				request.setAttribute("m", m);
				request.setAttribute("id", id);
				this.getServletContext().getRequestDispatcher("/WEB-INF/startAdmin.jsp").forward(request, response);
								
				
				
			}
			else if(action.equals("addFach")){
				String m = "addFach";
				int id =Integer.parseInt(request.getParameter("profId"));
				List<Professor> professoren= d.ListProf();
				request.setAttribute("professoren", professoren);
				Fach f = new Fach();
				f.setName(request.getParameter("name"));
				f.setSemester(request.getParameter("semester"));
				f.setIdProfessor(id);
				d.addFach(f);
				List<Fach> facher=d.listfacher(id);
				request.setAttribute("facher", facher);
				request.setAttribute("m", m);
				request.setAttribute("id", id);
				this.getServletContext().getRequestDispatcher("/WEB-INF/startAdmin.jsp").forward(request, response);
				
			}
			
		
				
				
			
				
			}
				
	}

}
