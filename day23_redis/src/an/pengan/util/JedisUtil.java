package an.pengan.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {
    private static JedisPool jedisPool;

    static {
        InputStream resourceAsStream = Jedis.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties prop = new Properties();
        try {
            prop.load(resourceAsStream);
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
            config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
            jedisPool = new JedisPool(config, prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void closeJedis(Jedis jedis) {
        jedis.close();
    }
}
