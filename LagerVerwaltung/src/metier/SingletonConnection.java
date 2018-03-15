package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
private static Connection connection ; 

// bolc static s'execute au moment de la chargement de la classe en memoire il garantie la creation d une seul connection 
static {
	String driver = "com.mysql.jdbc.Driver";
	String url= "jdbc:mysql://localhost:3306/cat_prod" ;
	String user= "root"; 
	String password= "1414lilase1414" ;
	try {
		Class.forName(driver);
		connection=  DriverManager.getConnection(url ,user, password);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	
}

public static Connection getConnection() {
	return connection;
}

}
