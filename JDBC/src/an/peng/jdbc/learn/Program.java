package an.peng.jdbc.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws Exception {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取数据库连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "root");
		// 定义sql语句
		String sql = "update students set score = 88 where id = 2";
		// 获取执行sql语句的对象
		Statement ste = conn.createStatement();
		//执行更新操作
		int i = ste.executeUpdate(sql);
		System.out.println("受影响的行数" + i);
		ste.close();
		conn.close();
	}

}
