package JDBC_Conn_Pool_Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @author Admin
 * 基于druid连接池的jdbcUtil
 *
 */
public class JDBCUtil {
	private static DataSource dataSourec = null;
	static {
		Properties prop = new Properties();
		InputStream inStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		try {
			prop.load(inStream);
			dataSourec = DruidDataSourceFactory.createDataSource(prop);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSourec.getConnection();
	}

	public static void close(Connection conn, PreparedStatement stm) throws SQLException {
		close(conn, stm, null);
	}

	public static void close(Connection conn, PreparedStatement stm, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
