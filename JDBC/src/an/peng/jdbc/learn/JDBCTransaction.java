package an.peng.jdbc.learn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import an.peng.jdbc.learn.util.JDBCUtil;

/**
 * @author Admin jdbc ÊÂÎñµÄÁ·Ï°
 */
public class JDBCTransaction {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "update students set score = ? where name = ?";
			String sql2 = "update students set score = ? where name =?";
			pstm1 = conn.prepareStatement(sql);
			pstm2 = conn.prepareStatement(sql2);
			pstm1.setInt(1, 20);
			pstm1.setString(2, "abc");
			pstm2.setInt(1, 200);
			pstm2.setString(2, "tom");
			pstm1.executeUpdate();
			pstm2.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstm1);
			JDBCUtil.close(conn = null, pstm2);
		}
	}

}
