package ui;

import java.sql.*;
public class SQLService {
	Connection connection=null;
	Statement st=null;
	public static String url="jdbc:mysql://localhost:3307/mysql?characterEncoding=utf8";
	public static String name="root";
	public static String pass="password";
	public void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url,name,pass);
			System.out.println("connection success");
			st=connection.createStatement();
//			String query="select * from student";
//			ResultSet rs=st.executeQuery(query);
//			while(rs.next()) {
//				System.out.println("id : "+rs.getInt("id")+" name: "+rs.getString("name"));
//			}
			}catch(Exception e) {
				System.out.println("error while creating connection"+e);
			}
	}
	
	public ResultSet executeQuery( String query) {
		
		if(connection==null) {
			return null;
		}else {
			try {
			ResultSet rs=st.executeQuery(query);
			return rs;
			}catch(Exception e) {
				System.out.println("Error occured while execution query "+e);
				return null;
			}
		}
	}
}
