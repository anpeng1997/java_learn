package an.peng.jdbc.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws Exception {
		// ע������
		Class.forName("com.mysql.jdbc.Driver");
		// ��ȡ���ݿ����Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "root");
		// ����sql���
		String sql = "update students set score = 88 where id = 2";
		// ��ȡִ��sql���Ķ���
		Statement ste = conn.createStatement();
		//ִ�и��²���
		int i = ste.executeUpdate(sql);
		System.out.println("��Ӱ�������" + i);
		ste.close();
		conn.close();
	}

}
