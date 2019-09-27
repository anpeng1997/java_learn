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
		//��һ�����ط���������ͨ���ڵ�������ʹ�õ�c3p0-config.xml�����ļ����Ǹ��ڵ�����������
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
