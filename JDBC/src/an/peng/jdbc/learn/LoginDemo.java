package an.peng.jdbc.learn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import an.peng.jdbc.learn.util.JDBCUtil;

public class LoginDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("input name:");
		String name = sc.nextLine();
		System.out.println("input password:");
		String pwd = sc.nextLine();
		boolean b = login(name, pwd);
		if (b) {
			System.out.println("login success!");
		} else {
			System.out.println("login fail");
		}
	}

	private static boolean login(String name, String pwd) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			// Statement stm = conn.createStatement();
			// ResultSet rs = stm.executeQuery("select * from t_user where name = '" + name
			// + "'" + " and password = '" + pwd + "'");
			String sql = "select * from t_user where name = ? and password = ?";
			// 使用preparedStatement来防止sql注入问题 a' or 'a' == 'a
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, pwd);
			rs = pstm.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm, rs);
		}
		return false;
	}

}
