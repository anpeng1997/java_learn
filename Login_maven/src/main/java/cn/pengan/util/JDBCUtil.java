package cn.pengan.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        InputStream druidConfStream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(druidConfStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
