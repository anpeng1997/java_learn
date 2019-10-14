package com.pengan.jdbc_conn_pool_util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 基于Druid连接池的JDBC工具类
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

    public static DataSource getDataSourec() {
        return dataSourec;
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
