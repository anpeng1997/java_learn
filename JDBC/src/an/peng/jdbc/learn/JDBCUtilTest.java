package an.peng.jdbc.learn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import an.peng.jdbc.learn.util.JDBCUtil;

public class JDBCUtilTest {

	public static void main(String[] args) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		Statement stm = conn.createStatement();
		ResultSet result = stm.executeQuery("select * from students");
		while (result.next()) {
			int id = result.getInt(1);
			String name = result.getString(2);
			int age = result.getInt(3);
			int score = result.getInt(4);
			System.out.println(id + "-" + "-" + name + "-" + age + "-" + score);
		}
		JDBCUtil.close(conn, stm, result);
	}
}
