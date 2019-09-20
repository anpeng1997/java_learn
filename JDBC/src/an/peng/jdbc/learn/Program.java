package an.peng.jdbc.learn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Program {

	public static void main(String[] args) throws Exception {
		//×¢²áÇý¶¯
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "root");
		
	}

}
