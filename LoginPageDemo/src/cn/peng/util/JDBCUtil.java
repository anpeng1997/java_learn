package cn.peng.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource dataSource;

    static {
        Properties prop = new Properties();
        InputStream stream = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            prop.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
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
