## Redis

#### java中来操作redis的jar包：`jedis`
* 入门使用：
    1. 导入两个jar包：
        1. `commons-pool2-2.4.2.jar`
        2. `jedis-2.8.1.jar`
    2. 代码示例：
        ```
         //创建jedis对象
        Jedis jedis = new Jedis();
        //设置字符串类型的数据
        jedis.set("jedisTest","test1");
        //获取数据
        String jedisTest = jedis.get("jedisTest");
        System.out.println(jedisTest);
        //关闭链接
        jedis.close();
        ```
    3. 常用方法：（方法名与redis原始命令类似）
        1. string类型：  
        `set()`  
        `get()`
        2. hash类型:  
        `hset()`  
        `hget()`  
        `hgetAll()`
        3. list类型：  
        `lpop()`  
        `lpush()`  
* JedisPool (开发环境要使用连接池)
   ```
    //创建连接池
   JedisPool jedisPool = new JedisPool();
   Jedis resource = jedisPool.getResource();
   String jedisTest = resource.get("jedisTest");
   //归还连接至连接池
   resource.close();
    ```
### JedisUtil类的创建