package JDBC_Conn_Pool_Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement stm = conn.prepareStatement("select * from students");
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			String name = rs.getString(2);
			System.out.println(name);
		}
		System.out.println(conn);
		JDBCUtil.close(conn, stm, rs);
	}

}
