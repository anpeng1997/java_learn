package C3P0_Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0_Demo_Test {

	public static void main(String[] args) throws SQLException {
		DataSource ds = new ComboPooledDataSource();
		//有一个重载方法，可以通过节点名设置使用的c3p0-config.xml配置文件中那个节点来进行配置
		//DataSource ds = new ComboPooledDataSource("mysql");
		Connection conn = ds.getConnection();
		PreparedStatement stm = conn.prepareStatement("select * from students");
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			String name=rs.getString(2);
			System.out.println(name);
		}
		System.out.println(conn);
		conn.close();
	}

}
