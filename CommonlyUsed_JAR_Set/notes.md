# jar Set

#### [Maven_Repository](https://mvnrepository.com/)

1. 数据库连接池
    + C3P0
    + Druid
2. Spring JDBC
    + Spring框架对JDBC的简单封装，提供了一个JDBCTemplate对象简化JDBC的开发
3. BeanUtils
    + 用于封装JavaBean类
    + `populate()`填充对象，在servlet中一般先使用request.getParameterMap();获取参数的集合，当作该方法的第二个参数，第一个参数则为要填充的对象
4. xml常见的解析器
    + JXAP:sun公司官方提供的，支持dom、sax两种思想（不好用）
    + DOM4J:一款非常优秀的解析器
    + Jsoup:java的html解析器，类型于jQuery的操作方式来取出和操作数据
    + PULL：Android操作系统内置的解析器，SAX方式
5. JSTL
    + `JavaServer Page Tag Library`:用于简化和替换jsp页面上的java代码
6. jedis
    + java中来操作redis的jar包
7. jackson
    + json解析器