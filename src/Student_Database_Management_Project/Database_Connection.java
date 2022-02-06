package Student_Database_Management_Project;

import java.sql.*;
public class Database_Connection {
Connection con=null;

public  Connection dbconnect() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_Database_Management","root","root");
	return conn;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	
	}
}
}
	