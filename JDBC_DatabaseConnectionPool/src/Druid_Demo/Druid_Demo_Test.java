package Druid_Demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class Druid_Demo_Test {

	public static void main(String[] args) throws Exception {
		// º”‘ÿ≈‰÷√Œƒº˛
		InputStream stream = Druid_Demo_Test.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties prop = new Properties();
		prop.load(stream);
		DataSource ds = DruidDataSourceFactory.createDataSource(prop);
		Connection conn = ds.getConnection();
		PreparedStatement stm = conn.prepareStatement("select * from students");
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			String name = rs.getString(2);
			System.out.println(name);
		}
		System.out.println(conn);
		conn.close();
	}

}
