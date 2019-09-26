package an.peng.jdbc.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///study", "root", "root");
			stm = conn.createStatement();
			String sqlStr = "select * from students";
			ResultSet result = stm.executeQuery(sqlStr);
			// 游标向下移，并判断是否还有内容
			while (result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				int age = result.getInt(3);
				int score = result.getInt(4);
				System.out.println(id + "-" + "-" + name + "-" + age + "-" + score);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
