package an.pengan.test;

import an.pengan.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisDemo {
    @Test
    public void test1() {
        //创建jedis对象
        Jedis jedis = new Jedis();
        //设置字符串类型的数据
        jedis.set("jedisTest", "test1");
        //获取数据
        String jedisTest = jedis.get("jedisTest");
        System.out.println(jedisTest);
        //关闭链接
        jedis.close();
    }

    @Test
    public void test2() {
        //创建连接池
        JedisPool jedisPool = new JedisPool();
        Jedis resource = jedisPool.getResource();
        String jedisTest = resource.get("jedisTest");
        //归还连接至连接池
        resource.close();
    }

    @Test
    public void test3() {
        Jedis jedis = JedisUtil.getJedis();
        String value = jedis.get("jedisTest");
        System.out.println(value);
        JedisUtil.closeJedis(jedis);
    }
}
