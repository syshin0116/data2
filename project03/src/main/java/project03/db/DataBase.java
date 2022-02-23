package project03.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	private Connection con;
	public DataBase() {
		try{
				Class.forName("org.mariadb.jdbc.Driver"); 
				System.out.println("Mariadb 드라이버 로딩");
				
				String url = "jdbc:mariadb://localhost:3306/mars";
				String user = "mars";
				String pw = "p@ssword";
				
				con = DriverManager.getConnection(url, user,pw);
				System.out.println("Mariadb Connection 연결 성공");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return con;
	}
}
